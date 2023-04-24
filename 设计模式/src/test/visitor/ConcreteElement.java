package test.visitor;

/**
 * @Author qzy
 * @ClassName ConcreteElement
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/21 10:19 星期五
 */
public class ConcreteElement implements AbstractElement {
    @Override
    public void beVisited(AbstractVisitor visitor) {
        visitor.visit(this);
        System.out.println(this + "被 " + visitor + " 访问了！");
    }
}
