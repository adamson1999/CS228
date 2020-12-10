package edu.iastate.cs228.hw1;

/**
 *
 * @author Bryanna Adamson
 *
 */

/**
 *
 * Living refers to the life form occupying a square in a plain grid. It is a
 * superclass of Empty, Grass, and Animal, the latter of which is in turn a superclass
 * of Badger, Fox, and Rabbit. Living has two abstract methods awaiting implementation.
 *
 */
public abstract class Living {
	protected Plain plain; // the plain in which the life form resides
	protected int row;     // location of the square on which
	protected int column;  // the life form resides

	// constants to be used as indices.
	protected static final int BADGER = 0;
	protected static final int EMPTY = 1;
	protected static final int FOX = 2;
	protected static final int GRASS = 3;
	protected static final int RABBIT = 4;

	public static final int NUM_LIFE_FORMS = 5;

	// life expectancies
	public static final int BADGER_MAX_AGE = 4;
	public static final int FOX_MAX_AGE = 6;
	public static final int RABBIT_MAX_AGE = 3;


	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a plain.
	 * @param population  counts of all life forms
	 */
	protected void census(int population[ ]){
		int width = plain.getWidth();
			for(int i=0;i<width;i++) {
				for(int j=0;j<width;j++) {
					//The following is for a 3x3 neighborhood
					if(plain.grid[row][column].who().equals(BADGER)) {
						population[BADGER]++;
					}
					if(plain.grid[row][column].who().equals(EMPTY)) {
						population[EMPTY]++;
					}
					if(plain.grid[row][column].who().equals(FOX)) {
						population[FOX]++;
					}
					if(plain.grid[row][column].who().equals(GRASS)) {
						population[GRASS]++;
					}
					if(plain.grid[row][column].who().equals(RABBIT)) {
						population[RABBIT]++;
					}


					if(column >0 && row>0) {
						if(plain.grid[row-1][column-1].who().equals(BADGER)) {
							population[0]++;
						}
						if(plain.grid[row-1][column-1].who().equals(EMPTY)) {
							population[1]++;
						}
						if(plain.grid[row-1][column-1].who().equals(FOX)) {
							population[2]++;
						}
						if(plain.grid[row-1][column-1].who().equals(GRASS)) {
							population[3]++;
						}
						if(plain.grid[row-1][column-1].who().equals(RABBIT)) {
							population[4]++;
						}
					}


					if(column < width-1 && row < width-1) {
						if(plain.grid[row+1][column+1].who().equals(BADGER)) {
							population[0]++;
						}
						if(plain.grid[row+1][column+1].who().equals(EMPTY)) {
							population[1]++;
						}
						if(plain.grid[row+1][column+1].who().equals(FOX)) {
							population[2]++;
						}
						if(plain.grid[row+1][column+1].who().equals(GRASS)) {
							population[3]++;
						}
						if(plain.grid[row+1][column+1].who().equals(RABBIT)) {
							population[4]++;
						}
					}


					if(row >0) {
						if(plain.grid[row-1][column].who().equals(BADGER)) {
							population[0]++;
						}
						if(plain.grid[row-1][column].who().equals(EMPTY)) {
							population[1]++;
						}
						if(plain.grid[row-1][column].who().equals(FOX)) {
							population[2]++;
						}
						if(plain.grid[row-1][column].who().equals(GRASS)) {
							population[3]++;
						}
						if(plain.grid[row-1][column].who().equals(RABBIT)) {
							population[4]++;
						}
					}


					if(column>0) {
						if(plain.grid[row][column-1].who().equals(BADGER)) {
							population[0]++;
						}
						if(plain.grid[row][column-1].who().equals(EMPTY)) {
							population[1]++;
						}
						if(plain.grid[row][column-1].who().equals(FOX)) {
							population[2]++;
						}
						if(plain.grid[row][column-1].who().equals(GRASS)) {
							population[3]++;
						}
						if(plain.grid[row][column-1].who().equals(RABBIT)) {
							population[4]++;
						}
					}
					if(column<width-1) {
						if(plain.grid[row][column+1].who().equals(BADGER)) {
							population[BADGER]++;
						}
						if(plain.grid[row][column+1].who().equals(EMPTY)) {
							population[EMPTY]++;
						}
						if(plain.grid[row][column+1].who().equals(FOX)) {
							population[FOX]++;
						}
						if(plain.grid[row][column+1].who().equals(GRASS)) {
							population[GRASS]++;
						}
						if(plain.grid[row][column+1].who().equals(RABBIT)) {
							population[RABBIT]++;
						}
					}
					if(row<width-1) {
						if(plain.grid[row+1][column].who().equals(BADGER)) {
							population[BADGER]++;
						}
						if(plain.grid[row+1][column].who().equals(EMPTY)) {
							population[EMPTY]++;
						}
						if(plain.grid[row+1][column].who().equals(FOX)) {
							population[FOX]++;
						}
						if(plain.grid[row+1][column].who().equals(GRASS)) {
							population[GRASS]++;
						}
						if(plain.grid[row+1][column].who().equals(RABBIT)) {
							population[RABBIT]++;
						}
					}
					if(row>0&&column<width-1) {
						if(plain.grid[row-1][column+1].who().equals(BADGER)) {
							population[BADGER]++;
						}
						if(plain.grid[row-1][column+1].who().equals(EMPTY)) {
							population[EMPTY]++;
						}
						if(plain.grid[row-1][column+1].who().equals(FOX)) {
							population[FOX]++;
						}
						if(plain.grid[row-1][column+1].who().equals(GRASS)) {
							population[GRASS]++;
						}
						if(plain.grid[row-1][column+1].who().equals(RABBIT)) {
							population[RABBIT]++;
						}
					}
					if(column>0&&row<width-1) {
						if(plain.grid[row+1][column-1].who().equals(BADGER)) {
							population[BADGER]++;
						}
						if(plain.grid[row+1][column-1].who().equals(EMPTY)) {
							population[EMPTY]++;
						}
						if(plain.grid[row+1][column-1].who().equals(FOX)) {
							population[FOX]++;
						}
						if(plain.grid[row+1][column-1].who().equals(GRASS)) {
							population[GRASS]++;
						}
						if(plain.grid[row+1][column-1].who().equals(RABBIT)) {
							population[RABBIT]++;
						}
					}
				}
			}
	}
		//
		//
		// Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits
		// in the 3x3 neighborhood centered at this Living object.  Store the
		// counts in the array population[] at indices 0, 1, 2, 3, 4, respectively.


	/**
	 * Gets the identity of the life form on the square.
	 * @return State
	 */
	public abstract State who();
	// To be implemented in each class of Badger, Empty, Fox, Grass, and Rabbit.
	//
	// There are five states given in State.java. Include the prefix State in
	// the return value, e.g., return State.Fox instead of Fox.

	/**
	 * Determines the life form on the square in the next cycle.
	 * @param  pNew  plain of the next cycle
	 * @return Living
	 */
	public abstract Living next(Plain pNew);
	// To be implemented in the classes Badger, Empty, Fox, Grass, and Rabbit.
	//
	// For each class (life form), carry out the following:
	//
	// 1. Obtains counts of life forms in the 3x3 neighborhood of the class object.

	// 2. Applies the survival rules for the life form to determine the life form
	//    (on the same square) in the next cycle.  These rules are given in the
	//    project description.
	//
	// 3. Generate this new life form at the same location in the plain pNew.

}
