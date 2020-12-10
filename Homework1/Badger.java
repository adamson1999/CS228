package edu.iastate.cs228.hw1;

/**
 *
 * @author Bryanna Adamson
 *
 */

/**
 * A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal{
	/**
	 * Constructor
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Badger (Plain p, int r, int c, int a) {
		super.row = r;
		super.column = c;
		super.age =a;
		super.plain =p;
	}

	/**
	 * A badger occupies the square.
	 */
	public State who(){
		return State.BADGER;
	}

	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes.
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle.
	 */
	public Living next(Plain pNew){
		int[] pop = new int[NUM_LIFE_FORMS];
		census(pop);
		if(age == 4) {
			return new Empty(pNew,row,column);
		}
		else
			if(pop[BADGER] ==1 && pop[FOX]>pop[BADGER]) {
				return new Fox(pNew,row,column,0);
			}
			else
				if(pop[BADGER]+pop[FOX]>pop[RABBIT]){
					return new Empty(pNew,row,column);
				}
				else {
					return new Badger(pNew,row,column,age);
				}
	}
}
