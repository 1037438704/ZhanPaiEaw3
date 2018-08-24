package zpe.jiakeyi.com.zhanpaieaw.activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.base.BaseAty;
@Layout(R.layout.activity_register2)
@DarkStatusBarTheme(false) //开启顶部状态栏图标、文字暗色模式
public class RegisterActivity2 extends BaseAty {

    private ImageView image_return;
    private ImageView image_logo;
    private EditText register_phone_number;
    private EditText register_password;
    private TextView register_button;
    private TextView zhuce_xy;
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
