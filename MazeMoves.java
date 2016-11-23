package HakerRank;

import java.util.Scanner;

public class Maze{
    
    
    
    static int count=0;
    static int[][] changeMatrix(int[][] maze){
    	for(int i=0;i<maze.length;i++){
    		for(int j=0;j<maze[i].length;j++){
    			if(maze[i][j]==2)
    				maze[i][j]=0;
    		}
    	}
    	return maze;
    }
    static int solveMaze(int[][] maze,int x,int y){
    	maze=changeMatrix(maze);
        if(x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==0){//Checking if current cell is legal
            maze[x][y]+=1;
            if(x==0 && y==0)//checking if point has reached
                return count;
            int up,down,left,right;
            /*
             Calculating horizontal and vertical distances and moving according to it
            */
            int xDiff=0-x;
            if(xDiff<0)
                xDiff*=-1;
            int yDiff=0-y;
            if(yDiff<0)
                yDiff*=-1;
            if(xDiff<yDiff){
                if(0<x){
                    up=solveMaze(maze,x-1,y);
                    down=solveMaze(maze,x+1,y);
                }
                else{
                    down=solveMaze(maze,x+1,y);
                    up=solveMaze(maze,x-1,y);
                }
                if(0<y){
                    left=solveMaze(maze,x,y-1);
                    right=solveMaze(maze,x,y+1);
                }
                else{
                    right=solveMaze(maze,x,y+1);
                    left=solveMaze(maze,x,y-1);
                }
            }
            else{
                if(0<y){
                    left=solveMaze(maze,x,y-1);
                    right=solveMaze(maze,x,y+1);
                }
                else{
                    right=solveMaze(maze,x,y+1);
                    left=solveMaze(maze,x,y-1);
                }
                if(0<x){
                    up=solveMaze(maze,x-1,y);
                    down=solveMaze(maze,x+1,y);
                }
                else{
                    down=solveMaze(maze,x+1,y);
                    up=solveMaze(maze,x-1,y);
                }
            }
            //print opposite movement if the cell is a part of the path
            if(up>=0||down>=0||left>=0||right>=0){
                count=count+1;
                return count;
            }
            maze[x][y]-=1;//backtrack
            return -1;
        }
        return -1;
    }
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int[][] maze=new int[4][4];
        System.out.println("enter maze 1 for path and 0 for wall");
        for(int i=0;i<4;i++) 
            for(int j=0;j<4;j++)
                maze[i][j]=in.nextInt();
        System.out.print("Enter cheese position\nX: ");
        int tarx=in.nextInt();
        System.out.print("Y: ");
        int tary=in.nextInt();
        System.out.println(solveMaze(maze,tarx,tary));
    }
}

