package zpe.jiakeyi.com.zhanpaieaw.utils;


/**
 * @author Gjianfu
 * @date 2018/7/31
 * 功能描述:网络接口
 */
public class RequestUtlis {
    //锋哥
    public final static String HttpUrl = "http://192.168.1.111";
    //龙哥
    //    public final static String HttpUrl = "http://192.168.1.182";
    //线上
//    public final static String HttpUrl = "http://39.107.254.193:8080/zp";
    //    public static String Token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxODgxMDM3OTAzOCIsImlhdCI6MTUzNDQwODYxOCwic3ViIjoiamt5LmFkbWluLnVzZXIiLCJpc3MiOiJ3d3cuamt5LmNvbSIsImV4cCI6MTUzNDQxMjIxOH0.A1uYnuQZtBXaCC4Zpe4JGESF3DJMtRAxfBNVyBb90Ac";
    public static String Token = null;

    //    public static String ID = "0d4fbd3293854028b9529af5b51319d8";
    public static String ID = null;
    public static String UserPhone = null;

    /**
     * 广告模块
     * adv-controller : 广告管理G
     * */
    /**
     * 求购模块
     * ask-controller : 求购信息
     */
    //根据地址获取全部广告
    public final static String sAPli = HttpUrl + "/ap/sAPli";
    //收藏展位列表
    public final static String getMyCollStands = HttpUrl + "/exStand/admin/getMyCollStands";
    //删除求购信息
    public final static String DA = HttpUrl + "/as/dA";
    //查看求购详情
    public final static String GA = HttpUrl + "/as/gA";
    //添加求购信息
    public final static String IA = HttpUrl + "/as/iA";
    //根据分类查找求购信息
    public final static String SATY = HttpUrl + "/as/sAty";
    //环信列表页
    public final static String getImUserInfo = HttpUrl + "/huanxin/getImUserInfo";
    //查询已解决与未解决
    public final static String SASO = HttpUrl + "/as/sAso";
    //查询我的求购信息
    public final static String sAu = HttpUrl + "/as/sAu";
    //编辑我的求购信息
    public final static String uA = HttpUrl + "/as/uA";
    //更新我的求购信息
    public final static String uAda = HttpUrl + "/as/uAda";
    /**
     * 新闻模块
     * news-controller : 新闻管理
     */
    //查询新闻详情
    public final static String GN = HttpUrl + "/ne/gN";
    //根据条件查看新闻列表
    public final static String SN = HttpUrl + "/ne/sN";
    //查询此新闻的上一个与下一个
    public final static String SNUAD = HttpUrl + "/ne/sNuad";
    /**
     * 人员模块
     * staff-controller : 人员管理G
     */
    //获取人员信息
    public final static String SS = HttpUrl + "/st/sS";
    //验证验证码
    public final static String verifyVCode = HttpUrl + "/st/verifyVCode";
    /**
     * 首页模块
     * mobile-controller : 移动端部分接口G
     */
    //首页接口
    public final static String HP = HttpUrl + "/mo/hp";
    /**
     * 登录注册
     * login-controller : 登陆模块
     */
    //用户注册
    public final static String RegisterUser = HttpUrl + "/login/registerUser";
    //注册信息重复测试
    public final static String RepeatValidation = HttpUrl + "/login/repeatValidation";
    //用户登录
    public final static String UserLogin = HttpUrl + "/login/userLogin";
    //获取短信验证码
    public final static String getCode = HttpUrl + "/st/getCode";
    //根据token查询用户信息
    public final static String sS = HttpUrl + "/st/sS";
    //修改用户信息
    public final static String updStaff = HttpUrl + "/st/updStaff";
    //验证 短信验证码
    public final static String verifyCode = HttpUrl + "/st/verifyCode";
    /**
     * 上传模块
     * oss-upload-controller : 文件上传模块
     */
    //图片上传
    public final static String singleUploadImg = HttpUrl + "/upload/singleUploadImg";
    public final static String singleUploadFile = HttpUrl + "/upload/singleUploadFile";
    /**
     * 收藏模块
     * firm-product-controller : 仪器管理G
     */

    //取消收藏
    public final static String delCollP = HttpUrl + "/fp/delCollP";
    //仪器分类列表
    public final static String sTs = HttpUrl + "/pt/asTs";
    //删除仪器
    public final static String delP = HttpUrl + "/fp/delP";
    //仪器详情
    public final static String getP = HttpUrl + "/fp/getP";
    //获取收藏列表
    public final static String selCollP = HttpUrl + "/fp/selCollP";
    //搜索
    public final static String selPWeb = HttpUrl + "/fp/selPWeb";
    /**
     * 城市选择模块
     */
    public static String City = "";
    public final static String sAr = HttpUrl + "/ot/sAR";
    /**
     * 仪器管理
     * firm-product-controller : 仪器管理G
     */
    //添加收藏、取消收藏 0=添加收藏，1=取消收藏
    public final static String CPStatus = HttpUrl + "/fp/CPStatus";
    //判断收藏状态G status 0=未收藏 1=已收藏
    public final static String ifCP = HttpUrl + "/fp/ifCP";
    //筛选仪器
    public final static String selP = HttpUrl + "/fp/selP";
    /**
     * 热搜搜索
     * other-controller : 其他接口G
     */
    //热搜词汇
    public final static String sSE = HttpUrl + "/ot/sSE";
    /**
     * 消息管理G
     * sys-message-controller : 消息管理G
     */
    //查看消息详情
    public final static String gM = HttpUrl + "/me/gM";
    //查询用户系统消息
    public final static String sAty = HttpUrl + "/me/sAty";
}
