package com.iejnnnmokkk.funnyplay.personal.library;

import com.google.gson.annotations.SerializedName;
import com.iejnnnmokkk.common.http.bean.BaseBean;

import java.util.List;

public class MyGameBean extends BaseBean {

    /**
     * data : [{"id":46967682,"no":"241120173419444088","uid":11591387,"status":2,"area":1,"task_name":"Connect The Bubbles","cpl_game_uid":0,"cpl_game_last_level":0,"cpl_game_last_paid":"0.00","cpl_game_reward":0,"success_flag":"1","date_time":20241229,"create_time":1735441596,"limit_time":1735445196,"ok_time":1735441597,"remark":null,"reward":1950000,"proxy_reward":10,"package_name":"h5","channel":"funny_play","type":18,"channel_task_type":0,"step_one_time":null,"remain_download_status":0,"step":0,"currency":"5.000","remain_download_time":0,"ip":"120.245.103.42, 172.71.147.215","desc_img":"","check_id":"","remain_1":0,"remain_2":0,"remain_3":0,"remain_4":0,"remain_5":0,"remain_6":0,"remain_7":0,"step_one_flag":0,"callback_flag":0,"fcm_num":0,"fcm_time":0,"register_event_callback":0,"pay_event_callback":0,"deposit_event_callback":0,"add_level_callback_event_callback":0,"loan_event_callback":0,"share_event_callback":0,"kyc_event_callback":0,"apply_event_callback":0,"open_tag_callback":0,"play_num":0,"play_date":0,"register_flag":0,"auto_check_flag":0,"img_ score":"","image_flag":0,"get_task_sum":4176,"red":2,"app_url":"https://game.chicmens.com/games/connectthebubbles/","pay_money":0,"game_play_time":0,"test":1,"app_name":"bubbles","name":"Connect The Bubbles","icon":"https://cdn.cxbwm.com/image/article/20231213/17/16054641.png","remain_play_days":0,"count_down":0,"normal_step_count":0,"ing_step":0,"status_name":"Ongoing","reward_rate":0,"reward_v1":"1.95M","local_money":"\u20b919500.00"}]
     * count : 1
     */

    private int count;
    private List<DataBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 46967682
         * no : 241120173419444088
         * uid : 11591387
         * status : 2
         * area : 1
         * task_name : Connect The Bubbles
         * cpl_game_uid : 0
         * cpl_game_last_level : 0
         * cpl_game_last_paid : 0.00
         * cpl_game_reward : 0
         * success_flag : 1
         * date_time : 20241229
         * create_time : 1735441596
         * limit_time : 1735445196
         * ok_time : 1735441597
         * remark : null
         * reward : 1950000
         * proxy_reward : 10
         * package_name : h5
         * channel : funny_play
         * type : 18
         * channel_task_type : 0
         * step_one_time : null
         * remain_download_status : 0
         * step : 0
         * currency : 5.000
         * remain_download_time : 0
         * ip : 120.245.103.42, 172.71.147.215
         * desc_img :
         * check_id :
         * remain_1 : 0
         * remain_2 : 0
         * remain_3 : 0
         * remain_4 : 0
         * remain_5 : 0
         * remain_6 : 0
         * remain_7 : 0
         * step_one_flag : 0
         * callback_flag : 0
         * fcm_num : 0
         * fcm_time : 0
         * register_event_callback : 0
         * pay_event_callback : 0
         * deposit_event_callback : 0
         * add_level_callback_event_callback : 0
         * loan_event_callback : 0
         * share_event_callback : 0
         * kyc_event_callback : 0
         * apply_event_callback : 0
         * open_tag_callback : 0
         * play_num : 0
         * play_date : 0
         * register_flag : 0
         * auto_check_flag : 0
         * img_ score :
         * image_flag : 0
         * get_task_sum : 4176
         * red : 2
         * app_url : https://game.chicmens.com/games/connectthebubbles/
         * pay_money : 0
         * game_play_time : 0
         * test : 1
         * app_name : bubbles
         * name : Connect The Bubbles
         * icon : https://cdn.cxbwm.com/image/article/20231213/17/16054641.png
         * remain_play_days : 0
         * count_down : 0
         * normal_step_count : 0
         * ing_step : 0
         * status_name : Ongoing
         * reward_rate : 0
         * reward_v1 : 1.95M
         * local_money : ₹19500.00
         */

        private int id;
        private String no;
        private int uid;
        private int status;
        private int area;
        private String task_name;
        private int cpl_game_uid;
        private int cpl_game_last_level;
        private String cpl_game_last_paid;
        private int cpl_game_reward;
        private String success_flag;
        private String date_time;
        private int create_time;
        private int limit_time;
        private int ok_time;
        private Object remark;
        private int reward;
        private int proxy_reward;
        private String package_name;
        private String channel;
        private int type;
        private int channel_task_type;
        private Object step_one_time;
        private int remain_download_status;
        private int step;
        private String currency;
        private int remain_download_time;
        private String ip;
        private String desc_img;
        private String check_id;
        private int remain_1;
        private int remain_2;
        private int remain_3;
        private int remain_4;
        private int remain_5;
        private int remain_6;
        private int remain_7;
        private int step_one_flag;
        private int callback_flag;
        private int fcm_num;
        private int fcm_time;
        private int register_event_callback;
        private int pay_event_callback;
        private int deposit_event_callback;
        private int add_level_callback_event_callback;
        private int loan_event_callback;
        private int share_event_callback;
        private int kyc_event_callback;
        private int apply_event_callback;
        private int open_tag_callback;
        private int play_num;
        private int play_date;
        private int register_flag;
        private int auto_check_flag;
        @SerializedName("img_ score")
        private String _$Img_Score9; // FIXME check this code
        private int image_flag;
        private int get_task_sum;
        private int red;
        private String app_url;
        private int pay_money;
        private int game_play_time;
        private int test;
        private String app_name;
        private String name;
        private String icon;
        private int remain_play_days;
        private int count_down;
        private int normal_step_count;
        private int ing_step;
        private String status_name;
        private int reward_rate;
        private String reward_v1;
        private String local_money;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public String getTask_name() {
            return task_name;
        }

        public void setTask_name(String task_name) {
            this.task_name = task_name;
        }

        public int getCpl_game_uid() {
            return cpl_game_uid;
        }

        public void setCpl_game_uid(int cpl_game_uid) {
            this.cpl_game_uid = cpl_game_uid;
        }

        public int getCpl_game_last_level() {
            return cpl_game_last_level;
        }

        public void setCpl_game_last_level(int cpl_game_last_level) {
            this.cpl_game_last_level = cpl_game_last_level;
        }

        public String getCpl_game_last_paid() {
            return cpl_game_last_paid;
        }

        public void setCpl_game_last_paid(String cpl_game_last_paid) {
            this.cpl_game_last_paid = cpl_game_last_paid;
        }

        public int getCpl_game_reward() {
            return cpl_game_reward;
        }

        public void setCpl_game_reward(int cpl_game_reward) {
            this.cpl_game_reward = cpl_game_reward;
        }

        public String getSuccess_flag() {
            return success_flag;
        }

        public void setSuccess_flag(String success_flag) {
            this.success_flag = success_flag;
        }

        public String getDate_time() {
            return date_time;
        }

        public void setDate_time(String date_time) {
            this.date_time = date_time;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public int getLimit_time() {
            return limit_time;
        }

        public void setLimit_time(int limit_time) {
            this.limit_time = limit_time;
        }

        public int getOk_time() {
            return ok_time;
        }

        public void setOk_time(int ok_time) {
            this.ok_time = ok_time;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
        }

        public int getProxy_reward() {
            return proxy_reward;
        }

        public void setProxy_reward(int proxy_reward) {
            this.proxy_reward = proxy_reward;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getChannel_task_type() {
            return channel_task_type;
        }

        public void setChannel_task_type(int channel_task_type) {
            this.channel_task_type = channel_task_type;
        }

        public Object getStep_one_time() {
            return step_one_time;
        }

        public void setStep_one_time(Object step_one_time) {
            this.step_one_time = step_one_time;
        }

        public int getRemain_download_status() {
            return remain_download_status;
        }

        public void setRemain_download_status(int remain_download_status) {
            this.remain_download_status = remain_download_status;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getRemain_download_time() {
            return remain_download_time;
        }

        public void setRemain_download_time(int remain_download_time) {
            this.remain_download_time = remain_download_time;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getDesc_img() {
            return desc_img;
        }

        public void setDesc_img(String desc_img) {
            this.desc_img = desc_img;
        }

        public String getCheck_id() {
            return check_id;
        }

        public void setCheck_id(String check_id) {
            this.check_id = check_id;
        }

        public int getRemain_1() {
            return remain_1;
        }

        public void setRemain_1(int remain_1) {
            this.remain_1 = remain_1;
        }

        public int getRemain_2() {
            return remain_2;
        }

        public void setRemain_2(int remain_2) {
            this.remain_2 = remain_2;
        }

        public int getRemain_3() {
            return remain_3;
        }

        public void setRemain_3(int remain_3) {
            this.remain_3 = remain_3;
        }

        public int getRemain_4() {
            return remain_4;
        }

        public void setRemain_4(int remain_4) {
            this.remain_4 = remain_4;
        }

        public int getRemain_5() {
            return remain_5;
        }

        public void setRemain_5(int remain_5) {
            this.remain_5 = remain_5;
        }

        public int getRemain_6() {
            return remain_6;
        }

        public void setRemain_6(int remain_6) {
            this.remain_6 = remain_6;
        }

        public int getRemain_7() {
            return remain_7;
        }

        public void setRemain_7(int remain_7) {
            this.remain_7 = remain_7;
        }

        public int getStep_one_flag() {
            return step_one_flag;
        }

        public void setStep_one_flag(int step_one_flag) {
            this.step_one_flag = step_one_flag;
        }

        public int getCallback_flag() {
            return callback_flag;
        }

        public void setCallback_flag(int callback_flag) {
            this.callback_flag = callback_flag;
        }

        public int getFcm_num() {
            return fcm_num;
        }

        public void setFcm_num(int fcm_num) {
            this.fcm_num = fcm_num;
        }

        public int getFcm_time() {
            return fcm_time;
        }

        public void setFcm_time(int fcm_time) {
            this.fcm_time = fcm_time;
        }

        public int getRegister_event_callback() {
            return register_event_callback;
        }

        public void setRegister_event_callback(int register_event_callback) {
            this.register_event_callback = register_event_callback;
        }

        public int getPay_event_callback() {
            return pay_event_callback;
        }

        public void setPay_event_callback(int pay_event_callback) {
            this.pay_event_callback = pay_event_callback;
        }

        public int getDeposit_event_callback() {
            return deposit_event_callback;
        }

        public void setDeposit_event_callback(int deposit_event_callback) {
            this.deposit_event_callback = deposit_event_callback;
        }

        public int getAdd_level_callback_event_callback() {
            return add_level_callback_event_callback;
        }

        public void setAdd_level_callback_event_callback(int add_level_callback_event_callback) {
            this.add_level_callback_event_callback = add_level_callback_event_callback;
        }

        public int getLoan_event_callback() {
            return loan_event_callback;
        }

        public void setLoan_event_callback(int loan_event_callback) {
            this.loan_event_callback = loan_event_callback;
        }

        public int getShare_event_callback() {
            return share_event_callback;
        }

        public void setShare_event_callback(int share_event_callback) {
            this.share_event_callback = share_event_callback;
        }

        public int getKyc_event_callback() {
            return kyc_event_callback;
        }

        public void setKyc_event_callback(int kyc_event_callback) {
            this.kyc_event_callback = kyc_event_callback;
        }

        public int getApply_event_callback() {
            return apply_event_callback;
        }

        public void setApply_event_callback(int apply_event_callback) {
            this.apply_event_callback = apply_event_callback;
        }

        public int getOpen_tag_callback() {
            return open_tag_callback;
        }

        public void setOpen_tag_callback(int open_tag_callback) {
            this.open_tag_callback = open_tag_callback;
        }

        public int getPlay_num() {
            return play_num;
        }

        public void setPlay_num(int play_num) {
            this.play_num = play_num;
        }

        public int getPlay_date() {
            return play_date;
        }

        public void setPlay_date(int play_date) {
            this.play_date = play_date;
        }

        public int getRegister_flag() {
            return register_flag;
        }

        public void setRegister_flag(int register_flag) {
            this.register_flag = register_flag;
        }

        public int getAuto_check_flag() {
            return auto_check_flag;
        }

        public void setAuto_check_flag(int auto_check_flag) {
            this.auto_check_flag = auto_check_flag;
        }

        public String get_$Img_Score9() {
            return _$Img_Score9;
        }

        public void set_$Img_Score9(String _$Img_Score9) {
            this._$Img_Score9 = _$Img_Score9;
        }

        public int getImage_flag() {
            return image_flag;
        }

        public void setImage_flag(int image_flag) {
            this.image_flag = image_flag;
        }

        public int getGet_task_sum() {
            return get_task_sum;
        }

        public void setGet_task_sum(int get_task_sum) {
            this.get_task_sum = get_task_sum;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public int getPay_money() {
            return pay_money;
        }

        public void setPay_money(int pay_money) {
            this.pay_money = pay_money;
        }

        public int getGame_play_time() {
            return game_play_time;
        }

        public void setGame_play_time(int game_play_time) {
            this.game_play_time = game_play_time;
        }

        public int getTest() {
            return test;
        }

        public void setTest(int test) {
            this.test = test;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getRemain_play_days() {
            return remain_play_days;
        }

        public void setRemain_play_days(int remain_play_days) {
            this.remain_play_days = remain_play_days;
        }

        public int getCount_down() {
            return count_down;
        }

        public void setCount_down(int count_down) {
            this.count_down = count_down;
        }

        public int getNormal_step_count() {
            return normal_step_count;
        }

        public void setNormal_step_count(int normal_step_count) {
            this.normal_step_count = normal_step_count;
        }

        public int getIng_step() {
            return ing_step;
        }

        public void setIng_step(int ing_step) {
            this.ing_step = ing_step;
        }

        public String getStatus_name() {
            return status_name;
        }

        public void setStatus_name(String status_name) {
            this.status_name = status_name;
        }

        public int getReward_rate() {
            return reward_rate;
        }

        public void setReward_rate(int reward_rate) {
            this.reward_rate = reward_rate;
        }

        public String getReward_v1() {
            return reward_v1;
        }

        public void setReward_v1(String reward_v1) {
            this.reward_v1 = reward_v1;
        }

        public String getLocal_money() {
            return local_money;
        }

        public void setLocal_money(String local_money) {
            this.local_money = local_money;
        }
    }
}
