package com.android.fitness.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.android.fitness.entity.Fitness;
import com.android.fitness.repository.FitnessRepository;

@Service
public class FitnessService {

	private int mButtons = 4;
	
	private enum ButtonText {
		Age, Weight, Height, Style, Sex
	}

	@Autowired
	private FitnessRepository fRepo;

	public void setNumberOfButtons(int numberOfButtons) {
		mButtons = numberOfButtons;
	}
	
	public List<Fitness> getByMinAge(int minAge) {
		List<Fitness> fitness = fRepo.findFitnessByMinAge(minAge);
		while (fitness == null) {
			minAge = minAge - 1;
			fitness = fRepo.findFitnessByMinAge(minAge);
		}
		return fitness;
	}

	public Model getSidebarButtonsAccess(Model model) {
		
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

}
