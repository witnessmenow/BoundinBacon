package com.ladinc.boundingBacon.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.ladinc.boundingBacon.core.BoundingBacon;
import com.ladinc.boundingBacon.core.objects.RaceTrack;

public class RaceScreen implements Screen
{
	private BoundingBacon game;

	public RaceTrack raceTrack;
	
	protected OrthographicCamera camera;
	protected SpriteBatch spriteBatch;
	
	protected World world;
	
	protected Box2DDebugRenderer debugRenderer;
	
	// Used for sprites etc
	protected int screenWidth;
	protected int screenHeight;
	
	// Used for Box2D
	protected float worldWidth;
	protected float worldHeight;
	protected int PIXELS_PER_METER = 10;
	
	protected Vector2 screenCenter;
	protected Vector2 worldCenter;
	
	public RaceScreen(BoundingBacon g, RaceTrack rt)
	{
		this.game = g;
		this.raceTrack = rt;
		
		screenWidth = 1920;
		screenHeight = 1080;
		
		screenCenter = new Vector2(screenWidth/2, screenHeight/2);
		
		worldWidth = screenWidth/PIXELS_PER_METER;
		worldHeight = screenHeight/PIXELS_PER_METER;
		
		worldCenter = new Vector2(worldWidth/2, worldHeight/2);
		
		spriteBatch = new SpriteBatch();
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, screenWidth, screenHeight);
		
		debugRenderer = new Box2DDebugRenderer();
	}
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0, 0, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		
		spriteBatch.begin();
		
		this.raceTrack.drawTrackSprite(spriteBatch);
		
		spriteBatch.end();
		
		debugRenderer.render(world,
			camera.combined.scale(PIXELS_PER_METER,PIXELS_PER_METER,
			PIXELS_PER_METER));
		
	}

	@Override
	public void resize(int width, int height) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() 
	{
		this.world = new World(Vector2.Zero, true);
		
		this.raceTrack.createBodies(world);
		
	}

	@Override
	public void hide() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		
	}

}
