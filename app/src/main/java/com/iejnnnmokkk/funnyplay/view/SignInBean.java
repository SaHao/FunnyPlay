package com.iejnnnmokkk.funnyplay.view;

import com.iejnnnmokkk.common.http.bean.BaseBean;

import java.io.Serializable;

public class SignInBean extends BaseBean implements Cloneable {

    /**
     * data : {"dayli_num":1,"dayli_flag":1,"res":{"id":52,"reward_1":6000,"type":1,"create_time":1733735965,"area":1,"daily_type":1,"status":1,"reward_2":10000,"reward_3":30000,"reward_4":10000,"reward_5":10000,"reward_6":50000,"reward_7":20000,"multiple_1":1,"multiple_2":1,"multiple_3":1,"multiple_4":1,"multiple_5":1,"multiple_6":1,"multiple_7":1,"channel":"funny_play,MiniPlay,gameplat"}}
     * count : 0
     */

    private DataBean data;
    private int count;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static class DataBean implements Serializable, Cloneable {
        /**
         * dayli_num : 1
         * dayli_flag : 1
         * res : {"id":52,"reward_1":6000,"type":1,"create_time":1733735965,"area":1,"daily_type":1,"status":1,"reward_2":10000,"reward_3":30000,"reward_4":10000,"reward_5":10000,"reward_6":50000,"reward_7":20000,"multiple_1":1,"multiple_2":1,"multiple_3":1,"multiple_4":1,"multiple_5":1,"multiple_6":1,"multiple_7":1,"channel":"funny_play,MiniPlay,gameplat"}
         */

        private int dayli_num;
        private int dayli_flag;
        private ResBean res;

        public int getDayli_num() {
            return dayli_num;
        }

        public void setDayli_num(int dayli_num) {
            this.dayli_num = dayli_num;
        }

        public int getDayli_flag() {
            return dayli_flag;
        }

        public void setDayli_flag(int dayli_flag) {
            this.dayli_flag = dayli_flag;
        }

        public ResBean getRes() {
            return res;
        }

        public void setRes(ResBean res) {
            this.res = res;
        }

        public static class ResBean implements Serializable, Cloneable {
            /**
             * id : 52
             * reward_1 : 6000
             * type : 1
             * create_time : 1733735965
             * area : 1
             * daily_type : 1
             * status : 1
             * reward_2 : 10000
             * reward_3 : 30000
             * reward_4 : 10000
             * reward_5 : 10000
             * reward_6 : 50000
             * reward_7 : 20000
             * multiple_1 : 1
             * multiple_2 : 1
             * multiple_3 : 1
             * multiple_4 : 1
             * multiple_5 : 1
             * multiple_6 : 1
             * multiple_7 : 1
             * channel : funny_play,MiniPlay,gameplat
             */

            private int id;
            private int reward_1;
            private int type;
            private int create_time;
            private int area;
            private int daily_type;
            private int status;
            private int reward_2;
            private int reward_3;
            private int reward_4;
            private int reward_5;
            private int reward_6;
            private int reward_7;
            private int multiple_1;
            private int multiple_2;
            private int multiple_3;
            private int multiple_4;
            private int multiple_5;
            private int multiple_6;
            private int multiple_7;
            private String channel;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getReward_1() {
                return reward_1;
            }

            public void setReward_1(int reward_1) {
                this.reward_1 = reward_1;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getArea() {
                return area;
            }

            public void setArea(int area) {
                this.area = area;
            }

            public int getDaily_type() {
                return daily_type;
            }

            public void setDaily_type(int daily_type) {
                this.daily_type = daily_type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getReward_2() {
                return reward_2;
            }

            public void setReward_2(int reward_2) {
                this.reward_2 = reward_2;
            }

            public int getReward_3() {
                return reward_3;
            }

            public void setReward_3(int reward_3) {
                this.reward_3 = reward_3;
            }

            public int getReward_4() {
                return reward_4;
            }

            public void setReward_4(int reward_4) {
                this.reward_4 = reward_4;
            }

            public int getReward_5() {
                return reward_5;
            }

            public void setReward_5(int reward_5) {
                this.reward_5 = reward_5;
            }

            public int getReward_6() {
                return reward_6;
            }

            public void setReward_6(int reward_6) {
                this.reward_6 = reward_6;
            }

            public int getReward_7() {
                return reward_7;
            }

            public void setReward_7(int reward_7) {
                this.reward_7 = reward_7;
            }

            public int getMultiple_1() {
                return multiple_1;
            }

            public void setMultiple_1(int multiple_1) {
                this.multiple_1 = multiple_1;
            }

            public int getMultiple_2() {
                return multiple_2;
            }

            public void setMultiple_2(int multiple_2) {
                this.multiple_2 = multiple_2;
            }

            public int getMultiple_3() {
                return multiple_3;
            }

            public void setMultiple_3(int multiple_3) {
                this.multiple_3 = multiple_3;
            }

            public int getMultiple_4() {
                return multiple_4;
            }

            public void setMultiple_4(int multiple_4) {
                this.multiple_4 = multiple_4;
            }

            public int getMultiple_5() {
                return multiple_5;
            }

            public void setMultiple_5(int multiple_5) {
                this.multiple_5 = multiple_5;
            }

            public int getMultiple_6() {
                return multiple_6;
            }

            public void setMultiple_6(int multiple_6) {
                this.multiple_6 = multiple_6;
            }

            public int getMultiple_7() {
                return multiple_7;
            }

            public void setMultiple_7(int multiple_7) {
                this.multiple_7 = multiple_7;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }
        }
    }
}
