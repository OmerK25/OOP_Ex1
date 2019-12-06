package stdDraw;

import java.awt.Color;
import java.awt.Font;

import Ex1.Range;

public class Testas {

	public static void main(String[] args) {
		int resolution = 600;
		Range rx = new Range(50,-50);
		Range ry = new Range(50,-50);
		int width = 500;
		int height = 500;
		
		double[] x = new double[resolution+1];
		double[] y = new double[resolution+1];
		
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
		StdDraw.setCanvasSize(width,height);
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		////////vertical lines
		for (int i = 0; i <= 100; i=i+10) {
			StdDraw.line(x[i], ry.get_min(), x[i], ry.get_max());
		}
		//////// horizontal  lines
		for (double i = ry.get_min(); i <= ry.get_max(); i=i+0.5) {
			StdDraw.line(0, i, rx.get_max(), i);
		}
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(0, y[resolution/2], Math.PI, y[resolution/2]);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		for (int i = 0; i <= resolution; i=i+10) {
			StdDraw.text(x[i]-0.07, -0.07, Integer.toString(i-resolution/2));
		}
		//////// y axis	
		StdDraw.line(x[resolution/2], ry.get_min(), x[resolution/2], ry.get_max());
		for (double i = ry.get_min(); i <= ry.get_max(); i=i+0.5) {
			StdDraw.text(x[resolution/2]-0.07, i+0.07, Double.toString(i));
		}

	}

}
