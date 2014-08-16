package greenpumpkin.artemis;

import greenpumpkin.MapCreation.MapList;
import greenpumpkin.artemis.systems.DeleteMapEntitiesS;

import java.util.Arrays;

import com.artemis.World;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import box2dLight.RayHandler;

public class DGWorld extends World {
	private static TiledMap foregroundMap;
	private static TiledMap backgroundMap;
	private static float mapSize = 1/16f;
	public static final int numRays = 16; //how many rays are emitted for shadow casting
	public static final float lightDistance = 10f; // distance light goes
	public static RayHandler rayHandler; //the main object of light2d, heavily important
	public static OrthographicCamera camera;
	public static SpriteBatch batch;
	public static OrthogonalTiledMapRenderer frontRenderer;
	public static OrthogonalTiledMapRenderer backRenderer;
	public static TiledMapTileLayer collisionLayer;
	public static int mapLocation[] = new int[]{0,1};
	private static float ambientColor[] = new float[]{0.20f ,0.20f ,0.26f};
	
	public static void init() {
		initCamera();
		initRayHandler();
		initBatch();
	}
	
	private static void initCamera() {
		camera = new OrthographicCamera(32,18);
		camera.position.set(16, 9, 0);
		camera.update(true);
	}
	
	private static void initRayHandler() {
		RayHandler.useDiffuseLight(true);
		rayHandler = new RayHandler(null);
		rayHandler.setCombinedMatrix(camera.combined);
		rayHandler.setAmbientLight(ambientColor[0]+(0.012f*mapLocation[1]), ambientColor[0]+(0.012f*mapLocation[1]), ambientColor[0]+(0.007f*mapLocation[1]), 1f);
		rayHandler.setCulling(true);
		rayHandler.setBlurNum(1);
		rayHandler.setShadows(true);
	}
	
	private static void initBatch() {
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
	}
	
	public static void setMaps(String frontMap, String backMap) {
		setForegroundMap(frontMap);
		setBackgroundMap(backMap);
	}
	
	public static void setForegroundMap(String mapFile) {
		foregroundMap = new TmxMapLoader().load("DGMaps/" + mapFile);
		frontRenderer = new OrthogonalTiledMapRenderer(DGWorld.foregroundMap, mapSize);
		frontRenderer.setView(camera);
		collisionLayer = (TiledMapTileLayer) foregroundMap.getLayers().get(1);
		DeleteMapEntitiesS.remove=true;
	}
	
	public static void setBackgroundMap(String mapFile) {
		backgroundMap = new TmxMapLoader().load(mapFile);
		backRenderer = new OrthogonalTiledMapRenderer(DGWorld.backgroundMap, mapSize);
		backRenderer.setView(camera);
	}
	
	public static void changeMapLocation(int horizontal, int vertical) {
		mapLocation[0] = horizontal;
		mapLocation[1] = vertical;
		if(horizontal>=0 && vertical>=0){
			setForegroundMap(MapList.mapList.get(vertical).get(horizontal));
			rayHandler.setAmbientLight(ambientColor[0]+(0.03f*mapLocation[1]), ambientColor[0]+(0.03f*mapLocation[1]), ambientColor[0]+(0.01f*mapLocation[1]), 1f);
		}
		else System.out.println("ERROR: " + Arrays.toString(mapLocation));
	}
	
	public static void flushRayHandler() {
		rayHandler.removeAll();
	}
}
