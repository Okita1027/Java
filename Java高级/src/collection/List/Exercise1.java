package collection.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 秦智耘
 * @Title 集合练习：使用List实现类添加3本书，按价格升序输出
 * @Date 2021年8月13日15:30:11
 */
public class Exercise1
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        book book1 = new book("西游记", 50);
        book book2 = new book("水浒传", 30);
        book book3 = new book("红楼梦", 90);
        book book4 = new book("三国演义", 70);

        List list = new ArrayList();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int j = 0 ; j < list.size() - 1 - i; j++)
            {
                book bookt1 = (book) list.get(j);
                book bookt2 = (book) list.get(j+1);
                if(bookt1.price > bookt2.price)
                {
                    list.set(j, bookt2);
                    list.set(j+1, bookt1);
                }
            }
        }

        for (Object obj : list)
            System.out.println("obj = " + obj);

    }
}

class book
{
    String name;
    int price;

    public book(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
