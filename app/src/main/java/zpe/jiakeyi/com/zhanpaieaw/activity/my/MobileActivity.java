package zpe.jiakeyi.com.zhanpaieaw.activity.my;

import android.view.View;
import android.widget.ImageView;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;

/**
 * @author Gjianfu
 * @date 2018/7/26
 * 功能描述: 修改绑定手机
 */
@Layout(R.layout.activity_mobile)
@DarkStatusBarTheme(true)
public class MobileActivity extends BaseActivity {

    private ImageView image_finish;

    @Override
    public void initViews() {
        image_finish = findViewById(R.id.image_finish);
    }

    @Override
    public void initDatas(JumpParameter paramer) {

    }

    public void requestData() {
        OkHttpUtils.post().url("").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

            }

        });

    }

    @Override
    public void setEvents() {
        image_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
