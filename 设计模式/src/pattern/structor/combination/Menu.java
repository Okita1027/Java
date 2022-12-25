package pattern.structor.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName Menu
 * @Description 树枝节点（Composite）：
 * 定义树枝节点的行为，存储子节点，组合树枝节点和叶子节点形成一个树形结构。
 * @Date 2022/12/21 16:01 星期三
 */
public class Menu extends MenuComponent{

    private List<MenuComponent> menuComponentList;

    public Menu(String name, int level) {
        this.name = name;
        this.level = level;
        menuComponentList = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("---");
        }
        System.out.println(name);
        for (MenuComponent menuComponent : menuComponentList) {
            menuComponent.print();
        }
    }
}
