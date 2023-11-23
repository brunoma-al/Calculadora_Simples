package devandroid.bruno.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numerDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto, soma, subtrair, multiplicar, dividir, igual, limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numerDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtrair.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.numero_Zero);
        numeroUm = findViewById(R.id.numero_Um);
        numerDois = findViewById(R.id.numero_Dois);
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

    @Override
    public void onClick(View view) {

        String expressao = txtExpressao.getText().toString();

        if (expressao.isEmpty()) {
            expressao = "";
        } else {
            expressao += " ";
        }

        if (view.getId() == R.id.numero_Um) {
            AcrescentarUmaExpressao("1", true);
        } else if (view.getId() == R.id.numero_Dois) {
            AcrescentarUmaExpressao("2", true);
        } else if (view.getId() == R.id.numero_Tres) {
            AcrescentarUmaExpressao("3", true);
        } else if (view.getId() == R.id.numero_Quatro) {
            AcrescentarUmaExpressao("4", true);
        } else if (view.getId() == R.id.numero_Cinco) {
            AcrescentarUmaExpressao("5", true);
        } else if (view.getId() == R.id.numero_Seis) {
            AcrescentarUmaExpressao("6", true);
        } else if (view.getId() == R.id.numero_Sete) {
            AcrescentarUmaExpressao("7", true);
        } else if (view.getId() == R.id.numero_Oito) {
            AcrescentarUmaExpressao("8", true);
        } else if (view.getId() == R.id.numero_Nove) {
            AcrescentarUmaExpressao("9", true);
        } else if (view.getId() == R.id.ponto) {
            AcrescentarUmaExpressao(".", true);
        } else if (view.getId() == R.id.btn_Somar) {
            AcrescentarUmaExpressao("+", false);
        } else if (view.getId() == R.id.btn_Subtrair) {
            AcrescentarUmaExpressao("-", false);
        } else if (view.getId() == R.id.btn_Multiplicar) {
            AcrescentarUmaExpressao("*", false);
        } else if (view.getId() == R.id.btn_Dividir) {
            AcrescentarUmaExpressao("/", false);
        }
    }
}