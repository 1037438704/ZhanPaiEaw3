package zpe.jiakeyi.com.zhanpaieaw.activity.buy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.baseframework.util.OnResponseListener;
import com.squareup.okhttp.Request;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.ReleaseAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.CityBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;
import zpe.jiakeyi.com.zhanpaieaw.utils.ToastUtlis;

import static android.media.MediaRecorder.VideoSource.CAMERA;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：发布求购页
 *
 * @author dell-pc
 */
@Layout(R.layout.activity_release_for_aty)
@DarkStatusBarTheme(true) //开启顶部状态栏图标、文字暗色模式
public class ReleaseForAty extends BaseActivity {
    private static int imagename;
    private ImageView back_aty;
    private static final int PICTURE = 200;
    private TextView rf_tv_fabu;
    private TextView text_camera;
    private TextView text_photo;
    private TextView text_finish;
    private View contentView;
    private PopupWindow window;
    private LinearLayout ll;
    private ImageView release_imag_camera;
    private AutoRelativeLayout release_rl_classify;
    private View view;
    private RecyclerView dialog_recyclerView;
    private static TextView auto_tv_ch;
    private TextView fenlei_tv;
    private static String city;
    private CityBean.ListBeanXX sheng;
    private CityBean.ListBeanXX.ListBeanX shi;
    private CityBean.ListBeanXX.ListBeanX.ListBean qu;
    private EditText et_title;
    private EditText et_account;
    private EditText et_phone;
    private EditText et_qq;
    private EditText et_weixin;
    private final String items[] = {"实验室仪器", "服务", "家具", "仪器与耗材"};
    private List<String> list;
    private int with = 1;
    private List<String> imgs;
    private AlertDialog dialog;
    private ReleaseAdapter releaseAdapter;

    @Override
    public void initViews() {
        auto_tv_ch = findViewById(R.id.auto_tv_ch);
        list = new ArrayList<>();
        view = LayoutInflater.from(me).inflate(R.layout.dialog_my_classify, null);
        dialog_recyclerView = view.findViewById(R.id.dialog_recyclerView);
        dialog_recyclerView.setLayoutManager(new LinearLayoutManager(me));
        fenlei_tv = findViewById(R.id.fenlei_tv);
        et_title = findViewById(R.id.et_title);
        et_account = findViewById(R.id.et_account);
        et_phone = findViewById(R.id.et_phone);
        et_qq = findViewById(R.id.et_qq);
        et_weixin = findViewById(R.id.et_weixin);
        rf_tv_fabu = findViewById(R.id.rf_tv_fabu);
        release_imag_camera = findViewById(R.id.release_imag_camera);
        release_rl_classify = findViewById(R.id.release_rl_classify);
        back_aty = findViewById(R.id.back_aty);
        // 用于PopupWindow的View
        ll = new LinearLayout(me);
        contentView = LayoutInflater.from(this).inflate(R.layout.layout_popuwindow, null, false);
        text_camera = contentView.findViewById(R.id.text_camera);
        text_photo = contentView.findViewById(R.id.text_photo);
        text_finish = contentView.findViewById(R.id.text_finish);
        list.add(items[0]);
        list.add(items[1]);
        list.add(items[2]);
        list.add(items[3]);
        releaseAdapter = new ReleaseAdapter(R.layout.item_dialog_release, list);
        dialog_recyclerView.setAdapter(releaseAdapter);
        dialog = new AlertDialog.Builder(me)
                .setView(view)
                .create();

    }

    @Override
    public void initDatas(JumpParameter paramer) {
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        window = new PopupWindow(contentView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //点击popupWindow外是否响应
        window.setFocusable(false);
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(false);
        // 设置PopupWindow是否能响应点击事件5
        window.setTouchable(true);
    }

    public void registerData() {
        OkHttpUtils.post().url(RequestUtlis.IA)
                .addHeader("loginType", "1")
                .addHeader("ACCESS_TOKEN", RequestUtlis.Token)
                .addParams("loginId", RequestUtlis.ID)
                .addParams("title", et_title.getText().toString())
                .addParams("content", et_account.getText().toString())
                .addParams("typeA", fenlei_tv.getText().toString())
                .addParams("typeAId", "with")
                .addParams("addressA", "" + sheng.getAreaName())
                .addParams("addressB", "" + shi.getAreaName())
                .addParams("addressC", "" + qu.getAreaName())
                .addParams("addressAId", "" + sheng.getId())
                .addParams("addressBId", "" + shi.getId())
                .addParams("addressCId", "" + qu.getId())
                .addParams("iphoneNo", "" + et_phone.getText().toString())
                .addParams("imgs", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                    }
                });
    }


    @Override
    public void setEvents() {
        //城市选择器
        auto_tv_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(CitySelectionActivity.class, new OnResponseListener() {
                    @Override
                    public void OnResponse(JumpParameter jumpParameter) {
                        if (jumpParameter == null) {
                            toast("选择失败，请重试");
                        } else {
                            sheng = (CityBean.ListBeanXX) jumpParameter.get("省");
                            shi = (CityBean.ListBeanXX.ListBeanX) jumpParameter.get("市");
                            qu = (CityBean.ListBeanXX.ListBeanX.ListBean) jumpParameter.get("区");
                            city = shi.getAreaName() + "   " + qu.getAreaName();
                        }
                    }
                });
            }
        });
        //调用相机
        release_imag_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                lightoff();
            }
        });
        //分类对话框
        release_rl_classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChoice();
            }
        });
        //这里是发布
        rf_tv_fabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("发布按钮");
            }
        });
        //调用相机
        text_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowCamera();
                window.dismiss();
                lighton();
            }
        });
        //调用相册
        text_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowPhoto();
            }
        });
        //取消
        text_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
                lighton();
            }
        });
        //对话框上的点击事件
        releaseAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toast(list.get(position));
                dialog.dismiss();
            }
        });
        back_aty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        auto_tv_ch.setText(city);
    }

    private void windowCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA);
    }

    private void windowPhoto() {
        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(picture, PICTURE);
        window.dismiss();
        lighton();
    }

    /**
     * 设置手机屏幕亮度变暗
     */
    private void lightoff() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);
    }

    /**
     * 设置手机屏幕亮度显示正常
     */
    private void lighton() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().setAttributes(lp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA && resultCode == RESULT_OK && data != null) {
            // 拍照
            Bundle bundle = data.getExtras();
            log(data);
            // 获取相机返回的数据，并转换为图片格式
            Bitmap bitmap = (Bitmap) bundle.get("data");
            ImgPost(null, bitmap);
//            toastUtlis(bitmap, null);

            // TODO 图片从这里拿
//            Glide.with(this).load(bitmap).apply(new RequestOptions().circleCrop()).into(imagView);

        } else if (requestCode == PICTURE && resultCode == RESULT_OK && data != null) {
            /**
             * 调用图库
             */
            Uri selectedImage = data.getData();
            ImgPost(new File(selectedImage + ""), null);
            // TODO 图片从这里拿
//            Glide.with(this).load(selectedImage).apply(new RequestOptions().circleCrop()).into(imagView);
        }
    }

    private void toastUtlis(Bitmap bitmap, Uri string) {
        ImageView imageView = new ImageView(me);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
//            Glide.with(this).load(string).error(new RequestOptions().circleCrop()).into(imageView);
        }
        ll.addView(imageView);
        TextView textView = new TextView(me);
        textView.setText("带图片的Toast信息");
        ll.addView(textView);
        ToastUtlis.showImageToast(me, ll);
    }


    private void dialogChoice() {
        dialog.show();
    }

    private void ImgPost(@Nullable File file, @Nullable Bitmap bitmap) {
        imagename = imagename++;
        if (file == null) {
            file = new File("/mnt/sdcard/zhanpai/" + imagename + "01.png");//将要保存图片的路径
            OkHttpUtils.post()
                    .url(RequestUtlis.singleUploadImg)
                    .addFile("file", imagename + "01.png", file)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Request request, Exception e) {
                            log(e + "");
                        }

                        @Override
                        public void onResponse(String response) {
                            Log.i("图片上传", "onResponse: " + response);
                        }
                    });
        } else {
            OkHttpUtils.post()
                    .url(RequestUtlis.singleUploadImg)
                    .addFile("file", imagename + "01.png", file)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Request request, Exception e) {
                            log(e + "");
                        }

                        @Override
                        public void onResponse(String response) {
                            Log.i("图片上传", "onResponse: " + response);
                        }
                    });

        }
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
