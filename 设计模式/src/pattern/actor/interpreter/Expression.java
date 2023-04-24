package pattern.actor.interpreter;

/**
 * @Author qzy
 * @ClassName Expression
 * @Description 抽象表达式（Abstract Expression）角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 * @Date 2022/12/25 15:39 星期日
 */
public abstract class Expression {
    public abstract int interpret(Context context);
}
