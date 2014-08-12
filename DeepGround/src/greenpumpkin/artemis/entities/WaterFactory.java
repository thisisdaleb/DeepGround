package greenpumpkin.artemis.entities;

import greenpumpkin.artemis.components.ShaderC;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class WaterFactory {
	
	public static Entity create(World world, float x, float y, String vertex, String fragment ) {
		Entity e = world.createEntity();
		
		ShaderC shader = new ShaderC();
		shader.shaderProgram = new ShaderProgram(Gdx.files.internal(vertex), Gdx.files.internal(fragment));
		shader.mesh = new Mesh(true, true, 10, 10, null);
		e.addComponent(shader);
		
		return e;
	}
}
