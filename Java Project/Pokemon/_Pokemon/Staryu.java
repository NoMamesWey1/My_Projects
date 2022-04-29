package _Pokemon;

import Objects.Pokemon;
import Interface.*;
import Controller.CheckInput;

/**
 Description: This is the fire pokemon Bulbasaur
 Here are the stats
 - water gun – 1-5 dmg
 - bubble beam – 1-2 dmg
 - waterfall– 1-4 dmg
 *
 */

public class Staryu extends Pokemon implements Water {
	public Staryu() {
		super("Staryu");
	}

	/**
	 Description: special attack number 1: watergun 1-5 dmg
	 @param: this is the pokemon we are attacking
	 @return: returning a string that shows which pokemon was attacks and for how much damage
	 */
	public String watergun(Pokemon p) {
		int damage = (int) (Math.random() * 5)+ 2;
		if(p instanceof Fire){
			double amplified = Pokemon.battleTable[1][0];
			damage *= amplified;
		}
		else if(p instanceof Water){
			double amplified = Pokemon.battleTable[1][1];
			damage *= amplified;
		}
		else{//p instanceof Grass
			double amplified = Pokemon.battleTable[1][2];
			damage *= amplified;
		}
		p.takeDamage(damage);
		String userAttack = p.getName() + "is doused by WATERGUN and takes " + damage + " damage!";
		return userAttack;
	}

	/**
	 Description: special attack number 2: bubble beam 1-2 dmg
	 @param: this is the pokemon we are attacking
	 @return: returning a string that shows which pokemon was attacks and for how much damage
	 */
	public String bubblebeam(Pokemon p) {
		int damage = (int) (Math.random() * 3) + 1;
		if(p instanceof Fire){
			double amplified = Pokemon.battleTable[1][0];
			damage *= amplified;
		}
		else if(p instanceof Water){
			double amplified = Pokemon.battleTable[1][1];
			damage *= amplified;
		}
		else{//p instanceof Grass
			double amplified = Pokemon.battleTable[1][2];
			damage *= amplified;
		}
		p.takeDamage(damage);
		String userAttack = p.getName() + " is sprayed by BUBBLEBEAM and takes " + damage + " damage!";
		return userAttack;
		
	}

	/**
	 Description: special attack number 3: waterfall 1-4 dmg
	 @param: this is the pokemon we are attacking
	 @return: returning a string that shows which pokemon was attacks and for how much damage
	 */
	public String waterfall(Pokemon p) {
		int damage = (int) (Math.random() * 4)+1;
		if(p instanceof Fire){
			double amplified = Pokemon.battleTable[1][0];
			damage *= amplified;
		}
		else if(p instanceof Water){
			double amplified = Pokemon.battleTable[1][1];
			damage *= amplified;
		}
		else{//p instanceof Grass
			double amplified = Pokemon.battleTable[1][2];
			damage *= amplified;
		}
		p.takeDamage(damage);
		String userAttack = p.getName() + " is slammed to the ground by WATERFALL and takes " + damage +  " damage!";
		return userAttack;
		
	}

	/**
	 Description: Displays the special attack menu for water pokemon
	 @return: the special menu found in fire interface
	 */
	@Override
	public String getSpecialMenu() {
		return specialMenu;
	}

	/**
	 Description: getting the special menu number
	 @return: the special menu number chosen from water interface
	 */
	@Override
	public int getNumSpecialMenuItems() {
		int numSpecialMenuItems = CheckInput.getIntRange(1,3);
		return numSpecialMenuItems;
	}

	/**
	 Description: getting the special attack from water interface
	 @param: Pokemon p is the pokemon we are attacking, and move is which special attack
	 @return: what attack we are doing
	 */
	@Override
	public String specialAttack(Pokemon p, int move) {
        String specialAttack = "";
        switch (move){
            case 1:
                specialAttack = watergun(p);
                break;
            case 2:
                specialAttack = bubblebeam(p);
                break;
            case 3:
                specialAttack = waterfall(p);
                break;
        }
        return specialAttack;
    }
}
