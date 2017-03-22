package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import entity.Fitness;

@RepositoryRestResource
interface FitnessRepository extends CrudRepository<Fitness, Integer> {

}
