package com.jhonlopera.nerd30;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm;
    FragmentTransaction ft;

    private  String correoR,contraseñaR,nombreR,log,foto,fotoR;
    SharedPreferences preferencias;
    SharedPreferences.Editor editor_preferencias;
    int silog;

    int duration = Toast.LENGTH_SHORT;
    GoogleApiClient mGoogleApiClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        Fragment fragment = new MenuPrincipalFragment();
        ft.add(R.id.main_content, fragment).commit();
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        boolean FragmentTransaction = false;
        Fragment fragment = null;
        Intent intent;

        if (id == R.id.nav_main) {

            fragment = new MenuPrincipalFragment();
            FragmentTransaction = true;

        } else if (id == R.id.nav_profile) {

            fragment = new PerfilFragment();
            FragmentTransaction = true;

        } else if (id == R.id.nav_ranking) {

            intent = new Intent(this, CreditosActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_config) {

            Log.i("NavDraw","Sección Configuración");
            getSupportActionBar().setTitle("Configuración");

        } else if (id == R.id.nav_juegos){

            intent = new Intent(this, BottomActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_csesion){

            /*preferencias=getSharedPreferences("Preferencias",Context.MODE_PRIVATE);
            editor_preferencias=preferencias.edit();

            log=preferencias.getString("log","error");
            if(log.equals("facebook")){
                silog=0;
                log="facebook";
                editor_preferencias.putInt("silog",silog);
                editor_preferencias.putString("log",log);
                editor_preferencias.commit();

                intent=new Intent(this,LoginActivity.class);
                LoginManager.getInstance().logOut();// cerrar sesion en facebook
                Toast.makeText(getApplicationContext(),"Saliendo de facebook", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
            else if(log.equals("google")){
                silog=0;
                log="google";
                editor_preferencias.putInt("silog",silog);
                editor_preferencias.putString("log",log);
                editor_preferencias.commit();

                signOut(); //cerrar sesion en google
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                silog=0;
                log="registro";
                editor_preferencias.putInt("silog",silog);
                editor_preferencias.putString("log",log);
                editor_preferencias.commit();
                intent=new Intent(this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }*/

        }

        if(FragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content,fragment)
                    .commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        Context context = getApplicationContext();
                        CharSequence text = "Saliendo de google";
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

    }*/
}
