package com.android.fitness.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.android.fitness.entity.Dificulty;
import com.android.fitness.entity.Fitness;
import com.android.fitness.entity.Gender;
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
		Age, Weight, Height, Style, Gender, Dificulty
	}

	private CurrentUserInfo currentUserInfo = new CurrentUserInfo();

	@Autowired
	private FitnessRepository fRepo;

	public void setNumberOfButtons(int numberOfButtons) {
		if (mButtons > 6 || mButtons < 0) {
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
		case "genderPage": {
			currentUserInfo.setGender(Gender.valueOf(input));
			break;
		}
		case "dificultyPage": {
			currentUserInfo.setDificulty(Dificulty.valueOf(input));
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
					if (i <= 5) {
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
		while (fitness == null) {
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
		case genderPage: {
			List<String> genderList = new ArrayList<>();
			for (int i = 0; i < Gender.values().length; i++) {
				genderList.add(Gender.values()[i].name());
			}
			model.addAttribute("allGenders", genderList);
			break;
		}
		case dificultyPage: {
			List<String> dificultyList = new ArrayList<>();
			for (int i = 0; i < Dificulty.values().length; i++) {
				dificultyList.add(Dificulty.values()[i].name());
			}
			model.addAttribute("allDificulties", dificultyList);
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

	public void updateGenderInput(String gender) {
		Gender tempGender = null;
		boolean found = false;
		for (int i = 0; i < Gender.values().length && !found; i++) {
			if (Gender.values()[i].name().equals(gender)) {
				found = true;
				tempGender = Gender.valueOf(gender);
			}
		}

		// if style not found in enum, default value is MALE
		if (!found) {
			tempGender = Gender.MALE;
		}
		currentUserInfo.setGender(tempGender);
	}

	public void updateDificultyInput(String dificulty) {
		Dificulty tempDificulty = null;
		boolean found = false;
		for (int i = 0; i < Dificulty.values().length && !found; i++) {
			if (Dificulty.values()[i].name().equals(dificulty)) {
				found = true;
				tempDificulty = Dificulty.valueOf(dificulty);
			}
		}

		// if style not found in enum, default value is EASY
		if (!found) {
			tempDificulty = Dificulty.EASY;
		}
		currentUserInfo.setDificulty(tempDificulty);
	}
}
