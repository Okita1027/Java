package pattern.structor.combination;

/**
 * @Author qzy
 * @ClassName MenuComponent
 * @Description 抽象根节点（Component）：
 * 定义系统各层次对象的共有方法和属性，可以预先定义一些默认行为和属性。
 * @Date 2022/12/21 15:57 星期三
 */
//菜单组件 不管是菜单还是菜单项，都应该继承该类
public abstract class MenuComponent {
    protected String name;
    protected int level;
    //添加菜单
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    //移除菜单
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    //获取指定的子菜单
    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }
    //获取菜单名称
    public String getName() {
        return name;
    }
    public void print(){
        throw new UnsupportedOperationException();
    }
}
