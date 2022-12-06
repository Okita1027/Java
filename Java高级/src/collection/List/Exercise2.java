package collection.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 秦智耘
 * @Title 集合练习2
 * @Date 2021年8月18日15:02:05
 */
public class Exercise2
{
    @SuppressWarnings("all")
    public static void main(String[] args)
    {
        List list = new ArrayList();
        news n = new news("123456678965324132");
        n.setContent("hhhhhhhhhhhhhhhhhh");
        list.add(n);
        list.add(new news("新冠确诊病例超千万，数百万印度教徒赴恒河“圣浴”引民众担忧"));
        list.add(new news("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        for (int i = list.size() - 1; i >= 0; i--)
        {
            char[] dest = new char[18];
            news nt = (news)list.get(i);
            if (nt.getTitle().length() > 15)
            {
                String str = nt.getTitle();
                str.getChars(0, 15, dest, 0);
                dest[15] = dest[16] = dest[17] = '.';
            }
            System.out.print("list[" + (i) + "] = ");
            for (int j = 0; j < dest.length; j++)
            {
                System.out.print(dest[j]);
            }
            System.out.println();
        }
    }
}
class news
{
    private String title, content;

    public news(String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "news{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}