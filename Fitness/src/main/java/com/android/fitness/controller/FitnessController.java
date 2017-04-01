package com.android.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.fitness.entity.Fitness;
import com.android.fitness.service.FitnessService;

@Controller
public class FitnessController {

	@Autowired
	private FitnessService fService;
	
	@ResponseBody
	@RequestMapping(value = "/getFitnessByMinAge/{minAge}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Fitness> getFitnessMinAge(@PathVariable("minAge") int minAge) {
		List<Fitness> fitnessList = fService.getByMinAge(minAge);
		return fitnessList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateButtons", method = RequestMethod.GET)
	public void updateButtons(@RequestParam(defaultValue = "4", name = "numberOfButtons") String numberOfButtons){
		fService.setNumberOfButtons(Integer.valueOf(numberOfButtons));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String homePage(Model model) {
		model = fService.getSidebarButtonsAccess(model);
		return "ManagePage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/setActiveInput", method = RequestMethod.GET)
	public void setNewActiveInput(@RequestParam(defaultValue = "agePage", name = "activePage") String activePage, @RequestParam(defaultValue = "", name = "input") String input) {
		fService.setActiveInput(activePage, input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/setResult", method = RequestMethod.GET)
	public void setResult(@RequestParam(defaultValue = "stylePage", name = "activePage") String activePage, @RequestParam(defaultValue = "", name = "input") String input) {
		fService.setInput(activePage, input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateAge", method = RequestMethod.GET)
	public void setNewAge(@RequestParam(defaultValue = "-1", name = "ageInput") String ageInput) {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateWeight", method = RequestMethod.GET)
	public void setNewWeight(@RequestParam(defaultValue = "-1", name = "weightInput") String weightInput) {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateHeight", method = RequestMethod.GET)
	public void setNewHeight(@RequestParam(defaultValue = "-1", name = "heightInput") String heightInput) {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateStyle", method = RequestMethod.GET)
	public void setNewStyle(@RequestParam(defaultValue = "null", name = "styleInput") String styleInput) {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateGender", method = RequestMethod.GET)
	public void setNewGender(@RequestParam(defaultValue = "null", name = "genderInput") String genderInput) {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateDificulty", method = RequestMethod.GET)
	public void setNewDificulty(@RequestParam(defaultValue = "-1", name = "dificultyInput") String dificultyInput) {
		
	}
}
