package com.example.rathore.assignmentgridviewimages4344;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rathore on 3/23/2017.
 */

public class GridViewImgWithTitle extends AppCompatActivity {
    LayoutInflater inflater;
    GridView gridData;
    // String[] androidImg= new String[]{"English", "Hindi", "Maths", "Science", "Computers", "Punjabi"};
    Integer[] imageIDs = {
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon

    };


    String[] imgName = {
            "GingerBread",
            "HoneyComb",
            "IceCream",
            "JellyBean",
            "Kitkat",
            "Lollipop"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_img_with_title);
        gridData = (GridView)findViewById(R.id.gridviewImgTitle);

        gridData.setAdapter(new CustomGridAdapter(this));

        gridData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),
                        "pic" + (position + 1) + " selected",
                        Toast.LENGTH_SHORT).show();
            }


        });


    }

    public class CustomGridAdapter extends BaseAdapter
    {
        private Context context;

        public CustomGridAdapter(Context c)
        {
            context = c;
            inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }

        //---returns the ID of an item---
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder;
            if(convertView==null){
                convertView= inflater.inflate(R.layout.data_row, parent, false);
                holder= new ViewHolder();
                // holder.view= (TextView)convertView.findViewById(R.id.view);
                holder.imgTitle= (TextView)convertView.findViewById(R.id.imgTitleCnt);
                holder.imgDP= (ImageView) convertView.findViewById(R.id.imgDPCnt);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder)convertView.getTag();
            }

            holder.imgDP.setImageResource(imageIDs[position]);
            holder.imgTitle.setText(imgName[position]);
            return convertView;
        }

        public class ViewHolder{
            //TextView view;
            TextView imgTitle;
            ImageView imgDP;
        }
    }

}
