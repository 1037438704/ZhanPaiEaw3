package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import com.kongzue.baseframework.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/8/10.
 */

public class CityBean extends BaseAdapter.BaseDataBean {

    private List<ListBeanXX> list;

    public List<ListBeanXX> getList() {
        return list;
    }

    public void setList(List<ListBeanXX> list) {
        this.list = list;
    }

    public static class ListBeanXX extends BaseAdapter.BaseDataBean {
        /**
         * areaCode : Beijing
         * areaName : 北京
         * areaParentId : 0
         * id : 110000
         * levels : 1
         * list : [{"areaCode":"Beijing","areaName":"北京市","areaParentId":110000,"id":110100,"levels":2,"list":[{"areaCode":"Dongcheng","areaName":"东城区","areaParentId":110100,"id":110101,"levels":3,"list":[]},{"areaCode":"Xicheng","areaName":"西城区","areaParentId":110100,"id":110102,"levels":3,"list":[]},{"areaCode":"Chaoyang","areaName":"朝阳区","areaParentId":110100,"id":110105,"levels":3,"list":[]},{"areaCode":"Fengtai","areaName":"丰台区","areaParentId":110100,"id":110106,"levels":3,"list":[]},{"areaCode":"Shijingshan","areaName":"石景山区","areaParentId":110100,"id":110107,"levels":3,"list":[]},{"areaCode":"Haidian","areaName":"海淀区","areaParentId":110100,"id":110108,"levels":3,"list":[]},{"areaCode":"Mentougou","areaName":"门头沟区","areaParentId":110100,"id":110109,"levels":3,"list":[]},{"areaCode":"Fangshan","areaName":"房山区","areaParentId":110100,"id":110111,"levels":3,"list":[]},{"areaCode":"Tongzhou","areaName":"通州区","areaParentId":110100,"id":110112,"levels":3,"list":[]},{"areaCode":"Shunyi","areaName":"顺义区","areaParentId":110100,"id":110113,"levels":3,"list":[]},{"areaCode":"Changping","areaName":"昌平区","areaParentId":110100,"id":110114,"levels":3,"list":[]},{"areaCode":"Daxing","areaName":"大兴区","areaParentId":110100,"id":110115,"levels":3,"list":[]},{"areaCode":"Huairou","areaName":"怀柔区","areaParentId":110100,"id":110116,"levels":3,"list":[]},{"areaCode":"Pinggu","areaName":"平谷区","areaParentId":110100,"id":110117,"levels":3,"list":[]},{"areaCode":"Miyun","areaName":"密云县","areaParentId":110100,"id":110228,"levels":3,"list":[]},{"areaCode":"Yanqing","areaName":"延庆县","areaParentId":110100,"id":110229,"levels":3,"list":[]}]}]
         */

        private String areaCode;
        private String areaName;
        private int areaParentId;
        private int id;
        private int levels;
        private List<ListBeanX> list;

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public int getAreaParentId() {
            return areaParentId;
        }

        public void setAreaParentId(int areaParentId) {
            this.areaParentId = areaParentId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevels() {
            return levels;
        }

        public void setLevels(int levels) {
            this.levels = levels;
        }

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public static class ListBeanX extends BaseAdapter.BaseDataBean {
            /**
             * areaCode : Beijing
             * areaName : 北京市
             * areaParentId : 110000
             * id : 110100
             * levels : 2
             * list : [{"areaCode":"Dongcheng","areaName":"东城区","areaParentId":110100,"id":110101,"levels":3,"list":[]},{"areaCode":"Xicheng","areaName":"西城区","areaParentId":110100,"id":110102,"levels":3,"list":[]},{"areaCode":"Chaoyang","areaName":"朝阳区","areaParentId":110100,"id":110105,"levels":3,"list":[]},{"areaCode":"Fengtai","areaName":"丰台区","areaParentId":110100,"id":110106,"levels":3,"list":[]},{"areaCode":"Shijingshan","areaName":"石景山区","areaParentId":110100,"id":110107,"levels":3,"list":[]},{"areaCode":"Haidian","areaName":"海淀区","areaParentId":110100,"id":110108,"levels":3,"list":[]},{"areaCode":"Mentougou","areaName":"门头沟区","areaParentId":110100,"id":110109,"levels":3,"list":[]},{"areaCode":"Fangshan","areaName":"房山区","areaParentId":110100,"id":110111,"levels":3,"list":[]},{"areaCode":"Tongzhou","areaName":"通州区","areaParentId":110100,"id":110112,"levels":3,"list":[]},{"areaCode":"Shunyi","areaName":"顺义区","areaParentId":110100,"id":110113,"levels":3,"list":[]},{"areaCode":"Changping","areaName":"昌平区","areaParentId":110100,"id":110114,"levels":3,"list":[]},{"areaCode":"Daxing","areaName":"大兴区","areaParentId":110100,"id":110115,"levels":3,"list":[]},{"areaCode":"Huairou","areaName":"怀柔区","areaParentId":110100,"id":110116,"levels":3,"list":[]},{"areaCode":"Pinggu","areaName":"平谷区","areaParentId":110100,"id":110117,"levels":3,"list":[]},{"areaCode":"Miyun","areaName":"密云县","areaParentId":110100,"id":110228,"levels":3,"list":[]},{"areaCode":"Yanqing","areaName":"延庆县","areaParentId":110100,"id":110229,"levels":3,"list":[]}]
             */

            private String areaCode;
            private String areaName;
            private int areaParentId;
            private int id;
            private int levels;
            private List<ListBean> list;
            public boolean xuanze;

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public int getAreaParentId() {
                return areaParentId;
            }

            public void setAreaParentId(int areaParentId) {
                this.areaParentId = areaParentId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLevels() {
                return levels;
            }

            public void setLevels(int levels) {
                this.levels = levels;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean extends BaseAdapter.BaseDataBean {
                /**
                 * areaCode : Dongcheng
                 * areaName : 东城区
                 * areaParentId : 110100
                 * id : 110101
                 * levels : 3
                 * list : []
                 */

                private String areaCode;
                private String areaName;
                private int areaParentId;
                private int id;
                private int levels;
                private List<?> list;

                public String getAreaCode() {
                    return areaCode;
                }

                public void setAreaCode(String areaCode) {
                    this.areaCode = areaCode;
                }

                public String getAreaName() {
                    return areaName;
                }

                public void setAreaName(String areaName) {
                    this.areaName = areaName;
                }

                public int getAreaParentId() {
                    return areaParentId;
                }

                public void setAreaParentId(int areaParentId) {
                    this.areaParentId = areaParentId;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getLevels() {
                    return levels;
                }

                public void setLevels(int levels) {
                    this.levels = levels;
                }

                public List<?> getList() {
                    return list;
                }

                public void setList(List<?> list) {
                    this.list = list;
                }
            }

            @Override
            public String toString() {
                return "ListBeanX{" +
                        "areaCode='" + areaCode + '\'' +
                        ", areaName='" + areaName + '\'' +
                        ", areaParentId=" + areaParentId +
                        ", id=" + id +
                        ", levels=" + levels +
                        ", list=" + list +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ListBeanXX{" +
                    "areaCode='" + areaCode + '\'' +
                    ", areaName='" + areaName + '\'' +
                    ", areaParentId=" + areaParentId +
                    ", id=" + id +
                    ", levels=" + levels +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "list=" + list +
                '}';
    }
}
