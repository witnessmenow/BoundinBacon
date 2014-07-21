package com.ladinc.boundingBacon.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.ladinc.boundingBacon.core.BoundingBacon;

public class BoundingBaconDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1920;
		config.height = 1080;
		new LwjglApplication(new BoundingBacon(), config);
	}
}
