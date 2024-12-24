package com.iejnnnmokkk.funnyplay.spl;

import com.iejnnnmokkk.common.http.bean.BaseBean;

/**
 * @author Sun
 * @Demo class LoginBean
 * @Description TODO
 * @date 2024/12/10 16:15
 */
public class LoginBean extends BaseBean {

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
        private String token;
        private int type;
        private String nickname;
        private String uuid;
        private int proxy_t;
        private String touxiang;
        private boolean bind_goog_flag;
        private String init_install_package;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public int getProxy_t() {
            return proxy_t;
        }

        public void setProxy_t(int proxy_t) {
            this.proxy_t = proxy_t;
        }

        public String getTouxiang() {
            return touxiang;
        }

        public void setTouxiang(String touxiang) {
            this.touxiang = touxiang;
        }

        public boolean isBind_goog_flag() {
            return bind_goog_flag;
        }

        public void setBind_goog_flag(boolean bind_goog_flag) {
            this.bind_goog_flag = bind_goog_flag;
        }

        public String getInit_install_package() {
            return init_install_package;
        }

        public void setInit_install_package(String init_install_package) {
            this.init_install_package = init_install_package;
        }
    }
}
