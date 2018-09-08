package zpe.jiakeyi.com.zhanpaieaw.activity.my;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.autolayout.AutoLinearLayout;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

@Layout(R.layout.activity_setting)
@DarkStatusBarTheme(true)
public class SettingActivity extends BaseActivity {

    private ImageView personal_imag_finish;
    private AutoLinearLayout record_auto1;
    private AutoLinearLayout record_auto2;
    private AutoLinearLayout record_auto3;
    private AutoLinearLayout record_auto4;
    private AutoLinearLayout record_auto5;

    @Override
    public void initViews() {
        personal_imag_finish = findViewById(R.id.personal_imag_finish);
        record_auto1 = findViewById(R.id.record_auto1);
        record_auto2 = findViewById(R.id.record_auto2);
        record_auto3 = findViewById(R.id.record_auto3);
        record_auto4 = findViewById(R.id.record_auto4);
        record_auto5 = findViewById(R.id.record_auto5);

    }

    @Override
    public void initDatas(JumpParameter paramer) {

    }

    @Override
    public void setEvents() {
        personal_imag_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        record_auto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(ManagementActivity.class);
            }
        });
        record_auto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        record_auto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        record_auto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        record_auto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestUtlis.Token = null;
                RequestUtlis.ID = null;
                EMClient.getInstance().logout(true);
                //此方法为同步方法
                finish();
                SharedPreferences sp = getSharedPreferences("UseUser", MODE_PRIVATE);
                if (sp != null) {
                    sp.edit().clear().commit();
                    Toast.makeText(me, "数据已清空", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(me, "您已退出登录", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
