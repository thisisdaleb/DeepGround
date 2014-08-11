package greenpumpkin.screens;

import greenpumpkin.artemis.DGWorld;
import greenpumpkin.artemis.entities.LightFactory;
import greenpumpkin.artemis.entities.PlayerFactory;
import greenpumpkin.artemis.systems.*;
import greenpumpkin.game.*;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

////////////////////////////////////////////////////////////
//This is the Artemis test screen. It is useful for/////////
//learning how Artemis works.///////////////////////////////
////////////////////////////////////////////////////////////

public class TestWorld implements Screen {
	private Stage stage = new Stage();
	Music caveTheme = Gdx.audio.newMusic(Gdx.files.internal("music/thisIsHome.mp3"));
	private DGWorld world;
	
	@Override
	public void show() {
		world = new DGWorld();

		DGWorld.init();
		DGWorld.setMaps("TestMap.tmx", "TestMapBack.tmx");

		world.setManager(new GroupManager());
		world.setSystem(new ControllerInputS());
		world.setSystem(new TiledS());
		world.setSystem(new LightCycleS());
		world.setSystem(new HealthS());
		world.setSystem(new MapCollisionS());
		world.setSystem(new MovementS());
		world.setSystem(new BatchRendererS());
		world.setSystem(new LightS());
		world.initialize();

		//These lights will not be here. They are just for a test.
		world.addEntity(LightFactory.createCyclePoint(world, DGWorld.rayHandler,  DGWorld.numRays, new Color(0.0f, 0.1f, 0.8f, 1.0f), DGWorld.lightDistance*2f, 6f, 1.0f, 1f, 30f/64f));
		world.addEntity(LightFactory.createCyclePoint(world, DGWorld.rayHandler,  DGWorld.numRays, new Color(1.0f, 1.0f, 0.9f, 1.0f), DGWorld.lightDistance*2, 35f, 11f, 7.7f, 1.875f*4f));
		//the real list of lights will be created with a for loop where the numbers come from a JSON file, in a different system.
		
		world.addEntity(PlayerFactory.create(world, 12, 4));
		
		caveTheme.play();
		caveTheme.setLooping(true);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(delta<0.2f){
			DGWorld.camera.update();
			world.setDelta(delta);
			world.process();
		}
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().setCamera(new VirtualResolution(DeepGround.WIDTH, DeepGround.HEIGHT));
		 DGWorld.batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void dispose() {
		stage.dispose();
		caveTheme.dispose();
	}
}
