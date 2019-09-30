package com.kamak.wayang.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kamak.wayang.Adapter.Adapter_wayang.ViewHolder;
import com.kamak.wayang.Model_Sejarah;
import com.kamak.wayang.Model_Wayang;
import com.kamak.wayang.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_wayang extends RecyclerView.Adapter<ViewHolder> {
    @NonNull
    List<Model_Wayang> modoel_wayang;
    private Context context;

    public void setModoel_wayang(@NonNull List<Model_Wayang> modoel_wayang) {
        this.modoel_wayang = modoel_wayang;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @NonNull
    public List<Model_Wayang> getModoel_wayang() {
        return modoel_wayang;
    }

    public Context getContext() {
        return context;
    }

    public Adapter_wayang(@NonNull List<Model_Wayang> modoel_wayang) {
        this.modoel_wayang = modoel_wayang;
    }

    public Adapter_wayang(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sejarah, viewGroup, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Model_Wayang model_wayang = (getModoel_wayang()).get(i);
        viewHolder.title.setText(model_wayang.getJudul());
        Glide.with(context)
                .load(model_wayang.getImg())


                .into(viewHolder.img);
        viewHolder.btnSetFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.detail_sejarah);
                dialog.setTitle( model_wayang.getJudul());
                dialog.setCancelable(true);

                TextView textView=(TextView) dialog.findViewById(R.id.tvdetail);
                TextView txtclose=(TextView) dialog.findViewById(R.id.btnclose);
                ImageView gbr=(ImageView) dialog.findViewById(R.id.gbr);
                textView.setText(model_wayang.getKet());
                Glide.with(context)
                        .load(model_wayang.getImg())


                        .into(gbr);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return getModoel_wayang().size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.btn_set_favorite)
        Button btnSetFavorite;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
