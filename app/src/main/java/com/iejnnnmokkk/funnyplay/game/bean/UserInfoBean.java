package com.iejnnnmokkk.funnyplay.game.bean;

import com.iejnnnmokkk.common.http.bean.BaseBean;

/**
 * @author Sun
 * @Demo class UserInfoBean
 * @Description TODO
 * @date 2024/12/13 16:02
 */
public class UserInfoBean extends BaseBean {

    private DataBean data;
    private String count;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public static class DataBean {
        private String type;
        private String nickname;
        private String uuid;
        private String uid;
        private String prxoy_num;
        private String touxiang;
        private String check_flag;
        private String risk_flag;
        private String new_user_guide;
        private String new_user_reward_status;
        private String new_task_sum;
        private String is_video_flag;
        private String video_down_time;
        private String new_userreward_down_time;
        private String task_unlock;
        private String user_small_pay_flag;
        private String new_task_flag;
        private String small_expire_time;
        private String small_pay_flag;
        private String small_withdrawal_flag;
        private String withdrawal_flag;
        private String is_first_small_pay;
        private String in_tx;
        private String invite_reward;
        private String invite_reward_v1;
        private String first_pay_ad_flag;
        private String review_timeout;
        private BankExampleBean bank_example;
        private WalletExampleBean wallet_example;
        private String google_url;
        private String download_url;
        private RankingDataBean ranking_data;
        private String task_ad_reward;
        private String phone;
        private String area_code;
        private double pic_rate;
        private String pic_flag;
        private PayBankVerificationBean pay_bank_verification;
        private PayWalletVerificationBean pay_wallet_verification;
        private String share_jf;
        private String share_txt;
        private String ym_task_flag;
        private String money_fuhao_res;
        private String sdk_total;
        private String task_empty_msg;
        private String pangle_flag;
        private String banner_ads_type;
        private String banner_ads_img_url;
        private String banner_ads_url;
        private String yeahmobi_sdk_flag;
        private String proxy_rate;
        private String mjb_auto_task_num;
        private double ad_task_reward_rate;
        private double ad_reward_rate;
        private String ad_flag;
        private String okspin_sdk_flag;
        private String adfly_flag;
        private String tapjoy_flag;
        private String check_version_flag;
        private String auto_reward_num;
        private String bind_google_reward;
        private String youtobe_url;
        private String fly_url;
        private int new_user_local_money;
        private String task_start_rewards;
        private String cps_url;
        private String new_reward;
        private String recommend_Stringerval;
        private String recommend_count;
        private String video_reward;
        private String video_reward_pertukaran;
        private String video_url;
        private String play_time_text;
        private String task_download_text;
        private String game4_play_time_text;
        private String game4_task_download_text;
        private String small_pay_task_flag;
        private String cpr_flag;
        private String small_pay_txt_v1;
        private String small_pay_txt_v2;
        private String ping_flag;
        private String small_pay_countdown;
        private String small_pay_area_flag;
        private String game_plate_flag;
        private String game_plate_money;
        private String game_plate_text;
        private String game4_small_pay_condition_flag;
        private String share_url;
        private String ad_task_reward_flag;
        private String auditing_flag;
        private String money_jiancheng;
        private String fly_flag;
        private String pertukaran;
        private String welfare_status;
        private String task_api_type;
        private String app_version;
        private String sumsung_pay_rate_flag;
        private String sumsung_check_version_flag;
        private String is_proxy;
        private String proxy_group_url;
        private String proxy_group_money;
        private String status;
        private String app_luck_img;
        private String link_type;
        private String new_user_reward_flag;
        private String proxy_username;
        private String proxy_uid;
        private String is_bind_proxy;
        private String balance;
        private String pertukaran_balance;
        private String pending_balance;
        private String lucky_coin;
        private double money;
        private String yesterday_total_money;
        private String yesterday_total_reward;
        private String no_balance;
        private String is_new_user;
        private String h5_adimg_url;
        private String msg_dot;
        private String msg_is_read;
        private String first_jf;
        private String first_money;
        private String first_jifen;
        private String first_money1;
        private String symbol;
        private String wjdc_reward;
        private String reg_flag;
        private String button1;
        private String button2;
        private String device_warning_flag;
        private MjbBean mjb;
        private String five_star_task_num;
        private int my_task_count;
        private String smail_reward;
        private String new_user_coin_reward;
        private String smail_pay_flag;
        private String remain_task_no;
        private String remain_task_type;
        private String remain_task_reward;
        private String welfare_num_reward;
        private int welfare_complete_sum;
        private int welfare_5_star_reward;
        private String welfare_5_star_id;
        private String area;
        private String has_review_task;
        private String five_star_reward;
        private String wish_invite_total_reward;
        private String cash_group_url;
        private String avatar;
        private String frame;
        private String complete_exp;
        private String pay_config_max_money;

        public String getType() {
            return type;
        }

        public void setType(String type) {
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

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPrxoy_num() {
            return prxoy_num;
        }

        public void setPrxoy_num(String prxoy_num) {
            this.prxoy_num = prxoy_num;
        }

        public String getTouxiang() {
            return touxiang;
        }

        public void setTouxiang(String touxiang) {
            this.touxiang = touxiang;
        }

        public String getCheck_flag() {
            return check_flag;
        }

        public void setCheck_flag(String check_flag) {
            this.check_flag = check_flag;
        }

        public String getRisk_flag() {
            return risk_flag;
        }

        public void setRisk_flag(String risk_flag) {
            this.risk_flag = risk_flag;
        }

        public String getNew_user_guide() {
            return new_user_guide;
        }

        public void setNew_user_guide(String new_user_guide) {
            this.new_user_guide = new_user_guide;
        }

        public String getNew_user_reward_status() {
            return new_user_reward_status;
        }

        public void setNew_user_reward_status(String new_user_reward_status) {
            this.new_user_reward_status = new_user_reward_status;
        }

        public String getNew_task_sum() {
            return new_task_sum;
        }

        public void setNew_task_sum(String new_task_sum) {
            this.new_task_sum = new_task_sum;
        }

        public String getIs_video_flag() {
            return is_video_flag;
        }

        public void setIs_video_flag(String is_video_flag) {
            this.is_video_flag = is_video_flag;
        }

        public String getVideo_down_time() {
            return video_down_time;
        }

        public void setVideo_down_time(String video_down_time) {
            this.video_down_time = video_down_time;
        }

        public String getNew_userreward_down_time() {
            return new_userreward_down_time;
        }

        public void setNew_userreward_down_time(String new_userreward_down_time) {
            this.new_userreward_down_time = new_userreward_down_time;
        }

        public String getTask_unlock() {
            return task_unlock;
        }

        public void setTask_unlock(String task_unlock) {
            this.task_unlock = task_unlock;
        }

        public String getUser_small_pay_flag() {
            return user_small_pay_flag;
        }

        public void setUser_small_pay_flag(String user_small_pay_flag) {
            this.user_small_pay_flag = user_small_pay_flag;
        }

        public String getNew_task_flag() {
            return new_task_flag;
        }

        public void setNew_task_flag(String new_task_flag) {
            this.new_task_flag = new_task_flag;
        }

        public String getSmall_expire_time() {
            return small_expire_time;
        }

        public void setSmall_expire_time(String small_expire_time) {
            this.small_expire_time = small_expire_time;
        }

        public String getSmall_pay_flag() {
            return small_pay_flag;
        }

        public void setSmall_pay_flag(String small_pay_flag) {
            this.small_pay_flag = small_pay_flag;
        }

        public String getSmall_withdrawal_flag() {
            return small_withdrawal_flag;
        }

        public void setSmall_withdrawal_flag(String small_withdrawal_flag) {
            this.small_withdrawal_flag = small_withdrawal_flag;
        }

        public String getWithdrawal_flag() {
            return withdrawal_flag;
        }

        public void setWithdrawal_flag(String withdrawal_flag) {
            this.withdrawal_flag = withdrawal_flag;
        }

        public String getIs_first_small_pay() {
            return is_first_small_pay;
        }

        public void setIs_first_small_pay(String is_first_small_pay) {
            this.is_first_small_pay = is_first_small_pay;
        }

        public String getIn_tx() {
            return in_tx;
        }

        public void setIn_tx(String in_tx) {
            this.in_tx = in_tx;
        }

        public String getInvite_reward() {
            return invite_reward;
        }

        public void setInvite_reward(String invite_reward) {
            this.invite_reward = invite_reward;
        }

        public String getInvite_reward_v1() {
            return invite_reward_v1;
        }

        public void setInvite_reward_v1(String invite_reward_v1) {
            this.invite_reward_v1 = invite_reward_v1;
        }

        public String getFirst_pay_ad_flag() {
            return first_pay_ad_flag;
        }

        public void setFirst_pay_ad_flag(String first_pay_ad_flag) {
            this.first_pay_ad_flag = first_pay_ad_flag;
        }

        public String getReview_timeout() {
            return review_timeout;
        }

        public void setReview_timeout(String review_timeout) {
            this.review_timeout = review_timeout;
        }

        public BankExampleBean getBank_example() {
            return bank_example;
        }

        public void setBank_example(BankExampleBean bank_example) {
            this.bank_example = bank_example;
        }

        public WalletExampleBean getWallet_example() {
            return wallet_example;
        }

        public void setWallet_example(WalletExampleBean wallet_example) {
            this.wallet_example = wallet_example;
        }

        public String getGoogle_url() {
            return google_url;
        }

        public void setGoogle_url(String google_url) {
            this.google_url = google_url;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public RankingDataBean getRanking_data() {
            return ranking_data;
        }

        public void setRanking_data(RankingDataBean ranking_data) {
            this.ranking_data = ranking_data;
        }

        public String getTask_ad_reward() {
            return task_ad_reward;
        }

        public void setTask_ad_reward(String task_ad_reward) {
            this.task_ad_reward = task_ad_reward;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getArea_code() {
            return area_code;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public double getPic_rate() {
            return pic_rate;
        }

        public void setPic_rate(double pic_rate) {
            this.pic_rate = pic_rate;
        }

        public String getPic_flag() {
            return pic_flag;
        }

        public void setPic_flag(String pic_flag) {
            this.pic_flag = pic_flag;
        }

        public PayBankVerificationBean getPay_bank_verification() {
            return pay_bank_verification;
        }

        public void setPay_bank_verification(PayBankVerificationBean pay_bank_verification) {
            this.pay_bank_verification = pay_bank_verification;
        }

        public PayWalletVerificationBean getPay_wallet_verification() {
            return pay_wallet_verification;
        }

        public void setPay_wallet_verification(PayWalletVerificationBean pay_wallet_verification) {
            this.pay_wallet_verification = pay_wallet_verification;
        }

        public String getShare_jf() {
            return share_jf;
        }

        public void setShare_jf(String share_jf) {
            this.share_jf = share_jf;
        }

        public String getShare_txt() {
            return share_txt;
        }

        public void setShare_txt(String share_txt) {
            this.share_txt = share_txt;
        }

        public String getYm_task_flag() {
            return ym_task_flag;
        }

        public void setYm_task_flag(String ym_task_flag) {
            this.ym_task_flag = ym_task_flag;
        }

        public String getMoney_fuhao_res() {
            return money_fuhao_res;
        }

        public void setMoney_fuhao_res(String money_fuhao_res) {
            this.money_fuhao_res = money_fuhao_res;
        }

        public String getSdk_total() {
            return sdk_total;
        }

        public void setSdk_total(String sdk_total) {
            this.sdk_total = sdk_total;
        }

        public String getTask_empty_msg() {
            return task_empty_msg;
        }

        public void setTask_empty_msg(String task_empty_msg) {
            this.task_empty_msg = task_empty_msg;
        }

        public String getPangle_flag() {
            return pangle_flag;
        }

        public void setPangle_flag(String pangle_flag) {
            this.pangle_flag = pangle_flag;
        }

        public String getBanner_ads_type() {
            return banner_ads_type;
        }

        public void setBanner_ads_type(String banner_ads_type) {
            this.banner_ads_type = banner_ads_type;
        }

        public String getBanner_ads_img_url() {
            return banner_ads_img_url;
        }

        public void setBanner_ads_img_url(String banner_ads_img_url) {
            this.banner_ads_img_url = banner_ads_img_url;
        }

        public String getBanner_ads_url() {
            return banner_ads_url;
        }

        public void setBanner_ads_url(String banner_ads_url) {
            this.banner_ads_url = banner_ads_url;
        }

        public String getYeahmobi_sdk_flag() {
            return yeahmobi_sdk_flag;
        }

        public void setYeahmobi_sdk_flag(String yeahmobi_sdk_flag) {
            this.yeahmobi_sdk_flag = yeahmobi_sdk_flag;
        }

        public String getProxy_rate() {
            return proxy_rate;
        }

        public void setProxy_rate(String proxy_rate) {
            this.proxy_rate = proxy_rate;
        }

        public String getMjb_auto_task_num() {
            return mjb_auto_task_num;
        }

        public void setMjb_auto_task_num(String mjb_auto_task_num) {
            this.mjb_auto_task_num = mjb_auto_task_num;
        }

        public double getAd_task_reward_rate() {
            return ad_task_reward_rate;
        }

        public void setAd_task_reward_rate(double ad_task_reward_rate) {
            this.ad_task_reward_rate = ad_task_reward_rate;
        }

        public double getAd_reward_rate() {
            return ad_reward_rate;
        }

        public void setAd_reward_rate(double ad_reward_rate) {
            this.ad_reward_rate = ad_reward_rate;
        }

        public String getAd_flag() {
            return ad_flag;
        }

        public void setAd_flag(String ad_flag) {
            this.ad_flag = ad_flag;
        }

        public String getOkspin_sdk_flag() {
            return okspin_sdk_flag;
        }

        public void setOkspin_sdk_flag(String okspin_sdk_flag) {
            this.okspin_sdk_flag = okspin_sdk_flag;
        }

        public String getAdfly_flag() {
            return adfly_flag;
        }

        public void setAdfly_flag(String adfly_flag) {
            this.adfly_flag = adfly_flag;
        }

        public String getTapjoy_flag() {
            return tapjoy_flag;
        }

        public void setTapjoy_flag(String tapjoy_flag) {
            this.tapjoy_flag = tapjoy_flag;
        }

        public String getCheck_version_flag() {
            return check_version_flag;
        }

        public void setCheck_version_flag(String check_version_flag) {
            this.check_version_flag = check_version_flag;
        }

        public String getAuto_reward_num() {
            return auto_reward_num;
        }

        public void setAuto_reward_num(String auto_reward_num) {
            this.auto_reward_num = auto_reward_num;
        }

        public String getBind_google_reward() {
            return bind_google_reward;
        }

        public void setBind_google_reward(String bind_google_reward) {
            this.bind_google_reward = bind_google_reward;
        }

        public String getYoutobe_url() {
            return youtobe_url;
        }

        public void setYoutobe_url(String youtobe_url) {
            this.youtobe_url = youtobe_url;
        }

        public String getFly_url() {
            return fly_url;
        }

        public void setFly_url(String fly_url) {
            this.fly_url = fly_url;
        }

        public int getNew_user_local_money() {
            return new_user_local_money;
        }

        public void setNew_user_local_money(int new_user_local_money) {
            this.new_user_local_money = new_user_local_money;
        }

        public String getTask_start_rewards() {
            return task_start_rewards;
        }

        public void setTask_start_rewards(String task_start_rewards) {
            this.task_start_rewards = task_start_rewards;
        }

        public String getCps_url() {
            return cps_url;
        }

        public void setCps_url(String cps_url) {
            this.cps_url = cps_url;
        }

        public String getNew_reward() {
            return new_reward;
        }

        public void setNew_reward(String new_reward) {
            this.new_reward = new_reward;
        }

        public String getRecommend_Stringerval() {
            return recommend_Stringerval;
        }

        public void setRecommend_Stringerval(String recommend_Stringerval) {
            this.recommend_Stringerval = recommend_Stringerval;
        }

        public String getRecommend_count() {
            return recommend_count;
        }

        public void setRecommend_count(String recommend_count) {
            this.recommend_count = recommend_count;
        }

        public String getVideo_reward() {
            return video_reward;
        }

        public void setVideo_reward(String video_reward) {
            this.video_reward = video_reward;
        }

        public String getVideo_reward_pertukaran() {
            return video_reward_pertukaran;
        }

        public void setVideo_reward_pertukaran(String video_reward_pertukaran) {
            this.video_reward_pertukaran = video_reward_pertukaran;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getPlay_time_text() {
            return play_time_text;
        }

        public void setPlay_time_text(String play_time_text) {
            this.play_time_text = play_time_text;
        }

        public String getTask_download_text() {
            return task_download_text;
        }

        public void setTask_download_text(String task_download_text) {
            this.task_download_text = task_download_text;
        }

        public String getGame4_play_time_text() {
            return game4_play_time_text;
        }

        public void setGame4_play_time_text(String game4_play_time_text) {
            this.game4_play_time_text = game4_play_time_text;
        }

        public String getGame4_task_download_text() {
            return game4_task_download_text;
        }

        public void setGame4_task_download_text(String game4_task_download_text) {
            this.game4_task_download_text = game4_task_download_text;
        }

        public String getSmall_pay_task_flag() {
            return small_pay_task_flag;
        }

        public void setSmall_pay_task_flag(String small_pay_task_flag) {
            this.small_pay_task_flag = small_pay_task_flag;
        }

        public String getCpr_flag() {
            return cpr_flag;
        }

        public void setCpr_flag(String cpr_flag) {
            this.cpr_flag = cpr_flag;
        }

        public String getSmall_pay_txt_v1() {
            return small_pay_txt_v1;
        }

        public void setSmall_pay_txt_v1(String small_pay_txt_v1) {
            this.small_pay_txt_v1 = small_pay_txt_v1;
        }

        public String getSmall_pay_txt_v2() {
            return small_pay_txt_v2;
        }

        public void setSmall_pay_txt_v2(String small_pay_txt_v2) {
            this.small_pay_txt_v2 = small_pay_txt_v2;
        }

        public String getPing_flag() {
            return ping_flag;
        }

        public void setPing_flag(String ping_flag) {
            this.ping_flag = ping_flag;
        }

        public String getSmall_pay_countdown() {
            return small_pay_countdown;
        }

        public void setSmall_pay_countdown(String small_pay_countdown) {
            this.small_pay_countdown = small_pay_countdown;
        }

        public String getSmall_pay_area_flag() {
            return small_pay_area_flag;
        }

        public void setSmall_pay_area_flag(String small_pay_area_flag) {
            this.small_pay_area_flag = small_pay_area_flag;
        }

        public String getGame_plate_flag() {
            return game_plate_flag;
        }

        public void setGame_plate_flag(String game_plate_flag) {
            this.game_plate_flag = game_plate_flag;
        }

        public String getGame_plate_money() {
            return game_plate_money;
        }

        public void setGame_plate_money(String game_plate_money) {
            this.game_plate_money = game_plate_money;
        }

        public String getGame_plate_text() {
            return game_plate_text;
        }

        public void setGame_plate_text(String game_plate_text) {
            this.game_plate_text = game_plate_text;
        }

        public String getGame4_small_pay_condition_flag() {
            return game4_small_pay_condition_flag;
        }

        public void setGame4_small_pay_condition_flag(String game4_small_pay_condition_flag) {
            this.game4_small_pay_condition_flag = game4_small_pay_condition_flag;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getAd_task_reward_flag() {
            return ad_task_reward_flag;
        }

        public void setAd_task_reward_flag(String ad_task_reward_flag) {
            this.ad_task_reward_flag = ad_task_reward_flag;
        }

        public String getAuditing_flag() {
            return auditing_flag;
        }

        public void setAuditing_flag(String auditing_flag) {
            this.auditing_flag = auditing_flag;
        }

        public String getMoney_jiancheng() {
            return money_jiancheng;
        }

        public void setMoney_jiancheng(String money_jiancheng) {
            this.money_jiancheng = money_jiancheng;
        }

        public String getFly_flag() {
            return fly_flag;
        }

        public void setFly_flag(String fly_flag) {
            this.fly_flag = fly_flag;
        }

        public String getPertukaran() {
            return pertukaran;
        }

        public void setPertukaran(String pertukaran) {
            this.pertukaran = pertukaran;
        }

        public String getWelfare_status() {
            return welfare_status;
        }

        public void setWelfare_status(String welfare_status) {
            this.welfare_status = welfare_status;
        }

        public String getTask_api_type() {
            return task_api_type;
        }

        public void setTask_api_type(String task_api_type) {
            this.task_api_type = task_api_type;
        }

        public String getApp_version() {
            return app_version;
        }

        public void setApp_version(String app_version) {
            this.app_version = app_version;
        }

        public String getSumsung_pay_rate_flag() {
            return sumsung_pay_rate_flag;
        }

        public void setSumsung_pay_rate_flag(String sumsung_pay_rate_flag) {
            this.sumsung_pay_rate_flag = sumsung_pay_rate_flag;
        }

        public String getSumsung_check_version_flag() {
            return sumsung_check_version_flag;
        }

        public void setSumsung_check_version_flag(String sumsung_check_version_flag) {
            this.sumsung_check_version_flag = sumsung_check_version_flag;
        }

        public String getIs_proxy() {
            return is_proxy;
        }

        public void setIs_proxy(String is_proxy) {
            this.is_proxy = is_proxy;
        }

        public String getProxy_group_url() {
            return proxy_group_url;
        }

        public void setProxy_group_url(String proxy_group_url) {
            this.proxy_group_url = proxy_group_url;
        }

        public String getProxy_group_money() {
            return proxy_group_money;
        }

        public void setProxy_group_money(String proxy_group_money) {
            this.proxy_group_money = proxy_group_money;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getApp_luck_img() {
            return app_luck_img;
        }

        public void setApp_luck_img(String app_luck_img) {
            this.app_luck_img = app_luck_img;
        }

        public String getLink_type() {
            return link_type;
        }

        public void setLink_type(String link_type) {
            this.link_type = link_type;
        }

        public String getNew_user_reward_flag() {
            return new_user_reward_flag;
        }

        public void setNew_user_reward_flag(String new_user_reward_flag) {
            this.new_user_reward_flag = new_user_reward_flag;
        }

        public String getProxy_username() {
            return proxy_username;
        }

        public void setProxy_username(String proxy_username) {
            this.proxy_username = proxy_username;
        }

        public String getProxy_uid() {
            return proxy_uid;
        }

        public void setProxy_uid(String proxy_uid) {
            this.proxy_uid = proxy_uid;
        }

        public String getIs_bind_proxy() {
            return is_bind_proxy;
        }

        public void setIs_bind_proxy(String is_bind_proxy) {
            this.is_bind_proxy = is_bind_proxy;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getPertukaran_balance() {
            return pertukaran_balance;
        }

        public void setPertukaran_balance(String pertukaran_balance) {
            this.pertukaran_balance = pertukaran_balance;
        }

        public String getPending_balance() {
            return pending_balance;
        }

        public void setPending_balance(String pending_balance) {
            this.pending_balance = pending_balance;
        }

        public String getLucky_coin() {
            return lucky_coin;
        }

        public void setLucky_coin(String lucky_coin) {
            this.lucky_coin = lucky_coin;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public String getYesterday_total_money() {
            return yesterday_total_money;
        }

        public void setYesterday_total_money(String yesterday_total_money) {
            this.yesterday_total_money = yesterday_total_money;
        }

        public String getYesterday_total_reward() {
            return yesterday_total_reward;
        }

        public void setYesterday_total_reward(String yesterday_total_reward) {
            this.yesterday_total_reward = yesterday_total_reward;
        }

        public String getNo_balance() {
            return no_balance;
        }

        public void setNo_balance(String no_balance) {
            this.no_balance = no_balance;
        }

        public String getIs_new_user() {
            return is_new_user;
        }

        public void setIs_new_user(String is_new_user) {
            this.is_new_user = is_new_user;
        }

        public String getH5_adimg_url() {
            return h5_adimg_url;
        }

        public void setH5_adimg_url(String h5_adimg_url) {
            this.h5_adimg_url = h5_adimg_url;
        }

        public String getMsg_dot() {
            return msg_dot;
        }

        public void setMsg_dot(String msg_dot) {
            this.msg_dot = msg_dot;
        }

        public String getMsg_is_read() {
            return msg_is_read;
        }

        public void setMsg_is_read(String msg_is_read) {
            this.msg_is_read = msg_is_read;
        }

        public String getFirst_jf() {
            return first_jf;
        }

        public void setFirst_jf(String first_jf) {
            this.first_jf = first_jf;
        }

        public String getFirst_money() {
            return first_money;
        }

        public void setFirst_money(String first_money) {
            this.first_money = first_money;
        }

        public String getFirst_jifen() {
            return first_jifen;
        }

        public void setFirst_jifen(String first_jifen) {
            this.first_jifen = first_jifen;
        }

        public String getFirst_money1() {
            return first_money1;
        }

        public void setFirst_money1(String first_money1) {
            this.first_money1 = first_money1;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getWjdc_reward() {
            return wjdc_reward;
        }

        public void setWjdc_reward(String wjdc_reward) {
            this.wjdc_reward = wjdc_reward;
        }

        public String getReg_flag() {
            return reg_flag;
        }

        public void setReg_flag(String reg_flag) {
            this.reg_flag = reg_flag;
        }

        public String getButton1() {
            return button1;
        }

        public void setButton1(String button1) {
            this.button1 = button1;
        }

        public String getButton2() {
            return button2;
        }

        public void setButton2(String button2) {
            this.button2 = button2;
        }

        public String getDevice_warning_flag() {
            return device_warning_flag;
        }

        public void setDevice_warning_flag(String device_warning_flag) {
            this.device_warning_flag = device_warning_flag;
        }

        public MjbBean getMjb() {
            return mjb;
        }

        public void setMjb(MjbBean mjb) {
            this.mjb = mjb;
        }

        public String getFive_star_task_num() {
            return five_star_task_num;
        }

        public void setFive_star_task_num(String five_star_task_num) {
            this.five_star_task_num = five_star_task_num;
        }

        public int getMy_task_count() {
            return my_task_count;
        }

        public void setMy_task_count(int my_task_count) {
            this.my_task_count = my_task_count;
        }

        public String getSmail_reward() {
            return smail_reward;
        }

        public void setSmail_reward(String smail_reward) {
            this.smail_reward = smail_reward;
        }

        public String getNew_user_coin_reward() {
            return new_user_coin_reward;
        }

        public void setNew_user_coin_reward(String new_user_coin_reward) {
            this.new_user_coin_reward = new_user_coin_reward;
        }

        public String getSmail_pay_flag() {
            return smail_pay_flag;
        }

        public void setSmail_pay_flag(String smail_pay_flag) {
            this.smail_pay_flag = smail_pay_flag;
        }

        public String getRemain_task_no() {
            return remain_task_no;
        }

        public void setRemain_task_no(String remain_task_no) {
            this.remain_task_no = remain_task_no;
        }

        public String getRemain_task_type() {
            return remain_task_type;
        }

        public void setRemain_task_type(String remain_task_type) {
            this.remain_task_type = remain_task_type;
        }

        public String getRemain_task_reward() {
            return remain_task_reward;
        }

        public void setRemain_task_reward(String remain_task_reward) {
            this.remain_task_reward = remain_task_reward;
        }

        public String getWelfare_num_reward() {
            return welfare_num_reward;
        }

        public void setWelfare_num_reward(String welfare_num_reward) {
            this.welfare_num_reward = welfare_num_reward;
        }

        public int getWelfare_complete_sum() {
            return welfare_complete_sum;
        }

        public void setWelfare_complete_sum(int welfare_complete_sum) {
            this.welfare_complete_sum = welfare_complete_sum;
        }

        public int getWelfare_5_star_reward() {
            return welfare_5_star_reward;
        }

        public void setWelfare_5_star_reward(int welfare_5_star_reward) {
            this.welfare_5_star_reward = welfare_5_star_reward;
        }

        public String getWelfare_5_star_id() {
            return welfare_5_star_id;
        }

        public void setWelfare_5_star_id(String welfare_5_star_id) {
            this.welfare_5_star_id = welfare_5_star_id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getHas_review_task() {
            return has_review_task;
        }

        public void setHas_review_task(String has_review_task) {
            this.has_review_task = has_review_task;
        }

        public String getFive_star_reward() {
            return five_star_reward;
        }

        public void setFive_star_reward(String five_star_reward) {
            this.five_star_reward = five_star_reward;
        }

        public String getWish_invite_total_reward() {
            return wish_invite_total_reward;
        }

        public void setWish_invite_total_reward(String wish_invite_total_reward) {
            this.wish_invite_total_reward = wish_invite_total_reward;
        }

        public String getCash_group_url() {
            return cash_group_url;
        }

        public void setCash_group_url(String cash_group_url) {
            this.cash_group_url = cash_group_url;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFrame() {
            return frame;
        }

        public void setFrame(String frame) {
            this.frame = frame;
        }

        public String getComplete_exp() {
            return complete_exp;
        }

        public void setComplete_exp(String complete_exp) {
            this.complete_exp = complete_exp;
        }

        public String getPay_config_max_money() {
            return pay_config_max_money;
        }

        public void setPay_config_max_money(String pay_config_max_money) {
            this.pay_config_max_money = pay_config_max_money;
        }

        public static class BankExampleBean {
            private String number;
            private String name;

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class WalletExampleBean {
            private String number;
            private String name;

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class RankingDataBean {
            private String type;
            private String ranking;
            private String reward;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getRanking() {
                return ranking;
            }

            public void setRanking(String ranking) {
                this.ranking = ranking;
            }

            public String getReward() {
                return reward;
            }

            public void setReward(String reward) {
                this.reward = reward;
            }
        }

        public static class PayBankVerificationBean {
            private String type;
            private String size;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }
        }

        public static class PayWalletVerificationBean {
            private String type;
            private String size;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }
        }

        public static class MjbBean {
            private String mjb_tixian_flag;
            private String device_warning_flag;
            private String mjb_tixian_status;
            private String first_mjb_tixian_flag;
            private String task_num;
            private String tixian_num;

            public String getMjb_tixian_flag() {
                return mjb_tixian_flag;
            }

            public void setMjb_tixian_flag(String mjb_tixian_flag) {
                this.mjb_tixian_flag = mjb_tixian_flag;
            }

            public String getDevice_warning_flag() {
                return device_warning_flag;
            }

            public void setDevice_warning_flag(String device_warning_flag) {
                this.device_warning_flag = device_warning_flag;
            }

            public String getMjb_tixian_status() {
                return mjb_tixian_status;
            }

            public void setMjb_tixian_status(String mjb_tixian_status) {
                this.mjb_tixian_status = mjb_tixian_status;
            }

            public String getFirst_mjb_tixian_flag() {
                return first_mjb_tixian_flag;
            }

            public void setFirst_mjb_tixian_flag(String first_mjb_tixian_flag) {
                this.first_mjb_tixian_flag = first_mjb_tixian_flag;
            }

            public String getTask_num() {
                return task_num;
            }

            public void setTask_num(String task_num) {
                this.task_num = task_num;
            }

            public String getTixian_num() {
                return tixian_num;
            }

            public void setTixian_num(String tixian_num) {
                this.tixian_num = tixian_num;
            }
        }
    }
}
