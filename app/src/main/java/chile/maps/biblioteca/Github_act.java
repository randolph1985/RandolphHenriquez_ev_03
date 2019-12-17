package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Github_act extends AppCompatActivity {

    private Spinner spn_id;
    private TextView tv_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spn_id = (Spinner)findViewById(R.id.spn_id);
        tv_id = (TextView)findViewById(R.id.tv_id);

        Bundle dat = getIntent().getExtras();
        String[] lista = dat.getStringArray("libros2");

        ArrayAdapter adapt2 = new ArrayAdapter(this,
               android.R.layout.simple_list_item_1, lista);

        spn_id.setAdapter(adapt2);
    }

    public void Calcular(View v)
    {

    Bundle dat = getIntent().getExtras();
    String[] precios = dat.getStringArray("precios2");


        if(spn_id.getSelectedItem().equals("Farenheit"))
        {
            String precio = precios[0];
            int pc = Integer.parseInt(precio);
            int resultado = pc;
            tv_id.setText("El Valor de Farenheit es: "+ resultado);
        }

        if(spn_id.getSelectedItem().equals("Revival"))
        {
            String precioRevival = precios[1];
            int precioLibro = Integer.parseInt(precioRevival);
            int resultado = precioLibro;
            tv_id.setText("El Valor de Revival es: "+ resultado);
        }

        if(spn_id.getSelectedItem().equals("El Alquimista"))
        {

            String precioTesla = precios[2];
            int precioLibro = Integer.parseInt(precioTesla);
            int resultado = precioLibro;
            tv_id.setText("El Valor de Tesla es: "+ resultado);
        }

        if(spn_id.getSelectedItem().equals("El Poder"))
        {

            String precioP = precios[3];
            int precioLibro = Integer.parseInt(precioP);
            int resultado = precioLibro;
            tv_id.setText("El Valor de El Poder es: "+ resultado);
        }

        if(spn_id.getSelectedItem().equals("El Despertar"))
        {

            String precioDespertar= precios[4];
            int precioLibro = Integer.parseInt(precioDespertar);
            int resultado = precioLibro;
            tv_id.setText("El Valor de El Despertar es: "+ resultado);
        }
    }
}
