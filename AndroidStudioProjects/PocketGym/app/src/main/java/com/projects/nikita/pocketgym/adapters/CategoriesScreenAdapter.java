package com.projects.nikita.pocketgym.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.nikita.pocketgym.R;

import java.util.List;

/**
 * Created by Nikita on 10/11/2015.
 */
public class CategoriesScreenAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int layoutRes;
    private List<String> data;

    public CategoriesScreenAdapter(Context c, int resource, List<String> data) {
        context = c;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutRes = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
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
        View myView;
        if(convertView == null){ myView = inflater.inflate(layoutRes, parent, false); }
        else { myView = convertView; }
        TextView textView = (TextView) myView.findViewById(R.id.textViewCategoryItem);
        ImageView imView = (ImageView) myView.findViewById(R.id.btnCategoryItem);

        textView.setText(data.get(position));
        imView.setTag(textView);

        return myView;
    }
}
