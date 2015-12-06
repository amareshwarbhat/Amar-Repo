package app.widas.com.widas.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.widas.com.widas.R;
import app.widas.com.widas.adapter.BigDataAdapter;
import app.widas.com.widas.model.BigDataModel;
import app.widas.com.widas.network.widasInterface;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amar on 08-Nov-15.
 */
public class BigDataFragment extends Fragment {
    private View view;
    private RecyclerView recyclerBigData;
    private LinearLayoutManager layoutManager;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerBigData = (RecyclerView) getActivity().findViewById(R.id.recycler_home);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerBigData.setLayoutManager(layoutManager);
        progressDialog = new ProgressDialog(view.getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://amartaskwidas2.orgfree.com/widasphp").build();
        widasInterface myInterface = restAdapter.create(widasInterface.class);
        myInterface.getBigDataDetails(new Callback<BigDataModel>() {
            @Override
            public void success(BigDataModel bigDataModel, Response response) {
                progressDialog.dismiss();
                recyclerBigData.setAdapter(new BigDataAdapter(getActivity(), bigDataModel.bigdatatable));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
