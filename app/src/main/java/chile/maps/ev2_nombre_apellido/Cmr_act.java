package chile.maps.ev2_nombre_apellido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cmr_act extends AppCompatActivity {
    private EditText tx1;
    private TextView tx2;
    private Button btn;
    private String[] productos = {"Tablet", "Refrigerador"};
    private String[] puntos = {"12000", "16000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmr_act);

        tx1 = (EditText)findViewById(R.id.tx_rut);
        tx2 = (TextView)findViewById(R.id.tx_resultado);
        btn = (Button)findViewById(R.id.btn_calcular);

        Bundle dato = getIntent().getExtras();
        String id_rut = dato.getString("rut");

        tx1.setText(id_rut);
    }

    public void calcular(View view){
        if(tx1.getText().toString().equals("183593897")){
            tx2.setText("Tiene: " + puntos[0] + "\npuede reclamar su " + productos[0]);
        }

        if(tx1.getText().toString().equals("114418455")){
            tx2.setText("Tiene: " + puntos[1] + "\npuede reclamar su " + productos[1]);
        }
    }



}
