package pattern.actor.template;

/**
 * @Author qzy
 * @ClassName CookBaoCai
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/22 16:53 星期四
 */
public class CookBaoCai extends CookTemplate {

    @Override
    protected void addVegetables() {
        System.out.println("3-加包菜！");
    }

    @Override
    protected void addSauce() {
        System.out.println("4-加辣椒！");
    }
}
