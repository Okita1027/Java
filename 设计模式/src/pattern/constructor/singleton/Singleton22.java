package pattern.constructor.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Date 2022/6/18 10:38 星期六
 * 解决反序列化破坏单例设计模式
 */
public class Singleton22 {
    public static void main(String[] args) throws Exception {
        //通过给GirlFriend添加readSolve方法解决此问题
        readObjectFromFile();
        readObjectFromFile();
    }
    public static void readObjectFromFile() throws Exception {
        GirlFriend instance = GirlFriend.getGriFriend();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\Java\\a.txt"));
        oos.writeObject(instance);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\Java\\a.txt"));
        instance = (GirlFriend) ois.readObject();
        System.out.println("instance = " + instance);
        ois.close();
    }
}
