package generics;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 秦智耘
 * @Title 泛型练习3 + Junit类介绍
 * @Date 2021年8月21日20:06:34
 */
public class Junit_GenericExe_3
{

    //JUnit类就是可以单独给方法一个执行按钮，方便我们测试用的
    //用法：在需要单独测试的方法前加上@Test注解之后Alt+Enter导入Junit5.4即可
    @Test
    public void Test()
    {
        DAO<User> dao = new DAO<User>();
        dao.save("001", new User(1, 18, "qzy"));
        dao.save("002", new User(2, 24, "zk"));
        dao.save("003", new User(3, 28, "hlf"));
        List<User> list = dao.list();
        System.out.println("list = " + list);

        System.out.println("dao = " + dao);
        dao.update("001", new User(1, 17, "xfy"));
        System.out.println("dao = " + dao);
    }
}

class DAO<T>
{
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity)
    {
        map.put(id, entity);
    }
    public T get(String id)
    {
        return map.get(id);
    }
    public void update(String id, T entity)
    {
        map.replace(id, entity);
    }
    public List<T> list()
    {
        ArrayList<T> arrayList = new ArrayList<T>();
        Set<String> keySet = map.keySet();
        for (String key : keySet)
        {
            arrayList.add(get(key));
        }
        return arrayList;
    }
    public void delete(String id)
    {
        map.remove(id);
    }

    @Override
    public String toString()
    {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

class User
{
    private int id, age;
    private String name;

    public User(int id, int age, String name)
    {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "\nUser{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}