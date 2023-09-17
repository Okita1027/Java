package newfeatures;

/**
 * @author qzy
 * @time 2023/9/17 10:25 星期日
 * String 再也不用 char[] 来存储了，改成了 byte[] 加上编码标记，节约了一些空间。
 * JDK11 新特性：新增了一系列字符串处理方法
 * 描述 举例
 * 判断字符串是否为空白 " ".isBlank(); // true
 * 去除首尾空白 " Javastack ".strip(); // "Javastack"
 * 去除尾部空格 " Javastack ".stripTrailing(); // " Javastack"
 * 去除首部空格 " Javastack ".stripLeading(); // "Javastack "
 * 复制字符串 "Java".repeat(3);// "JavaJavaJava"
 * 行数统计 "A\nB\nC".lines().count(); // 3
 *
 * JDK12 新特性：String 实现了 Constable 接口
 * 其实就是调用 Optional.of 方法返回一个 Optional 类型。
 * 举例：
 * private static void testDescribeConstable() {
 * String name = "尚硅谷 Java 高级工程师";
 * Optional<String> optional = name.describeConstable();
 * System.out.println(optional.get());
 * }
 * 结果输出：
 * 尚硅谷 Java 高级工程师
 *
 * JDK12 新特性：String 新增方法
 * String 的 transform(Function)
 * var result = "foo".transform(input -> input + " bar");
 * System.out.println(result); //foo bar
 * 或者
 * var result = "foo".transform(input -> input + " bar").transform(Strin
 * g::toUpperCase)
 * System.out.println(result); //FOO BAR
 *
 * 在某种情况下，该方法应该被称为 map()。
 * 举例：
 * private static void testTransform() {
 * System.out.println("======test java 12 transform======");
 * List<String> list1 = List.of("Java", " Python", " C++ ");
 * List<String> list2 = new ArrayList<>();
 * list1.forEach(element -> list2.add(element.transform(String::strip)
 *  .transform(String::toUpperCase)
 *  .transform((e) -> "Hi," + e))
 * );
 * list2.forEach(System.out::println);
 * }
 * 结果输出：
 * ======test java 12 transform======
 * Hi,JAVA
 * Hi,PYTHON
 * Hi,C++
 */
public class String_ {
}
