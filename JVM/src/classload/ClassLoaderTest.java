package classload;

/**
 * @Author qzy
 * @ClassName 系统类加载器
 * @Description TODO(一句话描述该类功能)
 * @Date 2023/12/29 16:05 星期五
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        // 系统类加载器：jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("sysClassLoader = " + sysClassLoader);
        // 获取其上层->扩展类加载器：jdk.internal.loader.ClassLoaders$PlatformClassLoader@6acbcfc0
        ClassLoader sysParent = sysClassLoader.getParent();
        System.out.println("sysParent = " + sysParent);
        // 【尝试】获取其上层->引导类加载器：null
        ClassLoader sysParParent = sysParent.getParent();
        System.out.println("sysParParent = " + sysParParent);
        System.out.println("-=========================-");
        // jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b;当前类加载器与系统类加载器是一样的
        ClassLoader currentClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("currentClassLoader = " + currentClassLoader);
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@6acbcfc0
        ClassLoader parent = currentClassLoader.getParent();
        System.out.println("parent = " + parent);
        // null
        ClassLoader parentParent = parent.getParent();
        System.out.println("parentParent = " + parentParent);

        // null
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println("stringClassLoader = " + stringClassLoader);



    }
}
