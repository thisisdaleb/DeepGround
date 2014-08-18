package greenpumpkin.artemis.systems;

import greenpumpkin.artemis.DGWorld;
import greenpumpkin.artemis.components.PlayerC;
import greenpumpkin.artemis.components.PositionC;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;

public class MapChangeS extends EntityProcessingSystem {
	@Mapper ComponentMapper<PositionC> posMap;
	
	@SuppressWarnings("unchecked")
	public MapChangeS() {
		super(Aspect.getAspectForAll(PlayerC.class));
	}

	@Override
	protected void process(Entity e) {
		PositionC position = posMap.get(e);
		
		if((position.x+0.5f)<0){
			position.x=31f;
			changeMap(-1,0);
		}
		else if((position.x+0.5f)>32){
			position.x=0.0f;
			changeMap(1,0);
		}
		if((position.y+1f)<0){
			position.y=17f;
			changeMap(0,-1);
		}
		else if((position.y+1f)>18){
			position.y=0.0f;
			changeMap(0,1);
		}
	}

	private void changeMap(int horizontal, int vertical) {
		DGWorld.changeMapLocation(DGWorld.mapLocation[0]+horizontal, DGWorld.mapLocation[1]+vertical);
	}
}
