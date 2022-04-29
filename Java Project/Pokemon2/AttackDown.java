public class AttackDown extends PokemonDecorator{

    /**
     * Adds a debuff for the pokemon p in the arg
     * Adds a "-ATK" string to the pokemon's name.
     * @param p - the pokemon that's getting debuffed.
     * getAttackBonus() gets override for pokemon
     * */
    public AttackDown(Pokemon p){
        super(p, "-ATK", 0);
    }

    /**
     * @return -1: 1 point gets taken off from their damage output.
     * */
    @Override
    public int getAttackBonus(int type){
        return -1;
    }
}
