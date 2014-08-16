package greenpumpkin.MapCreation;

import greenpumpkin.artemis.entities.GateFactory;

import com.artemis.World;

public class ItemAssembler {
	static final int yellowHorizontalGate = 0;
	static final int yellowVerticalGate = 1;
	static final int blueGate = 2;
	static final int jumpUpgrade = 3;
	static final int floatUpgrade = 4;
	static final int yellowGateSensor = 5;
	static final int blueGateSensor = 6;
	static final int bugEnemy = 7;
	static final int finalBoss = 8;
	
	public static void createItem(World world, int itemType, float x, float y) {
	 switch(itemType) {
	 case yellowHorizontalGate : 
		 world.addEntity(GateFactory.createYellowHorizontalGate(world, x, y));
		 break;
	 case yellowVerticalGate : 
		 world.addEntity(GateFactory.createYellowVerticalGate(world, x, y));
		 break;
	 case blueGate : 
		 world.addEntity(GateFactory.createBlueGate(world, x, y));
		 break;
	 case jumpUpgrade : 
		 break;
	 case floatUpgrade : 
		 break;
	 case yellowGateSensor : 
		 break;
	 case blueGateSensor : 
		 break;
	 case bugEnemy : 
		 break;
	 case finalBoss : 
		 break;
	 default : 
		 System.out.println("THAT ISNT A POSSIBLE GAME ITEM"); 
		 break; 
	 }
	}
}
