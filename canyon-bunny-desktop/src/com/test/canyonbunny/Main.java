package com.test.canyonbunny;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
//import 
public class Main {

	private static boolean rebuildAtlas = false;
	private static boolean drawDebugOutline = false;

	public static void main(String[] args) {
		
		if(rebuildAtlas){
			Settings settings = new Settings();
			settings.maxHeight = 1024;
			settings.maxWidth = 1024;
			settings.debug = drawDebugOutline;
			TexturePacker2.process(settings, "assets-raw/images",
					"../CanyonBunny-android/assets/images",
					"canyonbunny.pack");

		}
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "canyon-bunny";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 480;
		
		new LwjglApplication(new CanyonBunny(), cfg);
	}
}
