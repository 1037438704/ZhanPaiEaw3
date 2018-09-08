package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */

public class NewsListBean {

    /**
     * code : 1
     * data : {"list":{"endRow":3,"firstPage":0,"hasNextPage":false,"hasPreviousPage":false,"isFirstPage":true,"isLastPage":true,"lastPage":0,"list":[{"author":"作者","competitive":0,"coverImg":"http://mmbiz.qpic.cn/mmbiz_gif/GlRBxeGTadHLibytfnJwroITQyzZIaOIz7BxTR6iatnTcZpLK7S1KpNkGBTC3nnawb4IibXKDEK6B7mNDb3ZwVVcA/0?tp=webp&wxfrom=5&wx_lazy=1","createTime":"2018-07-12 17:47:06.0","delFlag":0,"id":"1","intro":"为进一步促进天津市会展业改革创新，推动实","loginId":"userId","pageView":1,"source":"微信","sourceUrl":"https://mp.weixin.qq.com/s?__biz=MzIwMjIyNjgzOQ==&mid=2247486415&idx=1&sn=50e6d127cd8b2fca9fe5ad98ca189d29&chksm=96e0a637a1972f21136cb59b575d1bbe0ee464c8283047884d2149a3d5c4565d2c0000685895&mpshare=1&scene=1&srcid=0726IHd8awCwVP0VHem64Ymn#rd","stickState":1,"title":"12号","typeId":1},{"author":"11111111111","competitive":1,"coverImg":"11111111111","createTime":"2018-07-26 18:25:09.0","delFlag":0,"id":"3","intro":"11111111111","loginId":"11111111111","pageView":0,"source":"11111111111","sourceUrl":"11111111111","stickState":0,"title":"26号","typeId":1},{"author":"无","competitive":1,"coverImg":"无","createTime":"2018-07-19 18:00:57.0","delFlag":0,"id":"2","intro":"传统气相色谱检测器很难胜任气体中痕量物质","loginId":"123","pageView":3,"source":"123","sourceUrl":"123","stickState":0,"title":"19号","typeId":1}],"navigateFirstPage":0,"navigateLastPage":0,"navigatePages":8,"navigatepageNums":[],"nextPage":0,"pageNum":1,"pageSize":0,"pages":0,"prePage":0,"size":3,"startRow":1,"total":3}}
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
         * list : {"endRow":3,"firstPage":0,"hasNextPage":false,"hasPreviousPage":false,"isFirstPage":true,"isLastPage":true,"lastPage":0,"list":[{"author":"作者","competitive":0,"coverImg":"http://mmbiz.qpic.cn/mmbiz_gif/GlRBxeGTadHLibytfnJwroITQyzZIaOIz7BxTR6iatnTcZpLK7S1KpNkGBTC3nnawb4IibXKDEK6B7mNDb3ZwVVcA/0?tp=webp&wxfrom=5&wx_lazy=1","createTime":"2018-07-12 17:47:06.0","delFlag":0,"id":"1","intro":"为进一步促进天津市会展业改革创新，推动实","loginId":"userId","pageView":1,"source":"微信","sourceUrl":"https://mp.weixin.qq.com/s?__biz=MzIwMjIyNjgzOQ==&mid=2247486415&idx=1&sn=50e6d127cd8b2fca9fe5ad98ca189d29&chksm=96e0a637a1972f21136cb59b575d1bbe0ee464c8283047884d2149a3d5c4565d2c0000685895&mpshare=1&scene=1&srcid=0726IHd8awCwVP0VHem64Ymn#rd","stickState":1,"title":"12号","typeId":1},{"author":"11111111111","competitive":1,"coverImg":"11111111111","createTime":"2018-07-26 18:25:09.0","delFlag":0,"id":"3","intro":"11111111111","loginId":"11111111111","pageView":0,"source":"11111111111","sourceUrl":"11111111111","stickState":0,"title":"26号","typeId":1},{"author":"无","competitive":1,"coverImg":"无","createTime":"2018-07-19 18:00:57.0","delFlag":0,"id":"2","intro":"传统气相色谱检测器很难胜任气体中痕量物质","loginId":"123","pageView":3,"source":"123","sourceUrl":"123","stickState":0,"title":"19号","typeId":1}],"navigateFirstPage":0,"navigateLastPage":0,"navigatePages":8,"navigatepageNums":[],"nextPage":0,"pageNum":1,"pageSize":0,"pages":0,"prePage":0,"size":3,"startRow":1,"total":3}
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
             * endRow : 3
             * firstPage : 0
             * hasNextPage : false
             * hasPreviousPage : false
             * isFirstPage : true
             * isLastPage : true
             * lastPage : 0
             * list : [{"author":"作者","competitive":0,"coverImg":"http://mmbiz.qpic.cn/mmbiz_gif/GlRBxeGTadHLibytfnJwroITQyzZIaOIz7BxTR6iatnTcZpLK7S1KpNkGBTC3nnawb4IibXKDEK6B7mNDb3ZwVVcA/0?tp=webp&wxfrom=5&wx_lazy=1","createTime":"2018-07-12 17:47:06.0","delFlag":0,"id":"1","intro":"为进一步促进天津市会展业改革创新，推动实","loginId":"userId","pageView":1,"source":"微信","sourceUrl":"https://mp.weixin.qq.com/s?__biz=MzIwMjIyNjgzOQ==&mid=2247486415&idx=1&sn=50e6d127cd8b2fca9fe5ad98ca189d29&chksm=96e0a637a1972f21136cb59b575d1bbe0ee464c8283047884d2149a3d5c4565d2c0000685895&mpshare=1&scene=1&srcid=0726IHd8awCwVP0VHem64Ymn#rd","stickState":1,"title":"12号","typeId":1},{"author":"11111111111","competitive":1,"coverImg":"11111111111","createTime":"2018-07-26 18:25:09.0","delFlag":0,"id":"3","intro":"11111111111","loginId":"11111111111","pageView":0,"source":"11111111111","sourceUrl":"11111111111","stickState":0,"title":"26号","typeId":1},{"author":"无","competitive":1,"coverImg":"无","createTime":"2018-07-19 18:00:57.0","delFlag":0,"id":"2","intro":"传统气相色谱检测器很难胜任气体中痕量物质","loginId":"123","pageView":3,"source":"123","sourceUrl":"123","stickState":0,"title":"19号","typeId":1}]
             * navigateFirstPage : 0
             * navigateLastPage : 0
             * navigatePages : 8
             * navigatepageNums : []
             * nextPage : 0
             * pageNum : 1
             * pageSize : 0
             * pages : 0
             * prePage : 0
             * size : 3
             * startRow : 1
             * total : 3
             */

            private int endRow;
            private int firstPage;
            private boolean hasNextPage;
            private boolean hasPreviousPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private int lastPage;
            private int navigateFirstPage;
            private int navigateLastPage;
            private int navigatePages;
            private int nextPage;
            private int pageNum;
            private int pageSize;
            private int pages;
            private int prePage;
            private int size;
            private int startRow;
            private int total;
            private List<ListBean> list;
            private List<?> navigatepageNums;

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
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

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
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

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

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

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<?> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<?> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * author : 作者
                 * competitive : 0
                 * coverImg : http://mmbiz.qpic.cn/mmbiz_gif/GlRBxeGTadHLibytfnJwroITQyzZIaOIz7BxTR6iatnTcZpLK7S1KpNkGBTC3nnawb4IibXKDEK6B7mNDb3ZwVVcA/0?tp=webp&wxfrom=5&wx_lazy=1
                 * createTime : 2018-07-12 17:47:06.0
                 * delFlag : 0
                 * id : 1
                 * intro : 为进一步促进天津市会展业改革创新，推动实
                 * loginId : userId
                 * pageView : 1
                 * source : 微信
                 * sourceUrl : https://mp.weixin.qq.com/s?__biz=MzIwMjIyNjgzOQ==&mid=2247486415&idx=1&sn=50e6d127cd8b2fca9fe5ad98ca189d29&chksm=96e0a637a1972f21136cb59b575d1bbe0ee464c8283047884d2149a3d5c4565d2c0000685895&mpshare=1&scene=1&srcid=0726IHd8awCwVP0VHem64Ymn#rd
                 * stickState : 1
                 * title : 12号
                 * typeId : 1
                 */

                private String author;
                private int competitive;
                private String coverImg;
                private String createTime;
                private int delFlag;
                private String id;
                private String intro;
                private String loginId;
                private int pageView;
                private String source;
                private String sourceUrl;
                private int stickState;
                private String title;
                private int typeId;

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public int getCompetitive() {
                    return competitive;
                }

                public void setCompetitive(int competitive) {
                    this.competitive = competitive;
                }

                public String getCoverImg() {
                    return coverImg;
                }

                public void setCoverImg(String coverImg) {
                    this.coverImg = coverImg;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
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

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }

                public String getLoginId() {
                    return loginId;
                }

                public void setLoginId(String loginId) {
                    this.loginId = loginId;
                }

                public int getPageView() {
                    return pageView;
                }

                public void setPageView(int pageView) {
                    this.pageView = pageView;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getSourceUrl() {
                    return sourceUrl;
                }

                public void setSourceUrl(String sourceUrl) {
                    this.sourceUrl = sourceUrl;
                }

                public int getStickState() {
                    return stickState;
                }

                public void setStickState(int stickState) {
                    this.stickState = stickState;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTypeId() {
                    return typeId;
                }

                public void setTypeId(int typeId) {
                    this.typeId = typeId;
                }
            }
        }
    }
}
