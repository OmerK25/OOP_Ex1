package Ex1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI implements functions{
private ArrayList<function> function_List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		
	}

}
