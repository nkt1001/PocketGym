package com.projects.nikita.pocketgym.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.projects.nikita.pocketgym.R;
import com.projects.nikita.pocketgym.dialogs.MyDialog;
import com.projects.nikita.pocketgym.provider.CategoriesProvider;

public class DayScreenFragment extends ListFragment{
    public interface EmptyCursorListener{
        void enablePlaceholder();
    }
    EmptyCursorListener emptyCursorListener;
    private Cursor myCursor;
    private SimpleCursorAdapter adapter;
    private final String[] from = new String[]{CategoriesProvider.COLUMN_ID, CategoriesProvider.COLUMN_NAME};
    private final int[] to = {R.id.textViewDayScreenItemId, R.id.textViewDayScreenItemName};

    public void setMyCursor(Cursor myCursor) {
        this.myCursor = myCursor;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(myCursor == null || myCursor.getCount() == 0) {
            emptyCursorListener.enablePlaceholder();
            return;
        }

        adapter = new SimpleCursorAdapter(getActivity(), R.layout.dayscreen_category_item, myCursor,
                from, to);
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{ emptyCursorListener = (EmptyCursorListener)activity; }
        catch (ClassCastException e){
            Log.d("mylog", "Interface not implemented in fragment!!");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        String name = ((TextView) v.findViewById(R.id.textViewDayScreenItemName)).getText().toString();
        String stringId = ((TextView)v.findViewById(R.id.textViewDayScreenItemId)).getText().toString();
        int intId = Integer.parseInt(stringId);
        DialogFragment dialogFragment = MyDialog.newInstance();
        Bundle args = new Bundle();
        args.putInt(MyDialog.KEY_POS, intId);
        args.putString(MyDialog.KEY_CAT, name);
        dialogFragment.setArguments(args);

        dialogFragment.show(getFragmentManager(), "dlg1");

    }
    public boolean listIsEmpty(){
        return getListView().getCount()==1;
    }

}
