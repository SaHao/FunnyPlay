package com.iejnnnmokkk.funnyplay.play

import java.io.Serializable

data class UserInfo(
    var balance: Int,
    val nickname: String,
    val no_balance: Int,
    val prxoy_num: Int,//邀请码
    val touxiang: String,
    val type: Int,
    var phone: String,
    val email: String? = null,
    var share_url: String,
    val proxy_rate: String,
    val share_jf: String,//邀请奖励
    val uuid: Int,
    val uid: Int,
    val bank: String? = null,
    var area: Int,  //1:IN-印度(英语),2:TH-泰国,3:VN-越南,4:ID-印尼  5.pt是葡萄牙 8.php菲律宾
    val bank_id: Int,  //bank_id >0 就是有银行卡
    val area_code: String, //区号
    var share_txt: String,//分享文案
    var msg_is_read: Int,// 消息是否已读
    var ym_task_flag: Int,// 是否显示有米SDK任务
    var tapjoy_flag: Int,// 是否显示TapJoySDK任务 ==1 显示
    var okspin_sdk_flag: Int,// 是否显示OkSpinSDK任务  1显示
    val task_no: String,//用于弹出未完成任务的对话框
    val reward: String,//用于弹出未完成任务的对话框
    val task_type: Int,//用于弹出未完成任务的对话框
    val pertukaran_balance: String,  //兌換成本地貨幣的價格
    val bind_google_reward: Int,
    val reg_flag: Int,  //1
    val money_jiancheng: String,//货币符号+货币
    val money_fuhao_res: String,//货币符号
    var money: String,//货币
    val is_bind_proxy: Int,//是否已经绑定邀请码 1已绑定 0未绑定
    val new_reward: Int,
    val ad_flag: Int,// 1开启
    val check_version_flag: Int,//1 开启审核
    val yeahmobi_sdk_flag: Int,//1 开启
    val is_new_user: Int,//是否是新用戶 1是新用戶 //仅用来判断签到弹窗
    val cps_url: String,//cps任务URL
    val remain_task_flag: Int,//2不可关闭
    val recommend_interval: Int,//推荐间隔
    val recommend_count: Int,//推荐次数
    val fly_url: String,//H5地址
    val youtobe_url: String,//YTB
    val fly_flag: Int,//1 关闭活动页
    val h5_adimg_url: String,// Yearmobi 广告图片
    val pangle_flag: Int,// 穿山甲广告开关  1打开  非必要字段 后接入AppLovin竞价广告，变为AppLovin广告开关
    val adfly_flag: Int,// AdflyTapTime积分墙开关  1打开
    val pending_reward_total: Int,//积分
    val pending_money: String,//法币
    val task_empty_msg: String,//无任务时文案
    val ad_reward_rate: Double,//广告比例
    val smail_pay_flag: Int,//是否展示小额提现 //1显示
    val video_reward: Int,//视频奖励
    val is_video_flag: Int,//is_video_flag,1:弹视频，2:不弹视频
    val video_reward_pertukaran: Double,//视频奖励法币
    val sdk_total: String,//SDK金币总额
    val video_url: String,//SDK金币总额
    val pic_flag: Int,//是否开启图片对比
    val pic_rate: Float,//相似度系数
    val remain_task_no: String,//remain_task_no,remain_task_type,remain_task_reward
    val remain_task_type: Int,//remain_task_no,remain_task_type,remain_task_reward
    val remain_task_reward: Int,//remain_task_no,remain_task_type,remain_task_reward
    val video_down_time: Int,// 视频奖励倒计时
    val new_userreward_down_time: Int,//新人任务奖励倒计时，若未零则无需重复拉去，不为零需要频繁更新
    val new_user_coin_reward: String,//新人任务奖励数值
    val auto_reward_num: Int,//百分百成功任务数
    var pending_balance: Int = 0,//待领取金币
    var risk_flag: Int = 0,//0正常用户大于0风险用户
    var task_ad_reward: Int = 0,//每次做完任务给多少
    val pay_bank_verification: Bank,//钱包配置
    val pay_wallet_verification: Bank,//银行卡配置
    val welfare_complete_sum: Int,//银行卡配置
    val new_user_reward_status: Int,//是否打开新手奖励模块  1显示2隐藏
    var new_user_reward_flag: Int,//新用户金币奖励：1已领取 0未领取
    var new_user_local_money: Double,//提现卡：大于0已领取
    var user_small_pay_flag: Int,//提现卡：大于0已领取
    var first_jf: Int,//第一档提现
    var first_money: String,//第一档提现
    var review_timeout: Int,//图片审核最大超时时间
    var welfare_status: Int,//是否开启福利页
    var task_api_type: Int,//1跳转新的API任务页
    var first_pay_ad_flag: Int,//首次提现是否看广告 1看  2不看
    var app_version: String,//最新版本
    var invite_reward_v1: String,//最新版本
    var my_task_count: Int,//最新版本
)
data class Tourist(
    val bind_goog_flag: Boolean,
    val init_install_package: String,
    val nickname: String,
    val proxy_t: Int,
    val token: String,
    val touxiang: String,
    val type: Int,
    val uuid: Int
)
data class Bank(
    val type: Int,//-1 不限制 1数字 2随便
    val size: Int,//最大长度
)
data class GameListEntity(
    var id: Int = 0,
    var name: String = "",
    var app_name: String = "",
    var type: Int = -1,
    var no: String = "",
    var reward: Int = 0,
    var game_play_time: Int = 0,
    var red: Int = 0,
    var icon: String = "",
    var button_title: String = "",
    var app_url: String = "",
    var pay_money: Float,
    var package_name: String = "",
    var recomm_img: String = "",
    val local_money: String,
    var touxiang: List<String>,
    var cpl_game_reward: Int = 0,
    var get_task_sum: Int = 0,
    var status: Int = 0,
    var is_get: Int = 0,
    var create_time: Long = 0L,
    var isADView: Boolean = false
) : Serializable

data class CoinHistory(
    val balance: Int,
    val create_time: Int,
    val old_balance: Int,
    val order_no: String,
    val remark: String,
    val serial_no: String,
    val sub_type: Int,
    val sub_type_name: String,
    val type: Int
)


data class GameInfoDetails(
    var name: String? = null,
    val type: Int = 0,
    val no: String= "",
    val offer_id: String= "",
    val reward: Int = 0,
    val currency: String? = null,
    val first_download_flag: Int = 0,
    val fa_num: Int = 0,
    val js_task_count: Int = 0,
    val ok_time: Int = 0,
    val now_time: Int = 0,
    var app_url: String? = null,
    val search_word: String? = null,
    val step_one_title: String? = null,
    val step_one_button: String? = null,
    val step_one_desc: String? = null,
    val keyword: String? = null,
    val app_name: String? = null,
    val package_name: String = "",
    val icon: String? = null,
    val cp_flag: Int = 0,
    val cp_content: String? = null,
    val h5game_text: String? = null,
    val full_time: Int = 0,
    val img_num: Int = 0,
    var step: DetailsStep? = null,
    var all: List<DetailsInfo>? = null,
    val game_role_info: ArrayList<GameInfo>?,
    val reward_pertukaran_balance: String? = null,
    val total_reward: Int = 0,
    val user_total_reward: Int = 0,
    val is_get: Int = 0,
    val red: Int = 0,
    val jumpFlag: Int = 0,
    val task_reward: Int = 0,
    val auto_task_flag: Int,//1(100%成功)，2（非100%成功）
    val ad_identification: String = "",
    val pay_money: Float,
    val step_two_desc: String,
    val img_example: List<SampleGraph>,
    val step2_img_example: List<SampleGraph>,
    val comment: String,
    val step_one_reward: Int,
    val step_three_button: String,
    val step_three_desc: String,
    val step_three_reward: Int,
    val step_three_title: String,
    val step_two_button: String,
    val step_two_reward: Int,
    val step_two_title: String,
    val additional_reward: Int,
    val completion_conditions: Int,
    val success_conditions: Int,
    val money: Float,
    val local_money: String,
)
data class DetailsStep(
    val add_level: List<DetailsInfo>,
    val deposit: List<DetailsInfo>,
    val score: List<DetailsInfo>,
    val ad_callback: List<DetailsInfo>
):Serializable

data class DetailsInfo(
    val server_name: String,
    val data: List<DetailsContent>,
):Serializable

data class DetailsContent(
    val title: String,
    val action: String,
    val condition: Int,
    val reward: Int,
    val status: Int
):Serializable

data class SampleGraph(
    val img: String,
)

data class GameInfo(
    val name: String,
    val value: String
)

data class StartGameResult(
    val check_id: String,
    val app_url: String,
    val key_word: MutableList<String>,
    val limit_time: Long,
)

data class OldGameData(
    val type: String = "",//类型=
    val action: String = "",//事件
    val coin: Int = 0,//金币
    val score: Int = 0,//分数
    val energy: Int = 0,//能量体能
    val level: String = "",//关卡
    val checkpoint: String = "",//关卡
    val diamond: Int = 0,//钻石
    val sign: String = "",//签名
    val time: Long = 0,//时间
)

data class NewGameData(
    var channel: String? = "FunnyPlay",
    var no: String = "",//流水号
    var action: String = "",//事件
    var coin: Int = 0,//金币
    var score: Int = 0,//成绩
    var level: Int = 0,//关卡
    var ads_num: Int = 0,//广告数
    var time: Long = 0,//时间
    var total_time: Long = 0,//总时间
    var extra1: String = "",//备用字段
    var extra2: String = "",//备用字段
    var extra3: String = "",//备用字段
    var signature: String = "" //签名
)