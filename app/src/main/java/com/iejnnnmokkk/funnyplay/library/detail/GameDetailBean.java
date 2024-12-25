package com.iejnnnmokkk.funnyplay.library.detail;

import com.iejnnnmokkk.common.http.bean.BaseBean;

import java.util.List;

public class GameDetailBean extends BaseBean {

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
        private String name;
        private int type;
        private String no;
        private int reward;
        private String currency;
        private int first_download_flag;
        private int fa_num;
        private int js_task_count;
        private int ok_time;
        private int now_time;
        private String app_url;
        private String search_word;
        private Object step_one_title;
        private String step_one_button;
        private String step_one_desc;
        private Object keyword;
        private String app_name;
        private String package_name;
        private String icon;
        private int cp_flag;
        private String cp_content;
        private int full_time;
        private int red;
        private int img_num;
        private List<?> img_example;
        private List<?> img_example_url;
        private String comment;
        private String watas;
        private String customerService;
        private int start_time;
        private int limit_time;
        private int task_time;
        private Object game_role_info;
        private String h5game_text;
        private List<String> touxiang;
        private String local_money;
        private String check_id;
        private int is_get;
        private String reward_pertukaran_balance;
        private List<AllBean> all;
        private int total_reward;
        private int jumpFlag;
        private int user_total_reward;
        private int task_reward;
        private int success_conditions;
        private int completion_conditions;
        private int money;
        private String offer_id;
        private String ad_identification;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getFirst_download_flag() {
            return first_download_flag;
        }

        public void setFirst_download_flag(int first_download_flag) {
            this.first_download_flag = first_download_flag;
        }

        public int getFa_num() {
            return fa_num;
        }

        public void setFa_num(int fa_num) {
            this.fa_num = fa_num;
        }

        public int getJs_task_count() {
            return js_task_count;
        }

        public void setJs_task_count(int js_task_count) {
            this.js_task_count = js_task_count;
        }

        public int getOk_time() {
            return ok_time;
        }

        public void setOk_time(int ok_time) {
            this.ok_time = ok_time;
        }

        public int getNow_time() {
            return now_time;
        }

        public void setNow_time(int now_time) {
            this.now_time = now_time;
        }

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public String getSearch_word() {
            return search_word;
        }

        public void setSearch_word(String search_word) {
            this.search_word = search_word;
        }

        public Object getStep_one_title() {
            return step_one_title;
        }

        public void setStep_one_title(Object step_one_title) {
            this.step_one_title = step_one_title;
        }

        public String getStep_one_button() {
            return step_one_button;
        }

        public void setStep_one_button(String step_one_button) {
            this.step_one_button = step_one_button;
        }

        public String getStep_one_desc() {
            return step_one_desc;
        }

        public void setStep_one_desc(String step_one_desc) {
            this.step_one_desc = step_one_desc;
        }

        public Object getKeyword() {
            return keyword;
        }

        public void setKeyword(Object keyword) {
            this.keyword = keyword;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getCp_flag() {
            return cp_flag;
        }

        public void setCp_flag(int cp_flag) {
            this.cp_flag = cp_flag;
        }

        public String getCp_content() {
            return cp_content;
        }

        public void setCp_content(String cp_content) {
            this.cp_content = cp_content;
        }

        public int getFull_time() {
            return full_time;
        }

        public void setFull_time(int full_time) {
            this.full_time = full_time;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getImg_num() {
            return img_num;
        }

        public void setImg_num(int img_num) {
            this.img_num = img_num;
        }

        public List<?> getImg_example() {
            return img_example;
        }

        public void setImg_example(List<?> img_example) {
            this.img_example = img_example;
        }

        public List<?> getImg_example_url() {
            return img_example_url;
        }

        public void setImg_example_url(List<?> img_example_url) {
            this.img_example_url = img_example_url;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getWatas() {
            return watas;
        }

        public void setWatas(String watas) {
            this.watas = watas;
        }

        public String getCustomerService() {
            return customerService;
        }

        public void setCustomerService(String customerService) {
            this.customerService = customerService;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getLimit_time() {
            return limit_time;
        }

        public void setLimit_time(int limit_time) {
            this.limit_time = limit_time;
        }

        public int getTask_time() {
            return task_time;
        }

        public void setTask_time(int task_time) {
            this.task_time = task_time;
        }

        public Object getGame_role_info() {
            return game_role_info;
        }

        public void setGame_role_info(Object game_role_info) {
            this.game_role_info = game_role_info;
        }

        public String getH5game_text() {
            return h5game_text;
        }

        public void setH5game_text(String h5game_text) {
            this.h5game_text = h5game_text;
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

        public String getCheck_id() {
            return check_id;
        }

        public void setCheck_id(String check_id) {
            this.check_id = check_id;
        }

        public int getIs_get() {
            return is_get;
        }

        public void setIs_get(int is_get) {
            this.is_get = is_get;
        }

        public String getReward_pertukaran_balance() {
            return reward_pertukaran_balance;
        }

        public void setReward_pertukaran_balance(String reward_pertukaran_balance) {
            this.reward_pertukaran_balance = reward_pertukaran_balance;
        }

        public List<AllBean> getAll() {
            return all;
        }

        public void setAll(List<AllBean> all) {
            this.all = all;
        }

        public int getTotal_reward() {
            return total_reward;
        }

        public void setTotal_reward(int total_reward) {
            this.total_reward = total_reward;
        }

        public int getJumpFlag() {
            return jumpFlag;
        }

        public void setJumpFlag(int jumpFlag) {
            this.jumpFlag = jumpFlag;
        }

        public int getUser_total_reward() {
            return user_total_reward;
        }

        public void setUser_total_reward(int user_total_reward) {
            this.user_total_reward = user_total_reward;
        }

        public int getTask_reward() {
            return task_reward;
        }

        public void setTask_reward(int task_reward) {
            this.task_reward = task_reward;
        }

        public int getSuccess_conditions() {
            return success_conditions;
        }

        public void setSuccess_conditions(int success_conditions) {
            this.success_conditions = success_conditions;
        }

        public int getCompletion_conditions() {
            return completion_conditions;
        }

        public void setCompletion_conditions(int completion_conditions) {
            this.completion_conditions = completion_conditions;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getOffer_id() {
            return offer_id;
        }

        public void setOffer_id(String offer_id) {
            this.offer_id = offer_id;
        }

        public String getAd_identification() {
            return ad_identification;
        }

        public void setAd_identification(String ad_identification) {
            this.ad_identification = ad_identification;
        }


        public static class AllBean {
            private String server_name;
            private List<AllDataBean> data;

            public String getServer_name() {
                return server_name;
            }

            public void setServer_name(String server_name) {
                this.server_name = server_name;
            }

            public List<AllDataBean> getData() {
                return data;
            }

            public void setData(List<AllDataBean> data) {
                this.data = data;
            }

            public static class AllDataBean {
                private String title;
                private int condition;
                private int reward;
                private int status;
                private String action;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getCondition() {
                    return condition;
                }

                public void setCondition(int condition) {
                    this.condition = condition;
                }

                public int getReward() {
                    return reward;
                }

                public void setReward(int reward) {
                    this.reward = reward;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }
            }
        }
    }
}
