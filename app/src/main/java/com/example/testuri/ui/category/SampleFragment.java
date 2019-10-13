package com.example.testuri.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testuri.R;
import com.example.testuri.model.GunType;
import com.example.testuri.ui.subcategory.GunDetailActivity;
import com.example.testuri.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class SampleFragment extends Fragment implements CategoryListener {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        String fileName = getArguments().getString(KEY);
        Adapter adapter = new Adapter(getGunCategories(fileName), this);
        recyclerView.setAdapter(adapter);
    }

    private List<GunType> getGunCategories(String fileName) {
        String json = ResourceManager.readFromAssets(getContext(), fileName);
        Type type = new TypeToken<List<GunType>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    private static String KEY = "key";

    public static SampleFragment getInstance(String fileName) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY, fileName);
        SampleFragment fragment = new SampleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClickCategory(GunType gunType) {
        startActivity(GunDetailActivity.newInstance(getContext(), gunType));
    }
}
