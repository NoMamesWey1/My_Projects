package _Pokemon;
import Objects.Pokemon;
import Interface.*;
import Controller.CheckInput;

/**
Description: This is the Grass pokemon Oddish 
*/
public class Oddish extends Pokemon implements Grass{
  public Oddish(){
    super("Oddish");
  }
/**
Description: special attack number 1
@param: this is the pokemon we are attacking
@return: returning a string that shows which pokemon was attacks and for how much damage
*/
  @Override
  public String vineWhip(Pokemon p){
    int damage = (int)(Math.random()*3)+1;
    if(p instanceof Fire){
      double amplified = Pokemon.battleTable[2][0];
      damage *= amplified;
    }
    else if(p instanceof Water){
      double amplified = Pokemon.battleTable[2][1];
      damage *= amplified;
    }
    else{//p instanceof Grass
      double amplified = Pokemon.battleTable[2][2];
      damage *= amplified;
    }
    p.takeDamage(damage);
    String userAttack = p.getName()+" is WHIPPED and takes "+damage+" damage.";
    return userAttack;
  }
  /**
  Description: special attack number 2
  @param: this is the pokemon we are attacking
  @return: returning a string that shows which pokemon was attacks and for how much damage
  */
  @Override
  public String razorLeaf(Pokemon p){
    int damage = (int)(Math.random()*4)+2;
    if(p instanceof Fire){
      double amplified = Pokemon.battleTable[2][0];
      damage *= amplified;
    }
    else if(p instanceof Water){
      double amplified = Pokemon.battleTable[2][1];
      damage *= amplified;
    }
    else{//p instanceof Grass
      double amplified = Pokemon.battleTable[2][2];
      damage *= amplified;
    }
    p.takeDamage(damage);
    String userAttack = p.getName()+" is attacked by razor"+damage+" damage.";
    return userAttack;
  }
  @Override
  /**
  Description: special attack number 3
  @param: this is the pokemon we are attacking
  @return: returning a string that shows which pokemon was attacks and for how much damage
  */
  public String solarBeam(Pokemon p){
    int damage = (int)(Math.random()*5)+0;
    if(p instanceof Fire){
      double amplified = Pokemon.battleTable[2][0];
      damage *= amplified;
    }
    else if(p instanceof Water){
      double amplified = Pokemon.battleTable[2][1];
      damage *= amplified;
    }
    else{//p instanceof Grass
      double amplified = Pokemon.battleTable[2][2];
      damage *= amplified;
    }
    p.takeDamage(damage);
    String userAttack = p.getName()+" is SLAMMED by a force of sunlight and takes "+damage+" damage.";
    return userAttack;
  }
  /**
  Description: Displays the special menu
  @return: the special menu 
  */
  @Override
  public String getSpecialMenu(){
    return specialMenu;
  }
  /**
  Description: getting the special menu number
  @return: the special menu number chosen 
  */
  @Override
  public int getNumSpecialMenuItems(){
    int numSpecialMenuItems = CheckInput.getIntRange(1,3);
    return numSpecialMenuItems;
  }
  /**
  Description: getting the special attack 
  @param: Pokemon p is the pokemon we are attacking, and move is which special attack
  @return: what attack we are doing
  */
  @Override
  public String specialAttack(Pokemon p, int move) {
    String specialAttack = "";
    switch (move){
      case 1:
        specialAttack = vineWhip(p);
        break;
      case 2:
        specialAttack = razorLeaf(p);
        break;
      case 3:
        specialAttack = solarBeam(p);
        break;
    }
    return specialAttack;
  } 

}//end of the class
