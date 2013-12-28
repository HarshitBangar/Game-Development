package com.test.canyonbunny;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.test.canyonbunny.game.Assets;
import com.test.canyonbunny.game.WorldController;
import com.test.canyonbunny.game.WorldRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;


public class CanyonBunny implements ApplicationListener{

	private static final String TAG = CanyonBunny.class.getName();
	
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	
	private boolean paused = false;
	
	@Override
	public void create() {
		// Setting the Libgdx Log Level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		//Load Assets
		Assets.instance.init(new AssetManager());
		//Initializing the worldcontroller and renderer
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);	
	
		paused = false;
		
	}

	@Override
	public void resize(int width, int height) {
		worldRenderer.resize(width, height);
	}

	@Override
	public void render() {
		// Updating the Game logic in WorldController
		if(!paused)
			worldController.update(Gdx.graphics.getDeltaTime());
		
		//Setting the clear screen color to blue
		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f,
				0xff/255.0f);

		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//Calling the worldRender's renderer
		worldRenderer.render();
		
	}

	@Override
	public void pause() {

		paused = true;
	}

	@Override
	public void resume() {
		Assets.instance.init(new AssetManager());
		paused = false;
	}

	@Override
	public void dispose() {
		worldRenderer.dispose();
		Assets.instance.dispose();
	}
	
	
}