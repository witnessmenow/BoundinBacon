package com.ladinc.boundingBacon.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.mappings.Ouya;
import com.ladinc.boundingBacon.core.assets.Assets;
import com.ladinc.boundingBacon.core.controllers.FireTV;
import com.ladinc.boundingBacon.core.objects.RaceTrack;
import com.ladinc.boundingBacon.core.objects.RaceTrack.TrackName;
import com.ladinc.boundingBacon.core.screens.RaceScreen;

public class BoundingBacon extends Game 
{
	public static boolean touchScreen = false;

	@Override
	public void create() 
	{
		Gdx.app.setLogLevel(Application.LOG_ERROR);
		Gdx.input.setCatchBackKey(true);
		
		if(Gdx.app.getType() == ApplicationType.Android
				&& !(Ouya.runningOnOuya || FireTV.isRunningOnFireTV() ))
		{
			touchScreen = true;
		}
		
		Assets.load();
		
		setScreen(new RaceScreen(this, new RaceTrack(TrackName.track1)));
	}
}
