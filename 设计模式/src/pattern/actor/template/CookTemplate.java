package pattern.actor.template;

/**
 * @Author qzy
 * @ClassName CookTemplate
 * @Description 炒菜的模板-抽象类（Abstract Class）：负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成。
 * @Date 2022/12/22 16:47 星期四
 */
public abstract class CookTemplate {
    public final void cook() {
        pourOil();
        heatOil();
        addVegetables();
        addSauce();
        fry();
    }

    private void pourOil() {
        System.out.println("1-倒油！");
    }

    private void heatOil() {
        System.out.println("2-热油！");
    }

    protected abstract void addVegetables();
    protected abstract void addSauce();

    private void fry() {
        System.out.println("5-翻炒！");
    }
}
