package pattern.actor.interpreter;

/**
 * @Author qzy
 * @ClassName Plus
 * @Description 非终结符表达式（Nonterminal Expression）角色：也是抽象表达式的子类，用来实现文法
 * 中与非终结符相关的操作，文法中的每条规则都对应于一个非终结符表达式。
 * @Date 2022/12/25 15:41 星期日
 */
public class Minus extends Expression {
    private Expression left;
    private Expression right;

    public Minus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "- " + right.toString() + ")";
    }
}
