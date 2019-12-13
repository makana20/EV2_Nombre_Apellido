package chile.maps.ev2_nombre_apellido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;





public class Home_act extends AppCompatActivity {
    private String[] lista = {"CMR puntos", "Deudas Pendientes"};
    private Spinner spin;
    private TextView rut;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        spin = (Spinner)findViewById(R.id.spinner);
        rut = (TextView)findViewById(R.id.rut);
        btn = (Button)findViewById(R.id.button);

        Bundle datos = getIntent().getExtras();
        String id_rut = datos.getString("rut");

        rut.setText(id_rut);

        ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);

        spin.setAdapter(adapt);
    }

    public void call(View view){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "6803906000"));
        startActivity(i);
    }

    public void internet(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.falabella.com"));
        startActivity(i);
    }

    public void mostrar(View view){
        if(spin.getSelectedItem().equals("CMR puntos")){
            Intent i = new Intent(getBaseContext(), Cmr_act.class);
            i.putExtra("rut", rut.getText().toString());
            startActivity(i);
        }

        if(spin.getSelectedItem().equals("Deudas Pendientes")){
            Intent i = new Intent(getBaseContext(), Deudas_act.class);
            i.putExtra("rut", rut.getText().toString());
            startActivity(i);
        }
    }


}
