package com.example.ourfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ourfirstapp.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private MainActivity binding;
    private Spinner spinnerBiomas;
    private ImageView imageBioma;
    private TextView textDescricao;
    private Button btnIrParaBioma;

    private String[] biomas = {
            "Amazônia", "Caatinga", "Cerrado", "Mata Atlântica", "Pampa", "Pantanal"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBiomas = findViewById(R.id.spinnerBiomas);
        imageBioma = findViewById(R.id.imageBioma);
        textDescricao = findViewById(R.id.textDescricao);
        btnIrParaBioma = findViewById(R.id.btnIrParaBioma);

        // Configura o spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, biomas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBiomas.setAdapter(adapter);

        // Recupera o bioma vindo da outra activity
        String biomaSelecionado = getIntent().getStringExtra("bioma");
        if (biomaSelecionado != null) {
            int index = Arrays.asList(biomas).indexOf(biomaSelecionado);
            if (index >= 0) {
                spinnerBiomas.setSelection(index);
                atualizarConteudo(biomaSelecionado);
            }
        }

        spinnerBiomas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Pega o bioma selecionado com base na posição
                String biomaSelecionado = biomas[position];

                // Atualiza a imagem e a descrição na tela
                atualizarConteudo(biomaSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Aqui você pode deixar vazio ou fazer algo quando nada estiver selecionado
            }
        });


        btnIrParaBioma.setOnClickListener(v -> {
            String biomaAtual = spinnerBiomas.getSelectedItem().toString();
            Toast.makeText(this, "Mostrar pássaros da região: " + biomaAtual, Toast.LENGTH_SHORT).show();
            // Aqui você pode chamar outra tela se quiser, ou mostrar uma lista de aves
        });
    }

    private void atualizarConteudo(String bioma) {
        switch (bioma) {
            case "Amazônia":
                imageBioma.setImageResource(R.drawable.amazonia);
                textDescricao.setText("A Amazônia é o maior bioma do Brasil e abriga a maior floresta tropical do mundo. Possui clima equatorial, caracterizado por altas temperaturas e elevada umidade durante todo o ano, com chuvas intensas. A vegetação é formada por uma floresta densa, com árvores muito altas, como a castanheira e a seringueira, além de grande variedade de cipós, bromélias e orquídeas. A fauna é extremamente rica, incluindo espécies como a onça-pintada, o boto-cor-de-rosa, a arara-azul, a anta e o peixe-boi. A Amazônia é fundamental para o equilíbrio climático do planeta e abriga milhares de espécies, muitas ainda desconhecidas pela ciência.");
                break;
            case "Caatinga":
                imageBioma.setImageResource(R.drawable.caatinga);
                textDescricao.setText("A Caatinga é um bioma exclusivamente brasileiro, presente principalmente no Nordeste. Possui clima semiárido, com chuvas escassas e irregulares, e longos períodos de seca. A vegetação é adaptada à falta de água, composta por plantas espinhosas, cactos, arbustos e árvores que perdem as folhas na estação seca. Apesar da aparência seca, a Caatinga abriga uma fauna variada, com espécies como o tatu-peba, o mocó, o gato-do-mato, a asa-branca e a ararinha-azul. É um bioma único e rico em endemismos, mas sofre com a desertificação e o desmatamento.");
                break;
            case "Cerrado":
                imageBioma.setImageResource(R.drawable.cerrado);
                textDescricao.setText("O Cerrado é o segundo maior bioma do Brasil, predominando no Planalto Central. O clima é tropical, com duas estações bem definidas: uma seca e outra chuvosa. A vegetação típica é composta por árvores de troncos retorcidos, cascas grossas, folhas duras, além de arbustos e gramíneas. É considerado a savana mais biodiversa do mundo. Entre os animais que habitam o Cerrado, destacam-se o lobo-guará, o tamanduá-bandeira, o tatu-canastra, a ema e o veado-campeiro. Apesar de sua importância ecológica, é um dos biomas mais ameaçados pela expansão da agricultura e da pecuária.");
                break;
            case "Mata Atlântica":
                imageBioma.setImageResource(R.drawable.mata_atlantica);
                textDescricao.setText("A Mata Atlântica se estende ao longo do litoral brasileiro, do Rio Grande do Norte ao Rio Grande do Sul. O clima varia conforme a região, mas em geral é úmido, com chuvas bem distribuídas ao longo do ano. A vegetação é muito densa e rica em espécies, incluindo árvores de grande porte, bromélias, samambaias e uma diversidade de orquídeas. Apesar de mais de 80% da sua área original já ter sido desmatada, ainda abriga muitas espécies ameaçadas de extinção, como o mico-leão-dourado, a onça-parda e diversas aves e anfíbios. É um dos biomas mais biodiversos do mundo.");
                break;
            case "Pampa":
                imageBioma.setImageResource(R.drawable.pampa);
                textDescricao.setText("O Pampa, também chamado de Campos Sulinos, é um bioma que ocorre exclusivamente no sul do Brasil, especialmente no Rio Grande do Sul. Apresenta clima subtropical, com verões quentes e invernos frios. A vegetação predominante é campestre, composta por gramíneas, arbustos e algumas árvores de pequeno porte. É um ecossistema ideal para a criação de gado, mas também abriga animais como o veado-campeiro, o graxaim-do-campo, o tatu e o quero-quero. Por ser menos valorizado e muito modificado pela agropecuária, é um dos biomas menos protegidos no Brasil.");
                break;
            case "Pantanal":
                imageBioma.setImageResource(R.drawable.pantanal);
                textDescricao.setText("O Pantanal é a maior planície alagável do planeta, localizado principalmente no Mato Grosso e Mato Grosso do Sul. Possui clima tropical, com estação chuvosa e seca bem marcadas. Durante a cheia, grande parte do bioma fica alagada, criando um ambiente único. A vegetação é composta por uma mistura de formações do Cerrado, da Amazônia, da Caatinga e da Mata Atlântica, além de áreas de campos abertos e várzeas. É um verdadeiro santuário da fauna, com destaque para o jacaré-do-pantanal, a capivara, o tuiuiú (ave símbolo da região), a sucuri e a onça-pintada. Apesar de sua riqueza, enfrenta ameaças como queimadas e avanço da agropecuária.");
                break;
        }
    }
}