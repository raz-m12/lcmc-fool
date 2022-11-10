package compiler.lib;

import compiler.PrintASTVisitor;

public interface Node {
    <S> S accept(BaseASTVisitor<S> visitor);
}

//public interface Node {
//    void accept(PrintASTVisitor visitor);
//}












//    void accept(PrintASTVisitor visitor);
	

	  