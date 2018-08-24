package zpe.jiakeyi.com.zhanpaieaw;

import android.app.Application;
import android.util.Log;

import com.easemob.chat.EMChat;

/**
 * Created by Administrator on 2018/8/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
//        appContext = this;
//        int pid = android.os.Process.myPid();
//        String processAppName = getAppName(pid);
//// 如果APP启用了远程的service，此application:onCreate会被调用2次
//// 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
//// 默认的app会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
//
//        if (processAppName == null || !processAppName.equalsIgnoreCase("zpe.jiakeyi.com.zhanpaieaw")) {
//            Log.e("环信", "enter the service process!");
//            //"com.easemob.chatuidemo"为demo的包名，换到自己项目中要改成自己包名
//
//            // 则此application::onCreate 是被service 调用的，直接返回
//            return;
//        }
        EMChat.getInstance().init(getApplicationContext());

/**
 * debugMode == true 时为打开，SDK会在log里输入调试信息
 * @param debugMode
 * 在做代码混淆的时候需要设置成false
 */
        EMChat.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，避免消耗不必要的资源
        super.onCreate();
    }

}
