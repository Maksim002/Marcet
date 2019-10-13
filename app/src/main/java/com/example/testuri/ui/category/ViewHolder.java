package com.example.testuri.ui.category;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testuri.R;
import com.example.testuri.model.GunType;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;
    private CategoryListener listener;

    public ViewHolder(@NonNull View itemView, CategoryListener listener) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
        this.listener = listener;
    }

    public void bind(final GunType gunType) {
        Glide.with(itemView)
                .load(gunType.getUrl())
                .into(imageView);
        textView.setText(gunType.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickCategory(gunType);
            }
        });
    }
}
