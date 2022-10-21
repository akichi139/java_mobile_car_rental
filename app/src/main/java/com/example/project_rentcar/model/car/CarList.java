package com.example.project_rentcar.model.car;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_rentcar.R;

import java.io.File;
import java.util.List;

public class CarList extends RecyclerView.Adapter<CarList.MyViewHolder> {

    private Context context;
    private List<Car> cars;
    public CarList(Context context){
        this.context = context;
    }

    public void setCarList(List<Car> cars){
        this.cars = cars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_cars, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarList.MyViewHolder holder, int position) {
        holder.tvName.setText(""+this.cars.get(position).name);
        holder.tvBrand.setText("Car Brand : "+this.cars.get(position).brand);
        holder.tvType.setText("Car Type : "+this.cars.get(position).type);
        holder.tvStatus.setText("Car Status : "+this.cars.get(position).status);
        holder.tvSeat.setText("Car seat : "+this.cars.get(position).seat);
        holder.tvGear.setText("Car Gear : "+this.cars.get(position).gear);
        holder.tvBaggage.setText("Car Baggage : "+this.cars.get(position).baggage);
        holder.tvEngine.setText("Car Engine : "+this.cars.get(position).engine);
        holder.tvOwner.setText("Car Owner : "+this.cars.get(position).owner);
        holder.tvRate.setText("Rate : "+this.cars.get(position).rate);
        holder.tvLocation.setText("Pickup Location : "+this.cars.get(position).prLocation);
//        File imgFile = new File(this.cars.get(position).image);
//        if(imgFile.exists()){
//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//            holder.imageView.setImageBitmap(myBitmap);
//        }
    }

    @Override
    public int getItemCount(){
        return this.cars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvName;
        TextView tvBrand;
        TextView tvType;
        TextView tvStatus;
        TextView tvSeat;
        TextView tvGear;
        TextView tvBaggage;
        TextView tvEngine;
        TextView tvOwner;
        TextView tvRate;
        TextView tvLocation;
        ImageView imageView;
        public MyViewHolder(View view){
            super(view);
            tvId = view.findViewById(R.id.tvId);
            tvName = view.findViewById(R.id.tvName);
            tvBrand = view.findViewById(R.id.tvBrand);
            tvType = view.findViewById(R.id.tvType);
            tvStatus = view.findViewById(R.id.tvStatus);
            tvSeat = view.findViewById(R.id.tvSeat);
            tvGear = view.findViewById(R.id.tvGear);
            tvBaggage = view.findViewById(R.id.tvBaggage);
            tvEngine = view.findViewById(R.id.tvEngine);
            tvOwner = view.findViewById(R.id.tvOwner);
            tvRate = view.findViewById(R.id.tvRate);
            tvLocation = view.findViewById(R.id.tvLocation);
//            imageView = view.findViewById(R.id.imageView);
        }
    }
}
