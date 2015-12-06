package app.widas.com.widas.network;

import app.widas.com.widas.model.AtAGlanceModel;
import app.widas.com.widas.model.BigDataModel;
import app.widas.com.widas.model.ContactModel;
import app.widas.com.widas.model.HomeModel;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Amar on 08-Nov-15.
 */
public interface widasInterface {
    //GET or POST API calls
    @GET("/getdatahome.php")
    public void getHomeDetails(Callback<HomeModel> response);

    @GET("/getdatabigdata.php")
    public void getBigDataDetails(Callback<BigDataModel> response);

    @GET("/getdatacontact.php")
    public void getContactDetails(Callback<ContactModel> response);

    @GET("/getdataataglance.php")
    public void getAtAGlanceDetails(Callback<AtAGlanceModel> response);

}
