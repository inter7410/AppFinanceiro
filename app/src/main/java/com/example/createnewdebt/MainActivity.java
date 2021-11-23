package com.example.createnewdebt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Divida_Nome = (EditText) findViewById(R.id.Divida_Nome); //
        Spinner Divida_SpinnerTipo = (Spinner) findViewById(R.id.Divida_SpinnerTipo); //
        Spinner Divida_SpinnerParcela = (Spinner) findViewById(R.id.Divida_SpinnerParcela); //
        RadioButton Divida_RadioParcSim = (RadioButton) findViewById(R.id.Divida_RadioParcSim); //
        RadioButton Divida_RadioParcNao = (RadioButton) findViewById(R.id.Divida_RadioParcNao); //
        RadioGroup Divida_RadGroupParc = (RadioGroup) findViewById(R.id.Divida_RadGroupParc);

        //INICIO array Tipo da Divida
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.TipoDivida_Array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Divida_SpinnerTipo.setAdapter(adapter);
        //FINAL array Tipo da Divida

        //INICIO array Quantidade de Parcelas
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
        R.array.Quant_pag_Array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Divida_SpinnerParcela.setAdapter(adapter2);
        //FINAL array Quantidade de Parcelas

        //Spinner2 Ficar desabilitado para que quando altere no radiogroup ele fique correto
        Divida_SpinnerParcela.setEnabled(false);
        //Fim Spinner2

        Divida_RadGroupParc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.Divida_RadioParcSim == checkedId) {
                    Divida_SpinnerParcela.setEnabled(true);
                    }else if (R.id.Divida_RadioParcNao == checkedId) {
                    Divida_SpinnerParcela.setEnabled(false);
                    }
            }
        });
    }
}