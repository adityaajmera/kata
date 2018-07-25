package com.practice.kata;

public class ChristmasLight {
	private OnOffState[][] lights = new OnOffState[1000][1000];

	public ChristmasLight() {
		turnOnOffLight(0, 0, 999, 999, OnOffState.OFF);
	}

	public boolean turnOn(int x1, int y1, int x2, int y2) {
		turnOnOffLight(x1, y1, x2, y2, OnOffState.ON);
		return true;
	}

	public boolean turnOff(int i, int j, int k, int l) {
		turnOnOffLight(i, j, k, l, OnOffState.OFF);
		return true;
	}

	public OnOffState isLightOnOff(int i, int j) {
		return lights[i][j];
	}
	
	public void toggle(int i, int j, int k, int l) {
		for (int a=i; a<=k; a++) {
			for (int b=j; b<=l; b++) {
				if(isLightOnOff(a, b).equals(OnOffState.OFF)) {
					lights[a][b] = OnOffState.ON;
				} else {
					lights[a][b] = OnOffState.OFF;
				}
			}
		}
	}
	
	public int countLights() {
		int count = 0;
		for(int i=0; i<=999; i++) {
			for(int j=0; j<=999; j++) {
				if(isLightOnOff(i, j).equals(OnOffState.ON)) {
					count++;
				}
			}
		}
		return count;
	}
	
	private void turnOnOffLight(int x1, int y1, int x2, 
			int y2, OnOffState state) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				lights[i][j] = state;
			}
		}
	}
}
