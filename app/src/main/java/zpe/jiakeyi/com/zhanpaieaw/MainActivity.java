package zpe.jiakeyi.com.zhanpaieaw;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.baseframework.util.Preferences;
import com.zhy.autolayout.AutoFrameLayout;

import zpe.jiakeyi.com.zhanpaieaw.base.BaseAty;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.LoginBeanCode;
import zpe.jiakeyi.com.zhanpaieaw.fragment.BuyFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.ExhibitionFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.HomeFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.MassageFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.MyFragment;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：主界面
 *
 * @author dell-pc
 */
@Layout(R.layout.activity_main)
public class MainActivity extends BaseAty implements RadioGroup.OnCheckedChangeListener {
    private AutoFrameLayout frameLayout;
    private RadioButton tabHome;
    private RadioButton tabExhibition;
    private RadioButton tabMassage;
    private RadioButton tabBuy;
    private RadioButton tabPersona;
    private RadioGroup tabGroup;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private ExhibitionFragment exhibitionFragment;
    private MassageFragment massageFragment;
    private BuyFragment buyFragment;
    private MyFragment myFragment;

    @Override
    public void initViews() {
        tabHome = findViewById(R.id.tab_home);
        frameLayout = findViewById(R.id.frame_layout);
        tabExhibition = findViewById(R.id.tab_exhibition);
        tabMassage = findViewById(R.id.tab_massage);
        tabBuy = findViewById(R.id.tab_buy);

        tabPersona = findViewById(R.id.tab_persona);
        tabGroup = findViewById(R.id.tab_group);


        RadioButton tabHome = (RadioButton) tabGroup.getChildAt(0);
        tabHome.setChecked(true);
        tabGroup.setOnCheckedChangeListener(this);
        initFragment();
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        if (Preferences.getInstance().getString(me, "UseUser", "UseUser") != "") {
            String string = Preferences.getInstance().getString(me, "UseUser", "UseUser");
            RequestUtlis.UserMassage = string;
            Gson gson = new Gson();
            final LoginBeanCode loginBeanCode = gson.fromJson(string, LoginBeanCode.class);
            RequestUtlis.UserPhone = loginBeanCode.getData().getUserInfo().getIphone();
            RequestUtlis.Token = loginBeanCode.getData().getACCESS_TOKEN();
            RequestUtlis.ID = loginBeanCode.getData().getUserInfo().getId();
            Log.i("登录", "initDatas: " + loginBeanCode);
            EMClient.getInstance().login(loginBeanCode.getData().getImUserInfo().getUserName(), loginBeanCode.getData().getImUserInfo().getPassword(), new EMCallBack() {//回调
                @Override
                public void onSuccess() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            EMClient.getInstance().groupManager().loadAllGroups();
                            EMClient.getInstance().chatManager().loadAllConversations();
                            Log.d("main", "登录聊天服务器成功！");
                        }
                    });
                }

                @Override
                public void onProgress(int progress, String status) {

                }

                @Override
                public void onError(int code, String message) {
                    Log.d("main", "登录聊天服务器失败！");
                }
            });
        }

    }

    @Override
    public void setEvents() {

    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.frame_layout, homeFragment);
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_home:
                FragmentTransaction ft1 = manager.beginTransaction();
                hideAll(ft1);
                if (homeFragment != null) {
                    ft1.show(homeFragment);
                } else {
                    homeFragment = new HomeFragment();
                    ft1.add(R.id.frame_layout, homeFragment);
                }
                ft1.commit();
                break;
            case R.id.tab_exhibition:
                FragmentTransaction ft2 = manager.beginTransaction();
                hideAll(ft2);
                if (exhibitionFragment != null) {
                    ft2.show(exhibitionFragment);
                } else {
                    exhibitionFragment = new ExhibitionFragment();
                    ft2.add(R.id.frame_layout, exhibitionFragment);
                }
                ft2.commit();
                break;
            case R.id.tab_massage:
                FragmentTransaction ft3 = manager.beginTransaction();
                hideAll(ft3);
                if (massageFragment != null) {
                    ft3.show(massageFragment);
                } else {
                    massageFragment = new MassageFragment();
                    ft3.add(R.id.frame_layout, massageFragment);
                }
                ft3.commit();
                break;
            case R.id.tab_buy:
                FragmentTransaction ft4 = manager.beginTransaction();
                hideAll(ft4);
                if (buyFragment != null) {
                    ft4.show(buyFragment);
                } else {
                    buyFragment = new BuyFragment();
                    ft4.add(R.id.frame_layout, buyFragment);
                }
                ft4.commit();
                break;
            case R.id.tab_persona:
                FragmentTransaction ft5 = manager.beginTransaction();
                hideAll(ft5);
                if (myFragment != null) {
                    ft5.show(myFragment);
                } else {
                    myFragment = new MyFragment();
                    ft5.add(R.id.frame_layout, myFragment);
                }
                ft5.commit();
                break;
            default:
        }
    }

    private void hideAll(FragmentTransaction ft) {
        if (ft == null) {
            return;
        }
        if (homeFragment != null) {
            ft.hide(homeFragment);
        }
        if (exhibitionFragment != null) {
            ft.hide(exhibitionFragment);
        }
        if (massageFragment != null) {
            ft.hide(massageFragment);
        }
        if (buyFragment != null) {
            ft.hide(buyFragment);
        }
        if (myFragment != null) {
            ft.hide(myFragment);
        }
    }
}
