package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fitness {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "min_age", nullable = false)
	private int minAge;

	@Column(name = "max_age", nullable = false)
	private int maxAge;

	@Column(name = "min_weight", nullable = false)
	private int minWeight;

	@Column(name = "max_weight", nullable = false)
	private int maxWeight;

	@Column(name = "min_height", nullable = false)
	private int minHeight;

	@Column(name = "max_height", nullable = false)
	private int maxHeight;

	@Column(name = "style", nullable = false)
	private Style style;

	@Column(name = "biceps", nullable = false)
	private int biceps;

	@Column(name = "triceps", nullable = false)
	private int triceps;

	@Column(name = "forearm", nullable = false)
	private int forearm;

	@Column(name = "shoulder", nullable = false)
	private int shoulder;

	@Column(name = "chest", nullable = false)
	private int chest;

	@Column(name = "back", nullable = false)
	private int back;

	@Column(name = "abdomen", nullable = false)
	private int abdomen;

	@Column(name = "feet", nullable = false)
	private int feet;

	@Column(name = "legs", nullable = false)
	private int legs;
}
