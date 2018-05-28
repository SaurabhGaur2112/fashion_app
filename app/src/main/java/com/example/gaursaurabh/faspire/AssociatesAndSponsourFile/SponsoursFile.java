package com.example.gaursaurabh.faspire.AssociatesAndSponsourFile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaursaurabh.faspire.ListData.AssociatesSponsoursList;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.example.gaursaurabh.faspire.R;

import java.util.List;

/**
 * Created by Saurabh Gaur on 2/10/2017.
 */
public class SponsoursFile extends RecyclerView.Adapter<SponsoursFile.ViewHolder> {

    private Context context;
    private List<AssociatesSponsoursList> associatesSponsoursLists;

    public SponsoursFile(Context context,List<AssociatesSponsoursList> associatesSponsoursLists){
        this.context = context;
        this.associatesSponsoursLists = associatesSponsoursLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.faspire_home_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(associatesSponsoursLists.get(position).getName());
        PicassoClient.downloadImgae(context,associatesSponsoursLists.get(position).getImage(),holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(associatesSponsoursLists.get(position).getLink()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return associatesSponsoursLists.size();
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
