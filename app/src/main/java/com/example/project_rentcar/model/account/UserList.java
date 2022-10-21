package com.example.project_rentcar.model.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_rentcar.R;

import java.util.List;

public class UserList extends RecyclerView.Adapter<UserList.MyViewHolder> {

    private Context context;
    private List<User> userList;
    public UserList(Context context){
        this.context = context;
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_user, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public  void onBindViewHolder(@NonNull UserList.MyViewHolder holder, int position){
        holder.tvId.setText("User ID : "+this.userList.get(position).id);
        holder.tvUsername.setText("User Username : "+this.userList.get(position).id);
        holder.tvPassword.setText("User Password : "+this.userList.get(position).id);
        holder.tvPhoneNum.setText("User PhoneNumber : "+this.userList.get(position).id);
    }

    @Override
    public int getItemCount(){
        return this.userList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvUsername;
        TextView tvPassword;
        TextView tvPhoneNum;
        public MyViewHolder(View view){
            super(view);
            tvId = view.findViewById(R.id.tvId);
            tvUsername = view.findViewById(R.id.tvName);
            tvPassword = view.findViewById(R.id.tvBrand);
            tvPhoneNum = view.findViewById(R.id.tvPhoneNum);
        }
    }
}
