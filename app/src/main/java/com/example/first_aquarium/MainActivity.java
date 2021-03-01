package com.example.first_aquarium;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ListView list;
    private  String[] array;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int category_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(R.string.introduction);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.introduction_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(array)));
        list.setAdapter(adapter);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        //toolbar.setTitle(R.string.introduction); //если убрать, то будет нахвание в баре такое
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.id_introduction){
            toolbar.setTitle(R.string.introduction);
            Toast.makeText(this, "1 pressed", Toast.LENGTH_SHORT).show();
            array = getResources().getStringArray(R.array.introduction_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=0;
        }
        else if (id == R.id.id_fish){
            toolbar.setTitle(R.string.fish);
            Toast.makeText(this, "2 pressed", Toast.LENGTH_SHORT).show();
            array = getResources().getStringArray(R.array.fish_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=1;
        }
        else if (id == R.id.id_Plants){
            toolbar.setTitle(R.string.plants);
            Toast.makeText(this, "3 pressed", Toast.LENGTH_SHORT).show();
            array = getResources().getStringArray(R.array.plants_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=2;
        }
        else if (id == R.id.id_equipment){
            toolbar.setTitle(R.string.equipment);
            Toast.makeText(this, "4 pressed", Toast.LENGTH_SHORT).show();
            array = getResources().getStringArray(R.array.equipment_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=3;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}