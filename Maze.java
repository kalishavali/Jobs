Re: Fw: Programme of Tom and Jerry Maze
VS
 
Vamsi Saikam
Thu 24-Nov-16 5:29 AM
Inbox
To:
KALISHAVALI SHAIK (kalishavali.rgukt@live.in);
Evernote
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surya
 */

public class mazesolution {
    
    
    
    static int m=0,cheese=0;
    static int findmin(int[][] maze,int a,int b,int d,int c,int x,int y,int dd,int cc,int cd)
    {
        int l=0;
        //System.out.println(m);
        if(maze[a][b]==2)cc--;
        if(dd>cd)return dd;
        if(a==x && b==y && cc ==0)
        {
           return dd;
        }
        
        int [][] maze1 = new int[100][100];
        int i,j;
        
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
            {
            
                maze1[i][j]=maze[i][j];
            }
        }
        
        
        int x1[] = new int[4];
        x1[0]=x1[1]=x1[2]=x1[3]=10000;
        
        if((a+1!=d || b != c) && ((a+1!=100 )))
        {
                if(maze1[a+1][b]!=1 )
                {
                   m= m+1;
                   maze1[a][b]=1;
                    x1[0]=findmin(maze1,a+1,b,a,b,x,y,dd+1,cc,cd);//3 m=3,c=1//
                    //if(cheese==0)return m;
                    //else m=m-1;
                    //System.out.println("1:"+m);
                }
                else l=l+1;//0 l=1//1 l=1
        
        }
        cd = x1[0];
        if((a!=d || b+1 != c) && (( b+1 != 100)))
        {
                if(maze1[a][b+1]!=1 )
                {
                    m= m+1;
                    maze1[a][b]=1;
                    x1[1]=findmin(maze1,a,b+1,a,b,x,y,dd+1,cc,cd);//1 m=1//2 m=2
                    //if(cheese==0)return m;
                    //else m=m-1;
                    //System.out.println("2:"+m);
                }
                else l=l+1;
        }
        if(cd > x1[1])cd=x1[1];
        if((a-1!=d || b != c) && ((a-1!=-1)))
        {
                if(maze1[a-1][b]!=1)
                {
                    m= m+1;
                    maze1[a][b]=1;
                   x1[2]= findmin(maze1,a-1,b,a,b,x,y,dd+1,cc,cd);//4 m=5,c=0//
                    //if(cheese==0)return m;
                    //else m=m-1;
                   // System.out.println("3:"+m);
                }
                else l=l+1;
        }
        if(cd > x1[2])cd=x1[2];
        if((a!=d || b-1 != c) && (( b-1 != -1)))
        {
                if(maze1[a][b-1]!=1 )
                {
                    m= m+1;
                    maze1[a][b]=1;
                    x1[3]=findmin(maze1,a,b-1,a,b,x,y,dd+1,cc,cd);
                    //if(cheese==0)return m;
                    //else m=m-1;
                    //System.out.println("4:"+m);
                }
                else l=l+1;
        
        }
        if(cd > x1[3])cd=x1[3];
        i=0;
        int min=x1[i];
        for(i=0;i<4;i++)if(min>x1[i])min=x1[i];
        
        
       // System.out.println("6:"+m);
       /* if(maze[a][b]!=2)
        m=m-1;
        else m= m+1;*/
       // if(l>=2)m=m-1;
        
        return min;
        
        
    }
     static int minMoves(int[][] maze,int x,int y)
     {
         
         maze[0][0]=2;
         maze[x][y]=0;
        int i,j;
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
            {
            
                if(maze[i][j]==2)cheese++;
            }
        }
        
        
        
        int a;
        a = findmin(maze,0,0,0,0,x,y,0,cheese,10000);
        if(a==1000)return -1;
        return a;
     
     
     }
      public static void main(String argv[])
    {
        int m[][] = new int[100][100];
        int i,j;
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
            {
            
                m[i][j]=1;
            }
        }
        
        //case 1
      /*
        m[0][0]=0;
        m[0][1]=2;
        m[0][2]=0;
        
        m[1][2]=2;
        m[2][2]=0;
        m[2][1]=0;
        
        
        
        //m[2][2]=0;
        
        /*
        m[0][3]=0;
        m[0][4]=0;
        m[1][4]=2;
        m[2][4]=0;
        * */
        //case 2
        
        /*
        m[0][0]=0;
        m[0][1]=1;
        m[0][2]=0;
        m[1][0]=1;
        m[1][1]=0;
        m[1][2]=1; 
        */
        //case 3
     /*   
       m[0][0]=0;
        m[0][1]=2;
        m[0][2]=0;
        m[1][0]=0;
        m[1][1]=0;q  2w
        m[1][2]=1;
   
       */ 
       
        
        
        
        m[0][0]=0;
        m[0][1]=2;
        m[0][2]=0;
        m[1][0]=0;
        m[1][1]=0;
        m[1][2]=1;
        m[2][0]=1;
        m[2][1]=1;
        m[2][2]=1;
        
        
        
        int a = minMoves(m,0,2);
        System.out.println(a);
       // System.out.println("Hello");
    }
    
}
