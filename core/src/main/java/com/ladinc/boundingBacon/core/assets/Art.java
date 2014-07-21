package com.ladinc.boundingBacon.core.assets;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ladinc.boundingBacon.core.objects.RaceTrack.TrackName;

public class Art 
{
	public static enum Artwork { track1}
	
	public static HashMap<Artwork, Texture> textureTable = new HashMap<Artwork, Texture>();
	public static HashMap<Artwork, Sprite> spriteTable = new HashMap<Artwork, Sprite>();
	public static HashMap<TrackName, Sprite> trackSpriteTable = new HashMap<TrackName, Sprite>();

	public static void load()
	{
		loadTextures();
		loadSprites();
	}
	
	private static void loadTextures()
	{
		
		Gdx.app.debug("Art",
				"LoadTextures - Begin");
		
		Gdx.app.debug("Art",
				"LoadTextures - End");
		
	}
	
	//For Images that will only ever be used as sprites
	private static void loadSprites()
	{
		
		Gdx.app.debug("Art",
				"LoadSprites - Begin");
		trackSpriteTable.put(TrackName.track1, new Sprite( new Texture(Gdx.files.internal("Tracks/track1.png"))));
		
		Gdx.app.debug("Art",
				"LoadSprites - End");
		
	}
	
}
