package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/8/9.
 */

public class loadType {

    /**
     * date : Thu, 09 Aug 2018 04:15:40 GMT
     * content-length : 152
     * content-type : text/plain;charset=UTF-8
     */

    private String date;
    @SerializedName("content-length")
    private String contentlength;
    @SerializedName("content-type")
    private String contenttype;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContentlength() {
        return contentlength;
    }

    public void setContentlength(String contentlength) {
        this.contentlength = contentlength;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }
}
