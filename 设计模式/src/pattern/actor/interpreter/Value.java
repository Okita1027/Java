package pattern.actor.interpreter;

/**
 * @Author qzy
 * @ClassName Value
 * @Description 终结符表达式（Terminal Expression）角色：是抽象表达式的子类，用来实现文法中与终结
 * 符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应。
 * @Date 2022/12/25 15:40 星期日
 */
public class Value extends Expression{
    private int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int interpret(Context context) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
