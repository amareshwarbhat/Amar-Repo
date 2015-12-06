package app.widas.com.widas.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.widas.com.widas.R;
import app.widas.com.widas.model.HomeModel;

/**
 * Created by Amar on 08-Nov-15.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private final List<HomeModel.HomeList> hometable;
    private final LayoutInflater inflater;
    Context context;

    public HomeAdapter(FragmentActivity activity, List<HomeModel.HomeList> hometable) {
        context = activity;
        this.hometable = hometable;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new HomeViewHolder(inflater.inflate(R.layout.fragment_module_home, parent, false));
    }
    //to get View inflation ..No data here

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        try {
            Picasso.with(context).load(hometable.get(position).icon).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(holder.imgHome);
        } catch (IllegalArgumentException e) {

        }
        holder.titleHome.setText(hometable.get(position).title.toString());
        holder.descriptionHome.setText(hometable.get(position).description.toString());
    }

    @Override
    public int getItemCount() {
        return hometable.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private final TextView descriptionHome;
        private final TextView titleHome;
        private final ImageView imgHome;

        public HomeViewHolder(View itemView) {
            super(itemView);
            imgHome = (ImageView) itemView.findViewById(R.id.img_home);
            titleHome = (TextView) itemView.findViewById(R.id.title_home);
            descriptionHome = (TextView) itemView.findViewById(R.id.description_home);
        }
    }
}
