package com.example.ramon.atividade1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton botao = this.findViewById(R.id.calularValor);
        botao.setImageResource(R.drawable.botao);

        RadioGroup sexo = this.findViewById(R.id.sexoValor);
        final String sexoTipo = ((RadioButton) findViewById(sexo.getCheckedRadioButtonId())).getText().toString();

        EditText altura = this.findViewById(R.id.alturaValor);
        final int alturaint = Integer.parseInt(altura.getText().toString());

        EditText peso = this.findViewById(R.id.pesoValor);
        final double pesodouble = Double.parseDouble(peso.getText().toString());

        EditText idade = this.findViewById(R.id.idadeValor);
        final int idadeint = Integer.parseInt(idade.getText().toString());

        final CheckBox semana = this.findViewById(R.id.resultadosemana);

        final CheckBox mes = this.findViewById(R.id.resultadomes);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sexoTipo.equalsIgnoreCase("masculino")) {
                    double resultado = (66 + (13.7 * pesodouble) + (5.0 * alturaint) - (6.8  * idadeint));
                    if (semana.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Sua TMB é de "+resultado+" kcal diárias", Toast.LENGTH_LONG);
                        Toast toastsemana = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
                    } else if (mes.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Sua TMB é de "+resultado+" kcal diárias", Toast.LENGTH_LONG);
                        Toast toastsemana = Toast.makeText(getApplicationContext(), "Sua TMB é de "+(resultado*7)+" kcal semanal", Toast.LENGTH_LONG);
                        Toast toastmes = Toast.makeText(getApplicationContext(), "Sua TMB é de "+(resultado*30)+" kcal mensal", Toast.LENGTH_LONG);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Sua TMB é de "+resultado+" kcal diárias", Toast.LENGTH_LONG);
                    }

                }
                if (sexoTipo.equalsIgnoreCase("feminino")) {

                }
            }
        });

    }
}
