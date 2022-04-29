package Controller;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * 
 * @author Aidan Tristen Angel
 * Map Class sets up the Map for the Porgram
 */

public class Map implements Serializable {
	private boolean next = false;
    private char [][] map;
    private boolean [][] revealed;
/**
 * Map creates the 2d array of the Map
 */
    public Map() {
         this.map = new char[5][5];
         this.revealed = new boolean[5][5];
    }

/**
 * 
 * @return returns the next map to be used
 */
	public boolean checkNextMap() {
		return next;
	}
/**
 * 
 * @param next equates to the next map txt file to be use
 */
	public void setNextMap(Boolean next) {
		this.next = next;
	}
/**
 *     
 * @param areaNum acts as the identifier for which map txt file to use.
 */
	public void generateArea(int areaNum) {
		File file = new File("src/Map/Area" + areaNum + ".txt");
		Scanner in = null;
		
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < map.length; i++) {
			String[] str = in.nextLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				map[i][j] = str[j].charAt(0);
			}
		}

	}
/**
 * 	
 * @param p returns the character of the location,
 * @return returns the initial x cover of the location before its revelation
 */
	public char getCharAtLocation(Point p) {
		try {
			return map[(int) p.getY()][(int) p.getX()];
		} catch (ArrayIndexOutOfBoundsException e) {
			return 'x';
		}
	}

	/**
	 * Checks if a new map has been created. if so, reset the reveal array (or set it to false),
	 * prints out the map with x except for the cities  and the starting point.
	 * */
	public void displayMap(Point p) {
		if(checkNextMap()){
			System.out.println(" ----------- ");
			for (int i = 0; i < map.length; i++){
				System.out.print("| ");
				for (int j = 0; j < map.length; j++){
					revealed[i][j] = false;
					if (i == (int) p.getY() && j == (int) p.getX()) {
						System.out.print('*');
					}else {
						System.out.print((map[i][j] == 'c' || map[i][j] == 's') ? map[i][j] : 'x');
					}
					System.out.print(" ");
				}
				System.out.println("|");
			}
			System.out.println(" ----------- ");
			setNextMap(false);
		} else{
			System.out.println(" ----------- ");
			for (int i = 0; i < map.length; i++) {
				System.out.print("| ");
				for (int j = 0; j < map.length; j++) {
					if (i == (int) p.getY() && j == (int) p.getX()) {
						System.out.print('*');
					}else {
						System.out.print((revealed[i][j] == true || map[i][j] == 'c' || map[i][j] == 's') ? map[i][j] : 'x');
					}
					System.out.print(" ");
				}
				System.out.println("|");
			}
			System.out.println(" ----------- ");
		}
	}
/**
 * Finds the starting location of the map loaded
 * @return the location in 2d array coordinates
 */
	public Point findStartLocation() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 's') {
					return new Point(j, i);
				}
			}
		}
		return null;
	}
	
/**
 * Finds the end location of the map loaded
 * @return the location in 2d array coordinates
 */
	public Point findEndLocation() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 'f') {
					return new Point(j, i);
				}
			}
		}
		return null;
	}
/**
 * 	
 * @param p reveals the point chosen and set equal to true
 */
	public void reveal(Point p) {
		revealed[(int) p.getY()][(int) p.getX()] = true;
	}
/**
 * 	
 * @param p finds object from location point
 */
	public void removeOppAtLoc(Point p) {
		map[(int) p.getY()][(int) p.getX()] = 'n';
	}

}
// Controller.Map 1 Layout:
//n w n p n
//i p w n c
//s n p i n
//w c n w w
//n w n p f

//Controller.Map 2 Layout:
//n w p f w
//c n n p i
//n w i n c
//p n p w n
//w n w n s

//Controller.Map 3 Layout:
//w n n s p
//n w n i c
//f p w w n
//p n w n n
//w c i n p


//Appendix:
//S= Start
//F = Finish
//C = City
//W = Wild pokemon encounter
//P = Random person encounter
//N = No encounter