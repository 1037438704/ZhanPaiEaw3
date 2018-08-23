package zpe.jiakeyi.com.zhanpaieaw.activity.login;

import android.app.Dialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.dialog.listener.OnMenuItemClickListener;
import com.kongzue.dialog.v2.BottomMenu;

import java.util.ArrayList;
import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.utils.ToastUtlis;

/**
 * @author Gjianfu
 * @date 2018/8/13
 * 功能描述:验证码登录页面
 */
@Layout(R.layout.activity_verification)
@DarkStatusBarTheme(true) //开启顶部状态栏图标、文字暗色模式
//@NavigationBarBackgroundColor(a = 255, r = 255, g = 255, b = 255)
////透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的)
//@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色模式
public class VerificationActivity extends BaseActivity {
    private List<String> list;
    private ListView listView;
    private TextView dialog_confirm;
    private TextView image_register;
    private TextView dialog_finish;
    private Dialog bottomDialog;
    private View contentView;
    private View image_return;
    private String count;
    private TextView register_text_login;

    @Override
    public void initViews() {
        register_text_login = findViewById(R.id.register_text_login);
        list = new ArrayList<>();
        image_return = findViewById(R.id.image_return);
        image_register = findViewById(R.id.image_register);
        bottomDialog = new Dialog(this, R.style.BottomDialog);
        contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_normal, null);
        listView = contentView.findViewById(R.id.listView);
        dialog_confirm = contentView.findViewById(R.id.dialog_confirm);
        dialog_finish = contentView.findViewById(R.id.dialog_finish);


        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);

    }

    @Override
    public void initDatas(JumpParameter paramer) {
    }

    @Override
    public void setEvents() {
        register_text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(LoginActivity.class);
            }
        });
        image_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        image_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(RegisterActivity.class);
            }
        });
    }

}
