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
import app.widas.com.widas.adapter.HomeAdapter;
import app.widas.com.widas.model.HomeModel;
import app.widas.com.widas.network.widasInterface;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by Amar on 08-Nov-15.
 */
public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView recyclerHome;
    private LinearLayoutManager layoutManager;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //eliminate super here ,it will come by default
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerHome = (RecyclerView) view.findViewById(R.id.recycler_home);
        layoutManager = new LinearLayoutManager(getActivity());
        //Layout inflater one by one linear else we can use grid,stagard grid too depends....
        recyclerHome.setLayoutManager(layoutManager);

        progressDialog = new ProgressDialog(view.getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://amartaskwidas2.orgfree.com/widasphp").build();
        widasInterface myInterface = restAdapter.create(widasInterface.class);
        myInterface.getHomeDetails(new Callback<HomeModel>() {
//passing model to retrofit callback interface
            @Override
            public void success(HomeModel homeModel, Response response) {
                //homemodel is the pogo model( complete Data)
                progressDialog.dismiss();
                recyclerHome.setAdapter(new HomeAdapter(getActivity(), homeModel.hometable));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
