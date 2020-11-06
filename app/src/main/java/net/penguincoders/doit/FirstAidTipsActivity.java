package net.penguincoders.doit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstAidTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_tips);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FirstAidAdapter aidAdapter = new FirstAidAdapter(this,"first_aid");

        RecyclerView recyclerView = findViewById(R.id.recFirstAid);

        recyclerView.setAdapter(aidAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        aidAdapter.setRecItem1(UtilsRec.getInstance(this).getAllFirstAid());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}