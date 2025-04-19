package com.example.ourfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ourfirstapp.R;

public class Bioma extends Fragment {

    private Spinner spinnerBiomas;
    private ImageView imageBioma;
    private TextView textDescricao;

    private final String[] biomas = {
            "Amazônia", "Caatinga", "Cerrado", "Mata Atlântica", "Pampa", "Pantanal"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        spinnerBiomas = view.findViewById(R.id.spinnerBiomas);
        imageBioma = view.findViewById(R.id.imageBioma);
        textDescricao = view.findViewById(R.id.textDescricao);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, biomas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBiomas.setAdapter(adapter);

        spinnerBiomas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                atualizarConteudo(biomas[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        return view;
    }

    private void atualizarConteudo(String bioma) {
        switch (bioma) {
            case "Amazônia":
                imageBioma.setImageResource(R.drawable.amazonia);
                textDescricao.setText("A Amazônia é o maior bioma do Brasil [...]");
                break;
            // ... os outros biomas ...
        }
    }
}
