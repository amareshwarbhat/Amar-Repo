package app.widas.com.widas.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import app.widas.com.widas.R;

/**
 * Created by Amar on 15-Nov-15.
 */
public class FullScreenActivity extends AppCompatActivity {

    private ImageView fullImg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_layout);

        Bundle bundle = getIntent().getExtras();
        String a = bundle.getString("img");

        fullImg = (ImageView) findViewById(R.id.full_img);
        Picasso.with(FullScreenActivity.this).load(a).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(fullImg);
    }
}
