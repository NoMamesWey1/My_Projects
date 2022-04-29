package Objects;
import java.lang.Math;
import Controller.*;
import Interface.*;

  /**
  Description: the pokemon class 
  */
public abstract class Pokemon extends Entity{
  public static final double[][] battleTable = {{1,.5,2},{2,1,.5},{.5,2,1}};
  /**
  Description: creates the variable type
  @param: which pokemon it is
  */
  public Pokemon(String n){
    super(n,24);
  }
  /**
  Description: getting the special menu
  */
  public abstract String getSpecialMenu();
  /**
  Description: getting the number for which special attack
  */
  public abstract int getNumSpecialMenuItems();
  /**
  Description: doing the special attack
  @param: Pokemon is which we are attacking and move is whihc move we want
  */
  public abstract String specialAttack(Pokemon p, int move);
  /**
  Description: getting the basic menu
  @return: the basic menu
  */
  public String getBasicMenu(){
    String basicMenu = "1. Slam\n2. Tackle\n3. Punch";
    return basicMenu;
  }
  /**
  Description: getting which attack
  @return: returning the num for basic menu
  */
  public int getNumBasicMenuItems(){
    int num = CheckInput.getIntRange(1, 3);
    return num;
  }
  /**
  Description: attacking the pokemon
  @param: which pokemon we are attacking and move is which attack they want
  @return: returning which attack the user wants
  */
  public String basicAttack(Pokemon p, int move){
    String basicAttack = "";
    switch(move){
      case 1:
        basicAttack = slam(p);
        break;
      case 2:
        basicAttack = tackle(p);
        break;
      case 3:
        basicAttack = punch(p);
        break;
    }
    return basicAttack;
  }
  /**
  Description: getting which attacks
  @return: returning the attack menu
  */
  public String getAttackMenu(){
    String attackMenu = "1. Basic Attacks\n2. Special Attacks";
    return attackMenu;
  }
  /**
  Description: getting the users choice of which attack
  @return: returning the num the user chose
  */
  public int getNumAttackMenuItems(){
    int num = CheckInput.getIntRange(1, 2);
    return num;
  }
  /**
  Description: slam attack method
  @param: which pokemon is being attack
  @return: returning the users attack slam
  */
  public String slam(Pokemon p){
    int damage = (int)(Math.random() * 5);
    p.takeDamage(damage);
    String userAttack = p.getName()+" is SLAMMED and takes " + damage + " damage";
    return userAttack;
  }
  /**
  Description: tackle attack method
  @param: which pokemon is being attack
  @return: returning the users attack tackle
  */
  public String tackle(Pokemon p){
    int damage = (int)(Math.random() * 3) + 2;
    p.takeDamage(damage);
    String userAttack = p.getName()+" is TACKLED and take " + damage + " damage";
    return userAttack;
  }
  /**
  Description: punch attack method
  @param: which pokemon is being attack
  @return: returning the users attack punch
  */
  public String punch(Pokemon p){
    int damage = (int)(Math.random() * 4) + 1;
    p.takeDamage(damage);
    String userAttack = p.getName()+" is PUNCHED and take " + damage + " damage";
    return userAttack;
  }
  /**
  Description: getting the type of the pokemon
  @return: the number
  */
  public int getType(){
    if(getName()=="Charmander"||getName()=="Ponyta"){
      return 0;
    }
    else if(getName()=="Staryu"||getName()=="Squirtle"){
      return 1;
    }
    else{
      return 2;
    }
  }
}//end of class