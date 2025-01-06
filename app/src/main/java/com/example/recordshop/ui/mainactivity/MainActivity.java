package com.example.recordshop.ui.mainactivity;

import android.app.Application;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityMainBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.model.AlbumRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albumList;
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );
        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        getAllAlbums();
    }

        private void getAllAlbums() {
            viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
                @Override
                public void onChanged(List<Album> albums) {
                    // albums refers to the variable name of your List of Album objects
                    albumList = (ArrayList<Album>) albums;

                    displayInRecyclerView();
                }
            });
        }
// method to display albums in the RecyclerView
        private void displayInRecyclerView() {
            // initialise the RecyclerView
            recyclerView = binding.recyclerview;

            // create and set the Adapter to the RecyclerView
            albumAdapter = new AlbumAdapter(albumList);  // assume that AlbumAdapter constructor accepts ArrayList<Album>
            recyclerView.setAdapter(albumAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            albumAdapter.notifyDataSetChanged();

        }


