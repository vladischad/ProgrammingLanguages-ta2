import java.util.Scanner;

public class NodeStmtRd extends NodeStmt {
    private String id;

    public NodeStmtRd(String id) {
        this.id = id;
    }

    public int eval(Environment env) throws EvalException {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        return env.put(id, val);
    }

    public String code() {
        return "scanf(\"%d\", &" + id + ");";
    }
}