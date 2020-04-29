package com.example.bai3_landmarks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_landmarks extends BaseAdapter {
    Context context;
    int layout;
    List<Landmark> landmarkList;

    public Adapter_landmarks(Context context, int layout, List<Landmark> landmarkList) {
        this.context = context;
        this.layout = layout;
        this.landmarkList = landmarkList;
    }

    @Override
    public int getCount() {
        return landmarkList.size();
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
        TextView txt_stt,txt_name;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null) {

            //chuyển đổi layout sang java code
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(layout, parent, false);

            //có convertView thì bắt đầu ánh xạ các thành phần
            holder = new viewHolder();
            holder.txt_stt = (TextView) convertView.findViewById(R.id.stt);
            holder.txt_name = (TextView) convertView.findViewById(R.id.name);


            convertView.setTag(holder);

        } else {
            holder = (viewHolder) convertView.getTag();
        }
        Landmark landmark=landmarkList.get(position);

        //gán các giá trị trong mảng vào viewHolder
        holder.txt_stt.setText(landmark.getStt()+"");
        holder.txt_name.setText(landmark.getName());
        //holder.avt.setImageResource(sv.getAvt()); hình

        return convertView;

    }
}
