package com.grapefruit.firebasedatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.grapefruit.firebasedatabaseexample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseReference database;
    private MainAdapter adapter;
    private List<Board> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        binding.setActivity(this);

        list = new ArrayList<>();
        database = FirebaseDatabase.getInstance().getReference();
        adapter = new MainAdapter(list);

        binding.recycler.setHasFixedSize(true);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(adapter);

        database.child("board").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.add(dataSnapshot.getValue(Board.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void write(View view) {
        startActivity(new Intent(this, WriteActivity.class));
    }
}
