//Greg Paolo Violan, 011706641
/**
 * imported necessary api's
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Enemy Generator class
 * @author Greg
 *
 */
public class EnemyGenerator {
	/**
	 * EnemyGenerator constructor, gets files from the EnemyList.txt file and put it in to the array
	 */
	public EnemyGenerator(){
		Item testItem = new Item("Test", 0);
		
		try{
		Scanner read = new Scanner(new File("EnemyList.txt"));
		//ADD ALL ENEMIES FROM EnemeyList.txt to enemyList Array
		do{
			read.useDelimiter(",");
			String line = read.nextLine();
			String[] tokens = line.split(",");
			                        //NAME     //QUIP      //HP                     //LV //G //ITEM
			Enemy enemy = new Enemy(tokens[0], tokens[1], Integer.parseInt(tokens[2]), 0, 0, testItem);
			
			enemyList.add(enemy);
		}while(read.hasNext());
		read.close();
		}catch(FileNotFoundException fnf){
			System.out.println("FNF");
		}
		
//		//TEST: SHOW ENEMYLIST ARRAY
//		for(int ii = 0; ii < enemyList.size(); ++ii){
//			System.out.println(String.format("%-2s %-10s %-1s %-10s %-5s %-5s %-5s %s %s %s ", ii, enemyList.get(ii).getName() , " " , enemyList.get(ii).getQuip() , " HP: " , enemyList.get(ii).getHp() , " LV: " , enemyList.get(ii).getLevel() , " Gold: " , enemyList.get(ii).getGold() , " Item: " ,enemyList.get(ii).getItem().getName() ));
//		}		
	}
	/**
	 * Generate Enemy class, generates a random enemy depending on the level
	 * @param level, level of current map
	 * @return enemy
	 */
	public Enemy generateEnemy(int level){
		Enemy enemy = null;
		Item monsterItem = null;
		int randomMob = 0;
		int gold = 0;
		int itemRoll = 0;
		Random rand = new Random();
		
		//ITEM GENERATOR FOR THE MONSTER
		ItemGenerator itemGen = new ItemGenerator();
		
		//ITEM GENERATES IF ITS 1, ELSE it gives "NO_DROP"
		itemRoll = rand.nextInt((5 - 1) + 1) + 1;
		if(itemRoll == 1){
			monsterItem = itemGen.generateItem();
		}
		else{
			monsterItem = new Item("NO_DROP", 0);
		}
		
		//LEVEL 1 MOBS : SNAKE, GIANT RAT, FROGLOK
		if(level == 1){
			rand = new Random();
			randomMob = rand.nextInt((3 - 1) + 1) + 1; //GENERATE RANDOM MOB
			gold = rand.nextInt((10 - 0) + 1) + 0; //GENERATE GOLD
			
			if(randomMob == 1) randomMob = 5; //5: SNAKE, 1 HP
			else if(randomMob == 2) randomMob = 2; //2: GIANT RAT, 2 HP
			else randomMob = 6; //6: FROGLOK, 3 HP

			//GENERATE A RANDOM LEVEL 3 MONSTER
			enemy = new Enemy(enemyList.get(randomMob).getName(), enemyList.get(randomMob).getQuip(), enemyList.get(randomMob).getHp(), 1, gold, monsterItem);
		}
		//LEVEL 2 MOBS : GNOLL, GOBLIN, ORC
		else if(level == 2){
			rand = new Random();
			randomMob = rand.nextInt((3 - 1) + 1) + 1; //GENERATE RANDOM MOB
			gold = rand.nextInt((20 - 0) + 1) + 0; //GENERATE GOLD
			
			if(randomMob == 1) randomMob = 4; //4: GNOLL, 4 HP
			else if(randomMob == 2) randomMob = 0; //5: GOBLIN, 5 HP
			else randomMob = 1; //1: ORC, 6 HP

			//GENERATE A RANDOM LEVEL 2 MONSTER
			enemy = new Enemy(enemyList.get(randomMob).getName(), enemyList.get(randomMob).getQuip(), enemyList.get(randomMob).getHp()*2, 2, gold, monsterItem);
			
		}
		//LEVEL 3 MOBS : ORC, KOBOLD, TROLL
		else{
			rand = new Random();
			randomMob = rand.nextInt((3 - 1) + 1) + 1; //GENERATE RANDOM MOB
			gold = rand.nextInt((30 - 0) + 1) + 0; //GENERATE GOLD
			
			if(randomMob == 1) randomMob = 1; //6: ORC, 6 HP
			else if(randomMob == 2) randomMob = 3; //3: KOBOLD, 7 HP
			else randomMob = 7; //7: TROLL, 8 HP
			
			//GENERATE A RANDOM LEVEL 3 MONSTER
			enemy = new Enemy(enemyList.get(randomMob).getName(), enemyList.get(randomMob).getQuip(), enemyList.get(randomMob).getHp()*2, 3, gold, monsterItem);
		}
		
		//TP: GENERATE RANDOM LEVEL # MONSTER + MONSTER ITEM
//		System.out.println("RandomMob#:" + randomMob + " " + monsterItem);
//		
//		//TP: CHECK MONSTER
//		System.out.println(String.format("%-15s %-5s %-8s %s", enemy.getName(), enemy.getLevel(), enemy.getItem().getName(), enemy.getItem().getValue(), enemy.getGold()));
		
		return enemy;
	}
	/**
	 * private ArrayList enemyList 
	 */
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
}
