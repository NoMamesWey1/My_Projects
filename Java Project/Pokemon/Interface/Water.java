package Interface;

import Objects.Pokemon;

public interface Water {
	String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
	int numSpecialMenuItems = 3;

	/**
	 Description: special attack number 1: water gun
	 Only for water types
	 @param: this is the pokemon we are attacking
	 Be sure to change the damage according to the pokemon.
	 */
	String watergun(Pokemon p);

	/**
	 Description: special attack number 2: bubblebeam
	 Only for water types
	 @param: this is the pokemon we are attacking
	 Be sure to change the damage according to the pokemon.
	 */
	String bubblebeam(Pokemon p);

	/**
	 Description: special attack number 3: waterfall
	 Only for water types
	 @param: this is the pokemon we are attacking
	 Be sure to change the damage according to the pokemon.
	 */
	String waterfall(Pokemon p);
}
