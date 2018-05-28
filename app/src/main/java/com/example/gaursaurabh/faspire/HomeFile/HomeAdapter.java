package com.example.gaursaurabh.faspire.HomeFile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaursaurabh.faspire.ActorCategory;
import com.example.gaursaurabh.faspire.Boutique;
import com.example.gaursaurabh.faspire.CelebrityDesigner;
import com.example.gaursaurabh.faspire.Designer;
import com.example.gaursaurabh.faspire.DesignerCategory;
import com.example.gaursaurabh.faspire.FashionCoordinator;
import com.example.gaursaurabh.faspire.FashionStylist;
import com.example.gaursaurabh.faspire.FaspireActor;
import com.example.gaursaurabh.faspire.FaspireCities;
import com.example.gaursaurabh.faspire.FaspireModel;
import com.example.gaursaurabh.faspire.FaspireNews;
import com.example.gaursaurabh.faspire.FaspirePeople;
import com.example.gaursaurabh.faspire.Faspire_Makeup;
import com.example.gaursaurabh.faspire.FlashBack;
import com.example.gaursaurabh.faspire.MakeupArtistCategory;
import com.example.gaursaurabh.faspire.ModelCategory;
import com.example.gaursaurabh.faspire.Photographer;
import com.example.gaursaurabh.faspire.PhotographerCategory;
import com.example.gaursaurabh.faspire.Picasso.PicassoClient;
import com.example.gaursaurabh.faspire.R;
import com.example.gaursaurabh.faspire.TrendsAndUpdate;

import java.util.List;

/**
 * Created by Saurabh Gaur on 2/6/2017.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private List<HomeData> homeData;
    Intent intent;

    public HomeAdapter(Context context,List<HomeData> homeData){
        this.context = context;
        this.homeData = homeData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.faspire_home_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.name.setText(homeData.get(position).getName());
        PicassoClient.downloadImgae(context,homeData.get(position).getImage(),holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(homeData.get(position).getCategory().equals("news")) {
                    context.startActivity(new Intent(context, FaspireNews.class));
                } else if(homeData.get(position).getCategory().equals("flash back")){
                    context.startActivity(new Intent(context, FlashBack.class));
                } else if(homeData.get(position).getCategory().equals("trends")){
                    context.startActivity(new Intent(context, TrendsAndUpdate.class));
                } else if(homeData.get(position).getCategory().equals("boutique")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","boutique");
                    context.startActivity(intent);

                } else if(homeData.get(position).getCategory().equals("designer")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","designer");
                    context.startActivity(intent);

                } else if(homeData.get(position).getCategory().equals("fashion_stylist")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","fashion_stylist");
                    context.startActivity(intent);

                } else if(homeData.get(position).getCategory().equals("actor")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","actor");
                    context.startActivity(intent);

                } else if(homeData.get(position).getCategory().equals("model")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","model");
                    context.startActivity(intent);

                } else if(homeData.get(position).getCategory().equals("makeup_artist")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","makeup_artist");
                    context.startActivity(intent);

                    context.startActivity(new Intent(context, MakeupArtistCategory.class));
                } else if(homeData.get(position).getCategory().equals("photographer")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","photographer");
                    context.startActivity(intent);

                } else if(homeData.get(position).getCategory().equals("fashion_coordinator")){
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","fashion_coordinator");
                    context.startActivity(intent);

                } else {
                    intent = new Intent(context, FaspireCities.class);
                    intent.putExtra("fileName","faspire_people");
                    context.startActivity(intent);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeData.size();
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
