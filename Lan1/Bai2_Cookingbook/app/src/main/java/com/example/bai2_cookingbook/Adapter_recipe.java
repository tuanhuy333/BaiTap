package com.example.bai2_cookingbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter_recipe extends BaseAdapter {
    Context context;
    int layout;
    List<recipe> recipeList;

    boolean isImageFitToScreen;

    public Adapter_recipe(Context context, int layout, List<recipe> recipeList) {
        this.context = context;
        this.layout = layout;
        this.recipeList = recipeList;
    }

    @Override
    public int getCount() {
        return recipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class viewHolder{
        ImageView img,img_thumnail;
        TextView txt_name;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final viewHolder holder;
        if (convertView == null) {

            //chuyển đổi layout sang java code
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(layout, parent, false);

            //có convertView thì bắt đầu ánh xạ các thành phần
            holder = new viewHolder();
            holder.txt_name = (TextView) convertView.findViewById(R.id.name);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.img_thumnail = (ImageView) convertView.findViewById(R.id.img_thumnail);


            convertView.setTag(holder);

        } else {
            holder = (viewHolder) convertView.getTag();
        }
        final recipe s = recipeList.get(position);

        //gán các giá trị trong mảng vào viewHolder
        holder.txt_name.setText(s.getName());
        holder.img.setImageResource(s.getImage());

        //tao doi tuong listener
        View.OnClickListener mListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(context, WebviewActivity.class);
                    intent.putExtra("url",s.getUrl());
                    context.startActivity(intent);
            }
        };
        //lắng nghe
        holder.txt_name.setOnClickListener(mListener);
        holder.img.setOnClickListener(mListener);

        holder.img_thumnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, HighResActivity.class);
                intent.putExtra("src_img",s.getImage());
                context.startActivity(intent);
            }
        });

        return convertView;
    }


}
