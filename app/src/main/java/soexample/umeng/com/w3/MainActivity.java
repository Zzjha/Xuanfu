package soexample.umeng.com.w3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gavin.com.library.StickyDecoration;
import com.gavin.com.library.listener.GroupListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.umeng.com.w3.adapter.GroupAdapter;
import soexample.umeng.com.w3.bean.NewsBean;
import soexample.umeng.com.w3.presenter.MyPresenter;
import soexample.umeng.com.w3.utils.Contracts;
import soexample.umeng.com.w3.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.grouprecy)
    RecyclerView grouprecy;

    private List<NewsBean.DataBean> list = new ArrayList<>();
    private GroupAdapter groupAdapter;
    private MyPresenter myPresenter;
    private Map<String,String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        grouprecy.setLayoutManager(manager);
        myPresenter = new MyPresenter(this);
        groupAdapter = new GroupAdapter(list,this);
        grouprecy.setAdapter(groupAdapter);
        map = new HashMap<>();
        map.put("uid",71+"");
        myPresenter.getRequest(Contracts.URL,NewsBean.class,map);
        sticky();
    }

    private void sticky() {
        //使用StickyDecoration
        StickyDecoration decoration = StickyDecoration.Builder
                .init(new GroupListener() {
                    @Override
                    public String getGroupName(int position) {
                        //组名回调
                        if (list.size() > position) {
                            //获取城市对应的省份
                            return list.get(position).getSellerName();
                        }
                        return null;
                    }
                })
                .setGroupBackground(Color.parseColor("#48BDFF"))//背景色
                .setDivideColor(Color.parseColor("#CCCCCC"))//分割线颜色
                .setGroupTextColor(Color.WHITE)//字体颜色
                // 边距   靠左时为左边距  靠右时为右边距
                .isAlignLeft(false)//靠右显示  （默认靠左）
                .build();
        grouprecy.addItemDecoration(decoration);
    }

    @Override
    public void success(Object success) {
        NewsBean bean = (NewsBean) success;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getList()==null){
                list.remove(list.get(i));
            }
        }
        list.addAll(bean.getData());
        groupAdapter.notifyDataSetChanged();
    }
}
