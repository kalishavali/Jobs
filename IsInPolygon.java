package Hackerrank;

public class Point {
	int X;
	int Y;
	Point(int x,int y){
		this.X=x;
		this.Y=y;
	}
	public static boolean IsPointInPolygon( String[] points ,String[] check)
	{
			String[] targetTemp=check[0].split("\\s+");
	        int targetX=Integer.parseInt(targetTemp[0]);
	        int targetY=Integer.parseInt(targetTemp[1]);
	        
	        String[] poTemp=check[0].split("\\s+");
	        int poX=Integer.parseInt(poTemp[0]);
	        int poY=Integer.parseInt(poTemp[1]);
	        
			double minX = poX;
		    double maxX = poX;
		    double minY = poY;
		    double maxY = poY;
		    for ( int i = 1 ; i < points.length ; i++ )
		    {
		        String[] temp=points[ i ].split("\\s+");
		        int X=Integer.parseInt(temp[0]);
		        int Y=Integer.parseInt(temp[1]);
		        minX = Math.min( X, minX );
		        maxX = Math.max( X, maxX );
		        minY = Math.min( Y, minY );
		        maxY = Math.max( Y, maxY );
		    }

		    if ( targetX< minX || targetX > maxX || targetY < minY || targetY > maxY )
		    {
		        return false;
		    }

		    boolean inside = false;
		    int j = points.length - 1;
	        for (int i = 0; i < points.length; i++) {
	        	
	        	String[] ipTemp=points[i].split("\\s+");
		        int ipX=Integer.parseInt(ipTemp[0]);
		        int ipY=Integer.parseInt(ipTemp[1]);
		        
		        String[] jpTemp=points[j].split("\\s+");
		        int jpX=Integer.parseInt(jpTemp[0]);
		        int jpY=Integer.parseInt(jpTemp[1]);
		        
	            if (ipY < targetY && jpY >= targetY || jpY < targetY && ipY >= targetY) {
	                if (ipX + (targetY - ipY) /( jpY - ipY) * (jpX - ipX) < targetX) {
	                    inside = !inside;
	                }
	            }
	            j = i;
	        }
		    return inside;
		
	    
	}
	public static void main(String[] args) {
		boolean res=IsPointInPolygon(new String[]{"0 0","2 2","0 2"},new String[]{"1 1"});
		System.out.println(res);
	}
}
