import java.util.Objects;

public class GameGrid {
private final int[][] grid;
public static final int GRID_DIM = 9;
public static final int SUBGRID_DIM = GRID_DIM / 3;
public static final int MAX_VAL = 9;
public static final int MIN_VAL = 1;
public static final int EMPTY_VAL = 0;

    public GameGrid(int[][] grid){
    	Objects.requireNonNull(grid);
    	this.grid = grid;  
    }
    
    public GameGrid(String args) {
    	Objects.requireNonNull(args);
    	grid = IOUtils.loadFromFile(args);
    }
    
    public int getField(int column, int row) {
    	  if (column < 0 || column >= GRID_DIM || row < 0 || row >= GRID_DIM)
              throw new IllegalArgumentException("Given dimensions invalid: " + column + "x" + row);
    	return grid[row][column];
    }
    
    public Boolean setField(int column, int row, int value) {
    	if (column < 0 || column >= GRID_DIM || row < 0 || row >= GRID_DIM)
            throw new IllegalArgumentException("Given dimensions invalid: " + column + "x" + row);
        if (value < MIN_VAL || value > MAX_VAL)
            throw new IllegalArgumentException("Given value invalid: " + value);
        
    	boolean result = isValid(column,row,value);
    	if(result == true) {
    		value = grid[row][column];
    		return true;
    	}else {
    		return false;    		
    	}
    }
    
    private boolean checkRow(int x, int y, int value) {
        final int GRID_DIM = 9;

        boolean result = true;        
        for(int xx = 0; xx < GRID_DIM; xx++) {
            if (xx != x && grid[y][xx] == value) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    private boolean checkColumn(int x, int y, int value) {
        final int GRID_DIM = 9;

        boolean result = true;        
        for(int yy = 0; yy < GRID_DIM; yy++) {
            if (yy != y && grid[yy][x] == value) {
                result = false;
                break;
            }
        }
        return result;
    }
        	
    private boolean checkSubGrid(int x, int y, int value) {
        boolean result = true;
        for(int xx = x/9; xx < x/9 + 3; xx++) {
            for(int yy = y/9; yy < y/9 + 3; yy++) {
                if (xx != x && yy != y && grid[yy][xx] == value) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    private boolean isValid(int x, int y, int value) {
        return checkRow(x,y,value) && 
               checkColumn(x,y,value) && 
               checkSubGrid(x,y,value);
    }
    
    public String toString() {
    	String result = " ";
    	for(int i =0; i <grid.length; i++) {
    		for(int j =0; j <grid.length; j++) {
    	        result += grid[i][j];
    	        if(j % 3 == 2) {
   			     result += " "; 
   			    }
   			    result += " ";
   			}
   			    if(i % 3 == 2) {
   			    	result += "\n";
   			    }
         			    result += "\n";
 
    		}
    	return result;
    }
    
    public void clearField(int column, int row) {
    	if (column < 0 || column >= GRID_DIM || row < 0 || row >= GRID_DIM)
            throw new IllegalArgumentException("Given dimensions invalid: " + column + "x" + row);
    	
    	grid[row][column] = 0;
    }
}
