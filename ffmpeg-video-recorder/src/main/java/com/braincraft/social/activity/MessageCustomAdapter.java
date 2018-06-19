package com.braincraft.social.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.braincraft.social.R;
import com.braincraft.social.activity.MessageModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ADMIN on 18/5/2018.
 */

public class MessageCustomAdapter extends RecyclerView.Adapter<MessageCustomAdapter.ProductViewHolder> {


        //this context we will use to inflate the layout
        private Context mCtx;

        //we are storing all the products in a list
        private List<MessageModel> productList;

        //getting the context and product list with constructor
        public MessageCustomAdapter(Context mCtx, List<MessageModel> productList) {
                this.mCtx = mCtx;
                this.productList = productList;
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                //inflating and returning our view holder
                LayoutInflater inflater = LayoutInflater.from(mCtx);
                View view = inflater.inflate(R.layout.message_text, null);
                return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
                //getting the product of the specified position
               MessageModel product = productList.get(position);

                //binding the data with the viewholder views
                holder.textViewUsername.setText(product.getUsername());
                holder.textViewLocation.setText(product.getLocation());
                holder.textViewMessage.setText(String.valueOf(product.getMessage()));
                holder.textViewDate.setText(String.valueOf(product.getDate()));
               // holder.textViewPrice.setText(String.valueOf(product.getPrice()));

               // holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        }


        @Override
        public int getItemCount() {
                return productList.size();
        }


        class ProductViewHolder extends RecyclerView.ViewHolder {

                TextView textViewUsername, textViewLocation, textViewMessage, textViewDate;
              //  ImageView imageView;

                public ProductViewHolder(View itemView) {
                        super(itemView);

                        textViewUsername = itemView.findViewById(R.id.username);
                        textViewLocation = itemView.findViewById(R.id.location);
                        textViewMessage = itemView.findViewById(R.id.message);
                        textViewDate = itemView.findViewById(R.id.date);
                       // imageView = itemView.findViewById(R.id.imageView);
                }
        }
}