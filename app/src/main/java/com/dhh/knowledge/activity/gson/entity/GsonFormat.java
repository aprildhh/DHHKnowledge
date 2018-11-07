package com.dhh.knowledge.activity.gson.entity;

import java.util.List;

/**
 * Created by DHH on 2018/11/7.
 * 页面：
 */
public class GsonFormat {

    /**
     * 步骤：
     * 右键--》Generate-->GsonFormat-->把json字符串粘贴进去--》OK
     */

    /**
     * success : true
     * data : {"page":10,"pageCount":29,"list":[{"starLevel":4,"remarkCotnent":"评价方未及时做出评价，系统默认满意！","remarkTime":"2013-02-27 07:21:48","explainContent":"","postMemberId":"y**f","tpLogoURL":"http://i04.c.aliimg.com/cms/upload/2012/186/684/486681_1232736939.png"},{"starLevel":4,"remarkCotnent":"评价方未及时做出评价，系统默认满意！","remarkTime":"2013-02-27 07:21:48","explainContent":"","postMemberId":"y**f","tpLogoURL":"http://i04.c.aliimg.com/cms/upload/2012/186/684/486681_1232736939.png"}],"statistics":{"star5":20,"star4":40,"star3":30,"star2":10,"star1":0}}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * page : 10
         * pageCount : 29
         * list : [{"starLevel":4,"remarkCotnent":"评价方未及时做出评价，系统默认满意！","remarkTime":"2013-02-27 07:21:48","explainContent":"","postMemberId":"y**f","tpLogoURL":"http://i04.c.aliimg.com/cms/upload/2012/186/684/486681_1232736939.png"},{"starLevel":4,"remarkCotnent":"评价方未及时做出评价，系统默认满意！","remarkTime":"2013-02-27 07:21:48","explainContent":"","postMemberId":"y**f","tpLogoURL":"http://i04.c.aliimg.com/cms/upload/2012/186/684/486681_1232736939.png"}]
         * statistics : {"star5":20,"star4":40,"star3":30,"star2":10,"star1":0}
         */

        private int page;
        private int pageCount;
        private StatisticsBean statistics;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public StatisticsBean getStatistics() {
            return statistics;
        }

        public void setStatistics(StatisticsBean statistics) {
            this.statistics = statistics;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class StatisticsBean {
            /**
             * star5 : 20
             * star4 : 40
             * star3 : 30
             * star2 : 10
             * star1 : 0
             */

            private int star5;
            private int star4;
            private int star3;
            private int star2;
            private int star1;

            public int getStar5() {
                return star5;
            }

            public void setStar5(int star5) {
                this.star5 = star5;
            }

            public int getStar4() {
                return star4;
            }

            public void setStar4(int star4) {
                this.star4 = star4;
            }

            public int getStar3() {
                return star3;
            }

            public void setStar3(int star3) {
                this.star3 = star3;
            }

            public int getStar2() {
                return star2;
            }

            public void setStar2(int star2) {
                this.star2 = star2;
            }

            public int getStar1() {
                return star1;
            }

            public void setStar1(int star1) {
                this.star1 = star1;
            }
        }

        public static class ListBean {
            /**
             * starLevel : 4
             * remarkCotnent : 评价方未及时做出评价，系统默认满意！
             * remarkTime : 2013-02-27 07:21:48
             * explainContent :
             * postMemberId : y**f
             * tpLogoURL : http://i04.c.aliimg.com/cms/upload/2012/186/684/486681_1232736939.png
             */

            private int starLevel;
            private String remarkCotnent;
            private String remarkTime;
            private String explainContent;
            private String postMemberId;
            private String tpLogoURL;

            public int getStarLevel() {
                return starLevel;
            }

            public void setStarLevel(int starLevel) {
                this.starLevel = starLevel;
            }

            public String getRemarkCotnent() {
                return remarkCotnent;
            }

            public void setRemarkCotnent(String remarkCotnent) {
                this.remarkCotnent = remarkCotnent;
            }

            public String getRemarkTime() {
                return remarkTime;
            }

            public void setRemarkTime(String remarkTime) {
                this.remarkTime = remarkTime;
            }

            public String getExplainContent() {
                return explainContent;
            }

            public void setExplainContent(String explainContent) {
                this.explainContent = explainContent;
            }

            public String getPostMemberId() {
                return postMemberId;
            }

            public void setPostMemberId(String postMemberId) {
                this.postMemberId = postMemberId;
            }

            public String getTpLogoURL() {
                return tpLogoURL;
            }

            public void setTpLogoURL(String tpLogoURL) {
                this.tpLogoURL = tpLogoURL;
            }
        }
    }
}
