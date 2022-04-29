public class Water extends Pokemon{
	/**
     * @author Aidan Tristen R. Angel
     */
	
	/**
  Description: the constructor for grass type pokemon
  @param n - is the name
  @param h - is the hp
  @param m - is the max hp
  */ 
	public Water(String n, int h, int m) {
		super(n,h,m);
	}
	/**
  Description: depending on the users atkType, it will decide to either return
               the basic menu or special menu
  @param atkType - is either basic attack or special attack depending on user choice
  @return - returning the basic menu or special menu depending on atkType
  */
	 @Override
	 public String getAttackMenu(int atkType) {
		 if(atkType == 1) {
			 String basicMenu = super.getAttackMenu(1);
			 return basicMenu;
		 }
		 else if(atkType == 2) {
			 String specialMenu = "1. Watergun\n2. Bubblebeam\n3. Waterfall";
			 return specialMenu;
		 }
		 return null;
	 }
/**
  Description: returning the number of items in the numAttackMenu
  @param atkType - is either basic attack or special attack depending on user choice
  @return - returning three since there is 3 opitons you can choose from
  */
	 @Override
	 public int getNumAttackMenuItems(int atkType) {
		 return 3;
	 }
/**
  Description: getting the attack string
  @param atkType - is either basic attack or special attack depending on user choice
  @param move - which attack the user chosed 
  @return - returning the string of what attack they are doing
  */
	 @Override
	 public String getAttackString(int atkType, int move) {
	        if(atkType == 1){
	            if(move == 1){
	                return "SLAMMED";
	            }else if (move == 2){
	                return "TACKLED";
	            }else if (move == 3){
	                return "PUNCHED";
	            }else{
	                return "OFFED";
	            }
	        }else if (atkType == 2){
	            if(move == 1){
	                return "WAS SPRAYED BY A TORRENT OF WATER";
	            }else if (move == 2){
	                return "GOT LOST IN THE BUBBLES";
	            }else if (move == 3){
	                return "WAS SQUASHED BY A WATERFALL";
	            }else{
	                return "OFFED";
	            }
	        }
			return null;
	}
/**
  Description: getting the attack damage based off the attack
  @param atkType - is either basic attack or special attack depending on user choice
  @param move - which attack the user chosed
  @return - returning the damage depending on the attack
  */
	@Override
	public int getAttackDamage(int atkType, int move){
		if(atkType == 1){
			return super.getAttackDamage(atkType, move);
		}else if (atkType == 2){
			if(move == 1){
				int specialDamage = (int)(Math.random()*5)+0;
				return specialDamage;
			}else if (move == 2){
				int specialDamage = (int) (Math.random() * 3) + 1;
				return specialDamage;
			}else if (move == 3){
				int specialDamage = (int) (Math.random() * 4) + 1;
				return specialDamage;
			}
			return 1;
		}
		return 1;
	}

/**
 *Done by Aidan Tristen Angel
 */
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
			double damage = 0;
			if(getType() == 0){
				damage = Pokemon.battleTable[0][0];
			}
			else if(getType() == 1){
				damage = Pokemon.battleTable[0][1];
			}
			else{//getType () == 2
				damage = Pokemon.battleTable[0][2];
			}
			return damage;
		}
		return 1;
	}
}
