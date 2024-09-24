package com.in.examen_parcial.ui.listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.in.examen_parcial.R;
import com.in.examen_parcial.model.Producto;

import java.util.ArrayList;
import java.util.Locale;

public class ListarAdapter extends RecyclerView.Adapter<ListarAdapter.ViewHolderListar>{
    private ArrayList<Producto> listaDeProducto;
    private LayoutInflater inflater;

    public ListarAdapter(ArrayList<Producto> listaDeProducto, LayoutInflater inflater) {
        this.listaDeProducto = listaDeProducto;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolderListar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tarjeta,parent,false);
        return new ViewHolderListar(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListar holder, int position) {
        Producto producto = listaDeProducto.get(position);
        holder.tvCodigo.setText(producto.getCodigo());
        holder.tvDescripcion.setText(producto.getDescripcion());

        holder.tvPrecio.setText(String.format(Locale.getDefault(), "%.2f", producto.getPrecio()));

        holder.tvStock.setText(String.valueOf(producto.getStock()));
    }

    @Override
    public int getItemCount() {
        return listaDeProducto.size();
    }

    public class ViewHolderListar extends RecyclerView.ViewHolder{
        private TextView tvCodigo,tvDescripcion,tvPrecio,tvStock;

        public ViewHolderListar(@NonNull View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvStock = itemView.findViewById(R.id.tvStock);
        }
    }
}
