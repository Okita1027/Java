package annotation;

import java.lang.annotation.*;

/**
 * @time 2022/5/22 20:21 星期日
 * 自定义注解
 * 如果注解有成员，在使用注解时,需要指明成员的值。
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义。自定义注解通过都会指明两个元注解: Retention. Target
 * jdk提供的4种元注解(元注解:对现有的注解进行解释说明的注解):
 * Retention:指定所修饰的 Annotation 的生命周期:SOURCE\CLASS(默认行为)\RUNTIME
 * 只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 * Target:用于指定被修饰的Annotation能用于修饰哪些程序元素
 * *******以下出现的频率较低*******
 * Documented:表示所修饰的注解在被javadoc解析时，保留下来。
 * Inherited:被它修饰的Annotation将具有继承性。
 * jdk 8中注解的新特性:可重复注解、类型注解
 * 可重复注解:a在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 * MyAnnotation的Target和Retention和MyAnnotations相同。
 * 类型注解:
 * ElementType.TYPE_PARAMETER表示该注解能写在类型变量的声明语句中（如:泛型声明)。
 * ElementType.TYPE_uSE表示该注解能写在使用类型的任何语句中。
 */
@Retention(RetentionPolicy.RUNTIME)
//可重复定义注解
@Repeatable(MyAnnotations.class)//@Retention和@Target需要和MyAnnotations一致
//可以在紫色字体关键字的前面声明注解
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR
        , ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {
    String[] value() default "HelloWorld!"; //这是变量
}
