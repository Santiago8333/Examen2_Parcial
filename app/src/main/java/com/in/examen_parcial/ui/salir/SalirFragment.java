package com.in.examen_parcial.ui.salir;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.in.examen_parcial.R;
import com.in.examen_parcial.ui.cargar.CargarFragment;

public class SalirFragment extends Fragment {



    public static SalirFragment newInstance() {
        return new SalirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salir, container, false);

        showExitDialog();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirmación de salida");
        builder.setMessage("¿Estás seguro de que quieres salir de la aplicación?");
        builder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                getActivity().finishAffinity(); // Cierra la aplicación
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(), "Salida cancelada", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });


        builder.show();
    }


}