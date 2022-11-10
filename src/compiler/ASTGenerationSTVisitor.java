package compiler;

import compiler.lib.Node;
import org.antlr.v4.runtime.tree.*;
import compiler.FOOLParser.*;
import compiler.AST.*;


public class ASTGenerationSTVisitor extends FOOLBaseVisitor<Node> {

	String indent;
	
    @Override
	public Node visit(ParseTree t) {             //visit now returns Node
        String temp=indent;
        indent=(indent==null)?"":indent+"  ";
        Node result = super.visit(t);
        indent=temp;
        return result;       
	}

	@Override
	public Node visitProg(ProgContext c) {
		System.out.println(indent+"prog. This is the syntax tree.");
//		return visit( c.exp() );

		// TODO(RV): the visit returns the syntax tree of the child.
		return new ProgNode(visit( c.exp() ));
	}
	
	@Override
	public Node visitTimes(TimesContext c) {       //modified production tags
		System.out.println(indent+"exp: prod with TIMES");
//		return visit( c.exp(0) ) * visit( c.exp(1) );

		return new TimesNode( visit( c.exp(0) ), visit( c.exp(1) ));
	}

	@Override
	public Node visitPlus(PlusContext c) {
		System.out.println(indent+"exp: prod with PLUS");
//		return visit( c.exp(0) ) + visit( c.exp(1) );
		return new PlusNode(visit( c.exp(0) ), visit( c.exp(1) ));
	}

	@Override
	public Node visitPars(ParsContext c) {
		System.out.println(indent+"exp: prod with LPAR RPAR");
//		return visit(c.exp());

		// Non lo aggiungo perché le parentesi vengono
		return visit(c.exp());
	}

	@Override
	public Node visitInteger(IntegerContext c) {
		int res=Integer.parseInt(c.NUM().getText());
		boolean minus= c.MINUS( ) != null;
		System.out.println(indent+"exp: prod with "+(minus?"MINUS ":"")+"NUM "+res);
		return new IntNode(minus? -res: res);
	}
	
}
