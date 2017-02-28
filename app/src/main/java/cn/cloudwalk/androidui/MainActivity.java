package cn.cloudwalk.androidui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import cn.cloudwalk.awesome_android_ui.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(this, mDatas));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener()
        {

            @Override
            public void onItemClick(View view, int position)
            {
//                Toast.makeText(MainActivity.this, position + " click",
//                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction(mDatas.get(position));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(MainActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
                mAdapter.removeData(position);
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("circular_progress_button");

    }

}
