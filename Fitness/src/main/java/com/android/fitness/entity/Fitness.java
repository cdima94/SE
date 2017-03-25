package com.android.fitness.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@Enumerated(EnumType.STRING)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + maxAge;
		result = prime * result + maxHeight;
		result = prime * result + maxWeight;
		result = prime * result + minAge;
		result = prime * result + minHeight;
		result = prime * result + minWeight;
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fitness other = (Fitness) obj;
		if (id != other.id)
			return false;
		if (maxAge != other.maxAge)
			return false;
		if (maxHeight != other.maxHeight)
			return false;
		if (maxWeight != other.maxWeight)
			return false;
		if (minAge != other.minAge)
			return false;
		if (minHeight != other.minHeight)
			return false;
		if (minWeight != other.minWeight)
			return false;
		if (style != other.style)
			return false;
		return true;
	}
}
