package devandroid.bruno.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto, soma, subtrair, multiplicar, dividir, igual, limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();
    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.numero_Zero);
        numeroUm = findViewById(R.id.numero_Um);
        numeroDois = findViewById(R.id.numero_Dois);
        numeroTres = findViewById(R.id.numero_Tres);
        numeroQuatro = findViewById(R.id.numero_Quatro);
        numeroCinco = findViewById(R.id.numero_Cinco);
        numeroSeis = findViewById(R.id.numero_Seis);
        numeroSete = findViewById(R.id.numero_Sete);
        numeroOito = findViewById(R.id.numero_Oito);
        numeroNove = findViewById(R.id.numero_Nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.btn_Somar);
        subtrair = findViewById(R.id.btn_Subtrair);
        multiplicar = findViewById(R.id.btn_Multiplicar);
        dividir = findViewById(R.id.btn_Dividir);
        igual = findViewById(R.id.btn_Igual);
        limpar = findViewById(R.id.btn_Limpar);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados) {
        if (txtResultado.getText().equals("")) {
            txtExpressao.setText("");
        }

        if (limpar_dados) {
            txtResultado.setText("");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }
    }
}