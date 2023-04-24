package test.visitor;

/**
 * @Author qzy
 * @ClassName AbstractElement
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/21 10:16 星期五
 */
public interface AbstractElement {
    void beVisited(AbstractVisitor visitor);
}
