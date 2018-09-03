package zpe.jiakeyi.com.zhanpaieaw.bean;

/**
 * Created by Administrator on 2018/8/15.
 */

public class LoginBeanCode {
    /**
     * code : 1
     * msg : success
     * data : {"userInfo":{"id":"c714cf2c528f40d5b4108a3ca52b21db","account":"tianma","password":"e10adc3949ba59abbe56e057f20f883e","username":"天马恒基","nickname":"tianma","viaUrl":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153198096951057437.png","sex":true,"loginState":null,"postId":1,"postName":null,"messageId":null,"iphone":"17633369350","qq":"12345678901111","mail":"12345678901111","wechat":"1212121212","wechatQr":null,"firmId":"1","status":null,"delFlag":0,"createTime":"2018-08-03 17:06:45.0"},"ACCESS_TOKEN":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ0aWFubWEiLCJpYXQiOjE1MzU5NDM0NTUsInN1YiI6ImpreS5hZG1pbi51c2VyIiwiaXNzIjoid3d3LmpreS5jb20iLCJleHAiOjE1MzU5Nzk0NTV9.C5_MLnPdSUbI4Vw1Scqe6uxQWaMWLdNq4Sc6BU0Obdc","imUserInfo":{"id":"c714cf2c528f40d5b4108a3ca52b21db","userName":"tianma","password":"123456","nickName":"天马昵称我给改了6不6","icon":"https://jkytest.oss-cn-beijing.aliyuncs.com/staticimg/00touxiang_handou.jpg","imType":null,"imStatus":null,"createTime":null}}
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
         * userInfo : {"id":"c714cf2c528f40d5b4108a3ca52b21db","account":"tianma","password":"e10adc3949ba59abbe56e057f20f883e","username":"天马恒基","nickname":"tianma","viaUrl":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153198096951057437.png","sex":true,"loginState":null,"postId":1,"postName":null,"messageId":null,"iphone":"17633369350","qq":"12345678901111","mail":"12345678901111","wechat":"1212121212","wechatQr":null,"firmId":"1","status":null,"delFlag":0,"createTime":"2018-08-03 17:06:45.0"}
         * ACCESS_TOKEN : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ0aWFubWEiLCJpYXQiOjE1MzU5NDM0NTUsInN1YiI6ImpreS5hZG1pbi51c2VyIiwiaXNzIjoid3d3LmpreS5jb20iLCJleHAiOjE1MzU5Nzk0NTV9.C5_MLnPdSUbI4Vw1Scqe6uxQWaMWLdNq4Sc6BU0Obdc
         * imUserInfo : {"id":"c714cf2c528f40d5b4108a3ca52b21db","userName":"tianma","password":"123456","nickName":"天马昵称我给改了6不6","icon":"https://jkytest.oss-cn-beijing.aliyuncs.com/staticimg/00touxiang_handou.jpg","imType":null,"imStatus":null,"createTime":null}
         */

        private UserInfoBean userInfo;
        private String ACCESS_TOKEN;
        private ImUserInfoBean imUserInfo;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public String getACCESS_TOKEN() {
            return ACCESS_TOKEN;
        }

        public void setACCESS_TOKEN(String ACCESS_TOKEN) {
            this.ACCESS_TOKEN = ACCESS_TOKEN;
        }

        public ImUserInfoBean getImUserInfo() {
            return imUserInfo;
        }

        public void setImUserInfo(ImUserInfoBean imUserInfo) {
            this.imUserInfo = imUserInfo;
        }

        public static class UserInfoBean {
            /**
             * id : c714cf2c528f40d5b4108a3ca52b21db
             * account : tianma
             * password : e10adc3949ba59abbe56e057f20f883e
             * username : 天马恒基
             * nickname : tianma
             * viaUrl : https://jkytest.oss-cn-beijing.aliyuncs.com/img/153198096951057437.png
             * sex : true
             * loginState : null
             * postId : 1
             * postName : null
             * messageId : null
             * iphone : 17633369350
             * qq : 12345678901111
             * mail : 12345678901111
             * wechat : 1212121212
             * wechatQr : null
             * firmId : 1
             * status : null
             * delFlag : 0
             * createTime : 2018-08-03 17:06:45.0
             */

            private String id;
            private String account;
            private String password;
            private String username;
            private String nickname;
            private String viaUrl;
            private boolean sex;
            private Object loginState;
            private int postId;
            private Object postName;
            private Object messageId;
            private String iphone;
            private String qq;
            private String mail;
            private String wechat;
            private Object wechatQr;
            private String firmId;
            private Object status;
            private int delFlag;
            private String createTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getViaUrl() {
                return viaUrl;
            }

            public void setViaUrl(String viaUrl) {
                this.viaUrl = viaUrl;
            }

            public boolean isSex() {
                return sex;
            }

            public void setSex(boolean sex) {
                this.sex = sex;
            }

            public Object getLoginState() {
                return loginState;
            }

            public void setLoginState(Object loginState) {
                this.loginState = loginState;
            }

            public int getPostId() {
                return postId;
            }

            public void setPostId(int postId) {
                this.postId = postId;
            }

            public Object getPostName() {
                return postName;
            }

            public void setPostName(Object postName) {
                this.postName = postName;
            }

            public Object getMessageId() {
                return messageId;
            }

            public void setMessageId(Object messageId) {
                this.messageId = messageId;
            }

            public String getIphone() {
                return iphone;
            }

            public void setIphone(String iphone) {
                this.iphone = iphone;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getWechat() {
                return wechat;
            }

            public void setWechat(String wechat) {
                this.wechat = wechat;
            }

            public Object getWechatQr() {
                return wechatQr;
            }

            public void setWechatQr(Object wechatQr) {
                this.wechatQr = wechatQr;
            }

            public String getFirmId() {
                return firmId;
            }

            public void setFirmId(String firmId) {
                this.firmId = firmId;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }

        public static class ImUserInfoBean {
            /**
             * id : c714cf2c528f40d5b4108a3ca52b21db
             * userName : tianma
             * password : 123456
             * nickName : 天马昵称我给改了6不6
             * icon : https://jkytest.oss-cn-beijing.aliyuncs.com/staticimg/00touxiang_handou.jpg
             * imType : null
             * imStatus : null
             * createTime : null
             */

            private String id;
            private String userName;
            private String password;
            private String nickName;
            private String icon;
            private Object imType;
            private Object imStatus;
            private Object createTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getImType() {
                return imType;
            }

            public void setImType(Object imType) {
                this.imType = imType;
            }

            public Object getImStatus() {
                return imStatus;
            }

            public void setImStatus(Object imStatus) {
                this.imStatus = imStatus;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }
        }
    }
}
