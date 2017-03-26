package com.android.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
