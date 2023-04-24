package pattern.actor.memorandum.black_box;

/**
 * @Author qzy
 * @ClassName GameRole
 * @Description TODO(一句话描述该类功能)
 * @Date 2022/12/25 14:33 星期日
 */
public class GameRole {
    private int hp;
    private int mp;

    public GameRole() {
        hp = 100;
        mp = 100;
    }

    public void fight() {
        hp -= 50;
        mp -= 50;
    }

    public RoleStateMemento saveState() {
        return new RoleStateMemento(hp, mp);
    }

    public void recoverState(Memento memento) {
        RoleStateMemento roleStateMemento = (RoleStateMemento) memento;
        this.hp = roleStateMemento.getHp();
        this.mp = roleStateMemento.getMp();
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

    @Override
    public String toString() {
        return "GameRole{" +
                "hp=" + hp +
                ", mp=" + mp +
                '}';
    }

    private class RoleStateMemento implements Memento {
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
}
