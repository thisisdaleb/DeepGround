package greenpumpkin.artemis;

import java.util.ArrayList;

public class MapList {
	public static ArrayList<ArrayList<String>> mapList = new ArrayList<ArrayList<String>>();
	
	public static void init() {
		for(int y = 0; y <= 6; y++) {
			
			mapList.add(new ArrayList<String>());
			for(int x = 0; x <= 6; x++) {
				char xValue = (char) ('A'+x);
				String mapName = "" + y + xValue;
				mapList.get(y).add((String) (mapName +".tmx"));
				System.out.println(mapList.get(y).get(x));
			}
		}
	}

}
