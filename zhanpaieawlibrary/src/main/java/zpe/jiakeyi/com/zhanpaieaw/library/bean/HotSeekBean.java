package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */

public class HotSeekBean {

    /**
     * code : 1
     * msg : success
     * data : {"list":["烧杯","北京力高泰科技有限公司","瓷盘","岛津色谱仪","天马天平","上海邦安检测工程有限公司"]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<String> list;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
