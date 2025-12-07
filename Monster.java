public class Monster {
	String name;
	int health;
	int damage;
	boolean isPheonix;
	boolean isDragon;
	boolean isTukilettu;
	boolean hasSpecialSpecial;

	public Monster(String name, int health, int damage, boolean hasSpecialSpecial) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.hasSpecialSpecial = hasSpecialSpecial;
	}

	public void takeDamage(int damage) {
		health -= damage;
		if (health < 0)
			health = 0;
	}

	public void monsterGreeting() {
		if (isDragon) {
			System.out.println("The Dragon\n");
			System.out.println("Ability Type: Passive");
			System.out.println("//LIFE-SHORTENING//");
			System.out.println("");
			System.out.println("                \\||/\n                |  @___oo\n      /\\  /\\   / (__,,,,|\n     ) /^\\) ^\\/ _)\n     )   /^\\/   _)\n     )   _ /  / _)\n /\\  )/\\/ ||  | )_)\n<  >      |(,,) )__)\n ||      /    \\)___)\n | \\____(      )___) )___\n  \\______(_______;;; __;;;");
			//I used these textarts for player to see their oponents directly like undertale or pokemon
			System.out.println("\nWHO IS DISTURBING ME IN MY ETERNAL SLEEP");
		}
		if (isPheonix) {
			System.out.println("Eternal Pheonix");
			System.out.println("Ability Type: Active");
			System.out.println("//REGEN//");
			System.out.println("");
			System.out.println(" .\\\\            //.\n. \\ \\          / /.\n.\\  ,\\     /` /,.-\n -.   \\  /'/ /  .\n ` -   `-'  \\  -\n   '.       /.\\`\n      -    .-\n      :`//.'\n      .`.'\n      .'");
			System.out.println("");
		}
		if (isTukilettu) {
			System.out.println("Fire Fox Tukkilettu");
			System.out.println("Ability Type: Active");
			System.out.println("//THIEF FOR LIFE//");
			System.out.println("   _,-='\"-.__               /\\_/\\\n   `-.}       `=._,.-==-._.,  @ @._,\n      `-.__   _,-.   )       _,.-'\n           `\"     G..m-\"^m`m'");
			System.out.println("");
		}
	}

	public void printStatus() {
		System.out.println(name + "'s remaining health is " + health);
	}

	public boolean isDefeated() {
		return health == 0;
	}

	public void performSpecialAction(Player p1) {
		if (isPheonix) {
			if (hasSpecialSpecial && health == 0) {
				if(Math.random()<0.6){
					System.out.println("   ///\\\\\\");
					System.out.println("BRING BACK FROM THE ASHES");
					System.out.println("   \\\\\\///");
					System.out.println("Eternal Pheonix used her special and regened for 20 HP");
					health += 20;
				}
					hasSpecialSpecial = false;
			}
		}
		if (isDragon) {
			System.out.println("FIRE HAZARD");
			System.out.println("The Dragon used her ability to reduce your max health by 5");
			p1.maxHealth -= 5;
		}
		if (isTukilettu) {
			if (Math.random() < 0.3) {
				System.out.println(" ===***===");
				System.out.println("SNEAKY THIEF");
				System.out.println(" ===***===");
				System.out.println("Tukilettu has stealed one of your precious items");
				p1.inventory[(int) (Math.random() * 3 + 2)] = "Empty";
				System.out.println("");
			}
		}
	}
}
