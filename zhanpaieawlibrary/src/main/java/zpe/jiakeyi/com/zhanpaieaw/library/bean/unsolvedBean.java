package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
//未解决
public class unsolvedBean {

    /**
     * code : 1
     * msg : success
     * data : {"list":{"pageNum":1,"pageSize":10,"size":5,"startRow":1,"endRow":5,"total":5,"pages":1,"list":[{"id":"555","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购试管","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":47,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-30 10:22:52.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"111","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购水平仪","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":9,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-25 18:32:01.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"222","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购测试仪","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":2,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-18 18:32:04.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"333","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购天平","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":1,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-11 18:32:07.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"444","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购显微镜","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":2,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-04 18:32:10.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}}
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
         * list : {"pageNum":1,"pageSize":10,"size":5,"startRow":1,"endRow":5,"total":5,"pages":1,"list":[{"id":"555","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购试管","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":47,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-30 10:22:52.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"111","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购水平仪","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":9,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-25 18:32:01.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"222","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购测试仪","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":2,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-18 18:32:04.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"333","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购天平","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":1,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-11 18:32:07.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"444","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购显微镜","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":2,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-04 18:32:10.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         */

        private ListBeanX list;

        public ListBeanX getList() {
            return list;
        }

        public void setList(ListBeanX list) {
            this.list = list;
        }

        public static class ListBeanX {
            /**
             * pageNum : 1
             * pageSize : 10
             * size : 5
             * startRow : 1
             * endRow : 5
             * total : 5
             * pages : 1
             * list : [{"id":"555","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购试管","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":47,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-30 10:22:52.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"111","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购水平仪","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":9,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-25 18:32:01.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"222","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购测试仪","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":2,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-18 18:32:04.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"333","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购天平","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":1,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-11 18:32:07.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"},{"id":"444","loginId":"0d4fbd3293854028b9529af5b51319d8","title":"title","content":"求购显微镜","solveState":0,"typeA":"实验室仪器","typeAId":1,"addressA":"天津","addressB":"天津","addressC":"南开区","addressAId":1,"addressBId":2,"addressCId":3,"contactOrder":"1","pageView":2,"authentication":0,"createTime":"2018-07-30 10:22:52.0","updateTime":"2018-07-04 18:32:10.0","delFlg":0,"iphoneNo":"13512488886","wechat":"13512488886","qq":"1234567898"}]
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             * navigateFirstPage : 1
             * navigateLastPage : 1
             * firstPage : 1
             * lastPage : 1
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private int firstPage;
            private int lastPage;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * id : 555
                 * loginId : 0d4fbd3293854028b9529af5b51319d8
                 * title : title
                 * content : 求购试管
                 * solveState : 0
                 * typeA : 实验室仪器
                 * typeAId : 1
                 * addressA : 天津
                 * addressB : 天津
                 * addressC : 南开区
                 * addressAId : 1
                 * addressBId : 2
                 * addressCId : 3
                 * contactOrder : 1
                 * pageView : 47
                 * authentication : 0
                 * createTime : 2018-07-30 10:22:52.0
                 * updateTime : 2018-07-30 10:22:52.0
                 * delFlg : 0
                 * iphoneNo : 13512488886
                 * wechat : 13512488886
                 * qq : 1234567898
                 */

                private String id;
                private String loginId;
                private String title;
                private String content;
                private int solveState;
                private String typeA;
                private int typeAId;
                private String addressA;
                private String addressB;
                private String addressC;
                private int addressAId;
                private int addressBId;
                private int addressCId;
                private String contactOrder;
                private int pageView;
                private int authentication;
                private String createTime;
                private String updateTime;
                private int delFlg;
                private String iphoneNo;
                private String wechat;
                private String qq;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getLoginId() {
                    return loginId;
                }

                public void setLoginId(String loginId) {
                    this.loginId = loginId;
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

                public int getSolveState() {
                    return solveState;
                }

                public void setSolveState(int solveState) {
                    this.solveState = solveState;
                }

                public String getTypeA() {
                    return typeA;
                }

                public void setTypeA(String typeA) {
                    this.typeA = typeA;
                }

                public int getTypeAId() {
                    return typeAId;
                }

                public void setTypeAId(int typeAId) {
                    this.typeAId = typeAId;
                }

                public String getAddressA() {
                    return addressA;
                }

                public void setAddressA(String addressA) {
                    this.addressA = addressA;
                }

                public String getAddressB() {
                    return addressB;
                }

                public void setAddressB(String addressB) {
                    this.addressB = addressB;
                }

                public String getAddressC() {
                    return addressC;
                }

                public void setAddressC(String addressC) {
                    this.addressC = addressC;
                }

                public int getAddressAId() {
                    return addressAId;
                }

                public void setAddressAId(int addressAId) {
                    this.addressAId = addressAId;
                }

                public int getAddressBId() {
                    return addressBId;
                }

                public void setAddressBId(int addressBId) {
                    this.addressBId = addressBId;
                }

                public int getAddressCId() {
                    return addressCId;
                }

                public void setAddressCId(int addressCId) {
                    this.addressCId = addressCId;
                }

                public String getContactOrder() {
                    return contactOrder;
                }

                public void setContactOrder(String contactOrder) {
                    this.contactOrder = contactOrder;
                }

                public int getPageView() {
                    return pageView;
                }

                public void setPageView(int pageView) {
                    this.pageView = pageView;
                }

                public int getAuthentication() {
                    return authentication;
                }

                public void setAuthentication(int authentication) {
                    this.authentication = authentication;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getDelFlg() {
                    return delFlg;
                }

                public void setDelFlg(int delFlg) {
                    this.delFlg = delFlg;
                }

                public String getIphoneNo() {
                    return iphoneNo;
                }

                public void setIphoneNo(String iphoneNo) {
                    this.iphoneNo = iphoneNo;
                }

                public String getWechat() {
                    return wechat;
                }

                public void setWechat(String wechat) {
                    this.wechat = wechat;
                }

                public String getQq() {
                    return qq;
                }

                public void setQq(String qq) {
                    this.qq = qq;
                }
            }
        }
    }
}
