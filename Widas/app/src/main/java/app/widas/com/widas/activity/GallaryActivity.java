package app.widas.com.widas.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import app.widas.com.widas.R;
import app.widas.com.widas.adapter.GallaryAdapter;
import app.widas.com.widas.utility.WidasConstants;

public class GallaryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private ImageSwitcher myImageView;
    private int i = 0;
    private ImageView galleryImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_gallary);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        galleryImg = (ImageView) findViewById(R.id.img_gallary);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_activity);
        toolbar.setTitle("Gallary");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);

        final String[] myImageList = new String[]{WidasConstants.IMG1, WidasConstants.IMG2, WidasConstants.IMG3, WidasConstants.IMG4, WidasConstants.IMG5, WidasConstants.IMG6};

        recyclerView.setAdapter(new GallaryAdapter(this, myImageList));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (i < 6) {
                    Picasso.with(GallaryActivity.this).load(myImageList[i]).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(galleryImg);
                    i++;
                } else {
                    i = 0;
                }
                handler.postDelayed(this, 10000);
            }
        }, 500);

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