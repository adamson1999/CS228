package edu.iastate.cs228.hw1;

/**
 *
 * @author Bryanna Adamson
 *
 */

/**
 * A fox eats rabbits and competes against a badger.
 */
public class Fox extends Animal{
	/**
	 * Constructor
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Fox (Plain p, int r, int c, int a){
		super.row = r;
		super.column = c;
		super.age =a;
		super.plain =p;
	}

	/**
	 * A fox occupies the square.
	 */
	public State who(){
		return State.FOX;
	}

	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers.
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew){
		int[] pop = new int[NUM_LIFE_FORMS];
		census(pop);
		if(age == 6) {
			return new Empty(pNew,row,column);
		}
		else
			if(pop[FOX]<pop[BADGER]) {
				return new Badger(pNew,row,column,0);
			}
			else
				if(pop[BADGER]+pop[FOX]>pop[RABBIT]){
					return new Empty(pNew,row,column);
				}
				else {
					return new Fox(pNew,row,column,age);
				}
	}
}
