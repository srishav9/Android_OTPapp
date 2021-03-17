package com.example.risha.myfragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;


import com.example.risha.myfragments.adapters.ViewPagerAdapter;
import com.example.risha.myfragments.fragments.Fragment1;
import com.example.risha.myfragments.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);   //title|
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        viewPager=(ViewPager)findViewById(R.id.viewpager);  //to show the content|
        setupViewPager(viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabs);   //tabs|
        tabLayout.setupWithViewPager(viewPager);
       /*
       splash screen work! create new activity and then pass from there to mainactivity.this
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(src,dest);
                startActivity(i);
                finish();
            }
        },3000);
        */
    }

    //for options---> three dots on the right side
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);     //my_menu is set in menu.
        return super.onCreateOptionsMenu(menu);
    }

    @Override       //like onClick(View v) then v.getID
    public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId()==R.id.action_edit){
                Toast.makeText(this, "Edit Cicked", Toast.LENGTH_SHORT).show();
            }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        Fragment1 of=new Fragment1();
        adapter.addFragment(of,"hello_title_tab-1");
        Fragment2 tf=new Fragment2();
        adapter.addFragment(tf,"hello_title_tab-2");
        viewPager.setAdapter(adapter);
    }

}
