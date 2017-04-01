package com.android.fitness.service;

import com.android.fitness.entity.Dificulty;
import com.android.fitness.entity.Gender;
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
	private int biceps;
	private int triceps;
	private int forearm;
	private int shoulder;
	private int chest;
	private int back;
	private int abdomen;
	private int feet;
	private int legs;
	
	/*
	 * These represents the input from the user
	 */
	private int age;
	private int weight;
	private int height;
	private Style style;
	private Gender gender;
	private Dificulty dificulty;
	
	private void init() {
		biceps = -1;
		triceps = -1;
		forearm = -1;
		shoulder = -1;
		chest = -1;
		back = -1;
		abdomen = -1;
		feet = -1;
		legs = -1;
		
		age = -1;
		weight = -1;
		height = -1;
		style = null;
		gender = null;
		dificulty = null;
	}
	
	public CurrentUserInfo() {
		init();
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Dificulty getDificulty() {
		return dificulty;
	}

	public void setDificulty(Dificulty dificulty) {
		this.dificulty = dificulty;
	}
	
	
}
