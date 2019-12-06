package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import stdDraw.StdDraw;

public class Functions_GUI implements functions{
	private ArrayList<function> function_List;
	

	public static Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, 
			Color.red, Color.GREEN, Color.PINK};

	@Override
	public int size() {
		return function_List.size();
	}

	@Override
	public boolean isEmpty() {
		return function_List.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return function_List.contains(o);
	}

	@Override
	public Iterator<function> iterator() {
		return function_List.iterator();
	}

	@Override
	public Object[] toArray() {
		return function_List.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return function_List.toArray(a);
	}

	@Override
	public boolean add(function e) {
		return function_List.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return function_List.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return function_List.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		return function_List.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return function_List.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return function_List.retainAll(c);
	}

	@Override
	public void clear() {
		function_List.clear();

	}

	@Override
	public void initFromFile(String file) throws IOException {


	}

	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		double[] x = new double[resolution+1];
		double[] y = new double[resolution+1];
		
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
		StdDraw.setCanvasSize(width,height);
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		////////vertical lines
		for (int i = 0; i <= resolution; i=i+10) {
			StdDraw.line(x[i], ry.get_min(), x[i], ry.get_max());
		}
		//////// horizontal  lines
		for (double i = ry.get_min(); i <= ry.get_max(); i=i+0.5) {
			StdDraw.line(0, i, Math.PI, i);
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

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
