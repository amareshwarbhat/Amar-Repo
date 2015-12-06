package app.widas.com.widas.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import app.widas.com.widas.R;
import app.widas.com.widas.fragments.BigDataFragment;
import app.widas.com.widas.fragments.HomeFragment;
import app.widas.com.widas.fragments.TabFragment;

public class MainWidasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public static final String TAG_MAIL = "mail";
    public static final String TAG_Call = "call";
    public static final String TAG_SMS = "sms";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (isConnected()) {

            Fragment frgmentHome = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, frgmentHome).commit();

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Dialog");
            builder.setMessage("Oops...You are not connected to Internet!!!");
            builder.setPositiveButton("OK", null);
            builder.setNegativeButton("Cancel", null);
            builder.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.ic_grade);
        icon.setBackgroundResource(R.color.colorPrimary);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        ImageView mail = new ImageView(this); // Create an icon
        mail.setImageResource(R.drawable.ic_action_tag);
        ImageView call = new ImageView(this); // Create an icon
        call.setImageResource(R.drawable.ic_perm_phone_msg);
        ImageView rate_us = new ImageView(this); // Create an icon
        rate_us.setImageResource(R.drawable.ic_action_mail);

        SubActionButton button_mail = itemBuilder.setContentView(mail).build();
        SubActionButton button_call = itemBuilder.setContentView(call).build();
        SubActionButton button_sms = itemBuilder.setContentView(rate_us).build();

        button_mail.setTag(TAG_MAIL);
        button_call.setTag(TAG_Call);
        button_sms.setTag(TAG_SMS);

        button_mail.setOnClickListener(this);
        button_call.setOnClickListener(this);
        button_sms.setOnClickListener(this);

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button_mail)
                .addSubActionView(button_call)
                .addSubActionView(button_sms)
                .attachTo(actionButton)
                .build();
    }

    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_widas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.go_next) {

            Toast.makeText(getApplicationContext(), "Connecting to Blog", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.widas.de/hr-blog/"));
            int s = Intent.URI_INTENT_SCHEME;
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            if (isConnected()) {

                Fragment frgmentHome = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, frgmentHome).commit();

            } else {

                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
                builder.setTitle("Dialog");
                builder.setMessage("Oops...You are not connected to Internet!!!");
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
            }

        } else if (id == R.id.nav_bigdata) {

            if (isConnected()) {
                Fragment fragmentBigData = new BigDataFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentBigData).commit();

            } else {

                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
                builder.setTitle("Dialog");
                builder.setMessage("Oops...You are not connected to Internet!!!");
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
            }

        } else if (id == R.id.nav_contact) {

            Fragment tabFragment = new TabFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, tabFragment).commit();

        } else if (id == R.id.nav_atglance) {
            if (isConnected()) {

                Fragment frgmentHome = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, frgmentHome).commit();

            } else {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
                builder.setTitle("Dialog");
                builder.setMessage("Oops...You are not connected to Internet!!!");
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
            }

        } else if (id == R.id.gallary) {
            Intent intent = new Intent(this, GallaryActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, About_Activity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        if (v.getTag().equals(TAG_MAIL)) {
            Toast.makeText(getApplication(), "mail button was clicked", Toast.LENGTH_SHORT).show();
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "amareshwarbhat@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Help");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Tell us about");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if (v.getTag().equals(TAG_Call)) {
            Toast.makeText(getApplication(), "Call button was clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+917829145933"));
            startActivity(intent);
        }

        if (v.getTag().equals(TAG_SMS)) {
            Toast.makeText(getApplication(), "RateUs button was clicked", Toast.LENGTH_SHORT).show();
            Intent intentsms = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "+917829145933"));
            intentsms.putExtra("sms_body", "Share your views ");
            startActivity(intentsms);
        }
    }
}
