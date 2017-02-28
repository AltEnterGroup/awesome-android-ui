package cn.cloudwalk.androidui.circularbtn;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.cloudwalk.awesome_android_ui.R;


/**
 * Created by Jing on 17/2/27.
 */

public class Cirprobtn extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] items = getResources().getStringArray(R.array.sample_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position)
        {
            case 0:
                CirprobtnActivity.startThisActivity(this);
                break;
            default:break;
        }
    }
}
