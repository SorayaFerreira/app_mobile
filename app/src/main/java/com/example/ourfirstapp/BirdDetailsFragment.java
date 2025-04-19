package com.example.ourfirstapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.ourfirstapp.databinding.FragmentBirdDetailsBinding;

public class BirdDetailsFragment extends Fragment {

    private FragmentBirdDetailsBinding binding;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBirdDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        Bird receivedBird = getArguments().getParcelable("selectedBird");
        //carrega as informacoes passadas na pagina
        if (receivedBird != null) {
            binding.birdName.setText(receivedBird.getName());
            binding.birdImage.setImageResource(receivedBird.getImageResId());
            binding.birdDescription.setText(receivedBird.getDescription());
            binding.scientificName.setText(receivedBird.getScientificName());

            // Set up MediaPlayer
            mediaPlayer = MediaPlayer.create(requireContext(), receivedBird.getAudioResId());

            binding.btnPlaySound.setOnClickListener(v -> {
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        return; // avoid multiple clicks
                    }

                    // Muda a cor do botao durante reproducao
                    binding.btnPlaySound.setBackgroundColor(
                            ContextCompat.getColor(requireContext(), android.R.color.holo_green_dark)
                    );

                    mediaPlayer.start();

                    // Reseta cor do botao apos a reproducao
                    mediaPlayer.setOnCompletionListener(mp -> {
                        binding.btnPlaySound.setBackgroundColor(
                                ContextCompat.getColor(requireContext(), android.R.color.darker_gray)
                        );
                    });
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        binding = null;
    }
}
