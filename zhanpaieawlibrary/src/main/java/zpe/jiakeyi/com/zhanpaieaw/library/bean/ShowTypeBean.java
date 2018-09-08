package zpe.jiakeyi.com.zhanpaieaw.library.bean;

/**
 * Created by Administrator on 2018/8/8.
 */
public class ShowTypeBean {
    public String name;
    //控制对号
    public boolean judge;

    public ShowTypeBean(String name, boolean judge) {
        this.name = name;
        this.judge = judge;
    }

    @Override
    public String toString() {
        return "ShowTypeBean{" +
                "name='" + name + '\'' +
                ", judge=" + judge +
                '}';
    }
}