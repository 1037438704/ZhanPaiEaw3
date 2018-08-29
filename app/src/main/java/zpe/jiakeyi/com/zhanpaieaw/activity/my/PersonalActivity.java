package zpe.jiakeyi.com.zhanpaieaw.activity.my;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.UUID;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.utils.RealPathFromUriUtils;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.media.MediaRecorder.VideoSource.CAMERA;

/**
 * @author Gjianfu
 * @date 2018/7/26
 * 功能描述: 个人消息界面
 */
@Layout(R.layout.activity_personal)
@DarkStatusBarTheme(true)
public class PersonalActivity extends BaseActivity {
    private AutoLinearLayout personal_user_name;
    private AutoLinearLayout personal_alter_pas;
    private ImageView personal_imag_finish;
    private AutoLinearLayout image_setting;
    private AutoLinearLayout sex_setting;
    private TextView phone_set_tv;
    private AutoLinearLayout phone_setting;
    private TextView is_checked_wx;
    private AutoLinearLayout wencht_setting;
    private TextView is_check_qq;
    private TextView text_camera;
    private TextView text_photo;
    private TextView text_finish;
    private static final int PICTURE = 200;
    private View contentView;
    private PopupWindow window;
    private LinearLayout ll;

    @Override
    public void initViews() {
        personal_user_name = findViewById(R.id.personal_user_name);
        personal_alter_pas = findViewById(R.id.personal_alter_pas);
        personal_imag_finish = findViewById(R.id.personal_imag_finish);
        image_setting = findViewById(R.id.image_setting);
        sex_setting = findViewById(R.id.sex_setting);
        phone_set_tv = findViewById(R.id.phone_set_tv);
        phone_setting = findViewById(R.id.phone_setting);
        is_checked_wx = findViewById(R.id.is_checked_wx);
        wencht_setting = findViewById(R.id.wencht_setting);
        ll = new LinearLayout(me);
        contentView = LayoutInflater.from(this).inflate(R.layout.layout_popuwindow, null, false);
        text_camera = contentView.findViewById(R.id.text_camera);
        text_photo = contentView.findViewById(R.id.text_photo);
        text_finish = contentView.findViewById(R.id.text_finish);
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

    @Override
    public void setEvents() {
        //跳转到用户名界面
        personal_user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(UserNameActivity.class);
            }
        });
        //跳转到密码修改界面
        personal_alter_pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(PasswordActivity.class);
            }
        });
        //返回上一界面
        personal_imag_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置头像
        image_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestAllPower();
                window.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                lightoff();
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
        phone_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(MobileActivity.class);
            }
        });

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

    public void requestAllPower() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
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
                        ImgPost(file);
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
            ImgPost(file);
            // TODO 图片从这里拿
//            Glide.with(this).load(selectedImage).apply(new RequestOptions().circleCrop()).into(imagView);
        }

    }

    private void ImgPost(File file) {
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
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.e("上传成功", "onResponse: " + response);

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