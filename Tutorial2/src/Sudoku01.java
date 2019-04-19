import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Objects;

public class Sudoku01 {

    /**
     * Print a game menu message to the console.
     */
    public static void printMenu() {
        System.out.print("\n" +
                "1.Set field\n"+
        		"2.Clear field\n"+
                "3. Print game\n" +
                "4. Exit\n\n" +
                "Select an action [1-2]: ");
    }   

    /**
     * Read a single integer value from the console and return it.
     * This function blocks the program's execution until a user
     * entered a value into the command line and confirmed by pressing
     * the Enter key.
     * @return The user's input as integer or -1 if the user's input was invalid.
     */
    public static int parseInput() {
        Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException missE) {
            in.next(); // discard invalid input
            return -1;
        }
    }   

    /**
     * Display a dialog requesting a single integer which is returned
     * upon completion.
     *
     * The dialog is repeated in an endless loop if the given input 
     * is not an integer or not within min and max bounds.
     *
     * @param msg: a name for the requested data.
     * @param min: minium accepted integer.
     * @param max: maximum accepted integer.
     * @return The user's input as integer.
     */
    public static int requestInt(String msg, int min, int max) {
        Objects.requireNonNull(msg);

        while(true) {
            System.out.print("Please provide " + msg + ": ");
            int input = parseInput();
            if (input >= min && input <= max) return input;
            else {
                System.out.println("Invalid input. Must be between " + min + " and " + max);
            }
        }
    }

	public static void printGrid(int[][] grid) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
			    System.out.print(grid[i][j]);
			    if(j % 3 == 2) {
			     System.out.print(" "); 
			    }
			    System.out.print(" ");
			}
			    if(i % 3 == 2) {
			    	System.out.println(" ");
			    }
      			    System.out.println(" ");
		}
		
	}

    public static void main(String[] args) {
        int[][] grid = {
            {9,4,0,1,0,2,0,5,8},
            {6,0,0,0,5,0,0,0,4},
            {0,0,2,4,0,3,1,0,0},
            {0,2,0,0,0,0,0,6,0},
            {5,0,8,0,2,0,4,0,1},
            {0,6,0,0,0,0,0,8,0},
            {0,0,1,6,0,8,7,0,0},
            {7,0,0,0,4,0,0,0,3},
            {4,3,0,5,0,9,0,1,2}
        };
        Sudoku01.printGrid(grid);
	    Sudoku01.printMenu();
        boolean stay = true;
  	    while(stay) {
  	    int action = parseInput();
      if(action == 1) {
    	  int x = Sudoku01.requestInt("x place",0,8);
    	  int y = Sudoku01.requestInt("y place", 0, 8);
    	  int value = Sudoku01.requestInt("the value in this place", 0, 9 );
    	  grid[y][x] = value;
    	  Sudoku01.printGrid(grid);
    	  Sudoku01.printMenu();
      }else if(action ==2) {
    	  int x = Sudoku01.requestInt("x place",0,8);
    	  int y = Sudoku01.requestInt("y place", 0, 8);
    	  grid[y][x] = 0;
    	  Sudoku01.printGrid(grid);
    	  Sudoku01.printMenu();
      }else if(action == 3) {
    	  Sudoku01.printGrid(grid);
  	    Sudoku01.printMenu();
      }else if(action == 4) {
         stay = false;
      }else {
    	  System.out.println("Error invalid input has been provied.");
    	  stay = true;
      }
  	  }
}
}
