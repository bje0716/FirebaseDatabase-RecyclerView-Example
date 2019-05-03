package com.grapefruit.firebasedatabaseexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.grapefruit.firebasedatabaseexample.databinding.ActivityWriteBinding;

public class WriteActivity extends AppCompatActivity {

    private ActivityWriteBinding binding;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write);
        binding.setActivity(this);
        setSupportActionBar(binding.toolbar);

        database = FirebaseDatabase.getInstance().getReference();
    }

    public void submit(View view) {
        final String name = binding.name.getText().toString();
        final String title = binding.title.getText().toString();
        final String content = binding.content.getText().toString();
        final String date = Util.getDate(System.currentTimeMillis());

        if (!VerifyUtil.verifyStrings(name, title, content)) {
            Toast.makeText(this, "빈 칸을 입력해주세요", Toast.LENGTH_SHORT).show();
        } else {
            Board board = new Board(name, title, content, date);
            database.child("board").setValue(board).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(WriteActivity.this, "글 등록 성공했습니다", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(WriteActivity.this, "글 등록 실패했습니다", Toast.LENGTH_SHORT).show();
                    Log.d(WriteActivity.class.getSimpleName(), task.getException().getLocalizedMessage());
                }
            });
        }
    }
}
