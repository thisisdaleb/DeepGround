package greenpumpkin.artemis.entities;

import com.artemis.Entity;
import com.artemis.World;

public class GateFactory {
	
	public static Entity createYellowHorizontalGate(World world, float x, float y) {
		Entity e = world.createEntity();
		System.out.println("Horizontal yellow gate created at: " + x + ", " + y);
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
