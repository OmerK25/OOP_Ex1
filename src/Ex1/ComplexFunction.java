package Ex1;

/**
 * this class
 * private node
 * @Autor Omer Katz, Rafaat Marzuq.
 */
public class ComplexFunction implements complex_function {
	private node head;


	//***********constructors**************

	public ComplexFunction(Operation op,function p1, function p2) {
		head.operator = op;
		head.left.f = p1;
		head.right.f = p2;
	}
	
	public ComplexFunction(function p1) {
		head.f = p1;
		head.operator = null;
		
	}

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
		ComplexFunction cf = new ComplexFunction(f1);
		node temp = this.head;
		this.head = new node(Operation.Plus);
		head.left = temp;
		head.right.f = f1;
		
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		return null;
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
