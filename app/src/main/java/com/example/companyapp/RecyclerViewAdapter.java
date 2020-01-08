package com.example.companyapp;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/*
Clase AdapterView, que sirve para personalizar el RecyclerView de PostActivity.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Image image;
    private List<Post> PostList;
    Dialog myDialog;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_content, tv_nombreusuario;
        private ImageView img_post, img_usuario;

        //Aquí asignamos las disintas Views mediante el constructor.
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_nombreusuario = (TextView) itemView.findViewById(R.id.tv_username);
            //tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            img_usuario = (ImageView) itemView.findViewById(R.id.img_user);
            img_post = (ImageView) itemView.findViewById(R.id.img_post);
        }
    }

    public RecyclerViewAdapter(List<Post> postList) {
        this.PostList = postList; //Asignamos la lista de la clase molde Post, previamente pasada como parámetro
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        image = new Image(); //instanciamos la clase molde Image, para poder acceder a su función returnBitmapImageFromURL
        myDialog = new Dialog(holder.img_post.getContext());
        holder.tv_title.setText(PostList.get(position).getTitulo());
        holder.tv_nombreusuario.setText(PostList.get(position).getNombre_usuario());
        Picasso.with(holder.tv_title.getContext()).load(PostList.get(position).getImg()).into(holder.img_post);
        Picasso.with(holder.tv_title.getContext()).load(PostList.get(position).getImg_usuario()).into(holder.img_usuario);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            /*
            Aquí creamos la ventana emergente que hará visualizar el contenido del Post. Le asignamos
            las views correspondientes junto con sus datos, obtenidos desde la clase molde Post.
             */

            @Override
            public void onClick(View arg0) {
                TextView txtclose;
                TextView tv_title;
                TextView tv_content;
                ImageView img;

                myDialog.setContentView(R.layout.post_popup);
                txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
                tv_title = (TextView) myDialog.findViewById(R.id.tv_title);
                tv_content = (TextView) myDialog.findViewById(R.id.tv_content);
                img = (ImageView) myDialog.findViewById(R.id.header_img);
                txtclose.setText("X");

                Picasso.with(txtclose.getContext()).load(PostList.get(position).getImg()).into(img);

                tv_title.setText(PostList.get(position).getTitulo());
                tv_content.setText(PostList.get(position).getContenido());
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                myDialog.show();
            }
        });
    }

    @Override

    public int getItemCount() {
        return PostList.size();
    }
}