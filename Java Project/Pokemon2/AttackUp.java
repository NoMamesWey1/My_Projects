public class AttackUp extends PokemonDecorator{

    /**
     * Adds a buff for the pokemon p
     * Adds a "+ATK" string to the pokemon's name.
     * @param p - the pokemon that's getting buffed.
     * getAttackBonus() gets override for pokemon
     * */
    public AttackUp(Pokemon p){
        super(p, "+ATK", 0);
    }

    /**
     * @return either 1 or 2: point(s) gets taken off from their damage output.
     * */
    @Override
    public int getAttackBonus(int type){
        return (int) (Math.random() * 2) + 1;
    }
}
