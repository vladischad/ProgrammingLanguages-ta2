public class NodeStmtWhile extends NodeStmt {
    private NodeBoolexpr boolexpr;
    private NodeStmt body;

    public NodeStmtWhile(NodeBoolexpr boolexpr, NodeStmt body) {
        this.boolexpr = boolexpr;
        this.body = body;
    }

    public int eval(Environment env) throws EvalException {
        while (boolexpr.eval(env) != 0) {
            body.eval(env);
        }
        return 0;
    }

    public String code() {
        return "while(" + boolexpr.code() + "){" + body.code() + "}";
    }
}