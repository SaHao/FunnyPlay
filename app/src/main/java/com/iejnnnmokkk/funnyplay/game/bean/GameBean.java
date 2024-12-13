package com.iejnnnmokkk.funnyplay.game.bean;

import com.iejnnnmokkk.common.http.bean.BaseBean;

import java.util.List;

/**
 * @author Sun
 * @Demo class GameBean
 * @Description TODO
 * @date 2024/12/12 16:42
 */
public class GameBean extends BaseBean {

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
        private String search_word;
        private String app_url;
        private String ecpm;
        private int sort;
        private int id;
        private String name;
        private String app_name;
        private int type;
        private String no;
        private int is_new_user_flag;
        private int reward;
        private int task_time;
        private int fa_num;
        private int red;
        private String icon;
        private int step_1_num;
        private int step_2_num;
        private String task_label;
        private String task_start_time;
        private String task_end_time;
        private String package_name;
        private int gaid_flag;
        private int is_spare_tire;
        private int serial_no;
        private String pay_money;
        private String recomm_img;
        private int game_play_time;
        private int get_task_sum;
        private int status;
        private String status_name;
        private String reward_v1;
        private int cpl_game_reward;
        private int is_red;
        private List<String> task_label_res;
        private int num;
        private int now_time;
        private String button_title;
        private int sdk_flag;
        private List<String> touxiang;
        private String local_money;
        private String local_money_no_symbol;

        public String getSearch_word() {
            return search_word;
        }

        public void setSearch_word(String search_word) {
            this.search_word = search_word;
        }

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public String getEcpm() {
            return ecpm;
        }

        public void setEcpm(String ecpm) {
            this.ecpm = ecpm;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public int getIs_new_user_flag() {
            return is_new_user_flag;
        }

        public void setIs_new_user_flag(int is_new_user_flag) {
            this.is_new_user_flag = is_new_user_flag;
        }

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
        }

        public int getTask_time() {
            return task_time;
        }

        public void setTask_time(int task_time) {
            this.task_time = task_time;
        }

        public int getFa_num() {
            return fa_num;
        }

        public void setFa_num(int fa_num) {
            this.fa_num = fa_num;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getStep_1_num() {
            return step_1_num;
        }

        public void setStep_1_num(int step_1_num) {
            this.step_1_num = step_1_num;
        }

        public int getStep_2_num() {
            return step_2_num;
        }

        public void setStep_2_num(int step_2_num) {
            this.step_2_num = step_2_num;
        }

        public String getTask_label() {
            return task_label;
        }

        public void setTask_label(String task_label) {
            this.task_label = task_label;
        }

        public String getTask_start_time() {
            return task_start_time;
        }

        public void setTask_start_time(String task_start_time) {
            this.task_start_time = task_start_time;
        }

        public String getTask_end_time() {
            return task_end_time;
        }

        public void setTask_end_time(String task_end_time) {
            this.task_end_time = task_end_time;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public int getGaid_flag() {
            return gaid_flag;
        }

        public void setGaid_flag(int gaid_flag) {
            this.gaid_flag = gaid_flag;
        }

        public int getIs_spare_tire() {
            return is_spare_tire;
        }

        public void setIs_spare_tire(int is_spare_tire) {
            this.is_spare_tire = is_spare_tire;
        }

        public int getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(int serial_no) {
            this.serial_no = serial_no;
        }

        public String getPay_money() {
            return pay_money;
        }

        public void setPay_money(String pay_money) {
            this.pay_money = pay_money;
        }

        public String getRecomm_img() {
            return recomm_img;
        }

        public void setRecomm_img(String recomm_img) {
            this.recomm_img = recomm_img;
        }

        public int getGame_play_time() {
            return game_play_time;
        }

        public void setGame_play_time(int game_play_time) {
            this.game_play_time = game_play_time;
        }

        public int getGet_task_sum() {
            return get_task_sum;
        }

        public void setGet_task_sum(int get_task_sum) {
            this.get_task_sum = get_task_sum;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatus_name() {
            return status_name;
        }

        public void setStatus_name(String status_name) {
            this.status_name = status_name;
        }

        public String getReward_v1() {
            return reward_v1;
        }

        public void setReward_v1(String reward_v1) {
            this.reward_v1 = reward_v1;
        }

        public int getCpl_game_reward() {
            return cpl_game_reward;
        }

        public void setCpl_game_reward(int cpl_game_reward) {
            this.cpl_game_reward = cpl_game_reward;
        }

        public int getIs_red() {
            return is_red;
        }

        public void setIs_red(int is_red) {
            this.is_red = is_red;
        }

        public List<String> getTask_label_res() {
            return task_label_res;
        }

        public void setTask_label_res(List<String> task_label_res) {
            this.task_label_res = task_label_res;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getNow_time() {
            return now_time;
        }

        public void setNow_time(int now_time) {
            this.now_time = now_time;
        }

        public String getButton_title() {
            return button_title;
        }

        public void setButton_title(String button_title) {
            this.button_title = button_title;
        }

        public int getSdk_flag() {
            return sdk_flag;
        }

        public void setSdk_flag(int sdk_flag) {
            this.sdk_flag = sdk_flag;
        }

        public List<String> getTouxiang() {
            return touxiang;
        }

        public void setTouxiang(List<String> touxiang) {
            this.touxiang = touxiang;
        }

        public String getLocal_money() {
            return local_money;
        }

        public void setLocal_money(String local_money) {
            this.local_money = local_money;
        }

        public String getLocal_money_no_symbol() {
            return local_money_no_symbol;
        }

        public void setLocal_money_no_symbol(String local_money_no_symbol) {
            this.local_money_no_symbol = local_money_no_symbol;
        }
    }
}
