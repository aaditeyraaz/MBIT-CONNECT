package com.example.mbitconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GateStafAdaptor extends RecyclerView.Adapter<GateStafAdaptor.ViewHolder> {
    Context context;
    List<GatepassStafModel> list;

    public GateStafAdaptor(Context context, List<GatepassStafModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GateStafAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.admin_retrive_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GateStafAdaptor.ViewHolder holder, int position) {

        GatepassStafModel model=list.get(position);
        holder.time.setText(model.getTime());
        holder.adminGrant.setText(model.getAdminGrant());
        holder.qrdate.setText(model.getQrdate());
        return;
    }

    @Override
    public int getItemCount() {
        return list.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView time,adminGrant,qrdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time=(TextView) itemView.findViewById(R.id.time);
            adminGrant=(TextView) itemView.findViewById(R.id.adminGrant);
            qrdate=(TextView) itemView.findViewById(R.id.qrdate);
        }
    }
}
