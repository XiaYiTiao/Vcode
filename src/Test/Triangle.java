package Test;
import java.awt.geom.Point2D.Double;
import java.util.Scanner;
import java.lang.Math;

public class Triangle extends Double {
	double d, s;

	Triangle(double a, double b, double c) {
		if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
			d = (a + b + c) / 2;
			s = d * (d - a) * (d - b) * (d - c);
			s = Math.sqrt(s);
			System.out.println("���������Ϊ��" + s);
		} else
			System.out.println("����������߳�������������");

	}

	public static void main(String args[]) {
		System.out.println("�����������ε����߳�");
		double a, b, c;
		Scanner input = new Scanner(System.in);
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		new Triangle(a, b, c);

	}

}
