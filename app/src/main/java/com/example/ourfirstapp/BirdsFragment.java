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

    private void listBirds_biome(String biome) {
        List<Bird> birdList = new ArrayList<>();

        switch (biome) {
            case "Amazônia":
                birdList.add(new Bird(R.drawable.ararajuba, R.raw.ararajuba, "Ararajuba", "Guaruba guarouba", "Conhecida como 'papagaio-dourado', tem plumagem amarelo-vivo com detalhes verdes. Ameaçada de extinção por perda de habitat e tráfico."));
                birdList.add(new Bird(R.drawable.mutum_de_penacho, R.raw.mutum_de_penacho, "Mutum-de-penacho", "Crax alector", "Ave de grande porte com penacho característico, encontrada em florestas tropicais. Importante dispersora de sementes."));
                birdList.add(new Bird(R.drawable.galo_da_serra, R.raw.galo_da_serra, "Galo-da-serra", "Rupicola rupicola", "Macho possui plumagem laranja vibrante e um topete em forma de disco. Vive em áreas rochosas da Amazônia e é conhecido por exibições de acasalamento."));
                birdList.add(new Bird(R.drawable.jacamim_de_costas_castanhas, R.raw.jacamim_de_costas_castanhas, "Jacamim-de-costas-castanhas", "Psophia leucoptera", "Ave terrestre e tímida, comum em florestas de terra firme. Emite sons altos e anda em bandos."));
                birdList.add(new Bird(R.drawable.anambe_preto, R.raw.anambe_preto, "Anambé-preto", "Cephalopterus ornatus", "Também chamado de corvo-da-Amazônia, possui penas pretas e um apêndice carnoso pendente da garganta. Raro e curioso."));
                break;

            case "Caatinga":
                birdList.add(new Bird(R.drawable.cardeal_do_nordeste, R.raw.cardeal_do_nordeste, "Cardeal-do-nordeste", "Paroaria dominicana", "Chamado de 'galo-de-campina', é símbolo cultural da região. Tem cabeça vermelha vibrante e corpo preto e branco."));
                birdList.add(new Bird(R.drawable.gralha_canca, R.raw.gralha_canca, "Gralha-cancã", "Cyanocorax cyanopogon", "Conhecida como 'voz da caatinga', é barulhenta e curiosa. Alimenta-se de frutos, insetos e ração."));
                birdList.add(new Bird(R.drawable.golinho, R.raw.golinho, "Golinho", "Sporophila albogularis", "Pequena ave com canto variado e garganta branca. Machos cantam com imitações de outras aves."));
                birdList.add(new Bird(R.drawable.asa_branca, R.raw.asa_branca, "Asa-branca", "Patagioenas picazuro", "Muito associada à cultura nordestina e à música regional. Pomba robusta, de canto melancólico."));
                birdList.add(new Bird(R.drawable.corrupiao, R.raw.corrupiao, "Corrupião", "Icterus jamacaii", "Ave canora muito apreciada, com plumagem alaranjada e preta. Imita outros sons e canta intensamente."));
                birdList.add(new Bird(R.drawable.pica_pau_verde_barrado, R.raw.pica_pau_verde_barrado, "Pica-pau-verde-barrado", "Colaptes melanochloros", "Tem plumagem rajada e bico forte para escavar troncos. Alimenta-se de formigas e larvas."));
                break;

            case "Cerrado":
                birdList.add(new Bird(R.drawable.gralha_do_campo, R.raw.gralha_do_campo, "Gralha-do-campo", "Cyanocorax cristatellus", "Conhecida também como 'gralha-de-topete', possui uma crista distinta. Habita o cerrado e é reconhecida por sua inteligência e comportamento social complexo."));
                birdList.add(new Bird(R.drawable.joao_bobo, R.raw.joao_bobo, "João-bobo", "Nystalus chacuru", "Recebe esse nome devido ao comportamento de permanecer imóvel quando ameaçado, aparentando ser 'bobo'. Alimenta-se de insetos, pequenos vertebrados e até mesmo escorpiões."));
                birdList.add(new Bird(R.drawable.seriema, R.raw.seriema, "Seriema", "Cariama cristata", "É uma das poucas aves terrestres do Brasil, preferindo correr a voar. Alimenta-se de pequenos vertebrados, insetos e até serpentes."));
                birdList.add(new Bird(R.drawable.gralha_azul, R.raw.gralha_azul, "Gralha-azul", "Cyanocorax caeruleus", "Ave símbolo do Paraná. Ajuda na dispersão de pinhões."));
                birdList.add(new Bird(R.drawable.pula_pula, R.raw.pula_pula, "Pula-pula", "Basileuterus culicivorus", "Pequeno e ágil, com canto melodioso. Comum em matas secundárias."));
                birdList.add(new Bird(R.drawable.canario_da_terra, R.raw.canario_da_terra, "Canário-da-terra", "Sicalis flaveola", "Amarelo vibrante e canto alegre. Bastante comum em áreas abertas e cultivadas."));
                break;

            case "Mata Atlântica":
                birdList.add(new Bird(R.drawable.gaviao_real, R.raw.gaviao_real, "Gavião-Real", "Harpia harpyja", "Grande ave de rapina, com crista de duas pontas e garras enormes. Alimenta-se de macacos e preguiças. O juvenil tem cabeça mais branca e falta a faixa no peito."));
                birdList.add(new Bird(R.drawable.colhereiro, R.raw.colhereiro, "Colhereiro", "Platalea ajaja", "Seu nome vem do formato peculiar do bico, que se assemelha a uma colher. Utiliza o bico para 'varrer' a água em busca de pequenos peixes e crustáceos. A coloração rosada é resultado da dieta rica em carotenoides."));
                birdList.add(new Bird(R.drawable.sabia_laranjeira, R.raw.sabia_laranjeira, "Sabiá-laranjeira", "Turdus rufiventris", "Ave símbolo do Brasil, de canto melodioso. Comum em áreas urbanas e florestas."));
                birdList.add(new Bird(R.drawable.mutum_do_sudeste, R.raw.mutum_do_sudeste, "Mutum-do-sudeste", "Crax blumenbachii", "Endêmico da Mata Atlântica. Preto com detalhes brancos e bico laranja. Ameaçado."));
                birdList.add(new Bird(R.drawable.tucano_de_bico_verde, R.raw.tucano_de_bico_verde, "Tucano-de-bico-verde", "Ramphastos dicolorus", "Colorido e de bico verde. Habita florestas, importante dispersor de sementes."));
                birdList.add(new Bird(R.drawable.saira_sete_cores, R.raw.saira_sete_cores, "Saíra-sete-cores", "Tangara seledon", "Plumagem vibrante com tons de azul, verde, amarelo e preto. Vive em matas atlânticas."));
                birdList.add(new Bird(R.drawable.tangara, R.raw.tangara, "Tangará", "Chiroxiphia caudata", "Famoso por suas danças de acasalamento. Vive em matas fechadas."));
                break;

            case "Pampa":
                birdList.add(new Bird(R.drawable.curicaca, R.raw.curicaca, "Curicaca", "Theristicus caudatus", "Possui um chamado característico, um som alto e estridente, que é facilmente reconhecível. Alimenta-se de insetos, pequenos vertebrados e outros invertebrados encontrados no solo."));
                birdList.add(new Bird(R.drawable.papagaio_charao, R.raw.papagaio_charao, "Papagaio-charão", "Amazona pretrei", "Endêmico da região Sul, depende das araucárias para alimentação. Ameaçado de extinção."));
                break;

            case "Pantanal":
                birdList.add(new Bird(R.drawable.tuiuiu, R.raw.tuiuiu, "Tuiuiú", "Jabiru mycteria", "Ave símbolo do Pantanal, o tuiuiú é a maior cegonha das Américas. Com pescoço preto e uma faixa vermelha, destaca-se nas paisagens alagadas da região."));
                birdList.add(new Bird(R.drawable.arara_azul_grande, R.raw.arara_azul_grande, "Arara-azul-grande", "Anodorhynchus hyacinthinus", "É a maior espécie de arara do mundo, podendo atingir até 1 metro de comprimento. Alimenta-se principalmente de frutos de palmeiras, como o acuri e o bocaiúva. Está ameaçada de extinção devido à perda de habitat e ao tráfico ilegal."));
                break;
        }

        if (binding != null && getContext() != null) {
            Adaptador adapter = new Adaptador(getContext(), birdList);
            binding.grid1.setAdapter(adapter);

            binding.grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBirdsBinding.inflate(inflater, container, false);

        Bundle args = getArguments();
        if (args != null) {
            String biome = args.getString("selected_biome");
            assert biome != null;
            listBirds_biome(biome);
        }

        return binding.getRoot();
    }

}

