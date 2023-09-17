package newfeatures;

/**
 * @author qzy
 * @time 2023/9/16 22:07 星期六
 * 文本块
 * 现实问题：
 * 在 Java 中，通常需要使用 String 类型表达 HTML，XML，SQL 或 JSON 等格式
 * 的字符串，在进行字符串赋值时需要进行转义和连接操作，然后才能编译该代
 * 码，这种表达方式难以阅读并且难以维护。
 * JDK13 的新特性
 * 使用"""作为文本块的开始符和结束符，在其中就可以放置多行的字符串，不需
 * 要进行任何转义。因此，文本块将提高 Java 程序的可读性和可写性。
 */
public class Block {
    public static void main(String[] args) {
        /*
        基本使用：
            """
            line1
            line2
            line3
            """
        相当于：
            "line1\nline2\nline3\n"
            或者一个连接的字符串：
            "line1\n" +
            "line2\n" +
            "line3\n"
        如果字符串末尾不需要行终止符，则结束分隔符可以放在最后一行内容上。例如：
            """
            line1
            line2
            line3"""
        相当于
            "line1\nline2\nline3"
        文本块可以表示空字符串，但不建议这样做，因为它需要两行源代码：
            String empty = """
            """;
         */

        /*举例 1：普通文本
        原有写法：
        String text1 = "The Sound of silence\n" +
                "Hello darkness, my old friend\n" +
                "I've come to talk with you again\n" +
                "Because a vision softly creeping\n" +
                "Left its seeds while I was sleeping\n" +
                "And the vision that was planted in my brain\n" +
                "Still remains\n" +
                "Within the sound of silence";
        System.out.println(text1);
        使用新特性：
        String text2 = """
                The Sound of silence
                Hello darkness, my old friend
                I've come to talk with you again
                Because a vision softly creeping
                Left its seeds while I was sleeping
                And the vision that was planted in my brain
                Still remains
                Within the sound of silence
                """;
        System.out.println(text2);
        举例 2：HTML 语句
                <html >
                 <body >
                 <p > Hello, 尚硅谷 </p >
                 </body >
                </html >
                将其复制到 Java 的字符串中，会展示成以下内容：
        "<html>\n" +
                " <body>\n" +
                " <p>Hello, 尚硅谷</p>\n" +
                " </body>\n" +
                "</html>\n";
        即被自动进行了转义，这样的字符串看起来不是很直观，在 JDK 13 中：
        """
                <html>
                 <body>
                 <p>Hello, world</p>
                 </body>
                </html>
                """;
        举例 3：SQL 语句
        select employee_id, last_name, salary, department_id
        from employees
        where department_id in(40, 50, 60)
        order by department_id asc
        原有方式：
        String sql = "SELECT id,NAME,email\n" +
                "FROM customers\n" +
                "WHERE id > 4\n" +
                "ORDER BY email DESC";
        使用新特性：
        String sql1 = """
                SELECT id,NAME,email
                FROM customers
                WHERE id > 4
                ORDER BY email DESC
                """;
        举例 4：JSON 字符串
        原有方式：
        String myJson = "{\n" +
                " \"name\":\"Song Hongkang\",\n" +
                " \"address\":\"www.atguigu.com\",\n" +
                " \"email\":\"shkstart@126.com\"\n" +
                "}";
        System.out.println(myJson);
        使用新特性：
        String myJson1 = """
                {
                "name":"Song Hongkang",
                "address":"www.atguigu.com",
                "email":"shkstart@126.com"
                }""";
        System.out.println(myJson1);
        JDK14 中二次预览特性
        JDK14 的版本主要增加了两个 escape sequences，分别是\ <line - terminator >
                与\s escape sequence。
        举例：

        String sql1 = """
                SELECT id,NAME,email
                FROM customers
                WHERE id > 4
                ORDER BY email DESC
                """;
        System.out.println(sql1);
        // \:取消换行操作
        // \s:表示一个空格
        String sql2 = """
                SELECT id,NAME,email \
                FROM customers\s\
                WHERE id > 4 \
                ORDER BY email DESC
                """;
        System.out.println(sql2);
        JDK15 中功能转正*/
    }
}
