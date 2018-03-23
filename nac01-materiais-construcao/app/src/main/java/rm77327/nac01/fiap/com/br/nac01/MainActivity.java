package rm77327.nac01.fiap.com.br.nac01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgbOpcoes;

    RadioButton rbnPisoBranco;
    RadioButton rbnPisoAlbania;
    RadioButton rbnPisoPerlato;
    RadioButton rbnRevestimento;

    CheckBox chbFrete;

    EditText edtMedida;

    TextView txtValor;

    double selecionado = 0;
    double resultado = 0;
    int valorMQuadrado = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgbOpcoes = findViewById(R.id.rgbOpcoes);
        rbnPisoBranco = findViewById(R.id.rbnPisoBranco);
        rbnPisoAlbania = findViewById(R.id.rbnPisoAlbania);
        rbnPisoPerlato = findViewById(R.id.rbnPisoPerlato);
        rbnRevestimento = findViewById(R.id.rbnRevestimento);
        chbFrete = findViewById(R.id.chbFrete);
        edtMedida = findViewById(R.id.edtMedida);
        txtValor = findViewById(R.id.txtValor);

    }

    public void btnCalc(View view) {
        valorMQuadrado = Integer.parseInt(String.valueOf(edtMedida.getText()));

        selecionado = rgbOpcoes.getCheckedRadioButtonId();

        if(rbnPisoBranco.isChecked()){
            selecionado = valorMQuadrado * 24.9;
        }else if (rbnPisoAlbania.isChecked()){
            selecionado = valorMQuadrado * 11.9;
        }else if (rbnPisoPerlato.isChecked()){
            selecionado = valorMQuadrado * 39.9;
        }else if (rbnRevestimento.isChecked()){
            selecionado = valorMQuadrado * 16.9;
        }

        resultado = selecionado;

        if(chbFrete.isChecked()){
            resultado *= 1.3;
        }

        if(valorMQuadrado == 0 || valorMQuadrado < 0){
            Toast.makeText(this, "Não é possivel efetuar o calculo!", Toast.LENGTH_SHORT).show();
            resultado = 0;
        }

        txtValor.setText(String.format("R$ %.2f", resultado));

    }
}
