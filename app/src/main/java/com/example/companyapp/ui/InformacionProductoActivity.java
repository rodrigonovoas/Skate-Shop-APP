package com.example.companyapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.companyapp.R;

//Clase en la que se carga la información del producto y posteriormente se asigna a las vistas del layout

public class InformacionProductoActivity extends AppCompatActivity {

    private TextView tv_titulo, tv_descripcion, tv_codigo, tv_precio;
    private ImageView img_producto;
    private FloatingActionButton fab_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacionproducto_activity);

        tv_titulo = (TextView) findViewById(R.id.tv_titulo);
        tv_descripcion = (TextView) findViewById(R.id.tv_descripcion);
        tv_codigo = (TextView) findViewById(R.id.tv_codigo);
        tv_precio = (TextView) findViewById(R.id.tv_precio);
        img_producto = (ImageView) findViewById(R.id.img_producto);
        fab_atras = (FloatingActionButton) findViewById(R.id.fba_atras);

        Intent intent = getIntent();
        String titulo = intent.getExtras().getString("Nom");
        String descripcion = intent.getExtras().getString("Desc");
        String imagen = intent.getExtras().getString("Img");
        String cod = intent.getExtras().getString("Codigo");
        String precio = intent.getExtras().getString("Precio");

        tv_titulo.setText(titulo);
        tv_descripcion.setText(descripcion);
        tv_codigo.setText(cod);
        tv_precio.setText(precio);

        cargarImagen(this,img_producto,imagen);


        fab_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private static void cargarImagen(Context context, ImageView img, String url){
        Glide.with(context)
                .load(url)
                .into(img);
    }
}
