package com.android.fitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.fitness.entity.Fitness;
import com.android.fitness.repository.FitnessRepository;

@Service
public class FitnessService {

	@Autowired
	private FitnessRepository fRepo;
	
	public List<Fitness> getByMinAge(int minAge) {
		List<Fitness> fitness = fRepo.findFitnessByMinAge(minAge);
		while (fitness == null) {
			minAge = minAge - 1;
			fitness = fRepo.findFitnessByMinAge(minAge);
		}
		return fitness;
	}
}
