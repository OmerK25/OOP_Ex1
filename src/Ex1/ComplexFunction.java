package Ex1;

/**
 * this class
 * private node
 * @Autor Omer Katz, Rafaat Marzuq.
 */
public class ComplexFunction implements complex_function {
	private node head;


	//***********constructors**********
	/**
	 * the regular constructor, gets an operation, left function and right function.
	 * @param op
	 * @param p1
	 * @param p2
	 */
	public ComplexFunction(Operation op,function p1, function p2) {
		head.operator = op;
		head.left.f = p1;
		head.right.f = p2;
	}

	/**
	 * @param op is a string that represents operator.
	 */
	public ComplexFunction(String op,function p1, function p2) {
		if(stringIsOperator(op)){
			//	head.operator = fromStringToOperator(op);	
		}

		head.left.f = p1;
		head.right.f = p2;
	}
	//this constructor gets only one function, and sets it to be the root node.
	public ComplexFunction(function p1) {
		head.f = p1;
		head.operator = null;

	}

	public boolean stringIsOperator(String s) {
		boolean isOperator = false;
		s.toLowerCase();
		switch(s){
		case "plus":
			isOperator = true;
			break;

		case "times":
			isOperator = true;
			break;

		case "divid":
			isOperator = true;
			break;

		case "max":
			isOperator = true;
			break;

		case "min":
			isOperator = true;
			break;

		case "comp":
			isOperator = true;
			break;

		case "none":
			isOperator = true;
			break;

		}
		return isOperator;
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
		node temp = this.head;
		this.head = new node(Operation.Plus);
		head.left = temp;
		head.right = new node(f1);
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
