package com.android.fitness.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.android.fitness.entity.Fitness;

@RepositoryRestResource
public interface FitnessRepository extends CrudRepository<Fitness, Integer> {

	List<Fitness> findFitnessByMinAge(int minAge);
}
