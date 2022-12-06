package class_.类和接口作为成员变量类型;

public class Hero
{
    private String name;
    private int age;
    private Weapon weapon;
    private Skill skill;

    public Hero(String name, int age, Weapon weapon, Skill skill)
    {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
        this.skill = skill;
    }

    public void attack()
    {
        skill.skillAttack();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }

    public Skill getSkill()
    {
        return skill;
    }

    public void setSkill(Skill skill)
    {
        this.skill = skill;
    }
}
