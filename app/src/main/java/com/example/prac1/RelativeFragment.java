package com.example.prac1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RelativeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("lifecycle", "onCreate");
        Toast.makeText(requireContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("lifecycle", this.getLifecycle().toString());
        Toast.makeText(requireContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_relative, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("lifecycle", "onViewCreated");
        Toast.makeText(requireContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("lifecycle", "onViewStateRestored");
        Toast.makeText(requireContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("lifecycle", "onStart");
        Toast.makeText(requireContext(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("lifecycle", "onResume");
        Toast.makeText(requireContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("lifecycle", "onPause");
        Toast.makeText(requireContext(), "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("lifecycle", "onStop");
        Toast.makeText(requireContext(), "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("lifecycle", "onSaveInstanceState");
        Toast.makeText(requireContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("lifecycle", this.getLifecycle().toString());
        Toast.makeText(requireContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle", this.getLifecycle().toString());
        Toast.makeText(requireContext(), "onDestroy", Toast.LENGTH_SHORT).show();
    }
}