package com.example.ourfirstapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ourfirstapp.R;

public class HomeFragment extends Fragment {

    private Spinner spinnerBiomas;
    private ImageView imageBioma;
    private TextView textDescricao;
    private Button btnBirds;

    private final String[] biomas = {
            "Amazônia", "Caatinga", "Cerrado",
            "Mata Atlântica", "Pampa", "Pantanal"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinnerBiomas = view.findViewById(R.id.spinnerBiomas);
        imageBioma    = view.findViewById(R.id.imageBioma);
        textDescricao = view.findViewById(R.id.textDescricao);
        btnBirds      = view.findViewById(R.id.btnBirds);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                biomas
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBiomas.setAdapter(adapter);

        spinnerBiomas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                atualizarConteudo(biomas[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // Navega para o Fragment de aves
        btnBirds.setOnClickListener(v ->
                Navigation.findNavController(v)
                        .navigate(R.id.action_navigation_home_to_birdsFragment)
        );
    }

    private void atualizarConteudo(String bioma) {
        switch (bioma) {
            case "Amazônia":
                imageBioma.setImageResource(R.drawable.amazonia);
                textDescricao.setText(
                        "O bioma Amazônia é o maior do Brasil, caracterizado pelo clima equatorial quente e úmido, com uma floresta densa e alta biodiversidade. Abriga espécies como a onça-pintada, o boto-cor-de-rosa e várias espécies de aves e peixes. O Cerrado possui clima tropical com estações bem definidas (seca e chuvosa), vegetação formada por árvores retorcidas, arbustos e gramíneas, sendo habitat de animais como o lobo-guará e o tamanduá-bandeira."
                );
                break;

            case "Caatinga":
                imageBioma.setImageResource(R.drawable.caatinga);
                textDescricao.setText(
                        "A Caatinga é exclusiva do Brasil, localizada no semiárido nordestino, com clima seco e vegetação resistente à escassez de água, como cactos e arbustos espinhosos; sua fauna inclui o tatu-peba e a asa-branca."
                );
                break;

            case "Cerrado":
                imageBioma.setImageResource(R.drawable.cerrado);
                textDescricao.setText(
                        "O Cerrado é a savana mais biodiversa do mundo, com árvores retorcidas e gramíneas."
                );
                break;

            case "Mata Atlântica":
                imageBioma.setImageResource(R.drawable.mata_atlantica);
                textDescricao.setText(
                        "a Mata Atlântica ocorre ao longo do litoral brasileiro, com clima variado e vegetação densa e úmida. Apesar de muito devastada, ainda abriga espécies ameaçadas como o mico-leão-dourado e a onça-parda."
                );
                break;

            case "Pampa":
                imageBioma.setImageResource(R.drawable.pampa);
                textDescricao.setText(
                        "O Pampa, encontrado no sul do país, tem clima subtropical, vegetação predominantemente campestre (gramíneas e arbustos baixos) e fauna típica como veados, capivaras e aves como o quero-quero."
                );
                break;

            case "Pantanal":
                imageBioma.setImageResource(R.drawable.pantanal);
                textDescricao.setText(
                        "O Pantanal é a maior planície alagável do mundo, com clima tropical, vegetação mista (cerrado, floresta e campos) e grande variedade de fauna aquática e terrestre, como jacarés, capivaras e tuiuiús."
                );
                break;
        }
    }
}