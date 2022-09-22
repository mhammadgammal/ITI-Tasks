package com.example.ititask7;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DaysViewHolder> {

    List<String> daysList = new ArrayList<>();
    List<Integer> imageOfDays = new ArrayList<>();
    OnDayClickListener listener;

    public DaysAdapter(OnDayClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaysViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item, parent, false), listener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DaysViewHolder holder, int position) {
        holder.dayTv.setText(daysList.get(position));
        holder.dayImg.setImageResource(imageOfDays.get(position));
        holder.dayDescriptionTV.setText(daysList.get(position) + " description");
    }

    @Override
    public int getItemCount() {
        return daysList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setDaysList(List<String> daysList) {
        this.daysList = daysList;
        notifyDataSetChanged();
    }

    public void setImageOfDays(List<Integer> imageOfDays) {
        this.imageOfDays = imageOfDays;
    }

    protected static class DaysViewHolder extends RecyclerView.ViewHolder {
        TextView dayTv, dayDescriptionTV;
        ImageView dayImg;
        public DaysViewHolder(@NonNull View itemView, OnDayClickListener listener) {
            super(itemView);
            dayDescriptionTV = itemView.findViewById(R.id.day_description_text_view);
            dayImg = itemView.findViewById(R.id.day_img);
            dayTv = itemView.findViewById(R.id.day_text_view);
            itemView.setOnClickListener(view -> listener.onDayClickListener(getAdapterPosition()));
        }
    }
    public interface OnDayClickListener{
        void onDayClickListener(int position);
    }
}
