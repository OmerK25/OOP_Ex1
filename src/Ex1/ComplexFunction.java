package Ex1;

/**
 * this class
 * private node
 * @Autor Omer Katz, Rafaat Marzuq.
 */
public class ComplexFunction implements complex_function {
	private function left,right;
	private Operation op;

	//***********constructors**************

	public ComplexFunction(String op,function p1, function p2) {
		setOp(stringToOperator(op));
		setLeft(p1);
		setRight(p2);
	}

	public ComplexFunction(function p1) {

		this.setLeft(p1);
		this.setRight(null);
		this.setOp(Operation.None);

	}
	
	public ComplexFunction(Operation op, function p1 , function p2) {
		setLeft(p1);
		setRight(p2);
		this.setOp(op);
	}




	//  *************************************************************************************
/**
 * 
 * @param s, a string that represent an operator
 * This method takes a string and convert him to operator like mul, div, plus.
 */
	
	//this method convert the string to operator
	public static Operation stringToOperator(String s) {
		Operation o = null;
		s = s.toLowerCase();
		try{
			switch(s){

			case "plus":
				o = Operation.Plus;
				break;

			case "mul":
				o = Operation.Times;
				break;
			case "times":
				o = Operation.Times;
				break;

			case "div":
				o = Operation.Divid;
				break;
			case "divid":
				o = Operation.Divid;
				break;

			case "max":
				o = Operation.Max;
				break;

			case "min":
				o = Operation.Min;
				break;

			case "comp":
				o = Operation.Comp;
				break;

			case "none":
				o = Operation.None;
				break;
			}
			if(o == null) {
				throw new Exception("the String is not a valid operator");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	/**
	 * This method checks if 2 functions are equal.
	 *  it calculate the value of 40 points and if they are all equal it return true.
	 */
	@Override
	
	public boolean equals(Object ob) {
		if(!(ob instanceof ComplexFunction)) {
			return false;
		}
		ComplexFunction cf = new ComplexFunction((function) ob);

		for (int i=-20;i<=20;i++) {
			if (this.f(i)!=cf.f(i)) {
				return false;
			}
		}
		return true;
	}
/**
 * This method calculate the value of the function in a given x point.
 */
	@Override
	public double f(double x) {
		
		double f=0;
		Operation O= getOp();
		switch (O) {
		
		case Plus:
			f=left().f(x) + right().f(x);

			break;
		case Times:
			f=left().f(x)* right().f(x);

			break;
		case Divid:
			f=(left().f(x)/right().f(x));
			break;

		case None:
			if(left() == null) {
				f= right().f(x);
			}
			if(right() == null) {
				f=left().f(x);
			}
			break;

		case Max:
			if(left().f(x) > right.f(x)) {
				f=left().f(x);
			
			}
			f= right().f(x);
			break;

		case Min:
			if(left().f(x) > right.f(x)) {
				f=right().f(x);
			
			}
			f= left().f(x);
			break;
		case Comp:
			if(right() == null) {
				f=left().f(x);
			}
			break;
		default:
			break;
		}

		return f;
	}
/**
 * @param s, is a string thats represent a function, 
 * and this method initializes a functions from it.
 */
	@Override
	public function initFromString(String s) {
	
		int i=0;
		String n=trimAll(s);
		if(!n.contains(")") && !n.contains("(")) {
			Polynom p1= new Polynom(s);
			function f=new ComplexFunction(p1);
			return f;
		}
		else {

			while (s.charAt(i) != '(') {
				i++;
			}

			int m=findMed(s , i+1);
			String s1=n.substring(i+1, m);
			String s2=n.substring(m+1,s.length()-1);
			String s3 = n.substring(0, i);
			function left = initFromString(s1);
			function right = initFromString(s2);
			function function= new ComplexFunction(s3, left, right);
			return function;
		}
	}
	//this method finds the meddle of a given function (finds the apostrophe)
	public int findMed(String str ,int j) {

		int c=0, p=1, S=0;
		for (; j < str.length(); j++) {

			if(str.charAt(j)==',') {
				c++;
			}
			if(str.charAt(j)=='(') {
				p++;
			}
			if( str.charAt(j) == ',' && (c == p)) {

				return j;
			}

		}		
		return S;

	}
	//this method returns the strings without spaces
	public String trimAll(String s) {
		String d="";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ' '){
				d=d+s.charAt(i);
			}

		}
		return d;
	}
/**
 * This method creates a copied function from the original one.
 */
	@Override
	public function copy() {
		function f= new ComplexFunction(this.op.toString(), left(), right());
		return f;
	}
/**
 * ***********************Operators functions**************************
 * Those method get an operator as an argument,
 *  and returns a new complex function with the added function and the operator it gets.
 */
	@Override
	public void plus(function f1) {
		if(this.right == null) {
			setRight(f1);
			setOp(Operation.Plus);
		}
		function f= new ComplexFunction(getOp().toString(),left(), right());

		setLeft(f);
		setRight(f1);
		setOp(Operation.Plus);

	}

	@Override
	public void mul(function f1) {

		if(this.right == null) {
			setRight(f1);
			setOp(Operation.Times);

		}
		function f= new ComplexFunction(getOp().toString(),left(), right());

		setLeft(f);
		setRight(f1);
		setOp(Operation.Times);

	}

	@Override
	public void div(function f1) {

		if(this.right == null) {
			setRight(f1);
			setOp(Operation.Divid);
		}
		function f= new ComplexFunction(getOp().toString(),left(), right());

		setLeft(f);
		setRight(f1);
		setOp(Operation.Divid);

	}

	@Override
	public void max(function f1) {

		if(this.right == null) {
			setRight(f1);
			setOp(Operation.Max);
		}
		function f= new ComplexFunction(getOp().toString(),left(), right());

		setLeft(f);
		setRight(f1);
		setOp(Operation.Max);

	}

	@Override
	public void min(function f1) {

		if(this.right == null) {
			setRight(f1);
			setOp(Operation.Min);
		}
		function f= new ComplexFunction(getOp().toString(),left(), right());

		setLeft(f);
		setRight(f1);
		setOp(Operation.Min);

	}

	@Override
	public void comp(function f1) {

		if(this.right == null) {
			setRight(f1);
			setOp(Operation.Comp);
		}
		function f= new ComplexFunction(getOp().toString(),left(), right());

		setLeft(f);
		setRight(f1);
		setOp(Operation.Comp);
	}
//**************************************************************
	
	// ***************** Getters ******************
	@Override
	public function left() {

		return this.left;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return this.right;
	}

	@Override
	public Operation getOp() {

		return this.op;
	}
	//***************************************
	
	@Override //this method returns a string of the Comlex function
	public String toString() {
		
		if(right() == null) {
			return   left().toString() 	;
		}
		Operation O= getOp();
		switch (O) {

		case Plus:
			return  "Plus(" + left() + "," + right() + ")";

		case Times:
			return  "mul(" + left() + "," + right() + ")";

		case Divid:
			return "div(" + left() + "," + right() + ")";
		case None:
			if(right() == null) {
				return  "(" + left() + ")";
			}
			break;
		case Max:
			return  "Max(" + left() + "," + right() + ")";	
		case  Min:
			return  "Min(" + left() + "," + right() + ")";
		case Comp:
			return  "Comp(" + left() + "," + right() + ")";
		default:
			break;
		}
		return  getOp() +"(" + left() + "," + right() + ")";
	}
	//////////////////////*******Setters*******\\\\\\\\\\\\\\\\\\\\\\\
	
	
	public void setOp(Operation op) {
		this.op = op;
	}
	public void setLeft(function left) {
		this.left = left;
	}
	public void setRight(function right) {
		this.right = right;
	}

}
