package app.widas.com.widas.model;

import java.util.List;

/**
 * Created by Amar on 08-Nov-15.
 */
public class ContactModel {
    public List<ContactList> contacttable;

    private class ContactList {
        public String title;
        public String description;
    }

    public String success;
}
