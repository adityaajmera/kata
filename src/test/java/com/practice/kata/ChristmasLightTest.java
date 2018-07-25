package com.practice.kata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class ChristmasLightTest {
	
	@Test
	public void turnOnTheLights() {
		ChristmasLight light = new ChristmasLight();
		assertThat(light, notNullValue());
		boolean state = light.turnOn(0,0,1,1);
		assertThat(state, notNullValue());
		assertThat(state, equalTo(true));
		assertThat(light.isLightOnOff(0, 0), equalTo(OnOffState.ON));
		assertThat(light.isLightOnOff(1, 1), equalTo(OnOffState.ON));
		assertThat(light.isLightOnOff(0, 1), equalTo(OnOffState.ON));
		assertThat(light.isLightOnOff(1, 0), equalTo(OnOffState.ON));
	}
	
	@Test
	public void turnOffTheLights() {
		ChristmasLight light = new ChristmasLight();
		boolean state = light.turnOff(0,0,1,1);
		assertThat(state, notNullValue());
		assertThat(state, equalTo(true));
		assertThat(light.isLightOnOff(0, 0), equalTo(OnOffState.OFF));
		assertThat(light.isLightOnOff(1, 1), equalTo(OnOffState.OFF));
	}
	
	@Test
	public void whenNoInstructionsExecuted_allLightsOff() {
		ChristmasLight light = new ChristmasLight();
		OnOffState state = light.isLightOnOff(0,0);
		assertThat(state, notNullValue());
		assertThat(state, equalTo(OnOffState.OFF));
	}
	
	@Test
	public void whenLightsAreOnAndOffOneAfterAnother_shouldOnAndOffAccordingly() {
		ChristmasLight light = new ChristmasLight();
		OnOffState state = light.isLightOnOff(0,0);
		assertThat(state, equalTo(OnOffState.OFF));
		light.turnOn(0, 0, 1, 1);
		state = light.isLightOnOff(0,0);
		assertThat(state, equalTo(OnOffState.ON));
		state = light.isLightOnOff(3, 3);
		assertThat(state, equalTo(OnOffState.OFF));
		light.turnOff(0, 0, 1, 1);
		state = light.isLightOnOff(0,0);
		assertThat(state, equalTo(OnOffState.OFF));
	}
	
	@Test
	public void whenLightsAreToggle_onShouldBeOff() {
		ChristmasLight light = new ChristmasLight();
		light.turnOn(0, 0, 1, 1);
		light.turnOff(2, 2, 3, 3);
		light.toggle(0, 0, 3, 3);
		OnOffState stateAt11 = light.isLightOnOff(1, 1);
		OnOffState stateAt22 = light.isLightOnOff(2, 2);
		assertThat(stateAt11, equalTo(OnOffState.OFF));
		assertThat(stateAt22, equalTo(OnOffState.ON));
	}
	
	@Test
	public void countOnLights() {
		ChristmasLight light = new ChristmasLight();
		int count = light.countLights();
		assertThat(count, equalTo(0));
		light.turnOn(0, 0, 1, 1);
		count = light.countLights();
		assertThat(count, equalTo(4));
		light.turnOn(2, 2, 3, 3);
		count = light.countLights();
		assertThat(count, equalTo(8));
		light.turnOn(0, 0, 999, 999);
		count = light.countLights();
		assertThat(count, equalTo(1000000));
	
	}
	
	@Test
	public void santaInstructions() { 
		ChristmasLight light = new ChristmasLight();
		light.turnOn(0, 0, 999, 999);
		light.toggle(0, 0, 999, 0);
		light.turnOff(499, 499, 500, 500);
		int count = light.countLights();
		assertThat(count, equalTo(998996));
		System.out.println(count);
	}
}
