package compiler;

import compiler.AST.*;
import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

public class PrintASTVisitor extends BaseASTVisitor<Void> {

	PrintASTVisitor() { super(true); }
	public Void visitNode(ProgNode n) {
		printNode(n);
		//System.out.println(indent + "Prog");
		// TODO(RV) Rtti non esiste in java
		visit(n.exp);
		return null;
	}

	public Void visitNode(PlusNode n) {
		printNode(n);
		//System.out.println(indent + "Plus");
		visit(n.left);
		visit(n.right);
		return null;
	}

	public Void visitNode(TimesNode n) {
		printNode(n);
		//System.out.println(indent + "Times");
		visit(n.left);
		visit(n.right);
		return null;
	}

	public Void visitNode(IntNode n) {
		printNode(n, n.val.toString());
		//System.out.println(indent + "Int: " + n.val);  // must also print value!
		return null;
	}
}






//	public void visit(Node n) { n.accept(this); } //performs the "n"-specific visit

//	String indent;
//
//	@Override
//	public void visit(Node n) {
//		String temp=indent;
//		indent=(indent==null)?"":indent+"  ";
//		n.accept(this);
//		indent=temp;
//	}

// DONE up

//	void printNode(Node n) {
//		System.out.println(indent+extractNodeName(n.getClass().getName()));
//	}
//
//	void printNode(Node n, String s) {
//		System.out.println(indent+extractNodeName(n.getClass().getName())+": "+s);
//	}
//
//	String extractNodeName(String s) { // s is in the form compiler.AST$NameNode
//		return s.substring(s.lastIndexOf('$')+1,s.length()-4);
//	}

//	PrintASTVisitor() { super(true); }


