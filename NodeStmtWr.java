public class NodeStmtWr extends NodeStmt {
    private NodeExpr expr;

    public NodeStmtWr(NodeExpr expr) {
        this.expr = expr;
    }

    public int eval(Environment env) throws EvalException {
        int val = expr.eval(env);
        System.out.println(val);
        return val;
    }

    public String code() {
        return "printf(\"%d\\n\", " + expr.code() + ");";
    }
}