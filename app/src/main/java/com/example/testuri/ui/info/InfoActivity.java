package com.example.testuri.ui.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.testuri.R;
import com.example.testuri.model.SubCategory;
import com.example.testuri.ui.base.BaseActivity;

public class InfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra(TITLE);
        setTitle(title);
    }


    public static Intent newInstance(Context context, SubCategory subCategory) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(TITLE, subCategory.getTitle());
        return intent;
    }

    private static String TITLE = "title";
}
