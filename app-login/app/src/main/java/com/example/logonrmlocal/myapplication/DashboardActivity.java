package com.example.logonrmlocal.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sp = getSharedPreferences("login",MODE_PRIVATE);

        edtInfo =findViewById(R.id.edtInfo);

    }

    public void logout(View view) {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("usuario");
        editor.remove("senha");
        editor.remove("conectado");
        editor.commit();
        finish();
    }

    public void salvarArquivo(View view) {

        try {
            FileOutputStream fos = openFileOutput("bd.txt", MODE_PRIVATE);
            String txt = edtInfo.getText().toString();
            fos.write(txt.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.gerar_file, Toast.LENGTH_SHORT).show();
        }
    }

    public void lerArquivo(View view) {

        try {
            FileInputStream fis = openFileInput("bd.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));


            String txt = br.readLine();
            Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.read_file, Toast.LENGTH_SHORT).show();
        }

    }
}
