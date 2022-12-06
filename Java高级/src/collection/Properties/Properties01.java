package collection.Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 秦智耘
 * @Title Properties
 * @Date 2021年8月17日15:34:14
 */
public class Properties01
{
    @SuppressWarnings("all")
    public static void main(String[] args) throws IOException
    {
        /*
        * 1) Properties继承自Hashtable类并实现了Map接口，所以与Hashtable相似
        * 3）Properties可以用于从 xxx.Properties文件中，加载数据到Properties类对象，并进行读取和修改
        * 4）工作中，xxx.Properties通常用作配置文件，
        * */
        Properties properties = new Properties();
        properties.load(new FileReader("collection\\Properties\\data1.properties"));
        properties.put("qzy", 20);
        properties.put("zmy", 18);
        properties.put("zmy", "20");
        properties.setProperty("phone", "17368591975");
        //key和value都不能是null
//        properties.put("zmy", null);
//        properties.put(null, 18);
        System.out.println("properties = " + properties);
        System.out.println(properties.get("qzy"));
        //getProperty，只有当值时String类型时才会返回值，否则返回null
        System.out.println(properties.getProperty("zmy"));
        System.out.println(properties.get("ip"));
        System.out.println(properties.getProperty("phone"));

    }
}
