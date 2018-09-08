package zpe.jiakeyi.com.zhanpaieaw.library.bean;

import com.kongzue.baseframework.BaseAdapter;

/**
 * Created by Administrator on 2018/8/8.
 */

public class TextBean extends BaseAdapter.BaseDataBean  {
    String title;

    @Override
    public TextBean setType(int type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TextBean setTitle(String title) {
        this.title = title;
        return this;
    }

}
