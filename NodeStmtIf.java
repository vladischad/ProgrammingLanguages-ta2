public class NodeStmtIf extends NodeStmt {
    private NodeBoolexpr boolexpr;
    private NodeStmt thenStmt, elseStmt;

    public NodeStmtIf(NodeBoolexpr boolexpr, NodeStmt thenStmt) {
        this.boolexpr = boolexpr;
        this.thenStmt = thenStmt;
        this.elseStmt = null;
    }

    public NodeStmtIf(NodeBoolexpr boolexpr, NodeStmt thenStmt, NodeStmt elseStmt) {
        this.boolexpr = boolexpr;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    public int eval(Environment env) throws EvalException {
        if (boolexpr.eval(env) != 0)
            return thenStmt.eval(env);
        else if (elseStmt != null)
            return elseStmt.eval(env);
        return 0;
    }

    public String code() {
        String result = "if(" + boolexpr.code() + "){" + thenStmt.code() + "}";
        if (elseStmt != null)
            result += "else{" + elseStmt.code() + "}";
        return result;
    }
}