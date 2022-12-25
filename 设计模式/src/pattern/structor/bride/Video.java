package pattern.structor.bride;

/**
 * @Author qzy
 * @ClassName Video
 * @Description 扩展抽象化（Refined Abstraction）角色 ：是抽象化角色的子类，实现父类中的业务方法，
 *              并通过组合关系调用实现化角色中的业务方法。
 * @Date 2022/12/21 14:24 星期三
 */
public interface Video {
    void decode(String fileName);
}
