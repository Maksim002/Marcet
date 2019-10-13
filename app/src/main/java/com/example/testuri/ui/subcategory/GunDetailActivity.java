package com.example.testuri.ui.subcategory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.testuri.R;
import com.example.testuri.model.GunType;
import com.example.testuri.model.SubCategory;
import com.example.testuri.ui.base.BaseActivity;
import com.example.testuri.ui.info.InfoActivity;
import com.example.testuri.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class GunDetailActivity extends BaseActivity implements SubcategoryListener {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String title = getIntent().getStringExtra(TITLE);
        String fileName = getIntent().getStringExtra(KEY);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(title);

        recyclerView = findViewById(R.id.recyclerView);

        SubCategoryAdapter adapter = new SubCategoryAdapter(getSubcategory(fileName), this);
        recyclerView.setAdapter(adapter);
    }

    private List<SubCategory> getSubcategory(String fileName) {
        String json = ResourceManager.readFromAssets(this, fileName);
        Type type = new TypeToken<List<SubCategory>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    @Override
    public void onClickSubcategory(SubCategory subCategory) {
        startActivity(InfoActivity.newInstance(this, subCategory));
    }

    public static Intent newInstance(Context context, GunType gunType) {
        Intent intent = new Intent(context, GunDetailActivity.class);
        intent.putExtra(KEY, gunType.getCategory() + ".json");
        intent.putExtra(TITLE, gunType.getTitle());
        return intent;
    }

    private static String TITLE = "title";
    private static String KEY = "key";
}
