package zpe.jiakeyi.com.zhanpaieaw.activity.exhibition;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import com.zhy.autolayout.AutoLinearLayout;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.MainActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.SeekActivity;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2018/8/17 10:38
 * 功能描述：这个界面是干啥的
 * 联系方式：1037438704@qq.com
 *
 * @author dell-pc
 */
public class ExhibitionActivity extends UnityPlayerActivity {

    private AutoLinearLayout scan;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        initView();
        mContext = this;
        UnityPlayer.UnitySendMessage("OtherPlatFormsObj", "GetUserID", "c714cf2c528f40d5b4108a3ca52b21db");
        UnityPlayer.UnitySendMessage("OtherPlatFormsObj", "GetAllShellSchemLoadMode", "");

    }

    public static void IntentAll() {
        UnityPlayer.UnitySendMessage("OtherPlatFormsObj", "GetUserID", "c714cf2c528f40d5b4108a3ca52b21db");
        UnityPlayer.UnitySendMessage("OtherPlatFormsObj", "GetAllShellSchemLoadMode", "");
    }

    public static void IntentOne(String id) {
        UnityPlayer.UnitySendMessage("OtherPlatFormsObj", "GetUserID", "c714cf2c528f40d5b4108a3ca52b21db");
        UnityPlayer.UnitySendMessage("OtherPlatFormsObj", "GetOneShellSchemLoadMode", id);

    }

    private void initView() {
        scan = (AutoLinearLayout) findViewById(R.id.UnityView);
        View view = mUnityPlayer.getView();
        scan.addView(view);
    }

    private void Chat() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        mUnityPlayer.quit();
        finish();
    }

    public static void Search() {
        getSeek();
    }

    public static void getSeek() {
        Intent intent = new Intent();
        intent.setClass(mContext, SeekActivity.class);
        mContext.startActivity(intent);
    }

    public static void ConnectError() {
        Log.i("U3D", "ConnectError: ");
    }

    public static void Share(String shellSchemId) {
        Log.i("Share", "Share: " + shellSchemId);
    }

    public static void BrochureDownLoad(final String path) {

        Log.i("U3D", "BrochureDownLoad: " + path);

    }

    public static void GetUserID() {
        Log.i("U3D", "GetUserID: ");
    }

    public static void GetShellSchemLoadType() {
        // 同样需要在UI线程下执行
        Log.i("U3D", "GetShellSchemLoadType: ");

    }

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == keyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
