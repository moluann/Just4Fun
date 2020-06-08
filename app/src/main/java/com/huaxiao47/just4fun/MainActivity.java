package com.huaxiao47.just4fun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.huaxiao47.just4fun.ui.home.HomeFragment;
import com.huaxiao47.just4fun.ui.slideshow.ShootFragment;


public class MainActivity extends AppCompatActivity implements TBarFragment.OnFragmentInteractionListener,NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private DrawerLayout drawer;
    private boolean isLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.page_container, new HomeFragment()).commit();
        //// TODO: 2020/4/27 测试
//        getSupportFragmentManager().beginTransaction().replace(R.id.page_container, new PlayFragment()).commit();
        initNavView();
        Log.e(TAG, "onCreate: "+createTld() );

    }

    private void initNavView() {
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
        //todo 修改nav

        
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        drawer.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Toast.makeText(this,"click home",Toast.LENGTH_LONG).show();

                break;
            case R.id.nav_record:
                Toast.makeText(this,"click record",Toast.LENGTH_LONG).show();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.page_container, new ShootFragment()).commit();
                break;
            case R.id.nav_gallery:
                break;

        }

        return false;
    }

    public void toggleDrawer() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    static {
        System.loadLibrary("native-lib");
    }
    public static native String stringFromjni();
    public static native String createTld();
}
