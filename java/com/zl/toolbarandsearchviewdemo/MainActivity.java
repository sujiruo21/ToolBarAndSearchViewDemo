package com.zl.toolbarandsearchviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("标题");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_search);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"ToolBar",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        //在Menu里面取SearchView
        MenuItem menuItem = menu.findItem(R.id.action_searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();

        //设置页面绘制完成时直接显示搜索框
        searchView.setIconified(false);

        //设置页面绘制完成时直接显示搜索框并且不能被隐藏
//        searchView.setIconifiedByDefault(false);

        //自定义扩展效果
        ImageView imageView = searchView.findViewById(R.id.search_go_btn);
        imageView.setImageResource(android.R.drawable.stat_sys_upload);
        searchView.setSubmitButtonEnabled(true);

        //改变输入框的提示
        EditText editText = searchView.findViewById(R.id.search_src_text);
        editText.setHint("请输入");
        editText.setHintTextColor(Color.WHITE);

        //添加监听
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"OnClickListener",Toast.LENGTH_SHORT).show();
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(MainActivity.this,"OnCloseListener",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText(MainActivity.this,"OnQueryTextFocusChangeListener",Toast.LENGTH_SHORT).show();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"QueryTextSubmit",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this,"QueryTextChange",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                Toast.makeText(MainActivity.this,"OnSuggestionListener",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                Toast.makeText(MainActivity.this,"onSuggestionClick",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"OnSearchClickListener",Toast.LENGTH_SHORT).show();
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:

                break;
            case R.id.action_searchView:

                break;
            default:

                break;
        }
        return true;
    }
}
