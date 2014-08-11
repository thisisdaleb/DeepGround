package greenpumpkin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

////////////////////////////////////////////////////////////
//This is an empty screen. It will be made as a standard////
//screen for when creating new screens./////////////////////
////////////////////////////////////////////////////////////

public class EmptyScreen implements Screen {
	private Stage stage = new Stage();

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1); // sets clear color to black
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear the batch
		stage.act(); // update all actors
		stage.draw(); // draw all actors on the Stage.getBatch()
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		/*
		 * If your image is not the same size as your screen
		 * splashImage.setX(?);splashImage.setY(?);
		 */
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
	}
}
