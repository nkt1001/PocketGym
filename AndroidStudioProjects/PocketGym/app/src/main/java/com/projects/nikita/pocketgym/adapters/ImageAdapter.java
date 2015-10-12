package com.projects.nikita.pocketgym.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.nikita.pocketgym.R;
import com.projects.nikita.pocketgym.testdata.StringTest;

/**
 * Created by Nikita on 10/2/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private StringTest data = new StringTest();
    private LayoutInflater inflater;
    private int width;
    private int height;

    public ImageAdapter(Context c) {
        context = c;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        width = context.getResources().getDisplayMetrics().widthPixels;
        height = context.getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public int getCount() {
        return data.getImages().length;
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
        FrameLayout frameLayout;

        if(convertView == null) {
            //получаем элемент для нашего layout и настраиваем
            frameLayout = (FrameLayout) inflater.inflate(R.layout.main_menu_item,parent,false);
            frameLayout.setLayoutParams(new GridView.LayoutParams(width / 2, height / 4));

        } else {
            frameLayout = (FrameLayout) convertView;
        }
        //добавляем строки в textview и imageview

        TextView textView = (TextView) frameLayout.findViewById(R.id.textViewMain);
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.imageViewMain);

        imageView.setImageResource(data.getImage(position));
        textView.setText(data.getDay(position));

        return frameLayout;
    }

}
