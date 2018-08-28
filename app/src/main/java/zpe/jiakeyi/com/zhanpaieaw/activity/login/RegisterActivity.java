package zpe.jiakeyi.com.zhanpaieaw.activity.login;


import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
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
        register_code = findViewById(R.id.register_code);
        register_find_code = findViewById(R.id.register_find_code);
        register_button = findViewById(R.id.register_button);
    }


    @Override
    public void initDatas(JumpParameter paramer) {

    }

    @Override
    public void setEvents() {
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        register_find_code.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (register_phone_number.getText().toString()
                        != null) {
                    boolean chinaPhoneLegal = isChinaPhoneLegal(register_phone_number.getText().toString());
                    if (chinaPhoneLegal) {
                        verificationTime = (VerificationTime) new VerificationTime(60000, 1000, register_find_code, R.color.myg, R.color.myblue).start();
                        OkHttpUtils.post().url(RequestUtlis.getCode)
                                .addHeader("loginType", "1")
                                .addParams("iphone", register_phone_number.getText().toString())
                                .build()
                                .execute(new StringCallback() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {

                                    }

                                    @Override
                                    public void onResponse(String response, int id) {

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

    private void submit() {
        // validate
        String number = register_phone_number.getText().toString().trim();
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = register_code.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public static boolean isChinaPhoneLegal(String str)
            throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
