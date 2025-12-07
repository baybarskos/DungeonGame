public class Treasure extends RoomContent {
	String itemFound;

	public Treasure(String description) {
		itemFound = description;
	}

	public String getTreasure() {
		return itemFound;
	}
	public void treasureDescription(String item){
		switch(item){
		case "Healing Potion":
			System.out.println("Healing Potion heals your health for 35 points");
			break;
		case "Ignis's Hair":
			System.out.println("Ignis's Hair rolls a dice of six and it either damage you heavily, do nothing or kills the enemy");
			break;
		case "Dragon's Breath":
			System.out.println("Dragon's Breath  gives you either passive health regen +5 after every round or +5 base damage");
			break;}
			System.out.println("----------------------------------------------");}
}
