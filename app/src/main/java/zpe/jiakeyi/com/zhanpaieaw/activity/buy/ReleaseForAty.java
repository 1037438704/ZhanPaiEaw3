package zpe.jiakeyi.com.zhanpaieaw.activity.buy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.baseframework.util.OnResponseListener;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.ReleaseAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.CityBean;
import zpe.jiakeyi.com.zhanpaieaw.bean.ImgPostBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RealPathFromUriUtils;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;
import zpe.jiakeyi.com.zhanpaieaw.utils.ToastUtlis;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
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
    private ImageView Image_4;
    private ImageView Image_1;
    private ImageView Image_2;
    private ImageView Image_3;
    private ImageView Image_5;
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
    private static List<File> files;
    private static String ImageString;
    private static List<String> stringList;

    @Override
    public void initViews() {
        stringList = new ArrayList<>();
        files = new ArrayList<>();
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
        Image_4 = findViewById(R.id.Image_4);
        Image_1 = findViewById(R.id.Image_1);
        Image_2 = findViewById(R.id.Image_2);
        Image_3 = findViewById(R.id.Image_3);
        Image_5 = findViewById(R.id.Image_5);
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
                    public void onError(Call call, Exception e, int id) {
                        Log.i("发布失败", "onError: " + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("发布???", "onResponse: " + response);
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
        Image_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestAllPower();
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
                PostImage();
            }
        });
        //调用相机
        text_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCamera();
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
                fenlei_tv.setText(items[position]);
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

    private void addFile(File file) {
        files.add(file);
        ImageSetImage();
    }

    private void ImageSetImage() {
        switch (files.size()) {
            case 1:
                Image_1.setVisibility(View.VISIBLE);
                Log.i("地址?", "ImageSetImage: " + files.get(0).getPath());
                Image_1.setImageBitmap(BitmapFactory.decodeFile(files.get(0).getPath()));
                break;
            case 2:
                Image_2.setVisibility(View.VISIBLE);
                Image_2.setImageBitmap(BitmapFactory.decodeFile(files.get(1).getPath()));
                break;
            case 3:
                Image_3.setVisibility(View.VISIBLE);
                Image_3.setImageBitmap(BitmapFactory.decodeFile(files.get(2).getPath()));
                break;
            case 4:
                Image_5.setVisibility(View.VISIBLE);
                Image_4.setVisibility(View.GONE);
                Image_5.setImageBitmap(BitmapFactory.decodeFile(files.get(3).getPath()));
                break;

        }
    }

    private void Delit(File file) {

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
        final Bitmap bitmap;

        if (requestCode == CAMERA && resultCode == RESULT_OK && data != null) {
            // 拍照
            Bundle bundle = data.getExtras();
            Log.i("img", "onActivityResult: " + bundle.get("data"));
            // 获取相机返回的数据，并转换为图片格式
            bitmap = (Bitmap) bundle.get("data");
//            toastUtlis(bitmap, null);
            final String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ZhanPai/MyImage/";
            //获取内部存储状态
            String state = Environment.getExternalStorageState();
            //如果状态不是mounted，无法读写
            if (!state.equals(Environment.MEDIA_MOUNTED)) {
                return;
            }
            //通过UUID生成字符串文件名
            final String fileName1 = UUID.randomUUID().toString();
            //通过Random()类生成数组命名
            Random random = new Random();
            String fileName2 = String.valueOf(random.nextInt(Integer.MAX_VALUE));
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        File file1 = new File(dir);
                        File file = new File(dir + fileName1 + ".png");
                        if (!file1.exists()) {

                            file1.mkdirs();//创建目录
                        }
                        FileOutputStream out = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                        out.flush();
                        out.close();
                        Uri uri = Uri.fromFile(file);
                        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
                        Log.i("图片地址", "onActivityResult: " + file.getPath());
                        if (file.exists()) {
                            addFile(file);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            // TODO 图片从这里拿
//            Glide.with(this).load(bitmap).apply(new RequestOptions().circleCrop()).into(imagView);

        } else if (requestCode == PICTURE && resultCode == RESULT_OK && data != null) {
            /**
             * 调用图库
             */
            String realPathFromUri = RealPathFromUriUtils.getRealPathFromUri(this, data.getData());
            File file = new File(realPathFromUri);
            addFile(file);
            // TODO 图片从这里拿
//            Glide.with(this).load(selectedImage).apply(new RequestOptions().circleCrop()).into(imagView);
        }

    }

    public void requestAllPower() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
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

    private void PostImage() {
        for (int i = 0; i < files.size(); i++) {
            ImgPost(files.get(i));
        }
    }

    private void ImgPost(final File file) {
        File myfile = new File(file.getParent());
        if (myfile.exists()) {
            OkHttpUtils
                    .post()
                    .url(RequestUtlis.singleUploadImg)
                    .addFile("file", file.getName(), file)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.e("上传失败", "onError: " + e);
                            ImgPost(file);
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.e("上传成功", "onResponse: " + response);
                            Gson gson = new Gson();
                            ImgPostBean imgPostBean = gson.fromJson(response, ImgPostBean.class);
                            if (imgPostBean.getCode() == 1) {
                                Log.i("图片地址", "PostImage: " + ImageString);
                                ImageAdd(imgPostBean.getData().getImgUrl());
                            } else {
                                Toast.makeText(me, "" + imgPostBean.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        private void ImageAdd(String string) {
                            stringList.add(string);
                        }
                    });
        }

    }

    public void getCamera() {
        //判断是否已经赋予权限
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PERMISSION_GRANTED) {
            //如果应用之前请求过此权限但用户拒绝了请求，此方法将返回 true。
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {//这里可以写个对话框之类的项向用户解释为什么要申请权限，并在对话框的确认键后续再次申请权限
            } else {
                //申请权限，字符串数组内是一个或多个要申请的权限，1是申请权限结果的返回参数，在onRequestPermissionsResult可以得知申请结果
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA,}, 1);
            }
        } else {
            windowCamera();
            window.dismiss();
            lighton();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {
                    windowCamera();
                    window.dismiss();
                    lighton();
                } else {
                    Toast.makeText(this, "" + "权限" + permissions[i] + "申请失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
