package greenpumpkin.artemis.entities;

import greenpumpkin.artemis.components.SpriteC;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GateFactory {
	
	public static Entity createYellowHorizontalGate(World world, float x, float y) {
		Entity e = world.createEntity();
		
		System.out.println("Horizontal yellow gate created at: " + x + ", " + y);
		Texture texture = new Texture(Gdx.files.internal("DGItems/YellowGate.png"));
		
		SpriteC sprite = new SpriteC();
		sprite.sprite = new Sprite(texture);
		sprite.sprite.setScale(1/16f);
		sprite.sprite.setOrigin(0, 0);
		e.addComponent(sprite);
		
		return e;
	}
	
	public static Entity createYellowVerticalGate(World world, float x, float y) {
		Entity e = world.createEntity();
		System.out.println("Vertical yellow gate created at: " + x + ", " + y);
		return e;
	}
	
	public static Entity createBlueGate(World world, float x, float y) {
		Entity e = world.createEntity();
		System.out.println("Vertical gate created at: " + x + ", " + y);
		return e;
	}
}
