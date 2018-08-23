package zpe.jiakeyi.com.zhanpaieaw.activity.my;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;

import zpe.jiakeyi.com.zhanpaieaw.R;

/**
 * @author Gjianfu
 * @date 2018/8/13
 * 功能描述:
 */
@Layout(R.layout.activity_hellp_booth)
@DarkStatusBarTheme(true)
public class HellpBoothActivity extends BaseActivity {
    private ImageView title_back;
    private TextView title_name;
    private ImageView title_seek;
    private TextView title_text_right;
    private TextView title;
    private TextView content_tv;

    @Override
    public void initViews() {
        title_back = findViewById(R.id.title_back);
        title_name = findViewById(R.id.title_name);
        title_seek = findViewById(R.id.title_seek);
        title_seek.setVisibility(View.GONE);
        title_text_right = findViewById(R.id.title_text_right);
        title_text_right.setVisibility(View.VISIBLE);
        title_name.setText("帮助中心");
    }

    @Override
    public void initDatas(JumpParameter paramer) {

    }

    @Override
    public void setEvents() {
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title_text_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
