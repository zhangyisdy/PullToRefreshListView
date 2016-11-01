package jhw.ptr.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import jhw.ptr.PullToRefreshLayout;
import jhw.ptr.RefreshHandler;
import jhw.ptr.header.DropHeaderLayout;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by jihongwen on 16/5/24.
 */
public class DropViewFragment extends Fragment {
    List<String> testDatas = new ArrayList<>();

    PullToRefreshListView ptrLayout;
    RecyclerView recyclerList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_base_refresh1, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getTestDatas();
        ptrLayout = (PullToRefreshListView) view.findViewById(R.id.ptrLayout);
        ptrLayout.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                ptrLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrLayout.onRefreshComplete();
                    }
                }, 3000);
            }
        });

        ptrLayout.setAdapter(new XAdapter());

    }

    private void getTestDatas() {
        testDatas.add("test");
        testDatas.add("test");
        testDatas.add("test");
        testDatas.add("test");
        testDatas.add("test");
        testDatas.add("test");
        testDatas.add("test");
        testDatas.add("test");
        testDatas.add("test");
    }

    class XAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return testDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getActivity().getLayoutInflater().inflate(R.layout.adapter_test_item_view, parent, false);
            TextView text = (TextView) convertView.findViewById(R.id.title);
            text.setText(testDatas.get(position));
            return convertView;
        }
    }

    class XViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public XViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
