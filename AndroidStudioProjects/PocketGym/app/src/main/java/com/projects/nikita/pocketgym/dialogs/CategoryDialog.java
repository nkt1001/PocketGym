package com.projects.nikita.pocketgym.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.nikita.pocketgym.R;

/**
 * Created by Nikita on 10/11/2015.
 */
public class CategoryDialog extends DialogFragment {
    public static final String CAT_NAME = "name";

    public static CategoryDialog newInstance() {
        Bundle args = new Bundle();
        CategoryDialog fragment = new CategoryDialog();
        fragment.setArguments(args);

        fragment.setStyle(STYLE_NO_FRAME, 0);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle myargs = getArguments();
        String s = myargs.getString(CAT_NAME);

        View myView = inflater.inflate(R.layout.category_dialog_layout, container, true);
        ((TextView)myView.findViewById(R.id.textViewCategoryDialog)).setText(s);

        getDialog().setCanceledOnTouchOutside(true);
        return myView;
    }
}
