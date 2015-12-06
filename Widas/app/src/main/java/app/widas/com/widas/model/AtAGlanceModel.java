package app.widas.com.widas.model;

import java.util.List;

/**
 * Created by Amar on 08-Nov-15.
 */
public class AtAGlanceModel {
    public List<AtAGlanceList> ataglance;

    private class AtAGlanceList {
        public String icon;
        public String description;

    }

    public String success;
}
