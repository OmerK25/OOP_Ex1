package Ex1;

class node { 

	function f; 
	Operation operator;
	node left, right; 

	//*********constructors***********

	node(function fun) { 
		f = fun; 
		left = right = null; 
		operator = null;
	}
	node(Operation op) { 
		operator = op; 
		left = right = null; 
		f = null; 
	}
	node(Operation op,function fun, node l, node r) { 
		operator = op; 
		left = l;
		right = r;
		f = fun;
	}
}
