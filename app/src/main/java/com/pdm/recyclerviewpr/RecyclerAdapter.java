package com.pdm.recyclerviewpr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final String [] titles = {
            "Primeiro Titulo",
            "Segundo Titulo",
            "Terceiro Titulo",
            "Quarto Titulo",
            "Quinto Titulo",
            "Sexto Titulo",
            "Setimo Titulo",
            "Oitavo Titulo"
    };

    private final String [] details = {
            "Primeira descricao",
            "Segunda descricao",
            "Terceira descricao",
            "Quarta descricao",
            "Quinta descricao",
            "Sexta descricao",
            "Setima descricao",
            "Oitavo descricao"
    };

    private final int [] images = {
            R.drawable.android_image_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
            R.drawable.android_image_4,
            R.drawable.android_image_5,
            R.drawable.android_image_6,
            R.drawable.android_image_7,
            R.drawable.android_image_8
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemDetail = itemView.findViewById(R.id.itemDetail);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int posicao = getAdapterPosition();

                            Snackbar.make(v,
                                    "Foi clicado o elemento " + (posicao+1),
                                    Snackbar.LENGTH_LONG).setAction("Action",
                                    null).show();
                        }
                    }
            );
        }
    }
}


