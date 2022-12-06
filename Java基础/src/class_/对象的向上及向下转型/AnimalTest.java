package class_.对象的向上及向下转型;

public class AnimalTest
{
    public static void main(String[] args)
    {
        //对象的向上转型：把猫看做一个动物
        Animal animal = new Cat();
        animal.eat();
        //向上转型绝对正确，但无法使用子类特有的方法
        //animal.sharp();       //error
//
//        //对象的向下转型：先前看做动物的猫还原为猫
//        Class.Cat cat = (Class.Cat) animal;
//        cat.eat();
//        cat.sharp();
//        animal.eat();
//        ((Class.Cat) animal).sharp();

        //但不能把猫还原成狗
        //编译不会报错，但运行会出现异常
//        Class.Dog dog = (Class.Dog) animal;
//        dog.eat();
//        dog.watchHouse();


    }

}
