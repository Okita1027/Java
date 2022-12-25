package pattern.actor.interpreter;

/**
 * @Author qzy
 * @ClassName Variable
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/25 15:44 星期日
 */
public class Variable extends Expression{
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }

}
