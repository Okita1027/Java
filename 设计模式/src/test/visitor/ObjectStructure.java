package test.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName ObjectStructure
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/4/21 10:20 星期五
 */
public class ObjectStructure {
    private List<AbstractElement> elementList;

    public ObjectStructure() {
        elementList = new ArrayList<>();
    }

    public void addElement(AbstractElement element) {
        elementList.add(element);
    }

    public void action(AbstractVisitor visitor) {
        for (AbstractElement element : elementList) {
            element.beVisited(visitor);
        }
    }
}
