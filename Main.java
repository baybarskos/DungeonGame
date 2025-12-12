import java.util.Scanner;
import java.util.Arrays;
public class Main{
static Scanner input=new Scanner(System.in);
static public boolean gameWon=false;
static int playerRow=0; static int playerCol=0;
static RoomContent[][] dungeonMap= new RoomContent[4][4];
static char[][] room = new char[4][4];
static Player player;
static int dragonBreathHealth=0;
static boolean hasSpecial=true;
public static int totalMonster=0;
static int race;
static String name;
static int lepriconCauldron=1;
static boolean playerDead=false;
public static void dungeonMap(){
for(int i=0; i<room.length;i++){
    for(int j=0; j<room[i].length; j++){
        if(room[i][j]=='D'){
            dungeonMap[i][j]=new MonsterEncounter(MonsterFactory.createMonster("DRAGON"));
            totalMonster++;
        }
        else if(room[i][j]=='P'){
            dungeonMap[i][j]=new MonsterEncounter(MonsterFactory.createMonster("PHOENIX"));
            totalMonster++;
        }
        else if(room[i][j]=='T'){
            dungeonMap[i][j]=new MonsterEncounter(MonsterFactory.createMonster("TUKILETTU"));
            totalMonster++;
        }
        else if(room[i][j]=='H'){
            dungeonMap[i][j]=new Treasure("Healing Potion");
        }
        else if(room[i][j]=='I'){
            dungeonMap[i][j]=new Treasure("Ignis's Hair");
        }
        else if(room[i][j]=='B'){
        	dungeonMap[i][j]=new Treasure("Dragon's Breath");
        }
        else if(room[i][j]=='E'){
        	dungeonMap[i][j]=new EmptyRoom();
        }	
    }
}
}

public static void createDungeonMap(){//I used these for easy room generation
    char[][] room1 = {{'E','T','P','T'},{'P','H','H','B'},{'I','B','T','I'},{'H','H','P','D'}};
    char[][] room2 = {{'E','P','H','P'},{'T','I','H','T'},{'H','P','B','T'},{'B','B','I','D'}};
    char[][] room3 = {{'E','T','I','T'},{'T','B','H','H'},{'P','B','H','P'},{'P','I','P','D'}};
    char[][] room4 = {{'E','P','H','T'},{'P','T','I','B'},{'I','T','H','H'},{'P','H','B','D'}};
    char[][] room5 = {{'E','B','H','P'},{'T','H','B','T'},{'I','T','I','H'},{'B','H','T','D'}};
    switch(((int)(Math.random()*5))+1){
        case 1:
            room=room1;
            break;
        case 2:
            room=room2;
            break;
        case 3:
            room=room3;
            break;
        case 4:
            room=room4;
            break;
        case 5:
            room=room5;
            break;
		default:
			room = room1;
    }
    dungeonMap();
}

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
				damageDealt*=lepriconCauldron;
				lepriconCauldron=1;
				monster.takeDamage(damageDealt);
				break;
			case 'U':
					for(int j=2;j<player.inventory.length;j++){
					System.out.println(player.inventory[j]);}
					System.out.println("Write 1-2-3 for your liking");
						char newChoiceString=input.next().charAt(0);
						int newChoice=newChoiceString-'0';
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
							System.out.println("Your damage or your regen will be boosted");
							if(Math.random()<0.5){
							dragonBreathHealth+=5;
							System.out.println("Your passive regen is increased by 5!");
							player.inventory[newChoice]="Empty";}
							else{
							System.out.println("Your base damage is increased by 5!");
							player.attackPower+=5;
							player.inventory[newChoice]="Empty";}
							break;}
					break;
			case 'D':
				player.isDefending=true;
				break;
			case 'S':
				if(hasSpecial){
					switch(race){
						case 1:
							System.out.println("----------------------");
							System.out.println("Fire Lepricons Cauldron");
							System.out.println("All positive luck has been doubled for next round!");
							lepriconCauldron=2;
							hasSpecial=false;
							break;
						case 2:
							System.out.println("----------------------");
							System.out.println("Chimera's Personalities");
							System.out.println("Your damage and health is swapped!");
							System.out.println("Previous health:"+player.currentHealth+" damage"+player.attackPower);
							int temporary=player.currentHealth;
							player.currentHealth=player.attackPower;
							player.attackPower=temporary;
							player.maxHealth=player.currentHealth;
							hasSpecial=false;
							System.out.println("Current health"+player.currentHealth+" damage"+player.attackPower);
							break;
						case 3:
							System.out.println("----------------------");
							System.out.println("Fire Salamender's Spit");
							System.out.println("The monsters health is decreased by 22");
							monster.health-=22;
							hasSpecial=false;
							break;
							}
						continue;}
			default:
				System.out.println("You hesitate and you failed");
				break;}
		monster.printStatus();
		if(monster.health==0&&monster.hasSpecialSpecial){
		monster.performSpecialAction(player);}
		if(monster.health>0){
		System.out.println("Now it is "+monster.name+"'s turn");//monster turn start
		monster.performSpecialAction(player);
		int damageDealt=(int)(monster.damage);
		if(player.isDefending==true) damageDealt=(int)(damageDealt/2);
		player.takeDamage(damageDealt);}
		player.printStatus();
		}
		if(player.currentHealth==0) playerDead=true;
		if(monster.health==0) player.monsterDefeated++;
		player.heal(dragonBreathHealth);	
		}
public static void main(String[] args){
	do{
	System.out.println("Select your race");
	System.out.println("1-Fire Lepricon can increase luck");
	System.out.println("2-Chimera can switch damage and health");
	System.out.println("3-Angry Salamender can deal damage with special");
	System.out.println("---------------------------------------");
	char raceString=input.next().charAt(0);//to prevent mistype i included this line
	race=raceString-'0';
	createDungeonMap();
	input.nextLine();//clean buffer
	}while(0>race||race>4);//to prevent racelessness
	System.out.println("You brave adventurer introduce yourself! ");
	name=input.nextLine();
	player=Player.createCharacter(name,race);
	int locationCount=0;
	while(!playerDead&&!gameWon){
		boolean moved=false;
		do{
		System.out.println("You are now in ["+playerRow+","+playerCol+"]");
		System.out.println("Where do you want to go?");
		System.out.println("[N]orth,[S]outh,[E]ast,[W]est");
		System.out.println("Press the first letter of preferred direction");
		System.out.println("If you want to use item press 'U'");
		char locationChoice=input.next().toUpperCase().charAt(0);
			if(locationCount==0){
		    	if(locationChoice == 'N'){
            	if((playerRow+1)<4){ 
                	playerRow++;
                	System.out.println("You are now in ["+playerRow+","+playerCol+"]");
                	locationCount++;
                	moved=true;
            	}
            	else System.out.println("You can't go further!");
        	}
        	else if(locationChoice == 'E'){
            	if((playerCol+1)<4){ 
            	    playerCol++;
            	    System.out.println("You are now in ["+playerRow+","+playerCol+"]");
            	    locationCount++;
            	    moved=true;
            	}
            	else System.out.println("You can't go further!");
        	}
        	else{
        	    System.out.println("Wrong Entry! You can only go North or East on your first move. And you can't use item!");
        	}
    	}
    	else{
		switch(locationChoice){//I used this switch to restrict the player to the platforms
			case 'N':
				if((playerRow+1)<4){ playerRow++;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				moved=true;
				break;
			case 'S':
				if((playerRow-1)>=0){ playerRow--;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				moved=true;
				break;
			case 'E':
				if((playerCol+1)<4){ playerCol++;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				moved=true;
				break;
			case 'W':
				if((playerCol-1)>=0){ playerCol--;
				System.out.println("You are now in ["+playerRow+","+playerCol+"]");}
				else System.out.println("You can't go further!");
				moved=true;
				break;
			case 'U':
				for(int j=2;j<player.inventory.length;j++){
				System.out.println(player.inventory[j]);}
				System.out.println("Write 1-2-3 for your liking");
					char newChoiceString=input.next().charAt(0);
					int newChoice=newChoiceString-'0';
					newChoice++;//I chose to handle the miscalenous inventory this way to make it easy for the player to prompt input						if((1>newChoice||newChoice>4)) break;
						if(player.inventory[newChoice]=="Healing Potion"){
							player.heal(35);
							player.inventory[newChoice]="Empty";
							System.out.println("You have been healed! your health is now"+player.currentHealth+"/"+player.maxHealth);
							break;}
						else if(player.inventory[newChoice]=="Ignis's Hair"){
							System.out.println("You can use Ignis's Hair only in combat!");
						}
						else if(player.inventory[newChoice]=="Dragon's Breath"){
						System.out.println("You have used eternal power of the dragon!");
						System.out.println("Your damage or your regen will be boosted");
						if(Math.random()<0.5){
						dragonBreathHealth+=5;
						System.out.println("Your passive regen is increased by 5!");
						player.inventory[newChoice]="Empty";}
						else{
						System.out.println("Your base damage is increased by 5!");
						player.attackPower+=5;
						player.inventory[newChoice]="Empty";}
						break;}
				break;
			default:
			System.out.println("Wrong Entry!");
			break;}
			locationCount++;}
			}while(!moved);
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
			char inventoryChoiceString=input.next().charAt(0);
			int inventoryChoice=inventoryChoiceString-'0';
			inventoryChoice++;
			if(1<inventoryChoice&&inventoryChoice<5){//I used this code block to defeat the Arrays.out.of.boundry error
				player.inventory[inventoryChoice]=item;
				dungeonMap[playerRow][playerCol]=new EmptyRoom();
				player.printStatus();}
			else{ System.out.println("Your inventory is full");}}
			else if(currentRoom instanceof EmptyRoom){ System.out.println("This room is empty");}
			if(player.monsterDefeated==totalMonster) gameWon=true;
			}
			player.endStatus(race);
		}
	
	}	

