package Ex1;

/**
 * this class
 * private node
 * @Autor Omer Katz, Raafat Marzuq.
 */
public class ComplexFunction implements complex_function {
	private function left, right;
	private Operation op;


	//***********constructors**********
	/**
	 * the regular constructor, gets an operation, left function and right function.
	 * @param op
	 * @param p1
	 * @param p2
	 */


	/**
	 * @param op is a string that represents operator.
	 */
	public ComplexFunction(String op,function p1, function p2) {
		this.op=stringToOperator(op);
		left = p1;
		right = p2;
	}
	//this constructor gets only one function, and sets it to be the root node.
	public ComplexFunction(function p1) {
		left = p1;
		op = null;
	}

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


	//***********functions*************

	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void plus(function f1) {
		this.left = this.copy();
		this.right = f1;
		op = Operation.Plus;
	}

	@Override
	public void mul(function f1) {
	

	}

	@Override
	public void div(function f1) {
	

	}

	@Override
	public void max(function f1) {


	}

	@Override
	public void min(function f1) {


	}

	@Override
	public void comp(function f1) {
		//comp means f(g(x)).

	}
	public String toString() {
		/**
		 * should be recursive, if polynom or monom just print, if complex function use the recursive with this cf.
		 */
		return null;
		
	}
	
	@Override
	public function initFromString(String s) {
		/**
		 * also recursive, every time it see a cf, call the function with this cf.
		 */
		return null;
	}

	@Override
	public function left() {
		return left;
		}


	@Override
	public function right() {
		
		return right;
	}

	@Override
	public Operation getOp() {
		return op;
	
	}

}
