package com.ladinc.boundingBacon.core.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.ladinc.boundingBacon.core.assets.Art;
import com.ladinc.boundingBacon.core.utilities.BodyEditorLoader;

public class RaceTrack 
{
	public TrackName trackId;
	public Sprite trackSprite;
	public Body body;
	
	public RaceTrack(TrackName track)
	{
		trackId = track;
		trackSprite = Art.trackSpriteTable.get(trackId);
		trackSprite.setPosition(0, 0);
	}
	
	public static enum TrackName { track1}
	
	public void createBodies(World world)
	{
		BodyEditorLoader loader = RaceTrack.getTrackData(this.trackId);
		
		BodyDef bd = new BodyDef();
	    bd.position.set(0, 0);
		
	    FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.density = 1.0f;
		
		this.body = world.createBody(bd);
		
		loader.attachFixture(this.body, "track", fixtureDef, 192);
	}
	
	public void drawTrackSprite(SpriteBatch batch)
	{
		trackSprite.draw(batch);
	}
	
	public static BodyEditorLoader getTrackData(TrackName track)
	{
		switch (track)
		{
			case track1:
				return new BodyEditorLoader(Gdx.files.internal("Tracks/track1.json"));
		}
		
		return null;
	}

}
