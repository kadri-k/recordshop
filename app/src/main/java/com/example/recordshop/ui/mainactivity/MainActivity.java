package com.example.recordshop.ui.mainactivity;

import android.app.Application;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityMainBinding;
import com.example.recordshop.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList = new ArrayList<> ();
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // Set up RecyclerView
        setupRecyclerView();

        // Fetch and observe album data
        getAllAlbums();
    }

    private void setupRecyclerView() {
        recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter with an empty list and set it to RecyclerView
        albumAdapter = new AlbumAdapter(albumList);
        recyclerView.setAdapter(albumAdapter);
    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                if (albums != null) {
                    // Update albumList and notify adapter
                    albumList.clear();
                    albumList.addAll(albums);
                    albumAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}