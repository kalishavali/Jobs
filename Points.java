package HakerRank;

public class Point {
	double x;
	double y;
	double z;
	Point(double xCoord, double yCoord){
	        this.x = xCoord;
	        this.y = yCoord;
	}
	Point(double xCoord, double yCoord, double zCoord){
        this.x=xCoord;
        this.y=yCoord;
        this.z = zCoord;
    }
	public static int distance3D(Point p1, Point p2){
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        double dz = p1.z - p2.z;
        return (int)(Math.ceil(Math.sqrt(dx * dx + dy * dy + dz *dz)));
    }
	public static int distance2D(Point a, Point b)
    {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return (int)(Math.ceil(Math.sqrt(dx * dx + dy * dy)));
    }
	public static void main(String[] args) {
        Point p1 = new Point(60,40,20);
        Point p2 = new Point(70,30,40);
        System.out.println("Distance between them is " + Point.distance3D(p1, p2));
    }
}
