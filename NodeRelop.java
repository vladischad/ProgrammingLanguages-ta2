public class NodeRelop extends Node {
    private String relop;

    public NodeRelop(int pos, String relop) {
        this.pos = pos;
        this.relop = relop;
    }

    public int op(int a, int b) throws EvalException {
        switch (relop) {
            case "<": return a < b ? 1 : 0;
            case "<=": return a <= b ? 1 : 0;
            case ">": return a > b ? 1 : 0;
            case ">=": return a >= b ? 1 : 0;
            case "<>": return a != b ? 1 : 0;
            case "==": return a == b ? 1 : 0;
            default: throw new EvalException(pos, "invalid relop: " + relop);
        }
    }

    public String code() { return relop; }
}
