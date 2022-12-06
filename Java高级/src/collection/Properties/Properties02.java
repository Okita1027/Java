package collection.Properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @time 2022/4/30 10:00 星期六
 */
public class Properties02
{
    public static void main(String[] args) throws IOException
    {
        Properties properties = new Properties();
        //创建键值对
        properties.setProperty("char-set", "utf-8");
        properties.setProperty("username", "秦智耘");
        properties.setProperty("password", "123");
        properties.store(new FileWriter("集合\\Properties\\data2.properties"), null);//null表示文件头的注释为空
        System.out.println("保存配置文件成功！");
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        //修改键值对
        properties.setProperty("char-set", "GBK");
        properties.setProperty("username", "QinZhiyun");
        properties.setProperty("password", "123456");
        properties.store(new FileWriter("集合\\Properties\\data2.properties"), null);//null表示文件头的注释为空
        System.out.println("修改配置文件成功！");
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
}
