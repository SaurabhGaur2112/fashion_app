package com.example.gaursaurabh.faspire.BoutiqueFile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.ListData.DataList;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.example.gaursaurabh.faspire.ProfileBoutique;
import com.example.gaursaurabh.faspire.R;

import java.util.List;

/**
 * Created by Saurabh Gaur on 2/6/2017.
 */
public class BoutiqueAdapter extends RecyclerView.Adapter<BoutiqueAdapter.ViewHolder> {

    private Context context;
    private List<DataList> dataLists;

    public BoutiqueAdapter(Context context,List<DataList> dataLists){
        this.context = context;
        this.dataLists = dataLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.faspire_home_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(dataLists.get(position).getName());
        PicassoClient.downloadImgae(context,dataLists.get(position).getImage(),holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileBoutique.class);
                intent.putExtra("boutiqueId",dataLists.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView imageView;

        public ViewHolder(View itemView){
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.home_name);
            imageView = (ImageView) itemView.findViewById(R.id.home_image);
        }
    }
}
