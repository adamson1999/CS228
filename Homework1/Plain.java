package edu.iastate.cs228.hw1;

/**
 *
 * @author Bryanna Adamson
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * The plain is represented as a square grid of size width x width.
 *
 */
public class Plain
{

	private int width; // grid size: width X width

	public static Living[][] grid;

	/**
	 *  Default constructor reads from a file
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{
		File file = new File(inputFileName);
		Scanner scan = new Scanner(file);
		int num = 0;
		while(scan.hasNext()) {
					num++;
					scan.next();
			}
		scan.close();
		File file1 = new File(inputFileName);
		Scanner scanner = new Scanner(file1);
		width = (int) (num/Math.sqrt(num));
		grid = new Living[width][width];
		for(int i=0; i<width;i++) {
			for(int j=0;j<width;j++) {
				String next = scanner.next();
				next = next.substring(0,1);
				int age=0;
				if(next.length() > 1 ) {
					age = Integer.parseInt(next.substring(1));
				}

				if(next == "B") {
					grid[i][j] = new Badger(this,i,j,age);
				}
				if(next=="F") {
					grid[i][j] = new Fox(this,i,j,age);
				}
				if(next=="R") {
					grid[i][j] = new Rabbit(this,i,j,age);
				}
				if(next=="G") {
					grid[i][j] = new Grass(this,i,j);
				}
				if(next=="E") {
					grid[i][j] = new Empty(this,i,j);
				}
			}

		}
		scanner.close();
	}

	/**
	 * Constructor that builds a w x w grid without initializing it.
	 * @param width  the grid
	 */
	public Plain(int w)
	{
		width = w;
		Living[][] g = new Living[w][w];
		grid = g;

		randomInit();

	}


	public int getWidth()
	{

		return width;  // to be modified
	}

	/**
	 * Initialize the plain by randomly assigning to every square of the grid
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 *
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random();
		for(int i=0;i<width;i++) {
			for(int j=0;j<width;j++) {
				int rand = generator.nextInt(5);
				if(rand==Living.BADGER) {
					grid[i][j] = new Badger(this,i,j,0);
				}
				if(rand==Living.FOX) {
					grid[i][j] = new Fox(this,i,j,0);
				}
				if(rand==Living.RABBIT) {
					grid[i][j] = new Rabbit(this,i,j,0);
				}
				if(rand==Living.GRASS) {
					grid[i][j] = new Grass(this,i,j);
				}
				if(rand==Living.EMPTY) {
					grid[i][j] = new Empty(this,i,j);
				}
			}
		}
	}


	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal
	 * followed by a blank space; otherwise, output two blanks.
	 */
	public String toString()
	{
		String strPlain = "";
		for(int i=0; i<width;i++) {
			for(int j=0;j<width;j++) {
				if(grid[i][j].who()==State.BADGER) {
					strPlain= strPlain+"B"+((Animal) grid[i][j]).myAge()+" ";
				}
				if(grid[i][j].who()==State.FOX) {
					strPlain= strPlain+"F"+((Animal) grid[i][j]).myAge()+" ";
				}
				if(grid[i][j].who()==State.RABBIT) {
					strPlain= strPlain+"R"+((Animal) grid[i][j]).myAge()+" ";
				}
				if(grid[i][j].who()==State.GRASS) {
					strPlain= strPlain+"G"+"  ";
				}
				if(grid[i][j].who()==State.EMPTY) {
					strPlain= strPlain+"E"+"  ";
				}
			}
			if(i < width)
				strPlain = strPlain + "\n";
		}
		return strPlain;
	}


	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly
	 * generated plain for debugging purpose.
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException{
		PrintStream ps = new PrintStream(outputFileName);
		PrintStream output = System.out;
		System.setOut(ps);
		String strPlain = "";

		for(int i=0; i<width;i++) {
			for(int j=0;j<width;j++) {
				if(grid[i][j].who()==State.BADGER) {
					strPlain= strPlain+"B"+((Animal) grid[i][j]).myAge()+" ";
				}
				if(grid[i][j].who()==State.FOX) {
					strPlain= strPlain+"F"+((Animal) grid[i][j]).myAge()+" ";
				}
				if(grid[i][j].who()==State.RABBIT) {
					strPlain= strPlain+"R"+((Animal) grid[i][j]).myAge()+" ";
				}
				if(grid[i][j].who()==State.GRASS) {
					strPlain= strPlain+"G"+"  ";
				}
				if(grid[i][j].who()==State.EMPTY) {
					strPlain= strPlain+"E"+"  ";
				}
			}
			if(i < width)
				strPlain = strPlain + "\n";
		}
		System.out.println(strPlain);
		System.setOut(output);
		ps.close();
	}
}
