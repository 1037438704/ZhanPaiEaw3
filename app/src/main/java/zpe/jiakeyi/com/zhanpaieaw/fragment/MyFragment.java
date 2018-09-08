package zpe.jiakeyi.com.zhanpaieaw.fragment;


import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.Preferences;
import com.zhy.autolayout.AutoLinearLayout;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.LoadingActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.ShowActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.login.LoginActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.my.BuyBuyActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.my.HellpActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.my.MyBuyActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.my.PersonalActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.my.SettingActivity;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.LoginBeanCode;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;
/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：我的页面
 *
 * @author dell-pc
 */
@Layout(R.layout.fragment_my)
public class MyFragment extends BaseFragment {
    //    private AutoLinearLayout my_ll_login;
    private AutoLinearLayout my_ll_collect;
    private AutoLinearLayout my_atll_hellp;
    private AutoLinearLayout record_auto;
    private AutoLinearLayout download_auto;
    private AutoLinearLayout my_buy_auto;
    private AutoLinearLayout share_auto;
    private AutoLinearLayout setting_auto;
    private AutoLinearLayout my_ll_login_ture;
    private TextView user_name;
    private TextView login_tv;
    private TextView user_phone;

    @Override
    public void initViews() {

        my_ll_collect = findViewById(R.id.my_ll_collect);
        user_name = findViewById(R.id.user_name);
        login_tv = findViewById(R.id.login_tv);
        user_phone = findViewById(R.id.user_phone);
        my_atll_hellp = findViewById(R.id.my_atll_hellp);
        record_auto = findViewById(R.id.record_auto);
        download_auto = findViewById(R.id.download_auto);
        my_buy_auto = findViewById(R.id.my_buy_auto);
        share_auto = findViewById(R.id.share_auto);
        setting_auto = findViewById(R.id.setting_auto);
        my_ll_login_ture = findViewById(R.id.my_ll_login_ture);

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (RequestUtlis.Token != null) {
            String string = Preferences.getInstance().getString(me, "UseUser", "UseUser");
            Gson gson = new Gson();
            LoginBeanCode loginBeanCode = gson.fromJson(string, LoginBeanCode.class);
            user_name.setText(loginBeanCode.getData().getUserInfo().getUsername());
            user_phone.setText(loginBeanCode.getData().getUserInfo().getIphone());
            user_name.setVisibility(View.VISIBLE);
            user_phone.setVisibility(View.VISIBLE);
            login_tv.setVisibility(View.GONE);
        } else {
            user_name.setVisibility(View.GONE);
            user_phone.setVisibility(View.GONE);
            login_tv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setEvents() {
        //跳转到个人信息界面
        my_ll_login_ture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RequestUtlis.Token != null) {
                    jump(PersonalActivity.class);
                } else {
                    jump(LoginActivity.class);
                }
            }
        });
        //收藏界面
        my_ll_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RequestUtlis.Token != null) {
                    //收藏界面
                    jump(BuyBuyActivity.class);
                } else {
                    jump(LoginActivity.class);
                }
            }
        });
        //帮助界面
        my_atll_hellp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(HellpActivity.class);
            }
        });
        //记录界面
        record_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RequestUtlis.Token != null) {
                    jump(ShowActivity.class);
                } else {
                    jump(LoginActivity.class);
                }

            }
        });
        //资料界面
        download_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RequestUtlis.Token != null) {
                    //这里是下载的资料页面

                } else {
                    jump(LoginActivity.class);
                }

            }
        });
        //我的求购
        my_buy_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RequestUtlis.Token != null) {
                    //我的求购界面
                    jump(MyBuyActivity.class);
                } else {
                    jump(LoginActivity.class);
                }

            }
        });
        //分享APP
        share_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(LoadingActivity.class);
            }
        });
        //设置页面
        setting_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RequestUtlis.Token != null) {
                    jump(SettingActivity.class);
                } else {
                    jump(LoginActivity.class);
                }

            }
        });

    }
}
