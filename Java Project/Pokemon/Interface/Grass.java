package Interface;
import Objects.Pokemon;

/**
Description: this is the special attacks for the grass pokemon
*/
public interface Grass{
  String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
  int numSpecialMenuItems = 3;

  /**
   Description: special attack number 1: vine whip
   Only for grass types
   @param: this is the pokemon we are attacking
   Be sure to change the damage according to the pokemon.
   */
  String vineWhip(Pokemon p);

  /**
   Description: special attack number 2: razor leaf
   Only for grass types
   @param: this is the pokemon we are attacking
   Be sure to change the damage according to the pokemon.
   */
  String razorLeaf(Pokemon p);

  /**
   Description: special attack number 3: solar beam
   Only for grass types
   @param: this is the pokemon we are attacking
   Be sure to change the damage according to the pokemon.
   */
  String solarBeam(Pokemon p);

}
