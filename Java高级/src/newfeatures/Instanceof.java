package newfeatures;

/**
 * @author qzy
 * @time 2023/9/16 17:45 星期六
 * JDK14 中预览特性：
 * instanceof 模式匹配通过提供更为简便的语法，来提高生产力。有了该功能，
 * 可以减少 Java 程序中显式强制转换的数量，实现更精确、简洁的类型安全的代码
 */
public class Instanceof {
    public static void main(String[] args) {
        //以前的写法
        Object obj = new String("hello,Java14");
        obj = null;//在使用 null 匹配 instanceof 时，返回都是 false.
        if(obj instanceof String){
            String str = (String) obj;
            System.out.println(str.contains("Java"));
        }else{
            System.out.println("非 String 类型");
        }

        //现在的写法 省去了强制类型转换的过程
        if (obj instanceof String str) {
            System.out.println(str);
        }
    }

}
