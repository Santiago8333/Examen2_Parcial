package com.in.examen_parcial.ui.cargar;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.in.examen_parcial.MainActivity;
import com.in.examen_parcial.databinding.FragmentCargarBinding;
import com.in.examen_parcial.model.Producto;

import java.util.ArrayList;

public class CargarViewModel extends AndroidViewModel {
    private ArrayList<Producto> productos;
    private MutableLiveData<String> errorMensaje = new MutableLiveData<>();
    private FragmentCargarBinding binding;

    public CargarViewModel(@NonNull Application application) {
        super(application);
        productos = new ArrayList<>();
    }
    public void CargarProducto(String codigo,String descripcion,String precioStr,String stockStr){
        Log.d("CargarProducto", "producto: " + codigo);
        if (codigo.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty()) {
            errorMensaje.setValue("Todos los campos son obligatorios");
            return;
        }
        //verificar si el codigo del producto esta repetido
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                errorMensaje.setValue("El codigo del producto ingresado ya exsiste");
                return;
            }
        }
        try {
        float precio = Float.parseFloat(precioStr);
        int stock = Integer.parseInt(stockStr);

        Producto nuevoProducto = new Producto(descripcion,codigo, precio, stock);
        productos.add(nuevoProducto);
        MainActivity.listaProductos.add(nuevoProducto);
        Log.d("CargarViewModel", "Producto cargado: " + nuevoProducto.getCodigo());

            errorMensaje.setValue("Producto cargado exitosamente");
        } catch (NumberFormatException e) {
            errorMensaje.setValue("Precio y stock deben ser numeros validos");
        }
    }
    public LiveData<String> getErrorMessage() {
        return errorMensaje;
    }


}