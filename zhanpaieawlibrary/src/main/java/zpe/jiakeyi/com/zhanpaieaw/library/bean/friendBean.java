package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */

public class friendBean {
    /**
     * code : 1
     * msg : success
     * data : {"friendList":[{"id":"4d767260e2194259a4c4be0542fd4f20","userName":"15226678936","password":null,"nickName":"个人用户","icon":"https://jkytest.oss-cn-beijing.aliyuncs.com/staticimg/00touxiang_handou.jpg","imType":null,"imStatus":null,"createTime":null}]}
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
        private List<FriendListBean> friendList;

        public List<FriendListBean> getFriendList() {
            return friendList;
        }

        public void setFriendList(List<FriendListBean> friendList) {
            this.friendList = friendList;
        }

        public static class FriendListBean {
            /**
             * id : 4d767260e2194259a4c4be0542fd4f20
             * userName : 15226678936
             * password : null
             * nickName : 个人用户
             * icon : https://jkytest.oss-cn-beijing.aliyuncs.com/staticimg/00touxiang_handou.jpg
             * imType : null
             * imStatus : null
             * createTime : null
             */

            private String id;
            private String userName;
            private Object password;
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

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
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
