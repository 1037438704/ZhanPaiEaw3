package zpe.jiakeyi.com.zhanpaieaw.library.bean;

/**
 * Created by Administrator on 2018/8/28.
 */

public class ImgPostBean {
    /**
     * code : 1
     * msg : success
     * data : {"imgUrl":"http://39.107.254.193/ossfs/img/153544589946339822.jpg"}
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
        /**
         * imgUrl : http://39.107.254.193/ossfs/img/153544589946339822.jpg
         */

        private String imgUrl;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
