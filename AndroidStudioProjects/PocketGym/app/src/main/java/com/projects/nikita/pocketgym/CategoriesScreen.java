package com.projects.nikita.pocketgym;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.nikita.pocketgym.adapters.CategoriesScreenAdapter;
import com.projects.nikita.pocketgym.adapters.InternetAdapter;
import com.projects.nikita.pocketgym.dialogs.CategoryDialog;
import com.projects.nikita.pocketgym.model.CategoriesModel;
import com.projects.nikita.pocketgym.provider.CategoriesProvider;
import com.projects.nikita.pocketgym.testdata.StringTest;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CategoriesScreen extends Activity {

    CategoriesScreenAdapter myAdapter;
    private InternetAdapter iadapter;
    private ListView listView;
    private StringTest data;

    final Uri CAT_CONTENT_URI = Uri.parse("content://com.projects.nikita.pocketgym.provider.Categories/path");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categories_screen);

        listView = (ListView) findViewById(R.id.categoriesListView);
        initInternetAdapter();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        customiseActionBar();

        getMenuInflater().inflate(R.menu.menu_categories_screen, menu);

        return super.onCreateOptionsMenu(menu);
    }
    private void customiseActionBar(){
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
        actionBar.setCustomView(R.layout.custom_actionbar);

        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        TextView tv = (TextView) findViewById(R.id.actionbar_title);
        tv.setText("Categories");
    }

    public void onAddButtonClicked(View v){
        String text = ((TextView)v.getTag()).getText().toString();
        if(!text.isEmpty()) {
            Log.d("mylog", text);
            ContentValues cv = new ContentValues();
            cv.put(CategoriesProvider.COLUMN_NAME, text);
            cv.put(CategoriesProvider.COLUMN_GROUP, StringTest.getCurrentDay());
            getContentResolver().insert(CAT_CONTENT_URI, cv);
            Toast.makeText(this, "Added " + text, Toast.LENGTH_SHORT).show();
        }
    }

    public void callDialog(View v){
        String text = ((TextView) v.findViewById(R.id.textViewCategoryItem)).getText().toString();
        CategoryDialog dialog = CategoryDialog.newInstance();
        Bundle args = new Bundle();
        args.putString(CategoryDialog.CAT_NAME, text);
        dialog.setArguments(args);
        dialog.show(getFragmentManager(), "dlg2");
    }

    private void initInternetAdapter(){
        String file = "categories.html";

        iadapter = new InternetAdapter();
        iadapter.getFeed(file, new Callback<CategoriesModel>() {
            @Override
            public void success(CategoriesModel categoriesModel, Response response) {
                Toast.makeText(CategoriesScreen.this, "success", Toast.LENGTH_SHORT).show();
                myAdapter = new CategoriesScreenAdapter(CategoriesScreen.this, R.layout.category_item,
                        categoriesModel.getCategories());
                listView.setAdapter(myAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(CategoriesScreen.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("mylog", ""+error.toString());
            }
        });
    }
}
