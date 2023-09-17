package newfeatures;

/**
 * @author qzy
 * @time 2023/9/16 17:50 星期六
 * 传统 switch 声明语句的弊端：
 * • 匹配是自上而下的，如果忘记写 break，后面的 case 语句不论匹配与否都会执行； ---> case 穿透
 * • 所有的 case 语句共用一个块范围，在不同的 case 语句定义的变量名不能重复；
 * • 不能在一个 case 里写多个执行结果一致的条件；
 * • 整个 switch 不能作为表达式返回值；
 */
public class Switch {
    public static void main(String[] args) {
        /*
         * • Java 12 将会对 switch 声明语句进行扩展，使用 case L ->来替代以前的 break;，
         * 省去了 break 语句，避免了因少写 break 而出错。
         * • 同时将多个 case 合并到一行，显得简洁、清晰，也更加优雅的表达逻辑分支。
         * • 为了保持兼容性，case 条件语句中依然可以使用字符: ，但是同一个 switch 结构里
         * 不能混用-> 和: ，否则编译错误。
         */

        /*
         * JDK13 中引入了 yield 语句，用于返回值。这意味着，switch 表达式(返回值)应
         * 该使用 yield，switch 语句(不返回值)应该使用 break。
         * yield 和 return 的区别在于：return 会直接跳出当前循环或者方法，而 yield 只
         * 会跳出当前 switch 块。
         */


        /*
            JDK17 的预览特性：switch 的模式匹配
            旧写法：
            static String formatter(Object o) {
             String formatted = "unknown";
             if (o instanceof Integer i) {
             formatted = String.format("int %d", i);
             } else if (o instanceof Long l) {
             formatted = String.format("long %d", l);
             } else if (o instanceof Double d) {
             formatted = String.format("double %f", d);
             } else if (o instanceof String s) {
             formatted = String.format("String %s", s);
             }
             return formatted;
            }
            模式匹配新写法：
            static String formatterPatternSwitch(Object o) {
             return switch (o) {
             case Integer i -> String.format("int %d", i);
             case Long l -> String.format("long %d", l);
             case Double d -> String.format("double %f", d);
             case String s -> String.format("String %s", s);
             default -> o.toString();
             };
            }
            直接在 switch 上支持 Object 类型，这就等于同时支持多种类型，使用模式匹
            配得到具体类型，大大简化了语法量，这个功能很实用。
         */
    }
}
