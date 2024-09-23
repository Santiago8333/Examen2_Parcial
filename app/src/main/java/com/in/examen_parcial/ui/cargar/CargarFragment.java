package com.in.examen_parcial.ui.cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.in.examen_parcial.R;
import com.in.examen_parcial.databinding.FragmentCargarBinding;
import com.in.examen_parcial.model.Producto;

import java.util.ArrayList;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCargarBinding.inflate(inflater,container,false);
        CargarViewModel viewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        Producto nuevoProducto = new Producto("001", "Ejemplo", 9.99f, 10);
        View root = binding.getRoot();
        binding.btnCargar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click","click");
                String codigo = binding.editCodigo.getText().toString().trim();
                String descripcion = binding.editDescripcion.getText().toString().trim();
                String precio = binding.editPrecio.getText().toString().trim();
                String stock = binding.editStock.getText().toString().trim();
                viewModel.CargarProducto(codigo,descripcion,precio,stock);
            }
        });
        //mostrar mensaje
        viewModel.getErrorMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textError.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        // TODO: Use the ViewModel
    }

}