package com.example.academia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView ListAcademia;
    Modelo model; //metodo con los get set de las variables de la list
    ArrayModelo listModel; //constructor vacio
    Adaptador Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAcademia=(ListView) findViewById(R.id.listView1);
        ListAcademia.setOnCreateContextMenuListener(this);
        llenandoLista();
    }
    void llenandoLista() //metodo para inicializar el constructor
    {
        listModel=new ArrayModelo();
        model=new Modelo("ADOBE","Aprende el uso de las tecnologias con las poderosas herramientas de diseño","$150","80","Internet");
        model.setImg(R.drawable.adobe);
        listModel.add(model);
        model=new Modelo("APLE","Diseño de aplicaciones para IOS","$100","60","Internet, conocimientos en el diseño de aplicaciones");
        model.setImg(R.drawable.aple);
        listModel.add(model);
        model=new Modelo("MICROSOFT","Programacion de driver","$200","100","Internet, Amplios conocimientos en programacion Orientada a objetos");
        model.setImg(R.drawable.microsoft);
        listModel.add(model);
        Adapter=new Adaptador(this, R.layout.item_list,listModel);
        ListAcademia.setAdapter(Adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones");
        getMenuInflater().inflate(R.menu.menucontext,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) { //metodo donde se programan los botones del menu contextual
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.btnDelet: //boton eliminar
                this.listModel.remove(info.position);
                this.Adapter.notifyDataSetChanged();
                return true;
            case R.id.btnSalir:// boton salir
                System.exit(0);

            case R.id.btnAddNew: //boton agregar 
                final Dialog dlg = new Dialog(this);
                dlg.setContentView(R.layout.add_new);
                dlg.setTitle("Agregar Nueva Academia");
                dlg.setCancelable(false);
                Button btnAgregar=(Button)dlg.findViewById(R.id.btNew);
                Button btnCancelar=(Button)dlg.findViewById(R.id.btCancel);

                btnAgregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText_Name=(EditText) dlg.findViewById(R.id.editText_Name);
                        EditText editText_Descripcion=(EditText)dlg.findViewById(R.id.editTex_Descripcion);
                        EditText editText_Horas=(EditText)dlg.findViewById(R.id.editTex_Horas);
                        EditText editText_Costo=(EditText)dlg.findViewById(R.id.editTex_Costo);
                        EditText editText_Requisitos=(EditText)dlg.findViewById(R.id.editTex_Requisitos);
                        if (
                                editText_Name.getText().toString().isEmpty() ||
                                        editText_Descripcion.getText().toString().isEmpty() ||
                                                     editText_Horas.getText().toString().isEmpty() ||
                                                                editText_Costo.getText().toString().isEmpty() ||
                                                                        editText_Requisitos.getText().toString().isEmpty()
                        )

                        {
                            Toast.makeText(MainActivity.this, "Los campos no deben estar vacios",Toast.LENGTH_LONG).show();
                        }else {
                            Modelo nuevoModelo = new Modelo(); //se declara un nuevo objeto donde se almacenara los nuevos datos
                            nuevoModelo.setNombre(editText_Name.getText().toString());
                            nuevoModelo.setDescripcion(editText_Descripcion.getText().toString());
                            nuevoModelo.setHoras(editText_Horas.getText().toString());
                            nuevoModelo.setPrecio(editText_Costo.getText().toString());
                            nuevoModelo.setRequisitos(editText_Requisitos.getText().toString());
                            nuevoModelo.setImg(R.drawable.nike);
                            listModel.add(nuevoModelo);
                            Adapter.notifyDataSetChanged(); //se manda actualizar la ventana
                            editText_Name.setText(""); //se limpian los editText una ves q guardas un nuevo elemento
                            editText_Costo.setText("");
                            editText_Descripcion.setText("");
                            editText_Horas.setText("");
                            editText_Requisitos.setText("");
                            dlg.cancel();
                        }
                    }
                });
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.cancel();
                    }
                });
                dlg.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
