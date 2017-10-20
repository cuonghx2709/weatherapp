package com.example.cuonghx.hw_weatherapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuonghx.hw_weatherapp.R;
import com.example.cuonghx.hw_weatherapp.utils.Utils;
import com.example.cuonghx.hw_weatherapp.weather.Weather;
import com.example.cuonghx.hw_weatherapp.weather.Weather3Hour;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by cuonghx on 10/19/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForeCastViewHolder> {

    public ForecastAdapter(List<Weather3Hour> list, Context context) {
        this.list = list;
    }

    private List<Weather3Hour> list;
    private Context context;

    @Override
    public ForeCastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycleview, parent, false);

        return new ForeCastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForeCastViewHolder holder, int position) {
        holder.loadData(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ForeCastViewHolder extends RecyclerView.ViewHolder{

        public TextView tvDay ;
        public TextView tv_main;
        public TextView tvDeg;
        public ImageView image;
        public ForeCastViewHolder(View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_day_item);
            tv_main = itemView.findViewById(R.id.tv_tv_main);
            tvDeg = itemView.findViewById(R.id.tv_lowHeightDeg);
            image = itemView.findViewById(R.id.iv_item_icon);

        }
        public void loadData(Weather3Hour weather3Hour, int position) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            tvDeg.setText(String.format("%.0f", weather3Hour.getMain().getTemp() - 273.15));
            tv_main.setText(weather3Hour.getWeather().get(0).getMain());
            Picasso.with(context).load("http://openweathermap.org/img/w/" + weather3Hour.getWeather().get(0).getIcon() + ".png").into(image);

            switch (position){
                case 0:
                    tvDay.setText("Today");
                    break;
                case 1:
                    tvDay.setText("Tomorrow");
                    break;
                case 2:
                    calendar.add(Calendar.DAY_OF_MONTH, 2);
                    tvDay.setText(Utils.getDateFormDayOfWeek(calendar.getTime().getDay()));
                    break;
                case 3:
                    calendar.add(Calendar.DAY_OF_MONTH, 3);
                    tvDay.setText(Utils.getDateFormDayOfWeek(calendar.getTime().getDay()));
                    break;
                case 4:
                    calendar.add(Calendar.DAY_OF_MONTH, 4);
                    tvDay.setText(Utils.getDateFormDayOfWeek(calendar.getTime().getDay()));
                    break;
            }
        }
    }
}
