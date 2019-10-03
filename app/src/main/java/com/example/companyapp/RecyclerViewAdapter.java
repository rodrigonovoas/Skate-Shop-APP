package com.example.companyapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_content;
        private ImageView img_recycler;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            img_recycler = (ImageView) itemView.findViewById(R.id.img_recycler);
        }
    }

    public RecyclerViewAdapter(List<Post> postList) {
        this.PostList = postList;
    }

    public List<Post> PostList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_title.setText(PostList.get(position).getTitulo());
        holder.tv_content.setText(PostList.get(position).getContenido());
        holder.img_recycler.setImageResource(PostList.get(position).getImg()); //cargar imagen
    }

    @Override

    public int getItemCount() {
        return PostList.size();
    }
}