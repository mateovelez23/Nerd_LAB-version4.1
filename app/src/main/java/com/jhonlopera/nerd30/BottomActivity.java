package com.jhonlopera.nerd30;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView bottomNavigationView;

    /**/private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNav);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    boolean FragmentTransaction = false;
                    Fragment fragment = null;

                    if(item.getItemId()==R.id.btmcuatroImag){
                        fragment = new CuatroImgFragment();
                        FragmentTransaction = true;

                    }

                    else if (item.getItemId()==R.id.btmconcentrese){
                        fragment = new ConcentreseFragment();
                        FragmentTransaction = true;

                    }

                    else if (item.getItemId()==R.id.btmtopo){
                        fragment = new TopoFragment();
                        FragmentTransaction = true;

                    }

                    if(FragmentTransaction){
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_content,fragment)
                                .commit();
                        item.setChecked(true);
                    }

                    return true;
                }
            });
            return true;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);



        /*mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/
    }

}
