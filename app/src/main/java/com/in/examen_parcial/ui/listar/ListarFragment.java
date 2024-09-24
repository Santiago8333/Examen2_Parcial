package com.in.examen_parcial.ui.listar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.in.examen_parcial.R;
import com.in.examen_parcial.databinding.FragmentListarBinding;
import com.in.examen_parcial.model.Producto;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private ListarViewModel mViewModel;
    private FragmentListarBinding binding;
    public static ListarFragment newInstance() {
        return new ListarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        mViewModel.getMLista().observe(getViewLifecycleOwner(), new Observer<ArrayList<Producto>>() {
            @Override
            public void onChanged(ArrayList<Producto> productos) {
                ListarAdapter adapter = new ListarAdapter(productos, inflater);
                GridLayoutManager grid = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.listaProductos.setAdapter(adapter);
                binding.listaProductos.setLayoutManager(grid);
            }
        });
        mViewModel.imprimirLista();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        // TODO: Use the ViewModel
    }

}