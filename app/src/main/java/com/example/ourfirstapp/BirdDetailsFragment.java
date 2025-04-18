package com.example.ourfirstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ourfirstapp.databinding.FragmentBirdDetailsBinding;

public class BirdDetailsFragment extends Fragment {

    private FragmentBirdDetailsBinding binding; // variavel que amarra codigo ao XML de layout

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBirdDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot(); // returns the root view for the fragment
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bird receivedBird = getArguments().getParcelable("selectedBird");

        if (receivedBird != null) {
            binding.birdName.setText(receivedBird.getName());
            binding.birdImage.setImageResource(receivedBird.getImageResId());
            binding.birdDescription.setText(receivedBird.getDescription());
            binding.scientificName.setText(receivedBird.getScientificName());

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // clean up to avoid memory leaks
    }
}

