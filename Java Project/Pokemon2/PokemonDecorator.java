public abstract class PokemonDecorator extends Pokemon {
    private Pokemon pokemon;

    /**
     * Responsible for decorating a pokemon with buffs and debuffs
     * @param p - the pokemon that is getting buffs/debuffs.
     * @param extraName - A pokemon can either have +HP, +ATK, -ATK, or -HP.
     *                  THe extra name is from HpUp, HpDown, atkUp, and atkDown.
     * @param extraHp - A pokemon's extra max hp is determined from HpUp or HpDown.
     *
     * */
    public PokemonDecorator(Pokemon p, String extraName, int extraHp){
        super(p.getName() + " " + extraName, p.getHp() + extraHp, p.getMaxHp() + extraHp);
        this.pokemon = p;
    }

    /**
     * @return getAttackMenu(int atkType) for the given pokemon
     * */
    @Override
    public String getAttackMenu(int atkType){
        return pokemon.getAttackMenu(atkType);
    }

    /**
     * @return getNumAttackMenuItems(int atkType) for the given pokemon
     * */
    @Override
    public int getNumAttackMenuItems(int atkType){
        return pokemon.getNumAttackMenuItems(atkType);
    }

    /**
     * @return getAttackString(int atkType, int move) for the given pokemon
     * */
    @Override
    public String getAttackString(int atkType, int move){
        return pokemon.getAttackString(atkType, move);
    }

    /**
     * @return getAttackDamage(int atkType, int move) for the given pokemon
     * */
    @Override
    public int getAttackDamage(int atkType, int move){
        return pokemon.getAttackDamage(atkType, move);
    }

    /**
     * @return getAttackMultiplier(Pokemon p, int type) for the given pokemon
     * */
    @Override
    public double getAttackMultiplier(Pokemon p, int type){
        return pokemon.getAttackMultiplier(p, type);
    }

    /**
     * @return getAttackBonus(int type) for the given pokemon
     * */
    @Override
    public int getAttackBonus(int type){
        return pokemon.getAttackBonus(type);
    }
}
