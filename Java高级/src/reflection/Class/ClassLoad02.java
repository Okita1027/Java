package reflection.Class;

/**
 * @time 2022/5/7 8:52 星期六
 * 类加载分三个阶段：加载、链接、初始化
 * 加载：生成.class文件
 * 链接阶段2.1-验证：目的是为了确保Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
 * 包括:文件格式验证(是否以魔数oxcafebabe开头)、元数据验证、字节码验证和符号引用验证。
 * 可以考虑使用-Xverify:none 参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间。
 * 链接阶段2.2-准备：详情请查看下方A类的注释。
 * 链接阶段2.3-解析：虚拟机将常量池中的符号引用替换为直接引用。
 * 初始化阶段：开始真正执行类中定义的Java代码，此阶段是执行clinit()方法的过程，
 * clinit方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并进行合并。
 * 注意！初始化阶段涉及还只是静态变量，不牵扯到实例化变量。
 */
public class ClassLoad02 {
    public static void main(String[] args) {
        //实例化变量或引用静态变量都会导致类加载
        System.out.println(A.n4);//没有进行实例化，所以不执行A的构造方法

        //类的加载会执行loadClass方法,这是线程同步的，这就能保证在某个类的内存中只有一份Class对象

    }
}

class A{

    static {
        System.out.println("A 静态代码块被执行！");
        //按照执行顺序，n4 = 400 -> n4 = 40，clinit()方法会将n4 = 400这句话过滤掉，直接执行n4 = 40;
        n4 = 400;
    }
    public static int n4 = 40;

    //类加载链接阶段2.2-准备：
    //n1是实例变量，在准备阶段不分配内存
    public int n1 = 10;
    //n2是静态变量，分配内存，但赋值为0
    public static int n2 = 20;
    //n3是静态常量，一步到位，赋值为30
    public static final int n3 = 30;

    public A() {
        System.out.println("A 构造器被执行！");
    }
}