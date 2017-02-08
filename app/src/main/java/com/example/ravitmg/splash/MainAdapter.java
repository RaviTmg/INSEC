package com.example.ravitmg.splash;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi Tmg on 2/6/2017.
 */

class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {
    private Context context;
    private List<Eveents> objectList;

    MainAdapter(Context context, List<Eveents> objectList){
        this.context = context;
        this.objectList = objectList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row, parent, false);
        // create ViewHolder instance
        return new Holder(v);

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Eveents orgObject = objectList.get(position);
        holder.date.setText(orgObject.getDate());
        holder.title.setText(orgObject.getTitle());
        holder.desc.setText(orgObject.getDesc());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do your thing here
                Toast.makeText(context, "ouch,dont tap hard", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView date, title, desc;
        CardView cardView;
        Holder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            title = (TextView) itemView.findViewById(R.id.tittle);
            desc = (TextView) itemView.findViewById(R.id.desc);
            cardView = (CardView) itemView.findViewById(R.id.card);
        }
    }
}
