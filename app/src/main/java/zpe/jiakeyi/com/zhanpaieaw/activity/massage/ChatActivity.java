package zpe.jiakeyi.com.zhanpaieaw.activity.massage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.platform.comapi.map.C;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.util.EasyUtils;

import zpe.jiakeyi.com.zhanpaieaw.MainActivity;
import zpe.jiakeyi.com.zhanpaieaw.R;

public class ChatActivity extends AppCompatActivity {
    public static ChatActivity activityInstance;
    private EaseChatFragment chatFragment;
    String toChatUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);
        activityInstance = this;
        //get user id or group id
        toChatUsername = getIntent().getExtras().getString("userId");
        //use EaseChatFratFragment
        chatFragment = new EaseChatFragment();
        //pass parameters to chat fragment
        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.chat, chatFragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityInstance = null;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // make sure only one chat activity is opened
        String username = intent.getStringExtra("userId");
        if (toChatUsername.equals(username))
            super.onNewIntent(intent);
        else {
            finish();
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        chatFragment.onBackPressed();
        if (EasyUtils.isSingleActivity(this)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public String getToChatUsername() {
        return toChatUsername;
    }

}
