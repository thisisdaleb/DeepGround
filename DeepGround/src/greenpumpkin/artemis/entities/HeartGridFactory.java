package greenpumpkin.artemis.entities;

import com.artemis.Entity;
import com.artemis.World;

public class HeartGridFactory {
	
	public static Entity create(World world) {
		Entity e = world.createEntity();
		return e;
	}
}
