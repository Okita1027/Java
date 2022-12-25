package pattern.actor.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qzy
 * @ClassName Home
 * @Description TODO(一句话描述该类功能)
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
