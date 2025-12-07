import java.util.Arrays;

public class Player {
	String name;
	int currentHealth;
	int maxHealth;
	int attackPower;
	String[] inventory;
	boolean isDefending;
	int monsterDefeated = 0;
	Main dungeon=new Main();
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

	public void endStatus(int race) {
		System.out.println(
				name + "'s legacy has ended...\n " + name + " has killed " + monsterDefeated + "/" + totalMonster);
        switch(race){
            case 1:
		        if (dungeon.gameWon) {
			        System.out.println("YOU HAVE DEFEATED ALL THE CREATURES!");
	    		    System.out.println("NOW YOU ARE THE KING OF ALL LEPRICONS");
	    		    System.out.println("YOU HAVE BECOME FIRE LORD");
	    		    System.out.println(
					"⠀⠀⠀⠀⡠⠤⠒⠒⢦⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⢣⢀⢤⣄⣸⡀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⢸⢙⣺⣓⣌⣳⣀⡀⠀⠀⠀⠀\n⠀⠀⢰⢋⠡⢰⡾⠰⣶⣶⢦⡇⠀⠀⠀⠀\n⠀⠀⠀⢿⡎⠂⡁⡤⠡⢰⡟⠃⠀⠀⠀⠀\n⠀⠀⠀⡠⠳⣑⠨⠤⠕⡽⢮⡀⠀⠀⠀⠀\n⠀⢠⠞⣠⠂⡜⠰⠺⠚⠅⢢⡱⣄⠀⠀⠀\n⠀⢺⡐⢼⠀⢄⡇⠀⢫⠀⢸⠊⢈⠇⠀⠀\n⠀⠀⢱⡋⡆⠀⡯⣛⣽⣆⢸⡁⣏⡀⠀⠀\n⠀⠀⠉⢿⠤⠜⠛⠢⠘⠉⣄⠘⣏⠀⠀⠀\n⠀⠀⠀⡜⠀⠀⠀⡏⢻⡀⠈⠉⢣⠀⠀⠀\n⠀⠀⠀⠙⢦⠤⣸⠃⠀⢧⢤⣴⠋⠀⣀⠀\n⠰⡦⢤⣤⣟⣸⠃⠀⠀⠈⢷⡌⢧⡴⢛⠆\n⠀⠑⢬⣋⣨⣹⠀⠀⠀⠀⠈⣇⣻⠤⠞⠀");
            }
            case 2:
                if(dungeon.gameWon){
                    System.out.println("YOU HAVE DEFEATED ALL THE CREATURES!");
                    System.out.println("NOW YOUR PERSONALITIES HAVE BEEN STABILIZED");
                    System.out.println("YOU HAVE BECAME ALL YOUR PERSONALITIES AT ONCE");
                    System.out.println("⠀⠀⠀⠀⣠⠶⡒⠒⢬⡲⣮⠂⣆⣀⠀⠀⠀⠀⠀⠀⢀⣤⣴⣦⣤⡀⠀⠀⠀⠀\n⠀⠀⠀⣀⣥⠠⣿⠆⠐⣻⣾⣿⣿⢷⡄⠀⠀⠀⠀⢠⡿⠋⠉⠉⠙⢿⡄⠀⠀⠀\n⠀⠀⢘⡵⢋⠄⡙⠒⣤⣄⣉⠙⣿⣗⠑⡄⠀⠀⠀⠘⡇⠀⠀⠀⠀⠈⡇⠀⠀⠀\n⠀⣴⢿⡜⢡⡞⢀⢼⣿⣿⣿⣿⣿⣿⠟⣂⠀⠀⢀⣀⠱⡀⠀⠀⠀⢰⠁⠀⠀⠀\n⠰⢫⢟⡇⢸⡇⢸⢾⣿⣿⣿⣿⣿⣿⡷⠰⠀⢰⡏⠀⠀⢡⠀⠀⢠⠃⠀⠀⠀⠀\n⢰⠁⣿⢣⣿⠇⢀⣿⣿⡿⠿⠤⣭⣥⣶⡆⠀⠸⣷⣤⣠⡾⠀⢀⡇⠀⠀⠀⠀⠀\n⡞⣰⣧⠟⡝⢸⢸⣿⣥⠖⣴⡆⣤⣬⠉⠀⠀⠀⠈⠉⠉⠀⠀⢸⣇⠀⠀⠀⠀⠀\n⠀⡿⡟⢸⡇⠸⡄⢹⣿⢸⣿⣇⡏⠟⣰⣄⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀\n⠀⠇⣧⠘⡇⠦⣹⣸⣿⡇⡿⡿⣡⣼⣿⣿⣷⣦⣄⡀⠀⠀⣸⣿⣿⠄⠻⢷⣦⠀\n⠀⢀⠘⣇⢹⡸⣿⣿⣿⢹⢃⣠⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠑⠋⠉⠀⠀⠈⣿⣧\n⠀⢸⣿⡌⠘⢷⣿⣿⡏⢀⣾⣿⣿⣿⣿⣿⣿⢻⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⣿⡿\n⠀⠈⣿⣿⣦⡌⢿⠏⣰⣿⣿⣿⣿⣿⣿⡿⡏⣼⣿⣿⣿⡇⣄⠀⠀⠀⢀⣼⣿⠇\n⠀⠀⠹⣿⣿⢻⡀⣼⣿⣿⢻⣿⣿⣿⣿⡇⡇⢻⣿⣿⣿⡇⣿⣿⣶⣿⣿⠟⠁⠀\n⠀⠀⠀⢻⣿⣦⡓⢿⣿⣿⡆⣿⣿⣿⣿⢃⣶⡸⣿⣿⣿⡇⠀⠉⠉⠁⠀⠀⠀⠀\n⠀⠀⠀⠈⣿⣿⣿⡆⠀⠀⠀⣿⣿⣿⡟⣼⡿⠁⢹⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⢠⣿⣿⣿⢠⣿⣇⠀⠀⢻⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠘⣿⣿⣧⠀⠀⢸⣿⣿⡿⠘⣿⣿⣆⠀⠀⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⣿⣿⣿⡄⠀⢸⣿⣿⡇⢀⣿⣿⡟⠀⠀⢸⣿⣿⡀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⡴⢿⣿⣿⡇⢠⡿⣿⣿⢷⢩⣿⡟⠁⠀⢀⢼⡿⣿⡇⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠁⢿⠸⠿⠇⠈⠃⠛⠃⠚⠈⠁⠀⠀⠀⠈⠸⠜⠛⠀⠀⠀⠀⠀⠀⠀");
                }
            case 3:
            	if(dungeon.gameWon){
            		System.out.println("YOU HAVE DEFEATED ALL THE CREATURES!");
            		System.out.println("NOW YOU ARE A PRINCE LIZARD");
            		System.out.println("YOU HAVE REDEEMED YOURSELF FOR YOUR KING");
            		System.out.println("⠀⠀⠀⠀⠀⢀⣠⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⢀⡴⠟⠛⠛⢿⠷⢤⡹⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠸⣧⣀⡀⠈⠻⠷⠀⠇⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠘⠪⡛⠦⠄⠀⠀⠀⡄⢈⣻⣦⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠙⢦⠀⠀⢠⠀⣇⣼⣿⡿⢿⣿⣷⣦⣄⠀⠀⠀⣠⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠈⢧⡀⣸⣸⠋⣿⣿⢁⣾⣿⠟⢁⣿⣿⣶⣤⡇⠈⢳⡀⣠⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠻⣿⠇⠀⠛⠁⠈⠻⠃⠀⣾⣿⣿⠟⠉⠙⣦⡀⢻⣿⣠⣾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⡟⠒⢶⣤⡀⠀⠀⠀⠈⠿⣿⠥⣤⡀⢸⣿⣿⣷⣿⣹⣥⣶⠿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⢳⠀⠀⣽⣿⣦⣄⣀⠀⠀⣿⠀⢀⠈⠉⠻⡄⠀⠈⠛⢧⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀⡟⠀⠈⠉⠛⠻⢿⡿⠀⠸⣼⡇⠀⠀⠀⣠⠄⢸⣿⡟⠙⠒⢶⣤⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠰⠶⣶⠤⣀⣠⡇⠀⡇⠀⠀⠀⠀⠀⠀⡇⠀⢰⡿⠻⠶⠶⠶⠿⠤⢤⣏⣀⠀⠀⠸⡇⠀⡟⠉⠉⠉⠑⡶⢄⡀⠀⠀⠀\n⠀⢀⣴⡯⣿⣯⢀⣁⢀⡼⠁⠀⢠⣠⣤⠤⠴⠇⠀⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠓⠒⠢⠤⢄⣀⠀⠈⠡⢀⣵⣄⠀⠀\n⠀⠈⣽⡿⠞⠋⠉⠉⠉⢀⣤⣔⡾⠿⢗⣿⣟⣤⢀⡼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠳⣤⡀⠀⡘⣧⠀\n⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⣶⠝⢋⣝⠗⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢳⡞⠛⢿⡆\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠉⢀⣴⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠐⢾⠇\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢤⣄⣀⠀⠀⠀⠀⢀⣀⠴⠁⢲⡾⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⣭⣉⡉⠉⠉⣀⣠⠴⠟⠁⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠁⠀⠀⠀⠀⠀");
		}        
	}		
}

	public static Player createCharacter(String name, int race) {
		String[] inven = new String[5];
		inven[0] = "Ignis's Spare";
		inven[1] = "Blaze's Shield";
		inven[2] = "Healing Potion";
		inven[3] = "Empty";
		inven[4] = "Empty";
		switch(race){
			case 1:
			Player p1 = new Player(name, 100, 100, 15, inven, false);
			return p1;
			case 2:
			Player p2=new Player(name, 65, 65, 35, inven, false);
			return p2;
			case 3:
			Player p3=new Player(name, 80, 80, 10, inven, false);
			return p3;
			default:
			Player p = new Player(name, 100, 100, 15, inven, false);
			return p;
		}
	}
}
