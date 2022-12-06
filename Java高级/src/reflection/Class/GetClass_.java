package reflection.Class;

/**
 * @time 2022/5/6 13:37
 * 获取class的方式
 * 几乎所有对象都有class:
 * 基本类、包装类、内部/外部类、注解、枚举、void
 */
public class GetClass_ {
    public static void main(String[] args) throws Exception {
        //1:通过路径,Class.forName();
        String classAllPath = "Class.CatC";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println("cls1 = " + cls1);

        //2:类名.class，多用于参数传递 (基本数据类型和包装类也可以)
        Class<CatC> cls2 = CatC.class;
        System.out.println("cls2 = " + cls2);
        Class<Integer> integerClass = int.class;
        System.out.println("integerClass = " + integerClass);
        //2.1:基本数据类型.class;包装类.TYPE;
        Class<Integer> integerClass1 = Integer.TYPE;
        System.out.println("integerClass1 = " + integerClass1);
        //2.2:int 和 Integer 底层执行自动装箱 -> true
        System.out.println(integerClass.hashCode() == integerClass1.hashCode());

        //3:对象.class,有实例时使用
        CatC catC = new CatC();
        Class<? extends CatC> cls3 = catC.getClass();
        System.out.println("cls3 = " + cls3);

        //4:通过类加载器获取
        ClassLoader classLoader = catC.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println("cls4 = " + cls4);
    }
}
