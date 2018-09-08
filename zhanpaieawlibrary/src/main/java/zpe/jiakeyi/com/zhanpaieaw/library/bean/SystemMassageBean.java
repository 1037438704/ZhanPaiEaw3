package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */

public class SystemMassageBean {

    /**
     * code : 1
     * msg : success
     * data : {"list":[{"id":4,"loginId":"0d4fbd3293854028b9529af5b51319d8","readStatus":0,"title":"系统消息","content":"充值50000已到账","groupId":null,"type":null,"createTime":"2018-08-14 21:05:15.0","readTima":null,"delFlag":0,"imgUrl":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153414750538638227.png"},{"id":3,"loginId":"0d4fbd3293854028b9529af5b51319d8","readStatus":0,"title":"系统消息","content":"账户余额不足","groupId":null,"type":null,"createTime":"2018-08-14 21:05:13.0","readTima":null,"delFlag":0,"imgUrl":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153414750538638227.png"},{"id":2,"loginId":"0d4fbd3293854028b9529af5b51319d8","readStatus":0,"title":"系统消息","content":"您的公司资料审核已经通过","groupId":null,"type":null,"createTime":"2018-08-14 21:05:10.0","readTima":null,"delFlag":0,"imgUrl":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153414663420801544.png"},{"id":1,"loginId":"0d4fbd3293854028b9529af5b51319d8","readStatus":0,"title":"系统消息","content":"您的展馆开通成功","groupId":null,"type":null,"createTime":"2018-08-03 14:46:52.0","readTima":null,"delFlag":0,"imgUrl":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153414663420801544.png"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 4
             * loginId : 0d4fbd3293854028b9529af5b51319d8
             * readStatus : 0
             * title : 系统消息
             * content : 充值50000已到账
             * groupId : null
             * type : null
             * createTime : 2018-08-14 21:05:15.0
             * readTima : null
             * delFlag : 0
             * imgUrl : https://jkytest.oss-cn-beijing.aliyuncs.com/img/153414750538638227.png
             */

            private int id;
            private String loginId;
            private int readStatus;
            private String title;
            private String content;
            private Object groupId;
            private Object type;
            private String createTime;
            private Object readTima;
            private int delFlag;
            private String imgUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLoginId() {
                return loginId;
            }

            public void setLoginId(String loginId) {
                this.loginId = loginId;
            }

            public int getReadStatus() {
                return readStatus;
            }

            public void setReadStatus(int readStatus) {
                this.readStatus = readStatus;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Object getGroupId() {
                return groupId;
            }

            public void setGroupId(Object groupId) {
                this.groupId = groupId;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getReadTima() {
                return readTima;
            }

            public void setReadTima(Object readTima) {
                this.readTima = readTima;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }
    }
}
