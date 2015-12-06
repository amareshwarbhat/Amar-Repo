package app.widas.com.widas.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import app.widas.com.widas.R;

public class About_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_about);
        toolbar.setTitle("About");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        // Picasso.with(About_Activity.this).load(WidasConstants.IMG1).placeholder(R.mipmap.logo).into((ImageView) findViewById(R.id.about_image));

        TextView abouttext = (TextView) findViewById(R.id.about_Text);
        abouttext.setText(R.string.about_Text);
        TextView aboutmore = (TextView) findViewById(R.id.about_more);
        aboutmore.setText(R.string.aboutmore);
        TextView aboutdeveloper = (TextView) findViewById(R.id.about_developer);
        aboutdeveloper.setText(R.string.aboutdev);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
