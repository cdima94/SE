package com.android.fitness.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.android.fitness.entity.Fitness;
import com.android.fitness.entity.Pages;
import com.android.fitness.entity.Style;
import com.android.fitness.repository.FitnessRepository;

@Service
public class FitnessService {

	// default value
	private int mButtons = 0;
	// default value
	private Pages activePage = Pages.agePage;

	private enum ButtonText {
		Age, Weight, Height, Style, Result
	}
	
	private Map<Pages, List<Fitness>> mPages2FitnessList = new HashMap<>();

	private CurrentUserInfo currentUserInfo = new CurrentUserInfo();

	@Autowired
	private FitnessRepository fRepo;

	public void setNumberOfButtons(int numberOfButtons) {
		if (mButtons > 4 || mButtons < 0) {
			mButtons = 0;
		}
		if (mButtons == 0) {
			activePage = Pages.agePage;
		} else {
			activePage = Pages.values()[numberOfButtons];
		}
		mButtons = numberOfButtons;
	}

	public void setInput(String nextPage, String input) {
		switch (nextPage) {
		case "agePage": {
			currentUserInfo.setAge(Integer.parseInt(input));
			break;
		}
		case "weightPage": {
			currentUserInfo.setWeight(Integer.parseInt(input));
			break;
		}
		case "heightPage": {
			currentUserInfo.setHeight(Integer.parseInt(input));
			break;
		}
		case "stylePage": {
			currentUserInfo.setStyle(Style.valueOf(input));
			break;
		}
		case "resultPage": {
			break;
		}
		default: {
			break;
		}
		}
	}

	public void setActiveInput(String nextPage, String input) {
		if (!input.equals("")) {
			boolean found = false;
			for (int i = 0; i < Pages.values().length && !found; i++) {
				if (Pages.values()[i].name().equals(nextPage)) {
					found = true;
					
					//set here the input because the we need to get the previousPage
					setInput(Pages.values()[i - 1].name(), input);
					activePage = Pages.valueOf(nextPage);
					if (i <= 4) {
						mButtons = i;
					}
				}
			}
			if (!found) {
				this.activePage = Pages.agePage;
			}
		} else {
			// input is not received or null => error
		}
	}

	public void submitInput() {
		
	}
	
	public List<Fitness> getByMinAge(int minAge) {
		List<Fitness> fitness = fRepo.findFitnessByMinAge(minAge);
		while (fitness == null || fitness.isEmpty()) {
			minAge = minAge - 1;
			fitness = fRepo.findFitnessByMinAge(minAge);
		}
		return fitness;
	}

	private Model setSidebarButtonsParameters(Model model) {
		List<SideButtonsReturnedHTML> buttons = new ArrayList<>();
		String returnedHTMLClass = "btn btn-block btn-lg btn-default";
		String returnedHTMLStyle = "color: #337ab7;text-align: left;margin-top: 0px;border-bottom-width: 0px;border-top-width: 0px; border-left-width: 0px;border-right-width: 0px;";
		String buttonsBlock = "<th:block th:each=\"button : ${returnedHTMLButtons}\"><a th:onclick=\"${button.returnedHTMLOnclick}\" th:class=\"${button.returnedHTMLClass}\" th:style=\"${button.returnedHTMLStyle}\" th:text=\"${button.returnedHTMLText}\"><span class=\"glyphicon glyphicon-eye-open\"></span></a></th:block>";

		for (int i = 1; i <= mButtons; i++) {
			SideButtonsReturnedHTML button = new SideButtonsReturnedHTML();
			button.setReturnedHTMLClass(returnedHTMLClass);
			button.setReturnedHTMLStyle(returnedHTMLStyle);
			button.setReturnedHTMLOnclick("getRequestedInput(" + (i - 1) + ");");
			button.setReturnedHTMLText(ButtonText.values()[i - 1] + " input");
			buttons.add(button);
		}

		model.addAttribute("returnedHTMLButtons", buttons);
		model.addAttribute("buttonsBlock", buttonsBlock);
		return model;
	}

	private Model setInputPageParameters(Model model) {
		model.addAttribute("inputPage", activePage.name());
		switch (activePage) {
		case stylePage: {
			List<String> styleList = new ArrayList<>();
			for (int i = 0; i < Style.values().length; i++) {
				styleList.add(Style.values()[i].name());
			}
			model.addAttribute("allStyles", styleList);
			break;
		}
		default:
			break;
		}
		return model;
	}

	public Model getSidebarButtonsAccess(Model model) {
		model = setSidebarButtonsParameters(model);
		model = setInputPageParameters(model);
		return model;
	}

	public void updateAgeInput(int age) {
		currentUserInfo.setAge(age);
	}

	public void updateWeightInput(int weight) {
		currentUserInfo.setWeight(weight);
	}

	public void updateHeightInput(int height) {
		currentUserInfo.setHeight(height);
	}

	public void updateStyleInput(String style) {
		Style tempStyle = null;
		boolean found = false;
		for (int i = 0; i < Style.values().length && !found; i++) {
			if (Style.values()[i].name().equals(style)) {
				found = true;
				tempStyle = Style.valueOf(style);
			}
		}

		// if style not found in enum, default value is PASSIVE
		if (!found) {
			tempStyle = Style.PASSIVE;
		}
		currentUserInfo.setStyle(tempStyle);
	}
	
	public CurrentUserInfo result() {
		if (currentUserInfo.getAge() != -1 && activePage.equals(Pages.weightPage)) {
			List<Fitness> resultList = getByMinAge(currentUserInfo.getAge());
			mPages2FitnessList.put(Pages.weightPage, resultList);
			currentUserInfo.clear();
			result(resultList);
			return currentUserInfo;
		}
		if (currentUserInfo.getAge() != -1 && currentUserInfo.getWeight() != -1 && activePage.equals(Pages.heightPage)) {
			if (mPages2FitnessList.get(Pages.weightPage).size() == 1) {
				return currentUserInfo;
			}
			List<Fitness> list = new ArrayList<>();
			int tempWeight = currentUserInfo.getWeight();
			boolean findOne = false;
			int weightFound = -1;
			while (!findOne) {
				for (Fitness fitness: mPages2FitnessList.get(Pages.weightPage)) {
					if (fitness.getMaxWeight() == tempWeight) {
						findOne = true;
					}
					if (findOne) {
						weightFound = tempWeight;
						break;
					}
				}
				tempWeight--;
			}
			for (Fitness fitness: mPages2FitnessList.get(Pages.weightPage)) {
				if (fitness.getMaxWeight() == weightFound) {
					list.add(fitness);
				}
			}
			mPages2FitnessList.put(Pages.heightPage, list);
			currentUserInfo.clear();
			result(list);
			return currentUserInfo;
		}
		if (currentUserInfo.getAge() != -1 && currentUserInfo.getWeight() != -1 && currentUserInfo.getHeight() != -1
				&& activePage.equals(Pages.stylePage)) {
			if (mPages2FitnessList.get(Pages.weightPage).size() == 1) {
				return currentUserInfo;
			}
			List<Fitness> list = new ArrayList<>();
			int tempHeight = currentUserInfo.getHeight();
			boolean findOne = false;
			int heightFound = - 1;
			while (!findOne) {
				for (Fitness fitness: mPages2FitnessList.get(Pages.heightPage)) {
					if (fitness.getMaxHeight() == tempHeight) {
						findOne = true;
					}
					if (findOne) {
						heightFound = tempHeight;
						break;
					}
				}
				tempHeight --;
			}
			for (Fitness fitness: mPages2FitnessList.get(Pages.heightPage)) {
				if (fitness.getMaxHeight() == heightFound) {
					list.add(fitness);
				}
			}
			mPages2FitnessList.put(Pages.stylePage, list);
			currentUserInfo.clear();
			result(list);
			return currentUserInfo;
		}
		if (currentUserInfo.getAge() != -1 && currentUserInfo.getWeight() != -1 && currentUserInfo.getHeight() != -1 
				&& currentUserInfo.getStyle() != null && activePage.equals(Pages.resultPage)) {
			if (mPages2FitnessList.get(Pages.weightPage).size() == 1) {
				return currentUserInfo;
			}
			List<Fitness> list = new ArrayList<>();
			for (Fitness fitness: mPages2FitnessList.get(Pages.stylePage)) {
				if (fitness.getStyle().equals(currentUserInfo.getStyle())) {
					list.add(fitness);
				}
			}
			mPages2FitnessList.put(Pages.resultPage, list);
			currentUserInfo.clear();
			result(list);
			return currentUserInfo;
		}
		return null;
	}
	
	private void result(List<Fitness> resultList) {
		for (Fitness fitness: resultList) {
			if (currentUserInfo.getMaxAbdomen() <= fitness.getAbdomen()) {
				currentUserInfo.setMaxAbdomen(fitness.getAbdomen());
			}
			if (currentUserInfo.getMaxBack() <= fitness.getBack()) {
				currentUserInfo.setMaxBack(fitness.getBack());
			}
			if (currentUserInfo.getMaxBiceps() <= fitness.getBiceps()) {
				currentUserInfo.setMaxBiceps(fitness.getBiceps());
			}
			if (currentUserInfo.getMaxChest() <= fitness.getChest()) {
				currentUserInfo.setMaxChest(fitness.getChest());
			}
			if (currentUserInfo.getMaxFeet() <= fitness.getFeet()) {
				currentUserInfo.setMaxFeet(fitness.getFeet());
			}
			if (currentUserInfo.getMaxForearm() <= fitness.getForearm()) {
				currentUserInfo.setMaxForearm(fitness.getForearm());
			}
			if (currentUserInfo.getMaxLegs() <= fitness.getLegs()) {
				currentUserInfo.setMaxLegs(fitness.getLegs());
			}
			if (currentUserInfo.getMaxShoulder() <= fitness.getShoulder()) {
				currentUserInfo.setMaxShoulder(fitness.getShoulder());
			}
			if (currentUserInfo.getMaxTriceps() <= fitness.getTriceps()) {
				currentUserInfo.setMaxTriceps(fitness.getTriceps());
			}
			if (currentUserInfo.getMinAbdomen() == -1) {
				currentUserInfo.setMinAbdomen(fitness.getAbdomen());
			} else {
				if (currentUserInfo.getMinAbdomen() >= fitness.getAbdomen()) {
					currentUserInfo.setMinAbdomen(fitness.getAbdomen());
				}
					
			}
			if (currentUserInfo.getMinBack() == -1) {
				currentUserInfo.setMinBack(fitness.getBack());
			} else {
				if (currentUserInfo.getMinBack() >= fitness.getBack()) {
					currentUserInfo.setMinBack(fitness.getBack());
				}
					
			}
			if (currentUserInfo.getMinBiceps() == -1) {
				currentUserInfo.setMinBiceps(fitness.getBiceps());
			} else {
				if (currentUserInfo.getMinBiceps() >= fitness.getBiceps()) {
					currentUserInfo.setMinBiceps(fitness.getBiceps());
				}
					
			}
			if (currentUserInfo.getMinChest() == -1) {
				currentUserInfo.setMinChest(fitness.getChest());
			} else {
				if (currentUserInfo.getMinChest() >= fitness.getChest()) {
					currentUserInfo.setMinChest(fitness.getChest());
				}
					
			}
			if (currentUserInfo.getMinFeet() == -1) {
				currentUserInfo.setMinFeet(fitness.getFeet());
			} else {
				if (currentUserInfo.getMinFeet() >= fitness.getFeet()) {
					currentUserInfo.setMinFeet(fitness.getFeet());
				}
					
			}
			if (currentUserInfo.getMinForearm() == -1) {
				currentUserInfo.setMinForearm(fitness.getForearm());
			} else {
				if (currentUserInfo.getMinForearm() >= fitness.getForearm()) {
					currentUserInfo.setMinForearm(fitness.getForearm());
				}
					
			}
			if (currentUserInfo.getMinLegs() == -1) {
				currentUserInfo.setMinLegs(fitness.getLegs());
			} else {
				if (currentUserInfo.getMinLegs() >= fitness.getLegs()) {
					currentUserInfo.setMinLegs(fitness.getLegs());
				}
					
			}
			if (currentUserInfo.getMinShoulder() == -1) {
				currentUserInfo.setMinShoulder(fitness.getShoulder());
			} else {
				if (currentUserInfo.getMinShoulder() >= fitness.getShoulder()) {
					currentUserInfo.setMinShoulder(fitness.getShoulder());
				}
					
			}
			if (currentUserInfo.getMinTriceps() == -1) {
				currentUserInfo.setMinTriceps(fitness.getTriceps());
			} else {
				if (currentUserInfo.getMinTriceps() >= fitness.getTriceps()) {
					currentUserInfo.setMinTriceps(fitness.getTriceps());
				}
					
			}	
		}
	}
}
