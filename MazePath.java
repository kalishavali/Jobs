package HakerRank;

import java.util.Scanner;

public class MinCostPath{
    
    
    
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
    static boolean solveMaze(int[][] maze,int x,int y){
    	maze=changeMatrix(maze);
        if(x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==0){//Checking if current cell is legal
            maze[x][y]+=1;
            if(x==0 && y==0)//checking if point has reached
                return true;
            boolean up,down,left,right;
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
            if(up||down||left||right){
                if(up)
                    System.out.println("DOWN");
                if(down)
                    System.out.println("UP");
                if(left)
                    System.out.println("RIGHT");
                if(right)
                    System.out.println("LEFT");
                count++;
                return true;
            }
            maze[x][y]-=1;//backtrack
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int[][] maze=new int[3][3];
        System.out.println("enter maze 1 for path and 0 for wall");
        for(int i=0;i<3;i++) 
            for(int j=0;j<3;j++)
                maze[i][j]=in.nextInt();
        System.out.print("Enter cheese position\nX: ");
        int tarx=in.nextInt();
        System.out.print("Y: ");
        int tary=in.nextInt();
        if(!solveMaze(maze,tarx,tary))
            System.out.println("no path");
        System.out.println(count);
    }
}

