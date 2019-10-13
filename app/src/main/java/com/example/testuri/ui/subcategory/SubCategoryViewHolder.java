package com.example.testuri.ui.subcategory;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testuri.R;
import com.example.testuri.model.SubCategory;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubCategoryViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;
    private SubcategoryListener listener;

    public SubCategoryViewHolder(@NonNull View itemView, SubcategoryListener listener) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
        this.listener = listener;
    }

    public void bind(final SubCategory subCategory) {
        textView.setText(subCategory.getTitle());

        Glide.with(itemView)
                .load(subCategory.getUrl())
                .into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickSubcategory(subCategory);
            }
        });
    }
}
