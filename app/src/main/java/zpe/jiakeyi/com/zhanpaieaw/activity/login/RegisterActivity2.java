package zpe.jiakeyi.com.zhanpaieaw.activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.base.BaseAty;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

@Layout(R.layout.activity_register2)
@DarkStatusBarTheme(false) //开启顶部状态栏图标、文字暗色模式
public class RegisterActivity2 extends BaseAty {

    private ImageView image_return;
    private ImageView image_logo;
    private EditText register_phone_number;
    private EditText register_password;
    private TextView register_button;
    private TextView zhuce_xy;
    private String phone;
    private String code;

    @Override
    public void initViews() {
        image_return = (ImageView) findViewById(R.id.image_return);
        image_logo = (ImageView) findViewById(R.id.image_logo);
        register_phone_number = (EditText) findViewById(R.id.register_phone_number);
        register_password = (EditText) findViewById(R.id.register_password);
        register_button = (TextView) findViewById(R.id.register_button);
        zhuce_xy = (TextView) findViewById(R.id.zhuce_xy);
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        if (paramer != null) {
            phone = paramer.getString("phone");
            code = paramer.getString("code");
            register_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submit();
                    OkHttpUtils.post().url(RequestUtlis.RegisterUser)
                            .addHeader("loginType", "1")
                            .addParams("phoneNum", phone)
                            .addParams("password", register_password.getText().toString())
                            .addParams("code", code)
                            .build()
                            .execute(new StringCallback() {
                                @Override
                                public void onError(Call call, Exception e, int id) {
                                    Toast.makeText(me, "注册失败,请重试", Toast.LENGTH_SHORT).show();
                                    jump(RegisterActivity.class);
                                }

                                @Override
                                public void onResponse(String response, int id) {
                                    Toast.makeText(me, "注册成功", Toast.LENGTH_SHORT).show();
                                    jump(LoginActivity.class);
                                }
                            });
                }
            });
        }
    }


    @Override
    public void setEvents() {
    }

    private void submit() {
        // validate
        String number = register_phone_number.getText().toString().trim();
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = register_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
