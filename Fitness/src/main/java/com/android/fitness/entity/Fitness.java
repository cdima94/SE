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

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(int minWeight) {
		this.minWeight = minWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public int getBiceps() {
		return biceps;
	}

	public void setBiceps(int biceps) {
		this.biceps = biceps;
	}

	public int getTriceps() {
		return triceps;
	}

	public void setTriceps(int triceps) {
		this.triceps = triceps;
	}

	public int getForearm() {
		return forearm;
	}

	public void setForearm(int forearm) {
		this.forearm = forearm;
	}

	public int getShoulder() {
		return shoulder;
	}

	public void setShoulder(int shoulder) {
		this.shoulder = shoulder;
	}

	public int getChest() {
		return chest;
	}

	public void setChest(int chest) {
		this.chest = chest;
	}

	public int getBack() {
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}

	public int getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(int abdomen) {
		this.abdomen = abdomen;
	}

	public int getFeet() {
		return feet;
	}

	public void setFeet(int feet) {
		this.feet = feet;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getId() {
		return id;
	}
	
	
}
