/**
 * 
 * @author Aidan Tristen Angel
 *
 */


/**
 * 
 * Class Entity acts as superclass for Trainer, Pokemon and other entities created.
 *
 */
public abstract class Entity {
    private String name;
    private int hp;
    private int maxHp;
/**
 * 
 * @param n equates to name
 * @param mHp equates to maximum hp of an Entity
 */
    public Entity(String n, int h, int mHp){
        this.name = n;
        this.hp = h;
        this.maxHp = mHp;
    }

 /**
  * getHp gets the hp of the Entity
  * @return returns the hp of said Entity
  */
    public int getHp() {
    	return hp;
    }
 /**
  *    getMaxHp gets the maximum hp of an Entity
  * @return maxhp of Entity
  */
    public int getMaxHp() {
    	return maxHp;
    }
/**
 * heal heals an Entity that has taken damage
 * sets hp equal to MaxHp
 */
    public void heal(){
        this.hp = maxHp;
    }
/**
 * 
 * @param d equals to damage
 */
    public void takeDamage(int d){
        if ((this.hp - d) <= 0 ){
            this.hp = 0;
        }else {
            this.hp -= d;
        }
    }

    /**
     *
     * @return name of Entity
     */
    public String getName(){
        return this.name;
    }


/**
 * 
 * @return name of the entity and their hp
 */
    public String toString(){
        return this.name + " HP: " + getHp() + "/" + getMaxHp();
    }
}
