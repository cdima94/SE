package com.android.fitness.service;

import com.android.fitness.entity.Style;

/**
 *
 * These fields will update on each action from the user:
 * 		-set new input: on each new input from the user, the respective input field will get the new value and all number of exercises will update
 * 		-get back to previous input: all the fields except the active ones will be reinitialized(with other words, it will go back to a previous state). 
 * 
 * Active field: a field which was set by the user.
 */
public class CurrentUserInfo {

	/*
	 * These represents the number of exercises per type of exercise
	 */
	private int minBiceps;
	private int maxBiceps;
	private int minTriceps;
	private int maxTriceps;
	private int minForearm;
	private int maxForearm;
	private int minShoulder;
	private int maxShoulder;
	private int minChest;
	private int maxChest;
	private int minBack;
	private int maxBack;
	private int minAbdomen;
	private int maxAbdomen;
	private int minFeet;
	private int maxFeet;
	private int minLegs;
	private int maxLegs;
	
	/*
	 * These represents the input from the user
	 */
	private int age;
	private int weight;
	private int height;
	private Style style;
	
	private void init() {
		minBiceps = -1;
		minTriceps = -1;
		minForearm = -1;
		minShoulder = -1;
		minChest = -1;
		minBack = -1;
		minAbdomen = -1;
		minFeet = -1;
		minLegs = -1;
		
		maxBiceps = -1;
		maxTriceps = -1;
		maxForearm = -1;
		maxShoulder = -1;
		maxChest = -1;
		maxBack = -1;
		maxAbdomen = -1;
		maxFeet = -1;
		maxLegs = -1;
		
		age = -1;
		weight = -1;
		height = -1;
		style = null;
	}
	
	public CurrentUserInfo() {
		init();
	}
	
	public int getMinBiceps() {
		return minBiceps;
	}

	public void setMinBiceps(int minBiceps) {
		this.minBiceps = minBiceps;
	}

	public int getMaxBiceps() {
		return maxBiceps;
	}

	public void setMaxBiceps(int maxBiceps) {
		this.maxBiceps = maxBiceps;
	}

	public int getMinTriceps() {
		return minTriceps;
	}

	public void setMinTriceps(int minTriceps) {
		this.minTriceps = minTriceps;
	}

	public int getMaxTriceps() {
		return maxTriceps;
	}

	public void setMaxTriceps(int maxTriceps) {
		this.maxTriceps = maxTriceps;
	}

	public int getMinForearm() {
		return minForearm;
	}

	public void setMinForearm(int minForearm) {
		this.minForearm = minForearm;
	}

	public int getMaxForearm() {
		return maxForearm;
	}

	public void setMaxForearm(int maxForearm) {
		this.maxForearm = maxForearm;
	}

	public int getMinShoulder() {
		return minShoulder;
	}

	public void setMinShoulder(int minShoulder) {
		this.minShoulder = minShoulder;
	}

	public int getMaxShoulder() {
		return maxShoulder;
	}

	public void setMaxShoulder(int maxShoulder) {
		this.maxShoulder = maxShoulder;
	}

	public int getMinChest() {
		return minChest;
	}

	public void setMinChest(int minChest) {
		this.minChest = minChest;
	}

	public int getMaxChest() {
		return maxChest;
	}

	public void setMaxChest(int maxChest) {
		this.maxChest = maxChest;
	}

	public int getMinBack() {
		return minBack;
	}

	public void setMinBack(int minBack) {
		this.minBack = minBack;
	}

	public int getMaxBack() {
		return maxBack;
	}

	public void setMaxBack(int maxBack) {
		this.maxBack = maxBack;
	}

	public int getMinAbdomen() {
		return minAbdomen;
	}

	public void setMinAbdomen(int minAbdomen) {
		this.minAbdomen = minAbdomen;
	}

	public int getMaxAbdomen() {
		return maxAbdomen;
	}

	public void setMaxAbdomen(int maxAbdomen) {
		this.maxAbdomen = maxAbdomen;
	}

	public int getMinFeet() {
		return minFeet;
	}

	public void setMinFeet(int minFeet) {
		this.minFeet = minFeet;
	}

	public int getMaxFeet() {
		return maxFeet;
	}

	public void setMaxFeet(int maxFeet) {
		this.maxFeet = maxFeet;
	}

	public int getMinLegs() {
		return minLegs;
	}

	public void setMinLegs(int minLegs) {
		this.minLegs = minLegs;
	}

	public int getMaxLegs() {
		return maxLegs;
	}

	public void setMaxLegs(int maxLegs) {
		this.maxLegs = maxLegs;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}
	
	public void clear() {
		minAbdomen = -1;
		minBack = -1;
		minBiceps = -1;
		minChest = -1;
		minFeet = -1;
		minForearm = -1;
		minLegs = -1;
		minShoulder = -1;
		minTriceps = -1;
		maxAbdomen = -1;
		maxBack = -1;
		maxBiceps = -1;
		maxChest = -1;
		maxFeet = -1;
		maxForearm = -1;
		maxLegs = -1;
		maxShoulder = -1;
		maxTriceps = -1;
	}
	
}
