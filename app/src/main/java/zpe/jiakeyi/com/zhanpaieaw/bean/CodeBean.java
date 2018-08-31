package zpe.jiakeyi.com.zhanpaieaw.bean;

/**
 * Created by Administrator on 2018/8/31.
 */

public class CodeBean {
    /**
     * code : -1
     * msg : 验证码错误
     * data : null
     */

    private int code;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
