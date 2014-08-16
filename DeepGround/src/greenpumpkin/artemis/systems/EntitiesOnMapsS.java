package greenpumpkin.artemis.systems;

import com.artemis.systems.VoidEntitySystem;

public class EntitiesOnMapsS extends VoidEntitySystem  {

	@Override
	protected void processSystem() {
		
	}
	
	@Override
	protected boolean checkProcessing() {
		if(DeleteMapEntitiesS.remove)
			return true;
		return false;
	}
}
