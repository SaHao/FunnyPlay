package com.iejnnnmokkk.funnyplay.spl;

import com.iejnnnmokkk.common.http.bean.BaseBean;

/**
 * @author Sun
 * @Demo class SplBean
 * @Description TODO
 * @date 2024/12/10 14:59
 */
public class SplBean extends BaseBean {

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
        private int flag;
        private String no;
        private int get_task_sum;
        private int send_flag;

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public int getGet_task_sum() {
            return get_task_sum;
        }

        public void setGet_task_sum(int get_task_sum) {
            this.get_task_sum = get_task_sum;
        }

        public int getSend_flag() {
            return send_flag;
        }

        public void setSend_flag(int send_flag) {
            this.send_flag = send_flag;
        }
    }
}
