public class NodeBoolexpr extends Node {
    private NodeExpr left;
    private NodeRelop relop;
    private NodeExpr right;

    public NodeBoolexpr(NodeExpr left, NodeRelop relop, NodeExpr right) {
        this.left = left;
        this.relop = relop;
        this.right = right;
    }

    public int eval(Environment env) throws EvalException {
        return relop.op(left.eval(env), right.eval(env));
    }

    public String code() {
        return "(" + left.code() + relop.code() + right.code() + ")";
    }
}