package com.example.level2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.level2.Al7an.A211;
import com.example.level2.Al7an.A212;
import com.example.level2.Al7an.A213;
import com.example.level2.Ash.Ash_1;
import com.example.level2.Coptic.Coptic_1;
import com.example.level2.Games.games;
//import com.example.level2.Quizes.QuizCatalogue;
import com.example.level2.Taks.Taks_1;

public class Level2_1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_1);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar toolbar = findViewById( R.id.toolbar2 );
        toolbar.setTitle("تـي اجـيــا    Level 2 ");
        toolbar.setTitleMarginStart(50);
        setTitleColor(Color.WHITE);

        setSupportActionBar( toolbar );


        android.support.v4.app.FragmentTransaction Transaction = getSupportFragmentManager().beginTransaction();
        A211 Fregment = new A211();
        Transaction.add( R.id.fram_l21, Fregment );
        Transaction.commit();

        DrawerLayout drawerLayout = findViewById( R.id.drwer_21 );

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );

        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav_l21);
        navigationView.setNavigationItemSelectedListener(this);


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById( R.id.drwer_21);
        if (drawerLayout.isDrawerOpen( GravityCompat.START )) {
            drawerLayout.closeDrawer( GravityCompat.START );
        } else {
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;



        if (itemId == R.id.t1_21)
        {   fragment=new A211();

            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        } else if (itemId == R.id.t2_21) {
            fragment=new A212();
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        } else if (itemId == R.id.t3_21) {
            fragment=new A213();
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        } else if (itemId == R.id.C_21) {
            fragment=new Coptic_1();
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        } else if (itemId == R.id.A_21) {
           fragment=new Ash_1();
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        } else if(itemId==R.id.T_21){
           fragment=new Taks_1();
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        }
        else if(itemId==R.id.catalog_21){
            fragment=new catalog();
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        }
        else if(itemId==R.id.gam_21){
            intent=new Intent(this, games.class);
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        }
        /*
        else if(itemId==R.id.quiz_21){
            intent=new Intent(this, QuizCatalogue.class);
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        }
        */
        else if(itemId==R.id.moraga_21){
            intent=new Intent(this, Morag3a.class);
            A211.mediaPlayer.stop();
            A212.mediaPlayer.stop();
            A213.mediaPlayer.stop();
        }
        else {
            intent=openfacebook("110490343647850");

        }
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace( R.id.fram_l21, fragment );
            transaction.commit();


        } else {
            startActivity( intent );
        }
        DrawerLayout drawerLayout= findViewById( R.id.drwer_21 );
        drawerLayout.closeDrawer( GravityCompat.START );
        return true;
    }
    public  static Intent openfacebook(String id){

        try {
            return new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/"+id));

        }
        catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+id));

        }

    }
}
