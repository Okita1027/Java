package interface_.接口;

public interface PriAndStaAndDef
{
    default void MethodA()
    {
        System.out.println("这是方法A");
//        System.out.println("111");
//        System.out.println("222");
//        System.out.println("333");

//        MethodCommon();
    }

    default void MethodB()
    {
        System.out.println("这是方法B");
//        System.out.println("111");
//        System.out.println("222");
//        System.out.println("333");

//        MethodCommon();
    }
    //MehodA 与 MethodB 中有相同的三句话是相同的，现在要想办法优化一下
//    public default void MethodCommon()
//    {
//        System.out.println("111");
//        System.out.println("222");
//        System.out.println("333");
//    }
    // ↑ 这样问题也算解决了，但是这样的实现类能够单独使用MethodCommon方法，所以还得继续优化


    //使用静态方法
//    private static void MethodCommon()
//    {
//        System.out.println("111");
//        System.out.println("222");
//        System.out.println("333");
//    }
}

