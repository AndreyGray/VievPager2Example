package com.dron.vievpager2example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.dron.vievpager2example.R;

import java.util.List;

//унаследуемся от нужного нам адаптера
public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

//объявляем неоходимые для работы поля
    private List<String> mData;
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;

//вспоминаем и задаем поле-массив с цветами
    private int[] colorArray = new int[]{
            android.R.color.black,
            android.R.color.holo_blue_dark,
            android.R.color.holo_green_dark,
            android.R.color.holo_red_dark};

// и конструктор, который и инициализирует данные для работы адаптера
    public ViewPager2Adapter(Context context, List<String> data, ViewPager2 viewPager2) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.viewPager2 = viewPager2;
    }

//этот метод 44-45 строки выглядит почти всегда одинаково мы задаем разметку итема
// и надуваем ее данными используя привязку к холдеру
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_viewpager, parent, false);
        return new ViewHolder(view);
    }

// этот метод отвечает за привязку холдера(который знает все про въюхи) к данным
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
        holder.mLayout.setBackgroundResource(colorArray[position]);
    }

//  самый простой возвращает количество итемов
    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ConstraintLayout mLayout;
        Button button;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvTitle);
            mLayout = itemView.findViewById(R.id.container);
            button = itemView.findViewById(R.id.btnToggle);

            button.setOnClickListener(v -> {
                if(viewPager2.getOrientation() == ViewPager2.ORIENTATION_VERTICAL) {
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                }
                else{
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                }
            });
        }
    }

}