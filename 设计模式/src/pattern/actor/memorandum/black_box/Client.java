package pattern.actor.memorandum.black_box;

/**
 * @Author qzy
 * @ClassName Client
 * @Description 备忘录模式-黑箱
 * @Date 2022/12/25 14:50 星期日
 */
public class Client {
    public static void main(String[] args) {
        GameRole role = new GameRole();
        System.out.println("role = " + role);

        //存档工具
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        //存档
        caretaker.setMemento(role.saveState());

        role.fight();
        System.out.println("role = " + role);

        //读档
        role.recoverState(caretaker.getMemento());
        System.out.println("role = " + role);
    }
}
