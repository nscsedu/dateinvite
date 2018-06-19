package com.braincraft.social.activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.braincraft.social.R;

import java.util.List;
/**
 * Created by ADMIN on 16/5/2018.
 */

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

    Context context;

    List<GetDataAdapter> getDataAdapter;

    public RecyclerViewAdapter1(List<GetDataAdapter> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.page_model, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);

        holder.NameTextView.setText(getDataAdapter1.getName());

        holder.IdTextView.setText(String.valueOf(getDataAdapter1.getId()));

        holder.PhoneNumberTextView.setText(getDataAdapter1.getPhone_number());

        holder.SubjectTextView.setText(getDataAdapter1.getSubject());

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView IdTextView;
        public TextView NameTextView;
        public TextView PhoneNumberTextView;
        public TextView SubjectTextView;


        public ViewHolder(View itemView) {

            super(itemView);

            IdTextView = (TextView) itemView.findViewById(R.id.nameTxt) ;
            NameTextView = (TextView) itemView.findViewById(R.id.count) ;
            PhoneNumberTextView = (TextView) itemView.findViewById(R.id.invitesreceived) ;
            SubjectTextView = (TextView) itemView.findViewById(R.id.avilablefor) ;


        }
    }
}