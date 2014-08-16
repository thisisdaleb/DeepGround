package greenpumpkin.MapCreation;

import com.artemis.World;

public class MapEntityCreator {

	public static void createTheMapEntities(World world, int x, int y) {
		if(y>=0 && y<=2)
			Map012.createMap(world,x,y);
	}
}
