package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private ProgressBar pb;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        btn = (Button)findViewById(R.id.btn);
        pb = (ProgressBar)findViewById(R.id.pb);

        pb.setVisibility(View.INVISIBLE); // hace invisible el elemento.

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute(et1.getText().toString());
            }
        });
    }


    class Task extends AsyncTask<String, Void, String>
    {

        // configura mi tarea inicial
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE); // Hago visible mi progress.
            btn.setEnabled(false);
        }

        // se ejecuta la tarea o proceso complejo.
        @Override
        protected String doInBackground(String... strings) {

            try
            {
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        // es lo que se va a realizar despues de mi tarea pesada.
        @Override
        protected void onPostExecute(String s) {


            String user = et1.getText().toString();
            String pass = et2.getText().toString();

            btn.setEnabled(true);
            pb.setVisibility(View.INVISIBLE);

            if( (user.equals("160036451") || user.equals("183593897") ) && pass.equals("1")){
                Intent i = new Intent(getBaseContext(), Home_act.class);
                Toast.makeText(getBaseContext(), "Acceso Concedido",Toast.LENGTH_LONG).show();
                i.putExtra("nombre", user);
                i.putExtra("contrasena", pass);
                startActivity(i);
            }
            else{
                Toast.makeText(getBaseContext(), "Recuperar Contraseña",Toast.LENGTH_LONG).show();
            }

        }
    }

    public void Home(View v)
    {
        Intent i = new Intent(this, Home_act.class);
        startActivity(i);
    }

    public void Location(View v)
    {
        Intent i = new Intent(this, Location_act.class);
        startActivity(i);
    }

    public void Maps(View v)
    {
        Intent i = new Intent(this,Activity_maps.class);
        startActivity(i);
    }

    public void Github(View v)
    {
        String[] datos   = {"Farenheit", "Revival", "El Alquimista", "El Poder", "El Despertar"};
        String[] precios = {"5000", "22000", "45000","88000","156000"};

        Intent i = new Intent(this,Github_act.class);
        i.putExtra("libros2", datos);
        i.putExtra("precios2", precios);
        startActivity(i);
    }
}