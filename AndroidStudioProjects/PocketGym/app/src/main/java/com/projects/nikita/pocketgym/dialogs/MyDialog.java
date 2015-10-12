package com.projects.nikita.pocketgym.dialogs;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.nikita.pocketgym.R;

/**
 * Created by Nikita on 10/9/2015.
 */
public class MyDialog extends DialogFragment implements View.OnClickListener {
    public interface OnDeleteItemListener{
        void deleteItem(int position);
    }
    private OnDeleteItemListener onDeleteItem;

    public static final String KEY_CAT = "cat";
    public static final String KEY_POS = "pos";
    private int itemId;


    public static MyDialog newInstance() {

        Bundle args = new Bundle();

        MyDialog fragment = new MyDialog();
        fragment.setArguments(args);
        fragment.setStyle(STYLE_NO_FRAME, 0);

        return fragment;
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        String category = args.getString(KEY_CAT);
        itemId = args.getInt(KEY_POS);
        String text = "You're going to delete the category " + category + " with id " + itemId;


        View v = inflater.inflate(R.layout.dialog_layout, container, true);
        TextView tv = (TextView) v.findViewById(R.id.dialog_textView);
        tv.setText(text);
        v.findViewById(R.id.dialog_button_cancel)
            .setOnClickListener(this);
        v.findViewById(R.id.dialog_button_delete)
                .setOnClickListener(this);

        getDialog().setCanceledOnTouchOutside(true);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{ onDeleteItem = (OnDeleteItemListener)activity; }
        catch (ClassCastException e){
            Log.d("mylog", "Interface not implemented in fragment!!");
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.dialog_button_cancel:
                dismiss();
                break;
            case R.id.dialog_button_delete:
                onDeleteItem.deleteItem(itemId);
                dismiss();
                break;
        }
    }


}
