package zpe.jiakeyi.com.zhanpaieaw.activity.home;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.android.flexbox.FlexboxLayout;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.HotSeekBean;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;
/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：搜索页
 *
 * @author dell-pc
 */
@Layout(R.layout.activity_seek)
@DarkStatusBarTheme(true)
public class SeekActivity extends BaseActivity {

    private ImageView return_img_seek;
    private FlexboxLayout flexbox_layout;
    private FlexboxLayout flexbox_layout_hot;
    private TextView seek_go_tv;
    private EditText seek_et;
    private FlexboxLayout flexbox_layout_history;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initViews() {
        return_img_seek = (ImageView) findViewById(R.id.return_img_seek);
        flexbox_layout_hot = (FlexboxLayout) findViewById(R.id.flexbox_layout_hot);
        flexbox_layout_history = (FlexboxLayout) findViewById(R.id.flexbox_layout_history);
        seek_go_tv = findViewById(R.id.seek_go_tv);
        seek_et = findViewById(R.id.seek_et);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ResourceAsColor")
    private void addHistoryTextItem(String s) {
        // 通过代码向FlexboxLayout添加View0
        TextView textView = new TextView(this);
        textView.setBackground(getResources().getDrawable(R.drawable.shape_corner_seek));
        textView.setLayoutParams(new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 0, 10, 10);//4个参数按顺序分别是左上右下
        textView.setLayoutParams(layoutParams);
        textView.setText(s);
        textView.setTextSize(12);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(30, 0, 30, 0);
        textView.setTextColor(R.color.seekColorText);
        flexbox_layout_history.addView(textView);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initDatas(JumpParameter paramer) {
        OkHttpUtils.post().url(RequestUtlis.sSE)
                .addHeader("loginType", "1")
                .addParams("", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        HotSeekBean hotSeekBean = gson.fromJson(response, HotSeekBean.class);
                        List<String> list = hotSeekBean.getData().getList();
                        for (int i = 0; i < list.size(); i++) {
                            addHotTextItem(list.get(i));
                        }
                    }

                });
    }

    @Override
    public void setEvents() {
        return_img_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        seek_go_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SeekShowActivity.class, new JumpParameter().put("TextContent", seek_et.getText().toString()));
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ResourceAsColor")
    private void addHotTextItem(String s) {
        // 通过代码向FlexboxLayout添加View
        TextView textView = new TextView(this);
        textView.setBackground(getResources().getDrawable(R.drawable.shape_corner_seek));
        textView.setLayoutParams(new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(25, 15, 25, 15);//4个参数按顺序分别是左上右下
        textView.setLayoutParams(layoutParams);
        textView.setText(s);
        textView.setTextSize(16);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(30, 20, 30, 20);
        textView.setTextColor(R.color.TextColor);
        flexbox_layout_hot.addView(textView);
    }

}
