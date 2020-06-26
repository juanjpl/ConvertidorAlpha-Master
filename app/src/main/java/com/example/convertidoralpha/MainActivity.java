package com.example.convertidoralpha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //propiedades tipo nombre = valor
    //Creo los Views que voy a usar

    EditText temperaturaET;
    Button fahrBT;
    Button celBT;
    TextView temperaturaTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asocio los Views a sus contrapartes XML

        temperaturaET   = findViewById(R.id.temperaturaET);
        fahrBT          = findViewById(R.id.fahrBT);
        celBT           = findViewById(R.id.celBT);
        temperaturaTV   = findViewById(R.id.temperaturaTV);

        //temperaturaTV.setText("Hola Mundo!");


        View.OnClickListener seClickeoFahr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // traer el valor temperaturaET
                String temperaturaSTR = temperaturaET.getText().toString();

                if (temperaturaSTR.isEmpty()){
                    //Le digo al usuario que necesita ingresar un dato
                    Toast.makeText(this, R.string.mensajeToast, Toast.LENGTH_LONG).show();


                }else{

                //parsear String a Float
                Float temperaturaFLT = Float.parseFloat(temperaturaSTR);

                //convertir
                Float resultado = ( temperaturaFLT + 9/5 ) + 32;

                //mostrar el valor
                temperaturaTV.setText(resultado.toString());

                }



            }
        };

        fahrBT.setOnClickListener(seClickeoFahr);

    }

    //Funcion auxiliar
    public void seClickeoCel(View view){

        // traer el valor temperaturaET
        String temperaturaSTR = temperaturaET.getText().toString();

        // El signo de Exclamacion ! funciona como negador
        if (!temperaturaSTR.isEmpty()){

            //parsear String a Float
            Float temperaturaFLT = Float.parseFloat(temperaturaSTR);

            //convertir
            Float resultado = ( temperaturaFLT - 32 ) * 5/9;

            //mostrar el valor
            temperaturaTV.setText(resultado.toString());


        }


    }
}
