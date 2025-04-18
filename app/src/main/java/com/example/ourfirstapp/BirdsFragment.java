package com.example.ourfirstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

//import android.widget.AdapterView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.ourfirstapp.databinding.FragmentBirdsBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BirdsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirdsFragment extends Fragment {
    //binding
    private FragmentBirdsBinding binding;

    public BirdsFragment() {
        // Required empty public constructor
    }

    public static BirdsFragment newInstance() {
        BirdsFragment fragment = new BirdsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBirdsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Bird> birdList = new ArrayList<>();

        birdList.add(new Bird(R.drawable.arara_azul_grande, R.raw.arara_azul_grande, "Arara-azul-grande", "Anodorhynchus hyacinthinus", "É a maior espécie de arara do mundo, podendo atingir até 1 metro de comprimento. Alimenta-se principalmente de frutos de palmeiras, como o acuri e o bocaiúva. Está ameaçada de extinção devido à perda de habitat e ao tráfico ilegal."));
        birdList.add(new Bird(R.drawable.ararajuba, R.raw.ararajuba, "Ararajuba", "Guaruba guarouba", "Conhecida como 'papagaio-dourado', a ararajuba é uma das aves mais emblemáticas da Amazônia. Sua plumagem amarelo-vivo com detalhes verdes é inconfundível. Infelizmente, está ameaçada de extinção devido à perda de habitat e ao tráfico ilegal."));
        birdList.add(new Bird(R.drawable.colhereiro, R.raw.colhereiro, "Colhereiro", "Platalea ajaja", "Seu nome vem do formato peculiar do bico, que se assemelha a uma colher. Utiliza o bico para 'varrer' a água em busca de pequenos peixes e crustáceos. A coloração rosada é resultado da dieta rica em carotenoides."));
        birdList.add(new Bird(R.drawable.mutum_de_penacho, R.raw.mutum_de_penacho, "Mutum-de-penacho", "Crax alector", "Esta ave de grande porte possui um penacho característico e é encontrada nas florestas tropicais da região. É conhecida por seus hábitos discretos e por ser uma importante dispersora de sementes."));
        birdList.add(new Bird(R.drawable.cardeal_do_nordeste, R.raw.cardeal_do_nordeste, "Cardeal-do-nordeste", "Paroaria dominicana", "Também chamado de 'galo-de-campina', é símbolo cultural do Nordeste. Sua plumagem vermelha vibrante na cabeça contrasta com o corpo branco e preto. É comum em áreas de caatinga e cerrado."));
        birdList.add(new Bird(R.drawable.gralha_canca, R.raw.gralha_canca, "Gralha-cancã", "Cyanocorax cyanopogon", "Conhecida por seu comportamento curioso e vocalizações altas, é chamada de 'voz da caatinga'. Alimenta-se de insetos, frutos e até ração de galinha."));
        birdList.add(new Bird(R.drawable.golinho, R.raw.golinho, "Golinho", "Sporophila albogularis", "Pequena ave granívora endêmica do Nordeste. Os machos possuem uma distinta garganta branca. Seu canto é variado e rápido, com imitações de outras aves."));
        birdList.add(new Bird(R.drawable.tuiuiu, R.raw.tuiuiu, "Tuiuiú", "Jabiru mycteria", "Ave símbolo do Pantanal, o tuiuiú é a maior cegonha das Américas. Com pescoço preto e uma faixa vermelha, destaca-se nas paisagens alagadas da região."));
        birdList.add(new Bird(R.drawable.gralha_do_campo, R.raw.gralha_do_campo, "Gralha-do-campo", "Cyanocorax cristatellus", "Conhecida também como 'gralha-de-topete', possui uma crista distinta. Habita o cerrado e é reconhecida por sua inteligência e comportamento social complexo."));
        birdList.add(new Bird(R.drawable.curicaca, R.raw.curicaca, "Curicaca", "Theristicus caudatus", "Possui um chamado característico, um som alto e estridente, que é facilmente reconhecível. Alimenta-se de insetos, pequenos vertebrados e outros invertebrados encontrados no solo. É frequentemente vista em grupos, forrageando em campos úmidos e pastagens."));
        birdList.add(new Bird(R.drawable.joao_bobo, R.raw.joao_bobo, "João-bobo", "Nystalus chacuru", "Recebe esse nome devido ao comportamento de permanecer imóvel quando ameaçado, aparentando ser 'bobo'. Alimenta-se de insetos, pequenos vertebrados e até mesmo escorpiões. Possui uma plumagem que proporciona excelente camuflagem entre os galhos e troncos."));
        birdList.add(new Bird(R.drawable.seriema, R.raw.seriema, "Seriema", "Cariama cristata", "É uma das poucas aves terrestres do Brasil, preferindo correr a voar. Alimenta-se de pequenos vertebrados, insetos e até serpentes. Possui um canto alto e característico, que pode ser ouvido a longas distâncias."));
        /*birdList.add(new Bird(R.drawable.sabia_laranjeira, R.raw.sabia_laranjeira, "Sabiá-laranjeira", "Turdus rufiventris", "Ave símbolo do Brasil, famosa por seu canto melodioso. É comum em áreas urbanas e rurais, sendo presença constante na cultura brasileira."));
        birdList.add(new Bird(R.drawable.mutum_do_sudeste, R.raw.mutum_do_sudeste, "Mutum-do-sudeste", "Crax blumenbachii", "Endêmica da Mata Atlântica, esta ave está ameaçada de extinção devido à perda de habitat. Possui plumagem preta com detalhes brancos e um bico laranja."));
        birdList.add(new Bird(R.drawable.tucano_de_bico_verde, R.raw.tucano_de_bico_verde, "Tucano-de-bico-verde", "Ramphastos dicolorus", "Com seu bico verde e plumagem colorida, é uma das espécies mais conhecidas da região. Habita florestas e é importante dispersor de sementes."));
        birdList.add(new Bird(R.drawable.gralha_azul, R.raw.gralha_azul, "Gralha-azul", "Cyanocorax caeruleus", "Ave símbolo do Paraná, possui plumagem azul vibrante. É conhecida por enterrar pinhões, auxiliando na regeneração das araucárias."));
        birdList.add(new Bird(R.drawable.tangara, R.raw.tangara, "Tangará", "Chiroxiphia caudata", "Pequena ave de plumagem azul e preta, famosa por suas danças elaboradas durante o acasalamento. Habita matas densas e é difícil de ser avistada."));
        birdList.add(new Bird(R.drawable.pula_pula, R.raw.pula_pula, "Pula-pula", "Basileuterus culicivorus", "Conhecido por seus movimentos rápidos entre a vegetação, possui canto melodioso e é comum em matas secundárias."));
        */
        binding.grid1.setAdapter(new Adaptador(getContext(), birdList));

        binding.grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //metodo de navegacao a partir de selecao no grid
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bird selectedBird = (Bird) parent.getItemAtPosition(position);

                Bundle bundle = new Bundle();
                bundle.putParcelable("selectedBird", selectedBird);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_birdsFragment_to_birdDetailsFragment, bundle);
            }
        });

    }
}

