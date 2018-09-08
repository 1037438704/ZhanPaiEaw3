package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/8/15.
 */

public class sysBean implements Serializable {

    /**
     * code : 1
     * msg : success
     * data : {"list":[{"id":30,"leaderId":1,"levels":2,"typeName":"分析仪器","orders":3,"img":null,"status":null,"createTime":null,"list":[{"id":7,"leaderId":30,"levels":3,"typeName":"光学仪","orders":1,"img":null,"status":null,"createTime":null,"list":[{"id":27,"leaderId":7,"levels":4,"typeName":"红外热成像仪","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153188464593288046.png","status":null,"createTime":null,"list":[]},{"id":25,"leaderId":7,"levels":4,"typeName":"光源","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153188855638180369.png","status":null,"createTime":null,"list":[]},{"id":24,"leaderId":7,"levels":4,"typeName":"粘度计","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/5img.jpg","status":null,"createTime":null,"list":[]}]},{"id":5,"leaderId":30,"levels":3,"typeName":"电子显微镜","orders":2,"img":null,"status":null,"createTime":null,"list":[{"id":19,"leaderId":5,"levels":4,"typeName":"离心机","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/3img.jpg","status":null,"createTime":null,"list":[]},{"id":14,"leaderId":5,"levels":4,"typeName":"色差仪","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/2img.jpg","status":null,"createTime":null,"list":[]},{"id":13,"leaderId":5,"levels":4,"typeName":"搅拌器","orders":2,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/4img.jpg","status":null,"createTime":null,"list":[]}]},{"id":8,"leaderId":30,"levels":3,"typeName":"光学成像设备","orders":3,"img":null,"status":null,"createTime":null,"list":[]},{"id":6,"leaderId":30,"levels":3,"typeName":"白度仪器","orders":4,"img":null,"status":null,"createTime":null,"list":[]},{"id":9,"leaderId":30,"levels":3,"typeName":"光学实验设备","orders":5,"img":null,"status":null,"createTime":null,"list":[]},{"id":11,"leaderId":30,"levels":3,"typeName":"光学测量仪","orders":6,"img":null,"status":null,"createTime":null,"list":[]},{"id":23,"leaderId":30,"levels":3,"typeName":"光学调整架","orders":8,"img":null,"status":null,"createTime":null,"list":[]},{"id":22,"leaderId":30,"levels":3,"typeName":"光学显微镜","orders":9,"img":null,"status":null,"createTime":null,"list":[]}]}]}
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

    public static class DataBean implements Serializable {
        private List<ListBeanXX> list;

        public List<ListBeanXX> getList() {
            return list;
        }

        public void setList(List<ListBeanXX> list) {
            this.list = list;
        }

        public static class ListBeanXX implements Serializable{
            /**
             * id : 30
             * leaderId : 1
             * levels : 2
             * typeName : 分析仪器
             * orders : 3
             * img : null
             * status : null
             * createTime : null
             * list : [{"id":7,"leaderId":30,"levels":3,"typeName":"光学仪","orders":1,"img":null,"status":null,"createTime":null,"list":[{"id":27,"leaderId":7,"levels":4,"typeName":"红外热成像仪","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153188464593288046.png","status":null,"createTime":null,"list":[]},{"id":25,"leaderId":7,"levels":4,"typeName":"光源","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153188855638180369.png","status":null,"createTime":null,"list":[]},{"id":24,"leaderId":7,"levels":4,"typeName":"粘度计","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/5img.jpg","status":null,"createTime":null,"list":[]}]},{"id":5,"leaderId":30,"levels":3,"typeName":"电子显微镜","orders":2,"img":null,"status":null,"createTime":null,"list":[{"id":19,"leaderId":5,"levels":4,"typeName":"离心机","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/3img.jpg","status":null,"createTime":null,"list":[]},{"id":14,"leaderId":5,"levels":4,"typeName":"色差仪","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/2img.jpg","status":null,"createTime":null,"list":[]},{"id":13,"leaderId":5,"levels":4,"typeName":"搅拌器","orders":2,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/4img.jpg","status":null,"createTime":null,"list":[]}]},{"id":8,"leaderId":30,"levels":3,"typeName":"光学成像设备","orders":3,"img":null,"status":null,"createTime":null,"list":[]},{"id":6,"leaderId":30,"levels":3,"typeName":"白度仪器","orders":4,"img":null,"status":null,"createTime":null,"list":[]},{"id":9,"leaderId":30,"levels":3,"typeName":"光学实验设备","orders":5,"img":null,"status":null,"createTime":null,"list":[]},{"id":11,"leaderId":30,"levels":3,"typeName":"光学测量仪","orders":6,"img":null,"status":null,"createTime":null,"list":[]},{"id":23,"leaderId":30,"levels":3,"typeName":"光学调整架","orders":8,"img":null,"status":null,"createTime":null,"list":[]},{"id":22,"leaderId":30,"levels":3,"typeName":"光学显微镜","orders":9,"img":null,"status":null,"createTime":null,"list":[]}]
             */

            private int id;
            private int leaderId;
            private int levels;
            private String typeName;
            private int orders;
            private Object img;
            private Object status;
            private Object createTime;
            private List<ListBeanX> list;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLeaderId() {
                return leaderId;
            }

            public void setLeaderId(int leaderId) {
                this.leaderId = leaderId;
            }

            public int getLevels() {
                return levels;
            }

            public void setLevels(int levels) {
                this.levels = levels;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public int getOrders() {
                return orders;
            }

            public void setOrders(int orders) {
                this.orders = orders;
            }

            public Object getImg() {
                return img;
            }

            public void setImg(Object img) {
                this.img = img;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX implements Serializable{
                /**
                 * id : 7
                 * leaderId : 30
                 * levels : 3
                 * typeName : 光学仪
                 * orders : 1
                 * img : null
                 * status : null
                 * createTime : null
                 * list : [{"id":27,"leaderId":7,"levels":4,"typeName":"红外热成像仪","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153188464593288046.png","status":null,"createTime":null,"list":[]},{"id":25,"leaderId":7,"levels":4,"typeName":"光源","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/153188855638180369.png","status":null,"createTime":null,"list":[]},{"id":24,"leaderId":7,"levels":4,"typeName":"粘度计","orders":1,"img":"https://jkytest.oss-cn-beijing.aliyuncs.com/img/5img.jpg","status":null,"createTime":null,"list":[]}]
                 */

                private int id;
                private int leaderId;
                private int levels;
                private String typeName;
                private int orders;
                private Object img;
                private Object status;
                private Object createTime;
                private List<ListBean> list;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getLeaderId() {
                    return leaderId;
                }

                public void setLeaderId(int leaderId) {
                    this.leaderId = leaderId;
                }

                public int getLevels() {
                    return levels;
                }

                public void setLevels(int levels) {
                    this.levels = levels;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public int getOrders() {
                    return orders;
                }

                public void setOrders(int orders) {
                    this.orders = orders;
                }

                public Object getImg() {
                    return img;
                }

                public void setImg(Object img) {
                    this.img = img;
                }

                public Object getStatus() {
                    return status;
                }

                public void setStatus(Object status) {
                    this.status = status;
                }

                public Object getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(Object createTime) {
                    this.createTime = createTime;
                }

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean implements Serializable{
                    /**
                     * id : 27
                     * leaderId : 7
                     * levels : 4
                     * typeName : 红外热成像仪
                     * orders : 1
                     * img : https://jkytest.oss-cn-beijing.aliyuncs.com/img/153188464593288046.png
                     * status : null
                     * createTime : null
                     * list : []
                     */

                    private int id;
                    private int leaderId;
                    private int levels;
                    private String typeName;
                    private int orders;
                    private String img;
                    private Object status;
                    private Object createTime;
                    private List<?> list;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getLeaderId() {
                        return leaderId;
                    }

                    public void setLeaderId(int leaderId) {
                        this.leaderId = leaderId;
                    }

                    public int getLevels() {
                        return levels;
                    }

                    public void setLevels(int levels) {
                        this.levels = levels;
                    }

                    public String getTypeName() {
                        return typeName;
                    }

                    public void setTypeName(String typeName) {
                        this.typeName = typeName;
                    }

                    public int getOrders() {
                        return orders;
                    }

                    public void setOrders(int orders) {
                        this.orders = orders;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public Object getStatus() {
                        return status;
                    }

                    public void setStatus(Object status) {
                        this.status = status;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public List<?> getList() {
                        return list;
                    }

                    public void setList(List<?> list) {
                        this.list = list;
                    }
                }
            }
        }
    }
}
