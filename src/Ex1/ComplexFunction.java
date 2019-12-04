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
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void plus(function f1) {
		this.left = this;
		this.right = f1;
		op = Operation.Plus;
	}

	@Override
	public void mul(function f1) {
		node temp = this.head;
		this.head = new node(Operation.Times);
		head.left = temp;
		head.right = new node(f1);

	}

	@Override
	public void div(function f1) {
		node temp = this.head;
		this.head = new node(Operation.Divid);
		head.left = temp;
		head.right = new node(f1);

	}

	@Override
	public void max(function f1) {
		node temp = this.head;
		this.head = new node(Operation.Max);
		head.left = temp;
		head.right = new node(f1);

	}

	@Override
	public void min(function f1) {
		node temp = this.head;
		this.head = new node(Operation.Min);
		head.left = temp;
		head.right = new node(f1);

	}

	@Override
	public void comp(function f1) {
		node temp = this.head;
		this.head = new node(Operation.Comp);
		head.left = temp;
		head.right = new node(f1);

	}

	@Override
	public function left() {
		if(this.head == null) {
			System.out.println("there is no left side");
			return null;
		}

		else
			if(this.head.left==null) {
				return this.head.f;
			}

			else
				return this.head.left.f;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return null;
	}

}
