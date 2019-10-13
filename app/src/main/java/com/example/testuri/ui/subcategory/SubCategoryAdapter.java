package com.example.testuri.ui.subcategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testuri.R;
import com.example.testuri.model.SubCategory;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryViewHolder> {
    private List<SubCategory> list;
    private SubcategoryListener listener;

    public SubCategoryAdapter(List<SubCategory> list, SubcategoryListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SubCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_subcategory, parent, false);
        return new SubCategoryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
