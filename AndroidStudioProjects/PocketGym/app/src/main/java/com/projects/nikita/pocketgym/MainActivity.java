package com.projects.nikita.pocketgym;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.nikita.pocketgym.adapters.ImageAdapter;

public class MainActivity extends Activity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.gridViewMain);
        gridView.setAdapter(new ImageAdapter(this));

        intent = new Intent(this, DayScreen.class);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position != 7) {
                    intent.putExtra(DayScreen.DAYSCREEN_KEY, position);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "This option is not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        customiseActionBar();

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    private void customiseActionBar(){
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar);

        TextView tv = (TextView) findViewById(R.id.actionbar_title);
        tv.setText("WORKOUT!!!");
    }




}
