import java.util.Arrays;

public class Player {
	String name;
	int currentHealth;
	int maxHealth;
	int attackPower;
	String[] inventory;
	boolean isDefending;
	int monsterDefeated = 0;
	DungeonGame dungeon = new DungeonGame();
	public int totalMonster = dungeon.totalMonster;

	public Player(String name, int currentHealth, int maxHealth, int attackPower, String[] inventory,
			boolean isDefending) {
		this.name = name;
		this.currentHealth = currentHealth;
		this.maxHealth = maxHealth;
		this.attackPower = attackPower;
		this.inventory = inventory;
		this.isDefending = isDefending;
	}

	public void takeDamage(int damage) {
		currentHealth -= damage;
		if (currentHealth < 0)
			currentHealth = 0;
	}

	public void heal(int amount) {
		currentHealth += amount;
		if (currentHealth > maxHealth)
			currentHealth = maxHealth;
	}

	public void printStatus() {
		System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
		System.out.println(
				"Player " + name + "'s health is" + currentHealth + "/" + maxHealth + ".\nYour inventory is: ");
		for (int i = 0; i < inventory.length; i++) {
			System.out.print(inventory[i] + "---");
		}
		System.out.println("");
		System.out.println("_____________________________________________________________________________");
	}

	public void endStatus() {
		System.out.println(
				name + "'s legacy has ended...\n " + name + " has killed " + monsterDefeated + "/" + totalMonster);
		if (dungeon.gameWon) {
			System.out.println("YOU HAVE DEFEATED ALL THE CREATURES!");
			System.out.println("NOW YOU ARE THE KING OF ALL LEPRICONS");
			System.out.println("YOU HAVE BECOME FIRE LORD");
			System.out.println(
					"⠀⠀⠀⠀⡠⠤⠒⠒⢦⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⢣⢀⢤⣄⣸⡀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⢸⢙⣺⣓⣌⣳⣀⡀⠀⠀⠀⠀\n⠀⠀⢰⢋⠡⢰⡾⠰⣶⣶⢦⡇⠀⠀⠀⠀\n⠀⠀⠀⢿⡎⠂⡁⡤⠡⢰⡟⠃⠀⠀⠀⠀\n⠀⠀⠀⡠⠳⣑⠨⠤⠕⡽⢮⡀⠀⠀⠀⠀\n⠀⢠⠞⣠⠂⡜⠰⠺⠚⠅⢢⡱⣄⠀⠀⠀\n⠀⢺⡐⢼⠀⢄⡇⠀⢫⠀⢸⠊⢈⠇⠀⠀\n⠀⠀⢱⡋⡆⠀⡯⣛⣽⣆⢸⡁⣏⡀⠀⠀\n⠀⠀⠉⢿⠤⠜⠛⠢⠘⠉⣄⠘⣏⠀⠀⠀\n⠀⠀⠀⡜⠀⠀⠀⡏⢻⡀⠈⠉⢣⠀⠀⠀\n⠀⠀⠀⠙⢦⠤⣸⠃⠀⢧⢤⣴⠋⠀⣀⠀\n⠰⡦⢤⣤⣟⣸⠃⠀⠀⠈⢷⡌⢧⡴⢛⠆\n⠀⠑⢬⣋⣨⣹⠀⠀⠀⠀⠈⣇⣻⠤⠞⠀");
		}
	}

	public static Player createCharacter(String name) {
		String[] inven = new String[5];
		inven[0] = "Ignis's Spare";
		inven[1] = "Blaze's Shield";
		inven[2] = "Healing Potion";
		inven[3] = "Empty";
		inven[4] = "Empty";
		Player p1 = new Player(name, 100, 100, 15, inven, false);
		return p1;
	}
}
