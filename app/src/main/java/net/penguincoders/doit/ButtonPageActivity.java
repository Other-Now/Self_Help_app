package net.penguincoders.doit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ButtonPageActivity extends AppCompatActivity {

//    Button btnlogoutm,btnMedReminder,btnknowYourMed,btnFirstAidTips,btnHealthTips,btnNearbyHospitals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_page);

        /*btnlogoutm=findViewById(R.id.btnlogoutm);
        btnMedReminder=findViewById(R.id.btnMedReminder);
        btnknowYourMed=findViewById(R.id.btnknowYourMed);
        btnFirstAidTips=findViewById(R.id.btnFirstAidTips);
        btnHealthTips=findViewById(R.id.btnHealthTips);
        btnNearbyHospitals=findViewById(R.id.btnNearbyHospitals);

        btnMedReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ButtonPageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecMainAdapter adapter = new RecMainAdapter(this,"button_page");
        RecyclerView recView = findViewById(R.id.buttonRecView);

        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setRecItem(UtilsRec.getInstance(this).getAllButtons());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.idAbout:
                Intent intent = new Intent(ButtonPageActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu,menu);
        return true;
    }
}