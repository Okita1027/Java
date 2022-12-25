package pattern.actor.memorandum.white_box;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 备忘录模式-白箱
 * @Date 2022/12/25 14:44 星期日
 */
public class Client {
    public static void main(String[] args) {
        GameRole role = new GameRole();
        System.out.println("role = " + role);

        //备份管理者
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        //存档
        caretaker.setRoleStateMemento(role.saveState());

        role.fight();
        System.out.println("role = " + role);

        //读档：从备份管理中恢复
        role.recoverState(caretaker.getRoleStateMemento());
        System.out.println("role = " + role);
    }
}
