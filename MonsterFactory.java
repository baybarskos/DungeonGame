public class MonsterFactory {
	public static Monster createMonster(String type) {
		Monster monster;
		switch (type.toUpperCase()) {
		case "TUKILETTU":
			monster = new Monster("Tukilettu", 30, 5, false);
			monster.isTukilettu = true;
			return monster;
		case "PHOENIX":
			monster = new Monster("Phoenix", 45, 15, true);
			monster.isPheonix = true;
			return monster;
		case "DRAGON":
			monster = new Monster("Dragon", 120, 30, false);
			monster.isDragon = true;
			return monster;
		default:
			monster = new Monster("Mini Fire Semender", 1, 1, false);// I used this as default
			return monster;
		}

	}
}
