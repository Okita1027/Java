package pattern.actor.memorandum.white_box;

/**
 * @Author qzy
 * @ClassName RoleStateCaretaker
 * @Description 管理者
 * @Date 2022/12/25 14:41 星期日
 */
public class RoleStateCaretaker {
    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}
