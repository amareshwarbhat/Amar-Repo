package app.widas.com.widas.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import app.widas.com.widas.R;
import app.widas.com.widas.activity.FullScreenActivity;
import app.widas.com.widas.activity.GallaryActivity;

/**
 * Created by Amar on 11-Nov-15.
 */
public class GallaryAdapter extends RecyclerView.Adapter<GallaryAdapter.GallaryViewHolder> {
    private final Context context;
    private final String[] list;
    private final LayoutInflater inflater;

    public GallaryAdapter(GallaryActivity gallaryActivity, String[] myImageList) {
        context = gallaryActivity;
        list = myImageList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public GallaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recyler_gallary_module, parent, false);
        return new GallaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GallaryViewHolder holder, final int position) {

        Picasso.with(context).load(list[position]).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(holder.gallaryrecyclermoduleimage);

        holder.gallaryrecyclermoduleimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, FullScreenActivity.class);
                i.putExtra("img", list[position]);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class GallaryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView gallaryrecyclermoduleimage;

        public GallaryViewHolder(View itemView) {
            super(itemView);
            gallaryrecyclermoduleimage = (ImageView) itemView.findViewById(R.id.gallary_recycler_module_image);

        }
    }
}
