package com.iejnnnmokkk.funnyplay.shop;

import com.iejnnnmokkk.common.http.bean.BaseBean;

import java.util.List;

/**
 * @author Sun
 * @Demo class ShopBean
 * @Description TODO
 * @date 2024/12/18 15:30
 */
public class ShopBean extends BaseBean {

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

    public static class DataBean {
        private List<AvatarGoodsBean> avatar_goods;
        private List<FrameGoodsBean> frame_goods;

        public List<AvatarGoodsBean> getAvatar_goods() {
            return avatar_goods;
        }

        public void setAvatar_goods(List<AvatarGoodsBean> avatar_goods) {
            this.avatar_goods = avatar_goods;
        }

        public List<FrameGoodsBean> getFrame_goods() {
            return frame_goods;
        }

        public void setFrame_goods(List<FrameGoodsBean> frame_goods) {
            this.frame_goods = frame_goods;
        }

        public static class AvatarGoodsBean {
            private int id;
            private int area;
            private int type;
            private String url;
            private int coins;
            private int edit_time;
            private int status;
            private String channel;
            private int gid;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getArea() {
                return area;
            }

            public void setArea(int area) {
                this.area = area;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getCoins() {
                return coins;
            }

            public void setCoins(int coins) {
                this.coins = coins;
            }

            public int getEdit_time() {
                return edit_time;
            }

            public void setEdit_time(int edit_time) {
                this.edit_time = edit_time;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getGid() {
                return gid;
            }

            public void setGid(int gid) {
                this.gid = gid;
            }
        }

        public static class FrameGoodsBean {
            private int id;
            private int area;
            private int type;
            private String url;
            private int coins;
            private int edit_time;
            private int status;
            private String channel;
            private int gid;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getArea() {
                return area;
            }

            public void setArea(int area) {
                this.area = area;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getCoins() {
                return coins;
            }

            public void setCoins(int coins) {
                this.coins = coins;
            }

            public int getEdit_time() {
                return edit_time;
            }

            public void setEdit_time(int edit_time) {
                this.edit_time = edit_time;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getGid() {
                return gid;
            }

            public void setGid(int gid) {
                this.gid = gid;
            }
        }
    }
}
