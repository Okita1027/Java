package pattern.actor.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qzy
 * @ClassName Order
 * @Description 客户的订单
 * @Date 2022/12/22 18:04 星期四
 */
public class Order {

    private int tableNum;
    private Map<String, Integer> foodDic;

    public Order() {
        foodDic = new HashMap<>();
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public Map<String, Integer> getFoodDic() {
        return foodDic;
    }

    public void setFoodDic(String key, int num) {
        foodDic.put(key, num);
    }
}
