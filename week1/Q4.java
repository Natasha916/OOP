package week1;

public class Q4 {
public static void main(String[] args) {
	double a = 4;
	double b = 6;
	double c = 8;
	double s = (a+b+c)/2 ;
	double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
	System.out.printf("The area of triangle is:",+ area);
}
}
