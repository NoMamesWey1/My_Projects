package Objects;

import Controller.Map;

import java.awt.*;
import java.util.ArrayList;

/**
 * The trainer class represent the player in the game.
 * Objects.Trainer is a sub-class of entity, so please refer to the Objects.Entity.java for more info.
 *
 * Ex: Objects.Trainer trainer = new Objects.Trainer(name, starting pokemon, and map)
 *
 * */

public class Trainer extends Entity {
    private int money;
    private int potions;
    private int pokeballs;
    private Point location;
    private Map map;
    private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();

    /**
     * Constructor for a trainer
     * takes in a name that the user gave, their starting pokemon, and a map.
     * Starts off the game with $25, 3 potions, and 1 pokeball
     * */
    public Trainer(String n, Pokemon p, Map m ){
        super(n, 100); //adds the trainer's info into entity.java
        pokemon.add(p); //add the trainer's first pokemon into the arraylist
        this.map = m;
        m.generateArea(1); //creates a map with the map object passed from main.java
        this.money = 25;
        this.potions = 3;
        this.pokeballs = 1;
        this.location = m.findStartLocation();
    }

    /**
     * @return the amount of money that the trainer has.
     * */
    public int getMoney(){
        return this.money;
    }

    /**
     * if the trainer spends money on items, the method will deduct the correct amount from his bank.
     * @param amount - the amount that the trainer will have to pay. ex. if the trainers buys a potion for $3, he/she will have to cough up 3 bucks from their bank
     * @return true if the user spent any money. false if the user somehow spends less than $0.
     * */
    public boolean spendMoney(int amount){
        if((this.money - amount) < 0) {
            return false;
        }else {
            this.money -= amount;
            return true;
        }
    }

    /**
     * adds money into their trainer's pocket.
     * prints out their new amount.
     * @param amount - the amount that is going to be added in their pockets.
     * */
    public void receiveMoney(int amount){
        this.money += amount;
    }

    /**
     * determines whether the trainer has any potions in their backpack.
     * @return true if the user have any potions. false if the user have 0 potions (or negative potions).
     * */
    public boolean hasPotion(){
        if(this.potions > 0){
            System.out.println("** I have " + potions + " potions. **");
            return true;
        }
        System.out.println("** I have " + potions + " potions. **");
        return false;
    }

    /**
     * adds one potion to the trainer's backpack.
     * prints out their new amount of potions in their backpack.
     * */
    public void receivePotion(){
        this.potions += 1;
    }

    /**
     * The trainer have their pokemon consumes a potion when they decide to use it during a fight.
     * subtracts one potion from their backpack.
     * */
    public void usePotion(int pokeIndex){
        getPokemon(pokeIndex).heal();
        this.potions -= 1;
    }

    /**
     * determines whether the trainer has any pokeballs in their backpack.
     * @return true if they have at least one pokeball.
     * @return false if they have zero pokeball
     * */
    public boolean hasPokeball(){
        if(this.pokeballs > 0) {
            return true;
        }
        return false;
    }

    /**
     * adds one pokeball to the trainer's backpack.
     * prints out their new amount of pokeballs in their backpack.
     * */
    public void receivePokeBall(){
        this.pokeballs += 1;
    }

    /**
     * Chances of a pokemon getting captured.
     * HP <= 1: 100% chance of getting captured
     * HP 2 - 9: 75% chance of getting captured
     * HP 10 - 19: 25% chance of getting captured
     * HP 20+: 0% chance of getting captured
     *
     * if the pokemon is captured, the pokemon will be added into the pokemon arraylist.
     * @return true if a pokemon is captured.
     * */
    public boolean catchPokemon(Pokemon p){
        this.pokeballs -= 1;
        if(p.getHp() <= 1){
            pokemon.add(p);
            p.heal();
            map.removeOppAtLoc(getLocation());
            return true;
        }else if (p.getHp() > 1 && p.getHp() < 8){
            int chanceToCatch = (int) (Math.random() * 100) + 1;
            if (chanceToCatch <= 70){
                pokemon.add(p);
                p.heal();
                map.removeOppAtLoc(getLocation());
                return true;
            }
        } else if (p.getHp() >= 9 && p.getHp() < 20){
            int chanceToCatch = (int) (Math.random() * 100) + 1;
            if (chanceToCatch <= 30){
                pokemon.add(p);
                p.heal();
                map.removeOppAtLoc(getLocation());
                return true;
            }
        }
        return false;
    }

    /**
     * @return the current location of the player in the map. Note: location is a Point object.
     * */
    public Point getLocation(){
        return this.location;
    }

    /**
     * the player will move east (location.x - 1) as long as the player is in within the area (index -1 is the limit).
     * Note: the map size is 5x5. So when assigning a new point, the range is from 0 - 4.
     * Remember: N.E.S.W = Never Eat Sour Watermelon (clockwise)
     * @return the character (c, w, p, i, s, f, and n) at the location the player is on.
     * */
    public char goNorth(){
        if(location.y - 1 == -1){
            return map.getCharAtLocation(location);
        }
        location = new Point(location.x, location.y - 1);
        return map.getCharAtLocation(location);
    }

    /**
     * the player will move east (location.y + 1) as long as the player is in within the area (index 5 is the limit).
     * Note: the map size is 5x5. So when assigning a new point, the range is from 0 - 4.
     * Remember: N.E.S.W = Never Eat Sour Watermelon (clockwise)
     * @return the character (c, w, p, i, s, f, and n) at the location the player is on.
     * */
    public char goSouth(){
        if(location.y + 1 == 5){
            return map.getCharAtLocation(location);
        }
        location = new Point(location.x, location.y + 1);
        return map.getCharAtLocation(location);
    }

    /**
     * the player will move east (location.x + 1) as long as the player is in within the area (index 5 is the limit).
     * Note: the map size is 5x5. So when assigning a new point, the range is from 0 - 4.
     * Remember: N.E.S.W = Never Eat Sour Watermelon (clockwise)
     * @return the character (c, w, p, i, s, f, and n) at the location the player is on.
     * */
    public char goEast(){
        if(location.x + 1 == 5){
            return map.getCharAtLocation(location);
        }
        location = new Point(location.x + 1, location.y);
        return map.getCharAtLocation(location);
    }

    /**
     * the player will move west (location.x - 1) as long as the player is in within the area (index -1 is the limit).
     * Note: the map size is 5x5. So when assigning a new point, the range is from 0 - 4.
     * Remember: N.E.S.W = Never Eat Sour Watermelon (clockwise)
     * @return the character (c, w, p, i, s, f, and n) at the location the player is on.
     * */
    public char goWest(){
        if(location.x - 1 == -1){
            //map.displayMap(location);
            return map.getCharAtLocation(location);
        }
        location = new Point(location.x - 1, location.y);
        return map.getCharAtLocation(location);
    }

    /**
     * @return the size of the pokemon arraylist. The pokemon arraylist stores all the pokemon that the trainer has.
     * */
    public int getNumPokemon(){
        int total = pokemon.size();
        return total;
    }

    /**
     * Heals all the pokemons that the trainer has. Check Objects.Entity.java for the method: heal().
     * */
    public void healAllPokemon(){
        for(Pokemon i : pokemon){
            i.heal();
        }
    }

    /**
     * @param index - index of the pokemon arraylist
     * @return a pokemon from the arraylist with the given index.
     * */
    public Pokemon getPokemon(int index){
        return pokemon.get(index);
    }

    /**
     * @return a string of all the names of the pokemons in the pokemon arraylist. The pokemon arraylist stores all the pokemon that the trainer has.
     * */
    public String getPokemonList(){
        String listOfPokemon = "";
        int index = 1;
        for (Pokemon i : pokemon){
            listOfPokemon += index + ". " + i.getName() +  " HP: " + i.getHp() + "/" + i.getMaxHp() + "\n";
            index++;
        }
        return listOfPokemon;
    }

    /**
     * @return a string of the trainer object. name, money, # of potion, and # of pokeballs.
     * */
    public String toString(){
        return (getName() +
                " HP: " + getHp() +"/" + getMaxHp() + ", $" +
                money + ", " +
                potions + " potions, " +
                pokeballs + " pokeballs ");
    }
}
