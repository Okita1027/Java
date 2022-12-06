package class_.类和接口作为成员变量类型;

public class SkillAchieve implements Skill
{
    private String SkillName;

    public SkillAchieve(String skillName)
    {
        this.SkillName = skillName;
    }

    public String getSkillName()
    {
        return SkillName;
    }

    public void setSkillName(String skillName)
    {
        SkillName = skillName;
    }
    @Override
    public void skillAttack()
    {
        System.out.println("月牙天冲！");
    }
}
