package zpe.jiakeyi.com.zhanpaieaw;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.autolayout.AutoFrameLayout;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.base.BaseAty;
import zpe.jiakeyi.com.zhanpaieaw.fragment.BuyFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.ExhibitionFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.HomeFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.MassageFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.MyFragment;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：主界面
 *
 * @author dell-pc
 */
@Layout(R.layout.activity_main)
public class MainActivity extends BaseAty implements RadioGroup.OnCheckedChangeListener {
    private AutoFrameLayout frameLayout;
    private RadioButton tabHome;
    private RadioButton tabExhibition;
    private RadioButton tabMassage;
    private RadioButton tabBuy;
    private RadioButton tabPersona;
    private RadioGroup tabGroup;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private ExhibitionFragment exhibitionFragment;
    private MassageFragment massageFragment;
    private BuyFragment buyFragment;
    private MyFragment myFragment;

    @Override
    public void initViews() {
        tabHome = findViewById(R.id.tab_home);
        frameLayout = findViewById(R.id.frame_layout);
        tabExhibition = findViewById(R.id.tab_exhibition);
        tabMassage = findViewById(R.id.tab_massage);
        tabBuy = findViewById(R.id.tab_buy);

        tabPersona = findViewById(R.id.tab_persona);
        tabGroup = findViewById(R.id.tab_group);


        RadioButton tabHome = (RadioButton) tabGroup.getChildAt(0);
        tabHome.setChecked(true);
        tabGroup.setOnCheckedChangeListener(this);
        initFragment();
    }

    @Override
    public void initDatas(JumpParameter paramer) {

    }

    @Override
    public void setEvents() {

    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.frame_layout, homeFragment);
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_home:
                FragmentTransaction ft1 = manager.beginTransaction();
                hideAll(ft1);
                if (homeFragment != null) {
                    ft1.show(homeFragment);
                } else {
                    homeFragment = new HomeFragment();
                    ft1.add(R.id.frame_layout, homeFragment);
                }
                ft1.commit();
                break;
            case R.id.tab_exhibition:
                FragmentTransaction ft2 = manager.beginTransaction();
                hideAll(ft2);
                if (exhibitionFragment != null) {
                    ft2.show(exhibitionFragment);
                } else {
                    exhibitionFragment = new ExhibitionFragment();
                    ft2.add(R.id.frame_layout, exhibitionFragment);
                }
                ft2.commit();
                break;
            case R.id.tab_massage:
                FragmentTransaction ft3 = manager.beginTransaction();
                hideAll(ft3);
                if (massageFragment != null) {
                    ft3.show(massageFragment);
                } else {
                    massageFragment = new MassageFragment();
                    ft3.add(R.id.frame_layout, massageFragment);
                }
                ft3.commit();
                break;
            case R.id.tab_buy:
                FragmentTransaction ft4 = manager.beginTransaction();
                hideAll(ft4);
                if (buyFragment != null) {
                    ft4.show(buyFragment);
                } else {
                    buyFragment = new BuyFragment();
                    ft4.add(R.id.frame_layout, buyFragment);
                }
                ft4.commit();
                break;
            case R.id.tab_persona:
                FragmentTransaction ft5 = manager.beginTransaction();
                hideAll(ft5);
                if (myFragment != null) {
                    ft5.show(myFragment);
                } else {
                    myFragment = new MyFragment();
                    ft5.add(R.id.frame_layout, myFragment);
                }
                ft5.commit();
                break;
            default:
        }
    }

    private void hideAll(FragmentTransaction ft) {
        if (ft == null) {
            return;
        }
        if (homeFragment != null) {
            ft.hide(homeFragment);
        }
        if (exhibitionFragment != null) {
            ft.hide(exhibitionFragment);
        }
        if (massageFragment != null) {
            ft.hide(massageFragment);
        }
        if (buyFragment != null) {
            ft.hide(buyFragment);
        }
        if (myFragment != null) {
            ft.hide(myFragment);
        }
    }
}
