public class NodeBlock extends Node {
    private NodeStmt stmt;
    private NodeBlock block;

    public NodeBlock(NodeStmt stmt) {
        this.stmt = stmt;
        this.block = null;
    }

    public NodeBlock(NodeStmt stmt, NodeBlock block) {
        this.stmt = stmt;
        this.block = block;
    }

    public int eval(Environment env) throws EvalException {
        stmt.eval(env);
        if (block != null) block.eval(env);
        return 0;
    }

    public String code() {
        return stmt.code() + (block != null ? block.code() : "");
    }
}