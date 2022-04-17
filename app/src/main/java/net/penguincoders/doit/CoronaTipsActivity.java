package net.penguincoders.doit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class CoronaTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_tips);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FirstAidAdapter coronaAdapter = new FirstAidAdapter(this,"corona_help");

        RecyclerView recyclerView = findViewById(R.id.recCoronaTips);

        recyclerView.setAdapter(coronaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        coronaAdapter.setRecItem1(UtilsRec.getInstance(this).getAllCoronaHelp());
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