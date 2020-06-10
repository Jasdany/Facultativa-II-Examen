package com.example.academia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.academia.ArrayModelo;
import com.example.academia.Modelo;

public class Adaptador extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayModelo Academia;

    public Adaptador(Context context, int layout, ArrayModelo academia) {
        this.context = context;
        this.layout = layout;
        this.Academia = academia;
    }

    @Override
    public int getCount() {
        return Academia.size();
    }

    @Override
    public Object getItem(int position) {
        return Academia.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //elementos de la lsita que van a llenar
    static class ViewHolder{
        private ImageView img;
        private TextView textViewNombre;
        private TextView textViewDescripcion;
        private TextView textViewPrecio;
        private TextView textViewHoras;
        private TextView textViewRequisitos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null || convertView.getTag() == null){
            LayoutInflater layoutInflater=LayoutInflater.from(this.context); //se manda a llamar la lista personalizada
            convertView=layoutInflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();

            //referencia de los elementos que se mostraran
            holder.img=(ImageView)convertView.findViewById(R.id.imagenviewlv);
            holder.textViewNombre=(TextView)convertView.findViewById(R.id.textViewNom);
            holder.textViewDescripcion=(TextView)convertView.findViewById(R.id.textViewDes);
            holder.textViewPrecio=(TextView)convertView.findViewById(R.id.textViewCos);
            holder.textViewHoras=(TextView)convertView.findViewById(R.id.textViewHor);
            holder.textViewRequisitos=(TextView)convertView.findViewById(R.id.textViewReq);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        Modelo current_Item=Academia.get(position);
        holder.textViewNombre.setText(current_Item.getNombre());
        holder.textViewDescripcion.setText(current_Item.getDescripcion());
        holder.textViewHoras.setText(current_Item.getHoras());
        holder.textViewPrecio.setText(current_Item.getPrecio());
        holder.textViewRequisitos.setText(current_Item.getRequisitos());
        holder.img.setImageResource(Academia.get(position).getImg());

        return convertView;
    }
}
