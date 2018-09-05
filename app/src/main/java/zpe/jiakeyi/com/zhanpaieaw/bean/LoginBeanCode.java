package zpe.jiakeyi.com.zhanpaieaw.bean;

/**
 * Created by Administrator on 2018/8/15.
 */

public class LoginBeanCode {

    /**
     * code : 1
     * msg : success
     * data : {"userInfo":{"id":"b0c96c7f7970476b9e08c377d721ff27","account":"18810379038","password":"e10adc3949ba59abbe56e057f20f883e","username":"18810379038","nickname":null,"viaUrl":null,"sex":null,"loginState":null,"postId":0,"postName":null,"messageId":null,"iphone":"18810379038","qq":null,"mail":null,"wechat":null,"wechatQr":null,"firmId":null,"status":null,"delFlag":0,"createTime":"2018-09-05 00:00:00.0"},"ACCESS_TOKEN":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxODgxMDM3OTAzOCIsImlhdCI6MTUzNjEyODg1Mywic3ViIjoiamt5LmFkbWluLnVzZXIiLCJpc3MiOiJ3d3cuamt5LmNvbSIsImV4cCI6MTUzNjE2NDg1M30.zjp56kPb23u00GzGGDVWSHEw5xXva3fPzpRvenIqKMo","imUserInfo":{"id":"0d4fbd3293854028b9529af5b51319d8","userName":"18810379038","password":"123456","nickName":"18810379038","icon":"https://jkytest.oss-cn-beijing.aliyuncs.com/staticimg/00touxiang_handou.jpg","imType":null,"imStatus":null,"createTime":null}}
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
         * userInfo : {"id":"b0c96c7f7970476b9e08c377d721ff27","account":"18810379038","password":"e10adc3949ba59abbe56e057f20f883e","username":"18810379038","nickname":null,"viaUrl":null,"sex":null,"loginState":null,"postId":0,"postName":null,"messageId":null,"iphone":"18810379038","qq":null,"mail":null,"wechat":null,"wechatQr":null,"firmId":null,"status":null,"delFlag":0,"createTime":"2018-09-05 00:00:00.0"}
         * ACCESS_TOKEN : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxODgxMDM3OTAzOCIsImlhdCI6MTUzNjEyODg1Mywic3ViIjoiamt5LmFkbWluLnVzZXIiLCJpc3MiOiJ3d3cuamt5LmNvbSIsImV4cCI6MTUzNjE2NDg1M30.zjp56kPb23u00GzGGDVWSHEw5xXva3fPzpRvenIqKMo
         * imUserInfo : {"id":"0d4fbd3293854028b9529af5b51319d8","userName":"18810379038","password":"123456","nickName":"18810379038","icon":"https://jkytest.oss-cn-beijing.aliyuncs.com/staticimg/00touxiang_handou.jpg","imType":null,"imStatus":null,"createTime":null}
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
             * id : b0c96c7f7970476b9e08c377d721ff27
             * account : 18810379038
             * password : e10adc3949ba59abbe56e057f20f883e
             * username : 18810379038
             * nickname : null
             * viaUrl : null
             * sex : null
             * loginState : null
             * postId : 0
             * postName : null
             * messageId : null
             * iphone : 18810379038
             * qq : null
             * mail : null
             * wechat : null
             * wechatQr : null
             * firmId : null
             * status : null
             * delFlag : 0
             * createTime : 2018-09-05 00:00:00.0
             */

            private String id;
            private String account;
            private String password;
            private String username;
            private Object nickname;
            private Object viaUrl;
            private Object sex;
            private Object loginState;
            private int postId;
            private Object postName;
            private Object messageId;
            private String iphone;
            private Object qq;
            private Object mail;
            private Object wechat;
            private Object wechatQr;
            private Object firmId;
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

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public Object getViaUrl() {
                return viaUrl;
            }

            public void setViaUrl(Object viaUrl) {
                this.viaUrl = viaUrl;
            }

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
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

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public Object getMail() {
                return mail;
            }

            public void setMail(Object mail) {
                this.mail = mail;
            }

            public Object getWechat() {
                return wechat;
            }

            public void setWechat(Object wechat) {
                this.wechat = wechat;
            }

            public Object getWechatQr() {
                return wechatQr;
            }

            public void setWechatQr(Object wechatQr) {
                this.wechatQr = wechatQr;
            }

            public Object getFirmId() {
                return firmId;
            }

            public void setFirmId(Object firmId) {
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
             * id : 0d4fbd3293854028b9529af5b51319d8
             * userName : 18810379038
             * password : 123456
             * nickName : 18810379038
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
