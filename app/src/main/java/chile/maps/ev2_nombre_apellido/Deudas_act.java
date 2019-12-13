package chile.maps.ev2_nombre_apellido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;








public class Deudas_act extends AppCompatActivity {
    private String[] pago = {"Pagar en Cuotas", "Pagar Todo"};
    private String[] cuota = {"1", "2"};
    private Spinner spn1, spn2;
    private EditText tx1, tx2;
    private TextView tx3, tx4;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deudas_act);

        tx1 = (EditText)findViewById(R.id.tx_deuda);
        tx2 = (EditText)findViewById(R.id.tx_saldo);
        tx3 = (TextView)findViewById(R.id.saldo_actual);
        tx4 = (TextView)findViewById(R.id.gasto_efectuado);

        spn1 = (Spinner)findViewById(R.id.spn1);
        spn2 = (Spinner)findViewById(R.id.spn2);

        btn = (Button)findViewById(R.id.btn_calcular);

        ArrayAdapter dato1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pago);
        ArrayAdapter dato2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cuota);

        spn1.setAdapter(dato1);
        spn2.setAdapter(dato2);
    }




    public void calcular(View view){
        int monto = 0;

        if(spn1.getSelectedItem().equals("Pagar en Cuotas")){
            if(spn2.getSelectedItem().equals("1")){
                tx3.setText("Su saldo actual es: " + tx1.getText().toString());
                tx4.setText("El gasto efectuado es: " + tx1.getText().toString());
            }else if(spn2.getSelectedItem().equals("2")){
                monto = (Integer.parseInt(tx1.getText().toString())/2);
                monto = (monto / 2);
                tx3.setText("Su saldo actual es: " + String.valueOf(monto));
                tx4.setText("El gasto efectuado es: " + tx1.getText().toString());
            }
        }else if(spn1.getSelectedItem().equals("Pagar Todo")){
            if(Integer.parseInt(tx2.getText().toString()) > Integer.parseInt(tx1.getText().toString())) {
                monto = (Integer.parseInt(tx2.getText().toString()) - Integer.parseInt(tx1.getText().toString()));
                tx3.setText("Su saldo actual es: " + String.valueOf(monto));
                tx4.setText("El gasto efectuado es: " + tx1.getText().toString());
            }
            else{
                tx4.setText("Saldo Insuficiente");
            }
        }
    }



}
