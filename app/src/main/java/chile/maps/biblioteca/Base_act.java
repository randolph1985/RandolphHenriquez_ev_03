package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        et1 = findViewById(R.id.cod);
        et2 = findViewById(R.id.nombre);
        et3 = findViewById(R.id.precio);
    }

    public void añadirOrdenador(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            BaseDeDatos.insert("Libros", null, registro);
            BaseDeDatos.close();

            Toast.makeText(this, "Se ha ingresado un Libro", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarOrdenador(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty())
        {
            String codigo = et1.getText().toString();

            BaseDeDatos.delete("Libros", "codigo="+codigo, null);
            BaseDeDatos.close();

            Toast.makeText(this, "Se ha eliminado un Libro", Toast.LENGTH_LONG).show();
        }
    }


    public void modificarOrdenador(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty())
        {
            String codigo = et1.getText().toString();
            ContentValues registro = new ContentValues();

            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            BaseDeDatos.update("Libros", registro, "codigo="+codigo, null);
            BaseDeDatos.close();

            Toast.makeText(this, "Se ha modificado un Libro", Toast.LENGTH_LONG).show();
        }
    }
}
