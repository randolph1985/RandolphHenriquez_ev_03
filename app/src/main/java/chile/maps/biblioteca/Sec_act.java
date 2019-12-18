package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sec_act extends AppCompatActivity {

    private TextView incidencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);

        incidencias = findViewById(R.id.textView7);
    }

    public void incidencia(View v)
    {
        incidencias.setText("Cryptopraphic Issues");
    }

    public void seg_incidencia(View v)
    {
        incidencias.setText("Hardcoded-password");
    }


}
