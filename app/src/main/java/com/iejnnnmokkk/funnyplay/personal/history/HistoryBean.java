package com.iejnnnmokkk.funnyplay.personal.history;

import com.iejnnnmokkk.common.http.bean.BaseBean;

import java.util.List;

public class HistoryBean extends BaseBean {

    private List<DataBean> data;
    private int count;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static class DataBean {
        private int sub_type;
        private int type;
        private String order_no;
        private String serial_no;
        private int old_balance;
        private int balance;
        private String remark;
        private long create_time;
        private String sub_type_name;
        private String local_money;

        public int getSub_type() {
            return sub_type;
        }

        public void setSub_type(int sub_type) {
            this.sub_type = sub_type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(String serial_no) {
            this.serial_no = serial_no;
        }

        public int getOld_balance() {
            return old_balance;
        }

        public void setOld_balance(int old_balance) {
            this.old_balance = old_balance;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(long create_time) {
            this.create_time = create_time;
        }

        public String getSub_type_name() {
            return sub_type_name;
        }

        public void setSub_type_name(String sub_type_name) {
            this.sub_type_name = sub_type_name;
        }

        public String getLocal_money() {
            return local_money;
        }

        public void setLocal_money(String local_money) {
            this.local_money = local_money;
        }
    }
}
