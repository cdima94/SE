package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import entity.Fitness;

@RestResource
interface FitnessRepository extends CrudRepository<Fitness, Integer> {

}
