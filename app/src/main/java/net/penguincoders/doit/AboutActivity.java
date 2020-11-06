package net.penguincoders.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView txtAbout12, txtAbout22, txtAbout32, txtAbout42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txtAbout12=findViewById(R.id.txtAbout12);
        txtAbout22=findViewById(R.id.txtAbout22);
        txtAbout32=findViewById(R.id.txtAbout32);
        txtAbout42=findViewById(R.id.txtAbout42);
        txtAbout12.setMovementMethod(LinkMovementMethod.getInstance());
        txtAbout22.setMovementMethod(LinkMovementMethod.getInstance());
        txtAbout32.setMovementMethod(LinkMovementMethod.getInstance());
        txtAbout42.setMovementMethod(LinkMovementMethod.getInstance());
    }
}