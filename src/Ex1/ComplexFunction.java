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
	
	
	
	
//  *************************************************************************************
	
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

			case "div":
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



	

	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double f=0;
		Operation O= getOp();
		switch (O) {

		case Plus:
			f=this.left().f(x) + this.right().f(x);

			break;
		case Times:
			f=this.left().f(x)* this.right().f(x);

			break;
		case Divid:
			f=(this.left().f(x)/this.right().f(x));

		case None:
			if(left() == null) {
				f= this.right().f(x);
			}
			if(right() == null) {
				f=this.left().f(x);
			}
			break;
		default:
			break;
		}

		return f;
	}

	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		String n=trimAll(s);
		if(!n.contains(")") && !n.contains("(")) {
			Polynom p1= new Polynom(s);
			function f=new ComplexFunction(p1);
			return f;
		}
		String[] f=findFun(n);
		function p1 = initFromString(f[0].toString());
		function p2 = initFromString(f[1].toString());
		
		return new ComplexFunction(f[2], p1, p2);
	}
	public int findMed(String str ,int j) {
		
		while (str.charAt(j) != '(') {
			j++;
		}
		int c=0;
		int p=1;
		int S=0;
		for (; j < str.length(); j++) {
		
			if(str.charAt(j)==',') {
				c++;
			}
			if(str.charAt(j)=='(') {
				p++;
			}
			if( str.charAt(j) == ',' && (c == p)) {
				S=j;
				return S;
			}
			
		}		
		return S;
		
	}
	public String[] findFun(String s) {
		String[] f = new String[3];
		int i=0;
		while (s.charAt(i) != '(') {
			i++;
		}
		int m=findMed(s, i+1);
		f[0]=s.substring(i+1, m);
		
		f[1]=s.substring(m+1, s.length()-1);
		function right = initFromString(f[1].toString());
		f[2] = s.substring(0, i);
	
		
		return f;
		
	}
	public String trimAll(String s) {
		String d="";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ')'){
				d=d+s.charAt(i);
			}
			
		}
		return d;
	}
	
	@Override
	public function copy() {
		// TODO Auto-generated method stub
		function f= new ComplexFunction(this.op.toString(), left(), right());
		return f;
	}

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		if(this.right == null) {
			setRight(f1);
			setOp(Operation.Comp);
		}
		function f= new ComplexFunction(getOp().toString(),left(), right());
		
		setLeft(f);
		setRight(f1);
		setOp(Operation.Comp);

	}
// ***************** Getters ******************
	@Override
	public function left() {
		// TODO Auto-generated method stub
		return this.left;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return this.right;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return this.op;
	}
@Override
	public String toString() {
		return  getOp() +"(" + left() + "," + right() + ")"
				 ;
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
