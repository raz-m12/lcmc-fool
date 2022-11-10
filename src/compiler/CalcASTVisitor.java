package compiler;

import compiler.AST.*;
import compiler.lib.*;

public class CalcASTVisitor extends BaseASTVisitor<Integer> {
	CalcASTVisitor() {}
	CalcASTVisitor(boolean debug) { super(debug); } // enables print for debugging

	@Override
	public Integer visitNode(ProgNode n) {
	   if (print) printNode(n);
	   return visit(n.exp);
	}

	@Override
	public Integer visitNode(PlusNode n) {
		if (print) printNode(n);
	    return visit(n.left) + visit(n.right);
	}

	@Override
	public Integer visitNode(TimesNode n) {
		if (print) printNode(n);
		return visit(n.left) * visit(n.right);
	}

	@Override
	public Integer visitNode(IntNode n) {
		if (print) printNode(n,": "+n.val);
        return n.val;
	}

	@Override
	public Integer visitNode(EqualNode n) {
		if (print) printNode(n);
		return visit(n.left) == visit(n.right)? 1: 0;
	}

	@Override
	public Integer visitNode(BooleanNode n) {
		if (print) printNode(n, ": "+n.value);
		return n.value == true ? 1: 0;
	}

	@Override
	public Integer visitNode(IfNode n) {
		if (print) printNode(n);
		var ifthen = visit(n.condition);
		return ifthen == 1 ? visit(n.thenExp): visit(n.elseExp);
	}

	@Override
	public Integer visitNode(PrintNode n) {
		if (print) printNode(n);
		return visit(n.exp);
	}
}

//    CalcASTVisitor() {}
//    CalcASTVisitor(boolean debug) { super(debug); } // enables print for debugging

