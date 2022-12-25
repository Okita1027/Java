package pattern.actor.responsibility;

/**
 * @Author qzy
 * @ClassName Request
 * @Description 请求
 * @Date 2022/12/23 15:28 星期五
 */
public class Request {
    private String name;
    private int dayNum;
    private String comment;

    public Request(String name, int dayNum, String comment) {
        this.name = name;
        this.dayNum = dayNum;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public int getDayNum() {
        return dayNum;
    }

    public String getComment() {
        return comment;
    }
}
