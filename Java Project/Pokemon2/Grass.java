public class Grass extends Pokemon{
  /**
  Description: the constructor for grass type pokemon
  @param n - is the name
  @param h - is the hp
  @param m - is the max hp
  */
  public Grass(String n, int h, int m){
    super(n,h,m);
  }
  /**
  Description: depending on the users atkType, it will decide to either return
               the basic menu or special menu
  @param atkType - is either basic attack or special attack depending on user choice
  @return - returning the basic menu or special menu depending on atkType
  */
  @Override
  public String getAttackMenu(int atkType){
    if(atkType == 1){
      String basicMenu = super.getAttackMenu(atkType);
      return basicMenu;
    }
    else{
      String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
      return specialMenu;
    }
  }
  /**
  Description: returning the number of items in the numAttackMenu
  @param atkType - is either basic attack or special attack depending on user choice
  @return - returning three since there is 3 opitons you can choose from
  */
  @Override
  public int getNumAttackMenuItems(int atkType){
    return 3;
  }
  /**
  Description: getting the attack string
  @param atkType - is either basic attack or special attack depending on user choice
  @param move - which attack the user chosed 
  @return - returning the string of what attack they are doing
  */
  @Override
  public String getAttackString(int atkType, int move){
    if(atkType == 1) {
        super.getAttackString(atkType, move);
    } else if (atkType == 2) {
        if (move == 1) {
          return "GOT WHIPPED";
        } else if (move == 2) {
          return "GOT SLICED";
        } else {
          return "GOT BURNED BY THE SUN";
        }
      }
      return null;
    }
 /**
  Description: 
  @param atkType - is either basic attack or special attack depending on user choice
  @param move - which attack the user chosed
  @return - returning the damage depending on the attack
  */
    @Override
    public int getAttackDamage(int atkType, int move){
      if(atkType == 1){
        super.getAttackDamage(atkType,move);
      } else {
        if(move == 1){
          int damage = (int)(Math.random()*3);
          return damage;
        } else if(move == 2){
          int damage = (int)(Math.random()*4)+2;
          return damage;
        } else if (move == 3){
          int damage = (int)(Math.random()*5);
          return damage;
        }
      }
      return 1;
    }
  /**
  Description: multiplying the attack
  @param p - is the pokemon 
  @param atkType - which attack the user chosed 
  @return - returning the damage multiplyed
  */
    @Override
    public double getAttackMultiplier(Pokemon p, int atkType){
        if(atkType == 1){
          super.getAttackMultiplier(p, atkType);
        } else if (atkType == 2){
          if (getType() == 0) {
            double damageMult = Pokemon.battleTable[2][0];
          } else if (getType() == 1) {
            double damageMult = Pokemon.battleTable[2][1];
          } else {
            double damageMult = Pokemon.battleTable[2][2];
            return damageMult;
          }
        }
        return 1;
    }
}//end of class
