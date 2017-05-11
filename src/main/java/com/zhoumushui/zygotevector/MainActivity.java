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
        Integer[] integersVector = getVetorDrawableId();
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


    private Integer[] getVetorDrawableId() {
        return new Integer[]{
                R.drawable.ic_accessibility_new,
                R.drawable.ic_accessibility_new_132dp
        };
    }
}
