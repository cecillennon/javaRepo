import java.util.*;


public class Grid {
	protected int rows; //number of grid rows
	protected int cols; //number of grid columns
	
	protected boolean [][] grid;  //grid containing blocks
	boolean [][] visited;  //used by blob count
	
	public Grid(int rows, int cols, int percentage){
		//Precondition: rows and cols > 0
		//				0 <= percentage <= 100
		//instantiates a grid of size rows by cols, where locations are set to
		//indicate blob characters based on the percentage probability
		
		this.rows = rows;
		this.cols = cols;
		grid = new boolean [rows][cols];
		
		//to generate random numbers
		int randInt;
		Random rand = new Random();
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++){
				
				randInt = rand.nextInt(100);  // random number 0 - 99
				if(randInt < percentage)
					grid[i][j] = true;
				else
					grid[i][j] = false;
			}
	}
	
	public String toString(){
		
		String gridString = "";
		for(int i = 0; i < rows; i++){
			
			for(int j = 0; j < cols; j++){
				
				if(grid[i][j])
					gridString = gridString + "X";
				else
					gridString = gridString + "-";
			}
			gridString = gridString + "\n";  //end of row
		}
		return gridString;
	}
	
	public int blobCount(){
		//returns number of blobs in grid
		
		int count = 0;
		visited = new boolean [rows][cols];  //true if location visited
		
		//inititalized visited
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				visited[i][j] = false;
		
		//count blobs
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				if(grid[i][j] && !visited[i][j]){
					
					count++;
					markBlob(i, j);
				}
		return count;
	}
	
	private void markBlob(int row, int col){
		//mark position row, col as having been visited
		//check and if appropriate mark locations above, below, and to the side
		visited[row][col] = true;
		
		//check above
		if((row - 1) >= 0)   //if its on the grid
			if(grid[row - 1][col])  //and has a blob character
				if(!visited[row - 1][col])  //and has not been visited
					markBlob(row - 1, col);  //mark it
		
		//check below
		if((row + 1) < rows)  //if it's on the grid
			if(grid[row + 1][col])  //and has a blob character
				if(!visited[row + 1][col])  //and has nbot been visited
					markBlob(row + 1, col);  //mark it
		
		//check left
		
		if((col - 1) >= 0)  //if it's on the grid
			if(grid[row][col - 1])  //and has a blob character on it
				if(!visited[row][col - 1])  //and has not been visited
					markBlob(row, col - 1);  //mark it
		
		//check right
		
		if((col + 1) < cols)  //if it's on the grid
			if( grid[row][col + 1])  //and has a blob character on it
				if(!visited[row][col+1])  //and has not been visited
					markBlob(row, col + 1);  //mark it
				
				
			
	{
		
	}
	}
}
