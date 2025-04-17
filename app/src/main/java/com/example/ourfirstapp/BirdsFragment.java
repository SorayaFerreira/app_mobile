package com.example.ourfirstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BirdsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BirdsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BirdsFragment newInstance(String param1, String param2) {
        BirdsFragment fragment = new BirdsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        //navegar para a pagina de detalhes da ave atraves de um botao de teste
        Button button = view.findViewById(R.id.arara);
        button.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_birdsFragment_to_birdDetailsFragment);
        });

        int[] lista=new int[]{
                R.drawable.arara_azul_grande,
                R.drawable.colhereiro,R.drawable.curicaca,
                R.drawable.gralha_do_campo,R.drawable.joao_bobo,
                R.drawable.seriema,R.drawable.tuiuiu,
                R.drawable.ararajuba,R.drawable.mutum_de_penacho,
                R.drawable.cardeal_do_nordeste,R.drawable.golinho,
                R.drawable.gralha_canca
        };
        List<Bird> birdList = new ArrayList<>();
        birdList.add(new Bird(R.drawable.arara_azul_grande, "Arara-azul-grande", "É a maior espécie de arara do mundo, podendo atingir até 1 metro de comprimento. Alimenta-se principalmente de frutos de palmeiras, como o acuri e o bocaiúva. Está ameaçada de extinção devido à perda de habitat e ao tráfico ilegal."));
        birdList.add(new Bird(R.drawable.ararajuba, "Ararajuba", "Conhecida como 'papagaio-dourado', a ararajuba é uma das aves mais emblemáticas da Amazônia. Sua plumagem amarelo-vivo com detalhes verdes é inconfundível. Infelizmente, está ameaçada de extinção devido à perda de habitat e ao tráfico ilegal."));
        birdList.add(new Bird(R.drawable.colhereiro, "Colhereiro", "Seu nome vem do formato peculiar do bico, que se assemelha a uma colher. Utiliza o bico para 'varrer' a água em busca de pequenos peixes e crustáceos. A coloração rosada é resultado da dieta rica em carotenoides."));

        birdList.add(new Bird(R.drawable.mutum_de_penacho, "Mutum-de-penacho", "Esta ave de grande porte possui um penacho característico e é encontrada nas florestas tropicais da região. É conhecida por seus hábitos discretos e por ser uma importante dispersora de sementes."));
        birdList.add(new Bird(R.drawable.cardeal_do_nordeste, "Cardeal-do-nordeste", "Também chamado de 'galo-de-campina', é símbolo cultural do Nordeste. Sua plumagem vermelha vibrante na cabeça contrasta com o corpo branco e preto. É comum em áreas de caatinga e cerrado."));
        birdList.add(new Bird(R.drawable.gralha_canca, "Gralha-cancã", "Conhecida por seu comportamento curioso e vocalizações altas, é chamada de 'voz da caatinga'. Alimenta-se de insetos, frutos e até ração de galinha."));
        birdList.add(new Bird(R.drawable.golinho, "Golinho", "Pequena ave granívora endêmica do Nordeste. Os machos possuem uma distinta garganta branca. Seu canto é variado e rápido, com imitações de outras aves."));
        birdList.add(new Bird(R.drawable.tuiuiu, "Tuiuiú", "Ave símbolo do Pantanal, o tuiuiú é a maior cegonha das Américas. Com pescoço preto e uma faixa vermelha, destaca-se nas paisagens alagadas da região."));
        birdList.add(new Bird(R.drawable.gralha_do_campo, "Gralha-do-campo", "Conhecida também como 'gralha-de-topete', possui uma crista distinta. Habita o cerrado e é reconhecida por sua inteligência e comportamento social complexo."));
        birdList.add(new Bird(R.drawable.curicaca, "Curicaca", "Possui um chamado característico, um som alto e estridente, que é facilmente reconhecível. Alimenta-se de insetos, pequenos vertebrados e outros invertebrados encontrados no solo. É frequentemente vista em grupos, forrageando em campos úmidos e pastagens."));
        birdList.add(new Bird(R.drawable.joao_bobo, "João-bobo", "Recebe esse nome devido ao comportamento de permanecer imóvel quando ameaçado, aparentando ser 'bobo'. Alimenta-se de insetos, pequenos vertebrados e até mesmo escorpiões. Possui uma plumagem que proporciona excelente camuflagem entre os galhos e troncos."));
        birdList.add(new Bird(R.drawable.seriema, "Seriema", "É uma das poucas aves terrestres do Brasil, preferindo correr a voar. Alimenta-se de pequenos vertebrados, insetos e até serpentes. Possui um canto alto e característico, que pode ser ouvido a longas distâncias."));
        /*birdList.add(new Bird(R.drawable.sabia_laranjeira, "Sabiá-laranjeira", "Ave símbolo do Brasil, famosa por seu canto melodioso. É comum em áreas urbanas e rurais, sendo presença constante na cultura brasileira."));
        birdList.add(new Bird(R.drawable.mutum_do_sudeste, "Mutum-do-sudeste", "Endêmica da Mata Atlântica, esta ave está ameaçada de extinção devido à perda de habitat. Possui plumagem preta com detalhes brancos e um bico laranja."));
        birdList.add(new Bird(R.drawable.tucano_de_bico_verde, "Tucano-de-bico-verde", "Com seu bico verde e plumagem colorida, é uma das espécies mais conhecidas da região. Habita florestas e é importante dispersor de sementes."));
        birdList.add(new Bird(R.drawable.gralha_azul, "Gralha-azul", "Ave símbolo do Paraná, possui plumagem azul vibrante. É conhecida por enterrar pinhões, auxiliando na regeneração das araucárias."));
        birdList.add(new Bird(R.drawable.tangara, "Tangará", "Pequena ave de plumagem azul e preta, famosa por suas danças elaboradas durante o acasalamento. Habita matas densas e é difícil de ser avistada."));
        birdList.add(new Bird(R.drawable.pula_pula, "Pula-pula", "Conhecido por seus movimentos rápidos entre a vegetação, possui canto melodioso e é comum em matas secundárias."));
        */
        binding.grid1.setAdapter(new Adaptador(getContext(), birdList));

        binding.grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensagem="";

            }
        });
    }
}

