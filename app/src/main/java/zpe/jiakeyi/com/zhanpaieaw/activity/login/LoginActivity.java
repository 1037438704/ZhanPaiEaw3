package zpe.jiakeyi.com.zhanpaieaw.activity.login;

import com.google.gson.Gson;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.LoginBeanCode;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：密码登录页面
 *
 * @author dell-pc
 */

@Layout(R.layout.activity_login)
@DarkStatusBarTheme(false) //开启顶部状态栏图标、文字暗色模式
@NavigationBarBackgroundColor(a = 255, r = 255, g = 255, b = 255)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的)
@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色模式
public class LoginActivity extends BaseActivity {
    private TextView login_text_verification;
    private TextView text_register;
    private ImageView image_return;
    private ImageView image_logo;
    private EditText user_numb;
    private EditText password_logi;
    private TextView login_but;
    private CheckBox password_logi_see;

    @Override
    public void initViews() {
        login_text_verification = findViewById(R.id.login_text_verification);
        image_return = findViewById(R.id.image_return);
        image_logo = findViewById(R.id.image_logo);
        user_numb = findViewById(R.id.user_numb);
        password_logi = findViewById(R.id.password_logi);
        login_but = findViewById(R.id.login_but);
        text_register = findViewById(R.id.text_register);
        password_logi_see = findViewById(R.id.password_logi_see);
    }

    @Override
    public void initDatas(JumpParameter paramer) {

    }

    @Override
    public void setEvents() {
        password_logi_see.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    password_logi.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    password_logi.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }

        });
        //注册界面
        text_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(RegisterActivity.class);
                finish();
            }
        });
        //验证码登录
        login_text_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(VerificationActivity.class);
                finish();
            }
        });
        image_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.post().url(RequestUtlis.UserLogin)
                        .addHeader("loginType", "1")
                        .addParams("account", user_numb.getText().toString())
                        .addParams("password", password_logi.getText().toString())
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                            }

                            @Override
                            public void onResponse(String response) {
                                Gson gson = new Gson();
                                LoginBeanCode loginBeanCode = gson.fromJson(response, LoginBeanCode.class);
                                if (loginBeanCode.getCode() == 1) {
                                    RequestUtlis.Token = loginBeanCode.getData().getACCESS_TOKEN();
                                    RequestUtlis.ID = loginBeanCode.getData().getUserInfo().getId();
                                    Log.i("token", "onResponse: " + RequestUtlis.Token);
                                    Log.i("id", "onResponse: " + RequestUtlis.ID);
                                    Toast.makeText(me, "登录成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(me, loginBeanCode.getMsg(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });

    }

}
