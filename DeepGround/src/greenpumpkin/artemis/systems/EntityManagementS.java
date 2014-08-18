package greenpumpkin.artemis.systems;

import greenpumpkin.MapCreation.MapEntityCreator;
import greenpumpkin.artemis.DGWorld;
import greenpumpkin.artemis.components.ItemC;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.ImmutableBag;

public class EntityManagementS extends EntitySystem {
	public static boolean remove = false;

	@SuppressWarnings("unchecked")
	public EntityManagementS() {
		super(Aspect.getAspectForAll(ItemC.class));
	}

	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		for (int i = 0, s = entities.size(); s > i; i++) {
			process(entities.get(i));
		}
		MapEntityCreator.createTheMapEntities(world, DGWorld.mapLocation[0], DGWorld.mapLocation[1]);
	}
	
	private void process(Entity e) {
		e.deleteFromWorld();
	}

	protected boolean checkProcessing() {
		if(remove)
			return true;
		return false;
	}
	

}
