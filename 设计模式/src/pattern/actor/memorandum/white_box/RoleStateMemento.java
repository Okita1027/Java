package pattern.actor.memorandum.white_box;

/**
 * @Author qzy
 * @ClassName RoleStateMemento
 * @Description 备份
 * @Date 2022/12/25 14:40 星期日
 */
public class RoleStateMemento {
    private int hp;
    private int mp;

    public RoleStateMemento(int hp, int mp) {
        this.hp = hp;
        this.mp = mp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
}
