package com.in.examen_parcial.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.in.examen_parcial.MainActivity;
import com.in.examen_parcial.model.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListarViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Producto>> mLista;
    public ListarViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<ArrayList<Producto>> getMLista(){
        if(mLista == null){
            mLista = new MutableLiveData<>();
        }
        return mLista;
    }

    public void imprimirLista(){
        ArrayList<Producto> listaOrdenada = new ArrayList<>(MainActivity.listaProductos);

        Collections.sort(listaOrdenada, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {

                return Float.compare(p2.getPrecio(), p1.getPrecio());
            }
        });
        mLista.setValue(listaOrdenada);
    }
}