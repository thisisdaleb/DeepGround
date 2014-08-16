package greenpumpkin.artemis.systems;

import greenpumpkin.MapCreation.MapEntityCreator;
import greenpumpkin.artemis.DGWorld;

import com.artemis.systems.VoidEntitySystem;

public class EntitiesOnMapS extends VoidEntitySystem  {

	@Override
	protected void processSystem() {
		MapEntityCreator.createTheMapEntities(world, DGWorld.mapLocation[0], DGWorld.mapLocation[1]);
	}
	
	@Override
	protected boolean checkProcessing() {
		if(DeleteMapEntitiesS.remove)
			return true;
		return false;
	}
}
