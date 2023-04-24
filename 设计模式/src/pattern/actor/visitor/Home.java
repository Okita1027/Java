package pattern.actor.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName Home
 * @Description 对象结构（Object Structure）角色：定义当中所提到的对象结构，对象结构是一个抽象表述，
 * 具体点可以理解为一个具有容器性质或者复合对象特性的类，它会含有一组元素（ Element ），并且可以迭代这些元素，供访问者访问。
 * @Date 2022/12/24 19:25 星期六
 */
public class Home {
    private List<Animal> animalList;

    public Home() {
        animalList = new ArrayList<>();
    }

    public void action(Person person) {
        for (Animal animal : animalList) {
            animal.accept(person);
        }
    }

    //添加操作
    public void add(Animal animal) {
        animalList.add(animal);
    }
}
