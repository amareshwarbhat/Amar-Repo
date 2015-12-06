package app.widas.com.widas.model;

import java.util.List;

/**
 * Created by Amar on 08-Nov-15.
 */
public class BigDataModel {
    public List<BigDataList> bigdatatable;

    public class BigDataList {
        public String icon;
        public String title;
        public String description;
    }

    public String success;
}
