package pattern.constructor.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Date 2022/6/17 21:15 星期五
 * 测试使用序列化破坏单例设计模式
 */
public class Singleton20 {
    public static void main(String[] args) throws Exception {
        //地址不一样，破坏了单例设计模式
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
