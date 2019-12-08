package stdDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Polygon;

import Ex1.Functions_GUI;
import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Range;
import Ex1.function;

public class Testas {

	public static void main(String[] args) {
		int resolution = 1000;
		Range rx = new Range(-5,5);
		Range ry = new Range(-5,5);
		int width = 1000;
		int height = 1000;
		
	Functions_GUI data = new Functions_GUI();
	function f = new Monom("x^2");
	data.add(f);
	function f1 = new Polynom("x^3-5+14x");
	data.add(f1); 
	function f2 = new Polynom("x-5+14x");
	data.add(f2);
	function f3 = new Polynom("-5+14x");
	data.add(f3);
	function f4 = new Polynom("x^7-5+14x");
	data.add(f4);
	data.drawFunctions(width, height, rx, ry, resolution);
	

	}

}
