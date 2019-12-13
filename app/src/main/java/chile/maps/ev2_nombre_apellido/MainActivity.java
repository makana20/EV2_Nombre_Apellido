package chile.maps.ev2_nombre_apellido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean valid = false;
    private EditText tx1, tx2;
    private TextView tx3;
    private Button btn;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = (EditText)findViewById(R.id.et1);
        tx2 = (EditText)findViewById(R.id.et2);
        tx3 = (TextView)findViewById(R.id.tvpass);
        pbar = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);

        pbar.setVisibility(View.INVISIBLE);
        tx3.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if((tx1.getText().toString().equals("114418455") || tx1.getText().toString().equals("183593897")) && tx2.getText().toString().equals("123")){
                    valid = true;
                    new Tack().execute(tx1.getText().toString());
                    Toast.makeText(getBaseContext(), "Acceso Concedido", Toast.LENGTH_SHORT).show();
                }
                else{
                    new Tack().execute(tx1.getText().toString());
                    tx1.setText("");
                    tx2.setText("");
                    tx3.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void mostrar(){
        Intent i = new Intent(getBaseContext(), Home_act.class);
        i.putExtra("rut", tx1.getText().toString());
        startActivity(i);
    }

    // Cambio de activity
    class Tack extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            pbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(2500);
                mostrar();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if(valid){
                pbar.setVisibility(View.INVISIBLE);
                valid = false;
            }
            else{
                pbar.setVisibility(View.INVISIBLE);
                tx3.setVisibility(View.VISIBLE);
            }
        }
    }
}
