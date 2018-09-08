package zpe.jiakeyi.com.zhanpaieaw.library.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 *
 * @author dell-pc
 * @date 2018/7/20
 */

public class ToastUtlis {
    private static Toast sSimpleToast;
    private static Toast sImageToast;

    public static void showSimpleToast(Context context,String content){
        if(sSimpleToast==null){
            sSimpleToast=Toast.makeText(context,content,Toast.LENGTH_SHORT);
        }else{
            sSimpleToast.setText(content);
        }
        sSimpleToast.show();
    }

    public static void  showImageToast(Context context,LinearLayout ll){
        if(sImageToast==null){
            sImageToast=new Toast(context);
            sImageToast.setGravity(Gravity.BOTTOM,0,0);
            sImageToast.setView(ll);
            sImageToast.setDuration(Toast.LENGTH_SHORT);
        }else {
            sImageToast.setView(ll);
        }

        sImageToast.show();
    }
}
