package greenpumpkin.MapCreation;

import java.util.ArrayList;

public class MapList {
	public static ArrayList<ArrayList<String>> mapList = new ArrayList<ArrayList<String>>();
	
	public static void init(int sizeX, int sizeY) {
		for(int y = 0; y < sizeY; y++) {
			mapList.add(new ArrayList<String>());
			for(int x = 0; x < sizeX; x++) {
				char xValue = (char) ('A'+x);
				String mapName = "" + y + xValue;
				mapList.get(y).add((String) (mapName +".tmx"));
			}
		}
	}
}
