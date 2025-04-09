public class NodeStmtBlock extends NodeStmt {
    private NodeBlock block;

    public NodeStmtBlock(NodeBlock block) {
        this.block = block;
    }

    public int eval(Environment env) throws EvalException {
        return block.eval(env);
    }

    public String code() {
        return block.code();
    }
}