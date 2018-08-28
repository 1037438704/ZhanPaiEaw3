package zpe.jiakeyi.com.zhanpaieaw.base;

import android.os.Bundle;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.util.Preferences;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * 创建时间:  2018/8/22.
 * 编写人:G
 */
public abstract class BaseAty extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        qingqiu();
    }

    private void qingqiu() {
        OkHttpUtils
                .post()
                .url(RequestUtlis.sAr)
                .addParams("", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Preferences.getInstance().set(me, "user", "user", response);
                    }

                });
    }
}
