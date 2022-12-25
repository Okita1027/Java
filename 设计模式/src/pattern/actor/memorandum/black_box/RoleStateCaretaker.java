package pattern.actor.memorandum.black_box;

/**
 * @Author qzy
 * @ClassName RoleStateCaretaker
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/25 14:54 星期日
 */
public class RoleStateCaretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
