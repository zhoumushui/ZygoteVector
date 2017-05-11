package com.zhoumushui.zygotevector;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.zhoumushui.zygotevector.util.HintUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ArrayList<Integer> arrayListVector;
    private Integer[] arrayVector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        initialLayout();
    }

    private void initialLayout() {
        GridView gridView = (GridView) findViewById(R.id.gridView);

        arrayListVector = new ArrayList<>();
        Integer[] integersVector = getVectorDrawableId();
        for (int i = 0; i < integersVector.length; i++) {
            arrayListVector.add(integersVector[i]);
        }

        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(context, arrayListVector);
        gridView.setAdapter(myGridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HintUtil.showToast(context, "view:" + view.toString());
            }
        });
    }

    class MyGridViewAdapter extends BaseAdapter {

        Context context;
        ArrayList<Integer> arrayListVector;
        LayoutInflater layoutInflater;

        public MyGridViewAdapter(Context context, ArrayList<Integer> arrayListVector) {
            this.context = context;
            this.arrayListVector = arrayListVector;

            layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return arrayListVector.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayListVector.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder myViewHolder;
            if (convertView == null) {
                myViewHolder = new MyViewHolder();
                convertView = layoutInflater.inflate(R.layout.item_grid_vector, null);
                myViewHolder.imageVector = (ImageView) convertView.findViewById(R.id.imageVector);

                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }

            myViewHolder.imageVector.setImageDrawable(
                    getResources().getDrawable(arrayListVector.get(position)));

            return convertView;
        }

        class MyViewHolder {
            ImageView imageVector;
        }
    }


    private Integer[] getVectorDrawableId() {
        return new Integer[]{
                R.drawable.ic_accessibility_new,
                R.drawable.ic_accessibility_new_132dp,
                R.drawable.ic_access_time,
                R.drawable.ic_access_time_132dp,
                R.drawable.ic_adb,
                R.drawable.ic_adb_132dp,
                R.drawable.ic_add,
                R.drawable.ic_arrow_forward,
                R.drawable.ic_avatar_default,
                R.drawable.ic_bluetooth,
                R.drawable.ic_bluetooth_searching_128dp,
                R.drawable.ic_cast,
                R.drawable.ic_chevron_end,
                R.drawable.ic_delete_132dp,
                R.drawable.ic_error_132dp,
                R.drawable.ic_games,
                R.drawable.ic_headset,
                R.drawable.ic_headset_mic,
                R.drawable.ic_home,
                R.drawable.ic_info_outline,
                R.drawable.ic_input,
                R.drawable.ic_input_132dp,
                R.drawable.ic_keyboard,
                R.drawable.ic_language,
                R.drawable.ic_list_sync_anim,
                R.drawable.ic_location_on,
                R.drawable.ic_lock,
                R.drawable.ic_mic,
                R.drawable.ic_mouse,
                R.drawable.ic_person,
                R.drawable.ic_search,
                R.drawable.ic_settings_backup_restore_132dp,
                R.drawable.ic_settings_system_daydream,
                R.drawable.ic_storage,
                R.drawable.ic_storage_132dp,
                R.drawable.ic_sync,
                R.drawable.ic_sync_problem,
                R.drawable.ic_timeline,
                R.drawable.ic_volume_off,
                R.drawable.ic_volume_up,
                R.drawable.ic_warning_132dp,
                R.drawable.ic_wifi_add,
                R.drawable.ic_wifi_signal_0,
                R.drawable.ic_wifi_signal_1,
                R.drawable.ic_wifi_signal_2,
                R.drawable.ic_wifi_signal_3,
                R.drawable.ic_wifi_signal_4,
                R.drawable.ic_wifi_signal_4_white,
                R.drawable.ic_wifi_signal_4_white_132dp,
                R.drawable.ic_wifi_signal_lock,
                R.drawable.setup_wps
        };
    }
}
