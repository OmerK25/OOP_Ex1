package Ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.regex.Pattern;



public class Polynom implements Polynom_able{
	public ArrayList<Monom> monList = new ArrayList<Monom>();
	private Monom_Comperator c = new Monom_Comperator();

	public Polynom() {
		//the default constructor, return the zero polynom.
		monList.add(Monom.ZERO);
	}
	/**
	 * init a Polynom from a String such as:
	 *  {'x', '12x', '-17x^33', '-1+x^7-22x^6+3x^2', '7+7'}.
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {
		//this constructor gets a string in the argument, and switch him to a polynom, shaped like an array list.
		try {
			if(s.contains("^-")) {
				throw new Exception("degree cant be negative");
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		s = s.replaceAll("\\s+", ""); 
		//spliting the polynom to separate monoms.
		String tempCoff[] = s.split("(?=\\-)|(\\+)");
		Monom_Comperator c = new Monom_Comperator();
		for (int i = 0; i < tempCoff.length; i++) {
			Monom tempMon = new Monom(tempCoff[i]);		
			monList.add(tempMon);
			monList.sort(c);
		}
		for(int i=0; i< monList.size()-1; i++) {
			if (monList.get(i).get_power()==monList.get(i+1).get_power()) {
				monList.get(i+1).add(monList.get(i));
				monList.remove(i);
			}
		}
	}


	public String toString(){
		//printing the polynom as a string.
		String ans = "";
		Iterator <Monom> i = this.iteretor();
		while(i.hasNext()) {
			ans+=i.next().toString();
			if(i.hasNext()) ans += "+";
		}
		ans = ans.replaceAll("\\s", "");
		ans = ans.replaceAll(Pattern.quote("++"),"+");
		ans = ans.replaceAll(Pattern.quote("++-"),"-");
		ans = ans.replaceAll(Pattern.quote("+-"),"-");
		ans = ans.replaceAll(Pattern.quote("--"),"+");

		return ans;
	}
	@Override
	public double f(double x) {
		//returns the value of the f(x) in the 'x' point.
		Iterator <Monom> i = this.iteretor();
		double ans = 0;
		while(i.hasNext()) {
			ans += i.next().f(x);
		}
		return ans;
	}

	@Override
	public void add(Polynom_able p1) {
		//summing two polynoms.
		Iterator <Monom> i = p1.iteretor();
		while (i.hasNext()) {
			this.add(i.next());
		}
	}


	@Override
	public void add(Monom m1) {
		//add a monom to a polynom.

		for(int i=0 ; i < this.monList.size();i++) {
			if(monList.get(i).get_power() == m1.get_power()) {
				Monom m2=new Monom(this.monList.get(i));
				m2.add(m1);
				this.monList.set(i,m2);
				return;
			}

		}

		monList.add(m1);
		monList.sort(c);
		return;

	}



	@Override
	public void substract(Polynom_able p1) {
		//sub a polynom from another polynom.
		Polynom_able c = (Polynom_able) p1.copy();
		c.multiply(Monom.MINUS1);
		this.add(c);
	}
	/**
	 * this method Multiple 2 polynoms with each other.
	 * @param p1 is the polynom that we want to multiple with our polynom.
	 */

	@Override
	public void multiply(Polynom_able p1) {
		Iterator <Monom> it = p1.iteretor();
		ArrayList<Monom> monTemp = new ArrayList<Monom>();
		while (it.hasNext()) {
			Monom temp = it.next();
			for (int i =0 ; i< monList.size() ; i++) {
				Monom monom_temp = new Monom (monList.get(i));
				monom_temp.multipy(temp);
				monTemp.add(monom_temp);
			}
		}
		Polynom p = new Polynom();
		for (int i =0 ; i < monTemp.size() ; i++) {
			p.add(monTemp.get(i));
		}
		this.monList = p.monList;
		for ( int i = 1 ; i< monList.size() ; i++) {
			if ( monList.get(i).equals(Monom.ZERO)) {
				monList.remove(monList.get(i));
				i--;
			}
		}
	}
	
	@Override
	public void multiply(Monom m1) {
		//multiple a polynom with a singke monom.
		Iterator <Monom> i = this.iteretor(); 
		while(i.hasNext()) {
			i.next().multipy(m1);
		}
	}

	@Override
	//checks if 2 polynoms are equal by switching them to strings and using String.equal method.
	public boolean equals(Object p1) {
	Polynom p =  (Polynom) this.copy();
	Polynom p2 = (Polynom) p1;
	p.substract(p2);
	if (p.isZero() || Math.abs(p.f(10))<0.001) {
		return true;
	}
	
		return false;
	}


	@Override
	public boolean isZero() {
		//return true if the argument is the zero polynom.
		Iterator <Monom> i = this.iteretor();
		while(i.hasNext()) {
			if(i.next().get_coefficient()!=0.0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		//this method finds the root of the polynom between two points.
		try {
			if (f(x0)*f(x1)>0) {
				throw new Exception("for using the root function, you need two ponits on diffrent side of the x line");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		double mean = 0;
		while (Math.abs(f(x1)-f(x0))>eps) {
			mean = (x0+x1)/2;
			if (f(mean)*f(x1)>0) {
				x1 = mean;
			}
			else {
				x0 = mean;
			}
		}
		return mean;
	}


	@Override
	public Polynom_able copy() {
		//creats a new polynom with same values.
		Polynom temp=new Polynom(this.toString());
		return temp;
	}

	@Override
	public Polynom_able derivative() {
		//this function returns a new polynom thats contain the derivative of the argument polynom.
		Iterator <Monom> i = this.iteretor();
		Polynom d= new Polynom();
		d.monList.clear();
		while(i.hasNext()) {

			d.monList.add(i.next().derivative());
			d.monList.sort(c);
		}
		return d;
	}

	@Override
	//this method calculate the area between the polynom and the x line, without the negative parts.
	public double area(double x0, double x1, double eps) {

		double sum = 0.0;

		for (double i = x0; i < x1; i=i+eps) {
			if (this.f(x0)>=0) {
				sum = sum + eps*this.f(i);
			}
		}
		return sum;
	}


	@Override
	public Iterator<Monom> iteretor() {
		return monList.iterator();
	}

	@Override
	public function initFromString(String s) {
		function p1 = new Polynom(s);
		return p1;
	}
}

