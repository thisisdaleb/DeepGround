package greenpumpkin.MapCreation;

import com.artemis.World;

public class Map012 {
	public static void createMap(World world, int x, int y) {
		//ROW ZERO (BOTTOM ROW)
		if(y==0){
			createMapsRow0(world, x, y);
		}
		//ROW ONE
		else if(y==1){
			createMapsRow1(world, x, y);
		}
		//ROW ONE
		else if(y==2){
			createMapsRow2(world, x, y);
		}
	}

	private static void createMapsRow0(World world, int x, int y) {
		//BOTTOM CORNER: 0A
		if(x==0){
			
		}
	}

	private static void createMapsRow1(World world, int x, int y) {
		//STARTING MAP: 1A
		if(x==0){
			ItemAssembler.createItem(world, ItemAssembler.yellowHorizontalGate, 1, 0);
		}
	}

	private static void createMapsRow2(World world, int x, int y) {
		
	}
}
