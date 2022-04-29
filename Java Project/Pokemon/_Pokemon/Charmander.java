package _Pokemon;
import Controller.CheckInput;
import Objects.Pokemon;
import Interface.*;

/**
 Description: This is the fire pokemon Bulbasaur
 Here are the stats
 - ember – 0-3 dmg
 - fire blast – 1-4 dmg
 - fire punch – 1-3 dmg
 *
 */

public class Charmander extends Pokemon implements Fire {
    public Charmander() {
        super("Charmander");
    }

    /**
     Description: special attack number 1: ember
     @param: this is the pokemon we are attacking
     @return: returning a string that shows which pokemon was attacks and for how much damage
     */
    @Override
    public String ember(Pokemon p){
        int damage = (int)(Math.random()*3)+0;
        if(p instanceof Fire){
            double amplified = Pokemon.battleTable[0][0];
            damage *= amplified;
        }
        else if(p instanceof Water){
            double amplified = Pokemon.battleTable[0][1];
            damage *= amplified;
        }
        else{//p instanceof Grass
            double amplified = Pokemon.battleTable[0][2];
            damage *= amplified;
        }
        p.takeDamage(damage);
        String userAttack = p.getName() + " is encased in EMBER and takes " + damage + " damage.";
        return userAttack;
    }

    /**
     Description: special attack number 2: Fire Blast
     @param: this is the pokemon we are attacking
     @return: returning a string that shows which pokemon was attacks and for how much damage
     */
    @Override
    public String fireBlast(Pokemon p) {
        int damage = (int) (Math.random() * 4) + 1;
        if(p instanceof Fire){
            double amplified = Pokemon.battleTable[0][0];
            damage *= amplified;
        }
        else if(p instanceof Water){
            double amplified = Pokemon.battleTable[0][1];
            damage *= amplified;
        }
        else{//p instanceof Grass
            double amplified = Pokemon.battleTable[0][2];
            damage *= amplified;
        }
        p.takeDamage(damage);
        String userAttack = p.getName() + " got toasted by a FIRE BLAST and takes " + damage + " damage.";
        return userAttack;
    }

    /**
     Description: special attack number 3: Fire Punch
     @param: this is the pokemon we are attacking
     @return: returning a string that shows which pokemon was attacks and for how much damage
     */
    @Override
    public String firePunch(Pokemon p) {
        int damage = (int) (Math.random() * 3) + 1;
        if(p instanceof Fire){
            double amplified = Pokemon.battleTable[0][0];
            damage *= amplified;
        }
        else if(p instanceof Water){
            double amplified = Pokemon.battleTable[0][1];
            damage *= amplified;
        }
        else{//p instanceof Grass
            double amplified = Pokemon.battleTable[0][2];
            damage *= amplified;
        }
        p.takeDamage(damage);
        String userAttack = p.getName() + " got served with a FIRE PUNCH and takes " + damage + " damage.";
        return userAttack;
    }

    /**
     Description: Displays the special attack menu for fire pokemon
     @return: the special menu found in fire interface
     */
    @Override
    public String getSpecialMenu() {
        return specialMenu;
    }

    /**
     Description: getting the special menu number
     @return: the special menu number chosen from fire interface
     */
    @Override
    public int getNumSpecialMenuItems() {
        int numSpecialMenuItems = CheckInput.getIntRange(1,3);
        return numSpecialMenuItems;
    }

    /**
     Description: getting the special attack from fire interface
     @param: Pokemon p is the pokemon we are attacking, and move is which special attack
     @return: what attack we are doing
     */
    @Override
    public String specialAttack(Pokemon p, int move) {
        String specialAttack = "";
        switch (move){
            case 1:
                specialAttack = ember(p);
                break;
            case 2:
                specialAttack = fireBlast(p);
                break;
            case 3:
                specialAttack = firePunch(p);
                break;
        }
        return specialAttack;
    }
}
