import java.util.Scanner;

/**
 * Prints information about specified points using the scanner class
 * @author andrei.tumbar
 *
 */
public class CoordGeom
{
	public static void main(String[] args)
	{
		GeomPoint[] AB = getPoints();
		System.out.printf("Slope of AB: %s\n", GeomPoint.getSlope(AB[0], AB[1]));
		System.out.printf("Length of AB: %s\n", GeomPoint.getDistance(AB[0], AB[1]));
		System.out.printf("Midpoint of AB: %s\n", GeomPoint.getMidpoint(AB[0], AB[1]));
		System.out.printf("Min X of AB: %s\n", GeomPoint.getMinX(AB[0], AB[1]));
	}
	
	/**
	 * Read from stdin and returns an array of points a and b
	 * @return An array of points a and b
	 */
	public static GeomPoint[] getPoints()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Point A");
		double aX;
		double aY;
		
		System.out.print("X coordinate: ");
		aX = sc.nextDouble();
		System.out.print("Y coordinate: ");
		aY = sc.nextDouble();
		
		System.out.println("Point B");
		double bX;
		double bY;

		System.out.print("X coordinate: ");
		bX = sc.nextDouble();
		System.out.print("Y coordinate: ");
		bY = sc.nextDouble();

		sc.close();
		
		GeomPoint pointA = new GeomPoint(aX, aY);
		GeomPoint pointB = new GeomPoint(bX, bY);
		
		GeomPoint[] out = new GeomPoint[2];
		out[0] = pointA;
		out[1] = pointB;
		
		return out;
	}
}

/**
 * Point on a 2d plane, able to perform various calculations between multiple points
 * @author andrei.tumbar
 *
 */
class GeomPoint
{
	/*
	 * Public to allow read access without need to call a method
	 */
	public double x;
	public double y;
	
	/**
	 * Constructor for GeomPoint
	 * @param x The X value of the point
	 * @param y The Y value of the point
	 */
	public GeomPoint(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns a formated string of GeomPoint
	 * @return A formated string of GeomPoint
	 */
	public String toString()
	{
		return String.format("(%s, %s)", this.x, this.y);
	}

	/**
	 * Returns the slope between points a and b as a string
	 * @param a The first point to be evaluated
	 * @param b The second point to be evaluated
	 * @return The slope between points a and b as a string
	 */
	public static String getSlope(GeomPoint a, GeomPoint b)
	{
		if (b.x - a.x == 0)
		{
			return "undefined";
		}
		/* Cast to double to get a more accurate answer */
		return "" + ((b.y - a.y) / (double)(b.x - a.x));
	}
	
	/**
	 * Returns the distance between points a and b as a double
	 * @param a The first point to be evaluated
	 * @param b The second point to be evaluated
	 * @return The distance between points a and b as a double
	 */
	public static double getDistance(GeomPoint a, GeomPoint b)
	{
		/*
		 * Distance formula
		 * sqrt ((x2 - x1)^2 + (y2 - y1)^2)
		 */
		return Math.sqrt(Math.pow((double)(b.x - a.x), (double)2) 
					   + Math.pow((double)(b.y - a.y), (double)2));
	}
	
	/**
	 * Returns the midpoint between points a and b as a GeomPoint
	 * @param a The first point to be evaluated
	 * @param b The second point to be evaluated
	 * @return The midpoint between points a and b as a GeomPoint
	 */
	public static GeomPoint getMidpoint(GeomPoint a, GeomPoint b)
	{
		/*
		 * Midpoint formula
		 * (x1 + x2) / 2, (y1 + y2) / 2
		 */
		double mid_x = (a.x + b.x) / 2;
		double mid_y = (a.y + b.y) / 2;
		
		return new GeomPoint(mid_x, mid_y);
	}
	
	/**
	 * Returns the minimum x coordinate of points a and b
	 * @param a The first point to be evaluated
	 * @param b The second point to be evaluated
	 * @return The minimum x coordinate of points a and b
	 */
	public static double getMinX(GeomPoint a, GeomPoint b)
	{
		return Math.min(a.x, b.x);
	}
}
