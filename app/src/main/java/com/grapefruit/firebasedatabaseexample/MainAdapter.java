package com.grapefruit.firebasedatabaseexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.grapefruit.firebasedatabaseexample.databinding.ViewMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Board> boards = new ArrayList<>();

    public MainAdapter(List<Board> list) {
        boards = list;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_main, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Board b = boards.get(position);
        if (b != null) {
            holder.binding.name.setText(b.getName());
            holder.binding.title.setText(b.getTitle());
            holder.binding.content.setText(b.getContent());
            holder.binding.date.setText(b.getDate());
        }
    }

    @Override
    public int getItemCount() {
        return boards.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private ViewMainBinding binding;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
