package greenpumpkin.artemis.systems;

import greenpumpkin.artemis.DGWorld;
import greenpumpkin.artemis.entities.LightFactory;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

public class LightsOnMapS extends VoidEntitySystem {

	@Override
	protected void processSystem() {
		for(int x = 0;x<33;x++)
			for(int y = 0; y<18;y++){
				if(isCellBlocked(x,y,"lightYellow")){
					world.addEntity(LightFactory.createPoint(world, DGWorld.rayHandler,  DGWorld.numRays, new Color(0.4f, 0.45f, 0.2f, 1.0f), DGWorld.lightDistance, x+0.5f, y+0.5f));
				}
				else if(isCellBlocked(x,y,"lightRed")){
					world.addEntity(LightFactory.createPoint(world, DGWorld.rayHandler,  DGWorld.numRays, new Color(0.4f, 0.1f, 0.1f, 1.0f), DGWorld.lightDistance, x+0.5f, y+0.5f));
				}
				else if(isCellBlocked(x,y,"lightGreen")){
					world.addEntity(LightFactory.createPoint(world, DGWorld.rayHandler,  DGWorld.numRays, new Color(0.1f, 0.45f, 0.1f, 1.0f), DGWorld.lightDistance, x+0.5f, y+0.5f));
				}
				else if(isCellBlocked(x,y,"lightBlue")){
					world.addEntity(LightFactory.createPoint(world, DGWorld.rayHandler,  DGWorld.numRays, new Color(0.1f, 0.1f, 0.6f, 1.0f), DGWorld.lightDistance, x+0.5f, y+0.5f));
				}
				else if (isCellBlocked(x,y, "waterLight")){
					world.addEntity(LightFactory.createPoint(world, DGWorld.rayHandler,  DGWorld.numRays, new Color(0.0f, 0.0f, 0.2f, 1.0f), DGWorld.lightDistance, x+0.5f, y+0.5f));
				}
			}
		DeleteMapEntitiesS.remove=false;
	}
	
	private boolean isCellBlocked(float x, float y, String id) {
		Boolean blocked = false;
		Cell cell = DGWorld.collisionLayer.getCell((int) (x), (int) (y));
		if(cell != null){
			if(cell.getTile() != null){
				if(cell.getTile().getProperties().containsKey(id)){
					blocked = true;
				}
			}
		}
		//if cell is not empty and the tile of the cell is not empty and the cell's properties says its blocked
		return blocked;
	}
	
	@Override
	protected boolean checkProcessing() {
		if(DeleteMapEntitiesS.remove)
			return true;
		return false;
	}
}
