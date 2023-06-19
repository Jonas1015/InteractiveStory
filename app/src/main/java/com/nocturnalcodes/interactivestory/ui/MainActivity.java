package com.nocturnalcodes.interactivestory.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nocturnalcodes.interactivestory.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText nameEditText;
    private Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                startStory(name);
            }
        };
        startButton.setOnClickListener(listener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameEditText.setText("");
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key , name);
        startActivity(intent);
    }
}