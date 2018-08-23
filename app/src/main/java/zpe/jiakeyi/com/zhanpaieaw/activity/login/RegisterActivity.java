package zpe.jiakeyi.com.zhanpaieaw.activity.login;


import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.loginBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.HttpUtlis;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;
import zpe.jiakeyi.com.zhanpaieaw.utils.VerificationTime;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：注册页面
 *
 * @author dell-pc
 */
@Layout(R.layout.activity_register)
@DarkStatusBarTheme(false) //开启顶部状态栏图标、文字暗色模式
//@NavigationBarBackgroundColor(a = 255, r = 255, g = 255, b = 255)
////透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的)
//@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色模式
public class RegisterActivity extends BaseActivity {

    private ImageView image_return;
    private ImageView image_logo;
    private EditText register_phone_number;
    private EditText register_password;
    private CheckBox register_checkbox;
    private EditText register_code;
    private TextView register_find_code;
    private TextView register_button;
    private VerificationTime verificationTime;

    @Override
    public void initViews() {
        image_return = findViewById(R.id.image_return);
        image_logo = findViewById(R.id.image_logo);
        register_phone_number = findViewById(R.id.register_phone_number);
        register_password = findViewById(R.id.register_password);
        register_checkbox = findViewById(R.id.register_checkbox);
        register_code = findViewById(R.id.register_code);
        register_find_code = findViewById(R.id.register_find_code);
        register_button = findViewById(R.id.register_button);
    }


    @Override
    public void initDatas(JumpParameter paramer) {

    }

    @Override
    public void setEvents() {
        register_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    register_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    register_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }

        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (register_phone_number.getText().toString() != null) {
                    boolean chinaPhoneLegal = isChinaPhoneLegal(register_phone_number.getText().toString());
                    if (chinaPhoneLegal) {
                        String s = HttpUtlis.RegisterData_Code(register_code.getText().toString());
                        if (register_password.getText().toString() != null) {
                            if (register_password.getText().toString().length() < 6) {
                                Toast.makeText(me, "密码格式有误", Toast.LENGTH_SHORT).show();
                            } else {
                                if (register_code != null) OkHttpUtils.post()
                                        .url(RequestUtlis.RegisterUser)
                                        .addHeader("loginType", "1")
                                        .addParams("phoneNum", register_phone_number.getText().toString())
                                        .addParams("password", register_password.getText().toString())
                                        .addParams("code", register_code.getText().toString())
                                        .build().execute(new StringCallback() {
                                            @Override
                                            public void onError(Request request, Exception e) {
                                                Log.i("失败", "onError: " + e);
                                                Toast.makeText(me, "注册失败", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void onResponse(String response) {
                                                Gson gson = new Gson();
                                                loginBean loginBean = gson.fromJson(response, loginBean.class);
                                                Log.i("注册软件", "onResponse: " + response);
                                                int code = loginBean.getCode();
                                                if (HttpUtlis.code == "1") {
                                                    Toast.makeText(me, "注册成功", Toast.LENGTH_SHORT).show();
                                                    jump(LoginActivity.class);
                                                } else {
                                                    Toast.makeText(me, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                else {
                                    Toast.makeText(me, "验证码不能为空", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            Toast.makeText(me, "请输入密码", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(me, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(me, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register_find_code.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (register_phone_number.getText().toString() != null) {
                    boolean chinaPhoneLegal = isChinaPhoneLegal(register_phone_number.getText().toString());
                    if (chinaPhoneLegal) {
                        verificationTime = (VerificationTime) new VerificationTime(60000, 1000, register_find_code,R.color.myg , R.color.myblue).start();
                        OkHttpUtils.post().url(RequestUtlis.getCode)
                                .addHeader("loginType", "1")
                                .addParams("iphone", register_phone_number.getText().toString())
                                .build()
                                .execute(new StringCallback() {
                                    @Override
                                    public void onError(Request request, Exception e) {
                                    }

                                    @Override
                                    public void onResponse(String response) {

                                    }
                                });
                    } else {
                        Toast.makeText(me, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(me, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
        image_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public static boolean isChinaPhoneLegal(String str)
            throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
