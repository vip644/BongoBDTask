package com.example.videoplayer.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;

/**
 * Created by vipin.c on 03/05/2019
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView{


    protected Context mContext = this;
    protected LayoutInflater mInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());
        mInflater = LayoutInflater.from(mContext);
        initializeViews(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onActivityStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        onActivityStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onActivityBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onActivityPause();
    }

    protected abstract void onActivityPause();

    protected abstract void onActivityBackPressed();

    protected abstract void onActivityStop();

    protected abstract void onActivityStart();

    protected abstract int getResourceLayout();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected abstract void initializeViews(Bundle savedInstanceState);
}
