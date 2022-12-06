package class_.类和接口作为成员变量类型;

public class Main
{
    public static void main(String[] args)
    {
        Weapon weapon = new Weapon("天锁斩月");
        SkillAchieve skillAchieve = new SkillAchieve("月牙天冲");
        Hero hero = new Hero("黑崎一护", 18, weapon, skillAchieve);
        System.out.println("姓名：" + hero.getName() + ",年龄：" + hero.getAge() +
                ",武器是" + hero.getWeapon().getCode() + ",技能为" + skillAchieve.getSkillName());
        hero.attack();
    }
}
