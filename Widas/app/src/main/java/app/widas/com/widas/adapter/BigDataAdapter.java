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
import app.widas.com.widas.model.BigDataModel;

/**
 * Created by Amar on 08-Nov-15.
 */
public class BigDataAdapter extends RecyclerView.Adapter<BigDataAdapter.BigDataViewHolder> {
    private final List<BigDataModel.BigDataList> bigdatatable;
    private final LayoutInflater inflater;
    Context context;

    public BigDataAdapter(FragmentActivity activity, List<BigDataModel.BigDataList> bigdatatable) {
        context = activity;
        this.bigdatatable = bigdatatable;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BigDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BigDataViewHolder(inflater.inflate(R.layout.fragment_module_home, parent, false));
    }

    @Override
    public void onBindViewHolder(BigDataViewHolder holder, int position) {
        try {
            Picasso.with(context).load(bigdatatable.get(position).icon).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(holder.imgBigData);
        } catch (IllegalArgumentException e) {
        }

        holder.titleBigdata.setText(bigdatatable.get(position).title.toString());
        holder.descriptionBigData.setText(bigdatatable.get(position).description.toString());

    }

    @Override
    public int getItemCount() {
        return bigdatatable.size();
    }

    public class BigDataViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgBigData;
        private final TextView titleBigdata;
        private final TextView descriptionBigData;

        public BigDataViewHolder(View itemView) {
            super(itemView);
            imgBigData = (ImageView) itemView.findViewById(R.id.img_home);
            titleBigdata = (TextView) itemView.findViewById(R.id.title_home);
            descriptionBigData = (TextView) itemView.findViewById(R.id.description_home);

        }
    }
}
