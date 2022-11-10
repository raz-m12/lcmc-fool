package compiler;

import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

public class AST {
	public static class ProgNode implements Node {
		Node exp;
		ProgNode(Node e) { exp=e; }

		@Override
		public <S> S accept(BaseASTVisitor<S> visitor) {
			return visitor.visitNode(this);
		}
//		@Override
//		public void accept(PrintASTVisitor visitor) {
//			visitor.visitNode(this);
//		}
	}

	public static class PlusNode implements Node {
		Node left;
		Node right;
		PlusNode(Node l, Node r) { left=l; right=r; }
		@Override
		public <S> S accept(BaseASTVisitor<S> visitor) {
			return visitor.visitNode(this);
		}
	}

	public static class TimesNode implements Node {
		Node left;
		Node right;
		TimesNode(Node l, Node r) { left=l; right=r; }
		@Override
		public <S> S accept(BaseASTVisitor<S> visitor) {
			return visitor.visitNode(this);
		}
	}

	public static class IntNode implements Node {
		Integer val;
		IntNode(Integer n) { val=n; }
		@Override
		public <S> S accept(BaseASTVisitor<S> visitor) {
			return visitor.visitNode(this);
		}
	}

	public static class EqualNode implements Node {
		Node left;
		Node right;
		EqualNode(Node l, Node r) { left=l; right=r; }
		@Override
		public <S> S accept(BaseASTVisitor<S> visitor) {
			return visitor.visitNode(this);
		}
	}

	public static class BooleanNode implements Node {
		Boolean value;
		BooleanNode(Boolean val) { value = val; }
		@Override
		public <S> S accept(BaseASTVisitor<S> visitor) {
			return visitor.visitNode(this);
		}
	}
}







