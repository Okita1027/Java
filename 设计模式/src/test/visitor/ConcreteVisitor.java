package test.visitor;

/**
 * @Author qzy
 * @ClassName ConcreteVisitor
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/21 10:17 星期五
 */
public class ConcreteVisitor implements AbstractVisitor {
    @Override
    public void visit(AbstractElement element) {
        System.out.println(this + "访问" + element + ":" );
    }
}
