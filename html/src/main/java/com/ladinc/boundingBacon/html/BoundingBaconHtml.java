package com.ladinc.boundingBacon.html;

import com.ladinc.boundingBacon.core.BoundingBacon;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class BoundingBaconHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new BoundingBacon();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
