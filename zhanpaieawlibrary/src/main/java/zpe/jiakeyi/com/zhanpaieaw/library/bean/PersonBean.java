package zpe.jiakeyi.com.zhanpaieaw.library.bean;

/**
 * Created by Administrator on 2018/7/31.
 */

public class PersonBean {

    /**
     * code : 1
     * data : {"user":{"account":"123456","createDate":1533017010000,"delFlag":0,"id":"123","iphone":"13512474747","loginState":0,"mail":"13512474747","messageId":"000","nickname":"三","password":"123456","postId":1,"postName":"游客","qq":"13512474747","username":"张三","viaUrl":"http://www.dzwww.com/xinwen/guojixinwen/201705/W020170503629378532215.jpg","wechat":"13512474747","wechatQr":"2215.jpg"}}
     * msg : success
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * user : {"account":"123456","createDate":1533017010000,"delFlag":0,"id":"123","iphone":"13512474747","loginState":0,"mail":"13512474747","messageId":"000","nickname":"三","password":"123456","postId":1,"postName":"游客","qq":"13512474747","username":"张三","viaUrl":"http://www.dzwww.com/xinwen/guojixinwen/201705/W020170503629378532215.jpg","wechat":"13512474747","wechatQr":"2215.jpg"}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * account : 123456
             * createDate : 1533017010000
             * delFlag : 0
             * id : 123
             * iphone : 13512474747
             * loginState : 0
             * mail : 13512474747
             * messageId : 000
             * nickname : 三
             * password : 123456
             * postId : 1
             * postName : 游客
             * qq : 13512474747
             * username : 张三
             * viaUrl : http://www.dzwww.com/xinwen/guojixinwen/201705/W020170503629378532215.jpg
             * wechat : 13512474747
             * wechatQr : 2215.jpg
             */

            private String account;
            private long createDate;
            private int delFlag;
            private String id;
            private String iphone;
            private int loginState;
            private String mail;
            private String messageId;
            private String nickname;
            private String password;
            private int postId;
            private String postName;
            private String qq;
            private String username;
            private String viaUrl;
            private String wechat;
            private String wechatQr;

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIphone() {
                return iphone;
            }

            public void setIphone(String iphone) {
                this.iphone = iphone;
            }

            public int getLoginState() {
                return loginState;
            }

            public void setLoginState(int loginState) {
                this.loginState = loginState;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getMessageId() {
                return messageId;
            }

            public void setMessageId(String messageId) {
                this.messageId = messageId;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getPostId() {
                return postId;
            }

            public void setPostId(int postId) {
                this.postId = postId;
            }

            public String getPostName() {
                return postName;
            }

            public void setPostName(String postName) {
                this.postName = postName;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getViaUrl() {
                return viaUrl;
            }

            public void setViaUrl(String viaUrl) {
                this.viaUrl = viaUrl;
            }

            public String getWechat() {
                return wechat;
            }

            public void setWechat(String wechat) {
                this.wechat = wechat;
            }

            public String getWechatQr() {
                return wechatQr;
            }

            public void setWechatQr(String wechatQr) {
                this.wechatQr = wechatQr;
            }
        }
    }
}
