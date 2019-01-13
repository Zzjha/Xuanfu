package soexample.umeng.com.w3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import soexample.umeng.com.w3.R;
import soexample.umeng.com.w3.bean.NewsBean;

/**
 * author:author${朱佳华}
 * data:2019/1/12
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private List<NewsBean.DataBean> list;
    private Context context;

    public GroupAdapter(List<NewsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.groupitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //viewHolder.groupTv.setText(list.get(i).getSellerName());

        //childRecy
        List<NewsBean.DataBean.ListBean> list1 = list.get(i).getList();
        ChildAdapter childAdapter = new ChildAdapter(list1,context);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        viewHolder.childRecy.setLayoutManager(manager);
        viewHolder.childRecy.setAdapter(childAdapter);

    }

    @Override
    public int getItemCount() {
        Toast.makeText(context, ""+list.size(), Toast.LENGTH_SHORT).show();
        return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView groupTv;
        private RecyclerView childRecy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //groupTv = itemView.findViewById(R.id.groupTv);
            childRecy = itemView.findViewById(R.id.childRecy);
        }
    }
}
