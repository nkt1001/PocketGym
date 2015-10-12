package com.projects.nikita.pocketgym;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.nikita.pocketgym.dialogs.MyDialog;
import com.projects.nikita.pocketgym.fragments.DayScreenFragment;
import com.projects.nikita.pocketgym.fragments.PlaceholderFragment;
import com.projects.nikita.pocketgym.provider.CategoriesProvider;
import com.projects.nikita.pocketgym.testdata.StringTest;


/**
 * Created by Nikita on 10/4/2015.
 */
public class DayScreen extends FragmentActivity implements MyDialog.OnDeleteItemListener, DayScreenFragment.EmptyCursorListener {
    public static final String DAYSCREEN_KEY = "key";

    StringTest data = new StringTest();
    private int day;
    private PlaceholderFragment placeholderFragment;
    private DayScreenFragment dayScreenFragment;
    private Intent intent;
    public Cursor myCursor;
    final Uri CAT_CONTENT_URI = Uri.parse("content://com.projects.nikita.pocketgym.provider.Categories/path");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dayscreen_layout);

        if((day = getIntent().getIntExtra(DAYSCREEN_KEY, -1)) != -1){
             //getIntent().getIntExtra(DAYSCREEN_KEY, -1);
            StringTest.setCurrentDay(day);
        }
        else{day = StringTest.getCurrentDay();}

        intent = new Intent(this, CategoriesScreen.class);

        myCursor = getContentResolver().query(CAT_CONTENT_URI, null, CategoriesProvider.COLUMN_GROUP+ " = " +StringTest.getCurrentDay(),
                null, null);
        startManagingCursor(myCursor);


        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
           dayScreenFragment = new DayScreenFragment();

            dayScreenFragment.setMyCursor(myCursor);
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, dayScreenFragment).commit();

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, dayScreenFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        customiseActionBar();

        getMenuInflater().inflate(R.menu.menu_dayscreen, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void customiseActionBar(){

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
        actionBar.setCustomView(R.layout.custom_actionbar);

        actionBar.setHomeButtonEnabled(true);
        actionBar.setIcon(R.drawable.ic_back);

        TextView tv = (TextView) findViewById(R.id.actionbar_title);
        tv.setText(data.getDay(day));

    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
       // Toast.makeText(this, R.id.actionAdd + " = " + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.actionAdd:
                startActivity(intent);
        }
        return super.onMenuItemSelected(featureId, item);
    }
    public void addExercise(View v){
        startActivity(intent);
    }

    public void enablePlaceholder() {
        if (placeholderFragment == null){
            placeholderFragment = new PlaceholderFragment();

        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, placeholderFragment).commit();
    }

    @Override
    public void deleteItem(int position) {
        Uri uri = ContentUris.withAppendedId(CAT_CONTENT_URI, position);
        getContentResolver().delete(uri, null, null);
        Toast.makeText(this, "Deleted id = " + position, Toast.LENGTH_SHORT).show();

        if(dayScreenFragment.listIsEmpty()){
            enablePlaceholder();
        }
    }
}
