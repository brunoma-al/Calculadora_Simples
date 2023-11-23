package devandroid.bruno.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto, soma, subtrair, multiplicar, dividir, igual, limpar;

    private TextView screen;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
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
        screen = findViewById(R.id.screen);
        backspace = findViewById(R.id.backspace);

        limpar.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");
        });

       ArrayList<Button> nums = new ArrayList<>();
       nums.add(numeroZero);
       nums.add(numeroUm);
       nums.add(numeroDois);
       nums.add(numeroTres);
       nums.add(numeroQuatro);
       nums.add(numeroCinco);
       nums.add(numeroSeis);
       nums.add(numeroSete);
       nums.add(numeroOito);
       nums.add(numeroNove);


       for (Button b : nums) {
           b.setOnClickListener(view -> {
               if (!screen.getText().toString().equals("0")){
                   screen.setText(screen.getText().toString() + b.getText().toString());
               } else {
                   screen.setText(b.getText().toString());
               }
           });
       }

       ArrayList<Button> opers = new ArrayList<>();
       opers.add(soma);
       opers.add(subtrair);
       opers.add(multiplicar);
       opers.add(dividir);
       for (Button b : opers) {
           b.setOnClickListener(view -> {
               firstNum = Double.parseDouble(screen.getText().toString());
               operation = b.getText().toString();
               screen.setText("0");
           });
       }

       backspace.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length()>1) {
                screen.setText(num.substring(0, num.length()-1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        ponto.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".");
            }
        });

        igual.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = firstNum/secondNum;
                    break;
                case "X":
                    result = firstNum*secondNum;
                    break;
                case "+":
                    result = firstNum+secondNum;
                    break;
                case "-":
                    result = firstNum-secondNum;
                    break;
                default:
                    result = firstNum+secondNum;
            }
            screen.setText(String.valueOf(result));
            firstNum = result;
        });


    }
}