package zpe.jiakeyi.com.zhanpaieaw;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;

/**
 * Created by Administrator on 2018/8/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        EMOptions options = new EMOptions();
// 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        EaseUI.getInstance().init(getApplicationContext(), options);
        EMClient.getInstance().init(getApplicationContext(), new EMOptions());
/**
 * debugMode == true 时为打开，SDK会在log里输入调试信息
 * @param debugMode
 * 在做代码混淆的时候需要设置成false
 */
        EMClient.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，避免消耗不必要的资源
        super.onCreate();
    }

}
