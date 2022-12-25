package pattern.actor.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qzy
 * @ClassName Context
 * @Description 环境（Context）角色：通常包含各个解释器需要的数据或是公共的功能，一般用来传递被所有
 * 解释器共享的数据，后面的解释器可以从这里获取这些值。
 * @Date 2022/12/25 15:39 星期日
 */
public class Context {
    private Map<Variable, Integer> map;

    public Context() {
        map = new HashMap<>();
    }

    public void assign(Variable variable, Integer value) {
        map.put(variable, value);
    }

    public int getValue(Variable variable) {
        return map.get(variable);
    }
}
