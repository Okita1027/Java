package pattern.actor.interpreter;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 客户端（Client）：主要任务是将需要分析的句子或表达式转换成使用解释器对象描述的抽象语
 * 法树，然后调用解释器的解释方法，当然也可以通过环境角色间接访问解释器的解释方法。
 * @Date 2022/12/25 15:48 星期日
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");

        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 4);

        Expression expression = new Plus(new Minus(new Plus(a, b), c), d);
        System.out.println("expression.interpret(context) = " + expression.interpret(context));

    }
}
