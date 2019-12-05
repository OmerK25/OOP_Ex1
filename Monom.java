
package Ex1;

import java.beans.Expression;
import java.io.IOException;
import java.util.Comparator;

import javax.imageio.IIOException;


public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		
			if(this.get_power()==0) {return new Monom(ZERO);}
			return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
		}
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}


	public Monom(String s) {
		//remove spaces, replace upper letter
		s = s.replaceAll("\\s+", "");
		s= s.replaceAll("X", "x");
		//see if the input is ok
		boolean valid = isValid(s);
		if(valid) {
			this.set_coefficient(checkCoff(s));
			this.set_power(checkPower(s));
		}	
	}	
	public Double checkTheFirst(String s) {
		//checking if the first letter is +,- or x
		Double ans= 0.0;
		if (s.charAt(0)=='-' ){
			ans = -1.0;
		}
		else
			if (s.charAt(0)=='+') {
				ans=1.0;	
			}
			else
				if (s.charAt(0)=='x') {
					ans=1.0;
				}

		return ans;
	}
	public int checkPower (String s) {
		int ans = 0;
		//if there is power sign, get power
		if (s.contains("^")) {
			ans=Integer.parseInt(s.substring(s.indexOf('^')+1));
		}
		//not, power is 1
		else
			if (s.charAt(s.length()-1)=='x') {
				ans = 1;
			}
		//not , power is 0
		return ans;
	}
	public Double checkCoff(String s){
		//get the first char of the string
		boolean first = Character.isDigit(s.charAt(0));
		Double ans = 0.0;
		if(!first) {
			Double a = checkTheFirst(s); 

			if (s.contains("x")) {
				//first char mult the rest
				if (s.charAt(0)!='x' && s.charAt(1)!='x') {
					ans = a*Double.parseDouble(s.substring(1,s.indexOf('x')));		
				}
				else 
					if(s.charAt(0)=='x') {
						ans = 1.0;
					}
					else {
						ans = -1.0;
					}
				return ans; 
			}
			else
				ans = a*Double.parseDouble(s.substring(1));
		}
		else 
			//checking if there is an x or not, if not- the string equals the coff
			if(s.contains("x")) {
				ans = Double.parseDouble((String) s.subSequence(0, s.indexOf('x')));
			}
			else
			{
				ans = Double.parseDouble(s);
			}
		return ans;
	}
	public boolean isValid(String s)  {
		//this function will check if the monom input is valid,
		//for example, monom that starts with '(' or ending with ')' will throw an error.
		try {
			char c = s.charAt(0);
			char end = s.charAt(s.length()-1);

			boolean first = Character.isDigit(c);
			boolean last = Character.isDigit(end);
			if(!first && c!='-' && c!='+' && c!= 'x') {
				throw new IOException("wront input, monom can only start with digit,+,- or x");
			}
			if (!last && end!= 'x') {
				throw new IOException("last char of the mon must be digit or x");
			}
			if (s.contains("/") || s.contains(":") || s.contains("!")) {
				throw new IOException("this is beta version, cand deal with complicated operators, sorry");
			}	
		}
		catch (IOException e) {
			//exp of input 
			e.printStackTrace();
		}
		catch (Exception e) {
			//other exp
			e.printStackTrace();
		}
		return true;
	}

	public void add (Monom m) {

		if (this.isZero()) {
			this._coefficient =+ m._coefficient;
			this._power =+ m._power; 
		}
		else if (this._power == m._power) {
			this._coefficient += m._coefficient;
		}
		else{
			System.out.println("Unable to add two Monoms if their power are different");
		}
	}


	public void multipy(Monom d) {
		//using the multiple operator on two monoms.
		this.set_coefficient(this.get_coefficient()*d.get_coefficient());
		this.set_power(this.get_power()+d.get_power());
	}
	public String toString() {
		//printing the monom on the screen as a string.
		String ans = "";
		if(this.isZero()) {
			return ans;
		}
		else
		{
			if (this.get_power()!=0) {
				ans = get_coefficient() + "x^" + get_power() ;
			}
			else
				ans = get_coefficient()+"";
		}
		return ans;
	}
	// you may (always) add other methods.


	//****************** Private Methods and Data *****************


	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {
		return new Monom(ZERO);
		
	}
	private double _coefficient; 
	private int _power;
	@Override
	public function initFromString(String s) {
		function f = new Monom(s);
		return f;
	}
	@Override
	public function copy() {
		function f = new Monom(this.toString());
		return f;
	}


}
