import java.util.Scanner;
import java.util.Arrays;
public class DungeonGame{
static Scanner input=new Scanner(System.in);
static public boolean gameWon=false;
static int playerRow=0; static int playerCol=0;
static RoomContent[][] dungeonMap= new RoomContent[4][4];
static Player player;
static boolean dragonBreath=false;
static boolean hasSpecial=true;
public static int totalMonster=0;
static int lepriconCauldron=1;
public static void createDungeonMap(){//I used these i+j sums to make it appear more randomized and make player see every possible room beforre going ing figth with the dragon
	for(int i=0;i<4;i++){
	for(int j=0; j<4;j++){
		if((i+j)==6){dungeonMap[i][j]=new MonsterEncounter(MonsterFactory.createMonster("DRAGON"));//33
		totalMonster++;}
		else if((2*i+j)==3||(i+3*j)==9){dungeonMap[i][j]=new MonsterEncounter(MonsterFactory.createMonster("PHOENIX"));//11 03 32
		totalMonster++;}
		else if((2*i+j)==4||(2*i+j)==6){dungeonMap[i][j]=new MonsterEncounter(MonsterFactory.createMonster("TUKILETTU"));//12 20 22 30
		totalMonster++;}
		else if((2*i+j)==2||(2*i+j)==7)dungeonMap[i][j]=new Treasure("Healing Potion");//10 02 23 31
		else if((2*i+j)==5)dungeonMap[i][j]=new Treasure("Ignis's Hair");//13 21
		else if((i+j)==1)dungeonMap[i][j]=new Treasure("Dragon's Breath");//01 10
		else dungeonMap[i][j]=new EmptyRoom();}}}
public static void startCombat(Player player, Monster monster){
	monster.monsterGreeting();
	player.printStatus();
	hasSpecial=true;
	while((player.currentHealth>0)&&(!monster.isDefeated()||monster.hasSpecialSpecial)){
		player.isDefending=false;
		System.out.println(player.name+"'s turn what is your choice");//player turn start
		System.out.println("[A]ttack, [U]se item, [D]efend, [S]pecial");
		char choice=input.next().toUpperCase().charAt(0);
		switch(choice){
			case 'A':
				int damageDealt=(int)((player.attackPower)*((((Math.random()*41)+80)/100)));
				if(Math.random()<0.1){
					damageDealt*=2; System.out.println("CRITICAL HIT!");}
				if(dragonBreath) damageDealt*=2;
				damageDealt*=lepriconCauldron;
				lepriconCauldron=1;
				monster.takeDamage(damageDealt);
				dragonBreath=false;
				break;
			case 'U':
					for(int j=2;j<player.inventory.length;j++){
					System.out.println(player.inventory[j]);}
					System.out.println("Write 1-2-3 for your liking");
						int newChoice=input.nextInt();
						newChoice++;//I chose to handle the miscalenous inventory this way to make it easy for the player to prompt input
						if((1>newChoice||newChoice>4)) break;
							if(player.inventory[newChoice]=="Healing Potion"){
								player.heal(35);
								player.inventory[newChoice]="Empty";
								System.out.println("You have been healed! your health is now"+player.currentHealth+"/"+player.maxHealth);
								break;}
							else if(player.inventory[newChoice]=="Ignis's Hair"){
								if(Math.random()*6<1){
								System.out.println("You rolled a 1 out of 6");
								System.out.println("You have damaged yourself for half of your health");
								player.currentHealth=(int)(player.currentHealth/2);}
							else if(Math.random()*6<=6-lepriconCauldron){
								System.out.println("Nothing happened, hair burned itself!");}
							else{
								System.out.println("Ignis have evokened! the monster burned into crisps!");
								monster.takeDamage(200);}
							player.inventory[newChoice]="Empty";
							}
							else if(player.inventory[newChoice]=="Dragon's Breath"){
							System.out.println("You have used eternal power of the dragon!");
							System.out.println("Your next attack has been boosted");
							dragonBreath=true;
							player.inventory[newChoice]="Empty";
							break;}
					break;
			case 'D':
				player.isDefending=true;
				break;
			case 'S':
				if(hasSpecial){
					System.out.println("----------------------");
					System.out.println("Fire Lepricons Cauldron");
					System.out.println("All positive luck has been doubled for next round!");
					System.out.println("Can be paired with Dragon's breath for quadruple damage!");
					lepriconCauldron=2;
					hasSpecial=false;
				break;}
			default:
				System.out.println("You hesitate and you failed");
				break;}
		monster.printStatus();
		if(monster.health>0||monster.hasSpecialSpecial){
		System.out.println("Now it is "+monster.name+"'s turn");//monster turn start
		monster.performSpecialAction(player);
		int damageDealt=(int)(monster.damage);
		if(player.isDefending==true) damageDealt=(int)(damageDealt/2);
		player.takeDamage(damageDealt);}
		player.printStatus();
		}
		if(monster.health==0) player.monsterDefeated++;
		}
public static void main(String[] args){
	System.out.println("You are a Fire Lepricon in a fire land");
	System.out.println("---------------------------------------");
	createDungeonMap();
	System.out.println("You brave adventurer introduce yourself! ");
	player=Player.createCharacter(input.nextLine());
	while(player.currentHealth>0&&!gameWon){
		System.out.println("You are now in ["+playerRow+","+playerCol+"]");
		System.out.println("Where do you want to go?");
		System.out.println("[N]orth,[S]outh,[E]ast,[W]est");
		System.out.println("Press the first letter of preferred direction");
		char locationChoice=input.next().toUpperCase().charAt(0);
		switch(locationChoice){//I used this switch to restrict the player to the platforms
			case 'N':
				if((playerRow+1)<4){ playerRow++;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				break;
			case 'S':
				if((playerRow-1)>=0){ playerRow--;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				break;
			case 'W':
				if((playerCol+1)<4){ playerCol++;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				break;
			case 'E':
				if((playerCol-1)>=0){ playerCol--;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				break;
			default:
			System.out.println("Wrong Entry!");
			break;}
			RoomContent currentRoom = dungeonMap[playerRow][playerCol];
			if(currentRoom instanceof MonsterEncounter){
			MonsterEncounter encounter=(MonsterEncounter) currentRoom;
			Monster monster=encounter.getMonster();
			dungeonMap[playerRow][playerCol]=new EmptyRoom();
			startCombat(player,monster);}
			else if(currentRoom instanceof Treasure){
			Treasure treasure=(Treasure) currentRoom;//with this (Treasure) we tell Java that currentRoom is actually a Treasure so we can use .getTreasure
			String item=treasure.getTreasure();
			System.out.println("You found "+item+" in a volcano nearby!");
			treasure.treasureDescription(item);
			for(int j=2;j<player.inventory.length;j++){
					System.out.println(player.inventory[j]);}
			System.out.println("Where do you want to put it in your inventory (1-2-3)");
			//I choosed to handle the inventory this way because i want the player to make choices about items that they encounter. This way they make direct impact to the games end fight
			int inventoryChoice=input.nextInt();
			inventoryChoice++;
			if(1<inventoryChoice&&inventoryChoice<5){//I used this code block to defeat the Arrays.out.of.boundry error
				player.inventory[inventoryChoice]=item;
				dungeonMap[playerRow][playerCol]=new EmptyRoom();
				player.printStatus();}
			else{ System.out.println("Your inventory is full");}}
			else if(currentRoom instanceof EmptyRoom){ System.out.println("This room is empty");}
			if(player.monsterDefeated==totalMonster) gameWon=true;
			}
			player.endStatus();
		}
	
	}	

