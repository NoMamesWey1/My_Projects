import java.lang.Math;
/**
 Description: the pokemon class
 */
public abstract class Pokemon extends Entity{
  public static final double[][] battleTable = {{1,.5,2},{2,1,.5},{.5,2,1}};
/**
  Description: the constructor for the pokemon
  @param n - is the name
  @param h - is the hp
  @param m - is the max hp
  */
  public Pokemon(String n, int h, int m){
    super(n,h,m);
  }
/**
  Description: getting the attack menu
  @return - returning the menu
  */
  public String getAttackTypeMenu(){
    String menu = "1. Basic Attacks\n2. Special Attacks";
    return menu;
  }
/**
  Description: getting the amount of options it contains
  @return - returning the amount of options
  */
  public int getNumAttackTypeMenuItems(){
    return 2;
  }
/**
  Description: getting the basic Attacks
  @param atkType - is which atkType they chose
  @return - the basic menu attacks
  */
  public String getAttackMenu(int atkType){
    if(atkType == 1){
      String basicMenu = "1. Slam\n2. Tackle\n3. Punch";
      return basicMenu;
    }else{
      return null;
    }
  }
/**
  Description: getting the amount of options it contains
  @param atkType - the atkType they chose
  @return - returning the amount of options
  */
  public int getNumAttackMenuItems(int atkType){
    return 3;
  }
/**
  Description: attacking the pokemon
  @param p - the pokemon
  @param atkType - which atkType they user chose
  @param move - which move the user chose
  return - returning the attack string
  */
  public String attack(Pokemon p, int atkType, int move){
    int damage = (int) (getAttackDamage(atkType, move) * getAttackMultiplier(p,atkType)) + getAttackBonus(atkType);
    p.takeDamage(damage);

    String attackString = p.getName() + " " + getAttackString(atkType,move) + " and takes " + damage + " damage.";
    return attackString;
  }
/**
  Description: getting the string of the attack
  @param atkType - which atkType it is
  @param move - which move they are doing
  return -  the string of the attack
  */
  public String getAttackString(int atkType, int move){
    if(move == 1){
      return "is SLAMMED";
    }
    else if(move == 2){
      return "is TACKLED";
    }
    else{
      return "is PUNCHED";
    }
  }
/**
  Description: getting the damage
  @param atkType - which attack it is
  @param move - which move they are doing
  @return - returning the damage
  */
  public int getAttackDamage(int atkType, int move){
    if(move == 1){
      int damage = (int)(Math.random()*5);
      return damage;
    } else if(move == 2){
      int damage = (int)(Math.random()*3)+2;
      return damage;
    } else{
      int damage = (int)(Math.random()*4)+1;
      return damage;
    }
  }
/**
Description: getting the attack multiplyed 
@param p - which pokemon it is
@param atkType - which attack it is
@return - returning the multipler
*/
  public double getAttackMultiplier(Pokemon p, int atkType){
      return 1;
  }
/**
Description: getting the bonus amount 
@param atkType - which attack it is
@return - the bonus amount
*/
  public int getAttackBonus(int atkType){
    return 0;
  }
/**
Description: getting the type of the pokemon
@return - the type it is
*/
  public int getType(){
    if(this instanceof Fire){
      return 0;
    }
    else if(this instanceof Water){
      return 1;
    }
    else{
      return 2;
    }
  }


}//end of the class
