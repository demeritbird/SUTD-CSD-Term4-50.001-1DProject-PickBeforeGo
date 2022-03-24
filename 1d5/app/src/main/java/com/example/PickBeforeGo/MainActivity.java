package com.example.PickBeforeGo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.PickBeforeGo.activities.ProductScreenActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Toolbar topbar;
    private BottomNavigationView bottom_bar;

//    img for homepage Should be included in the HomeFragment instead
    private Integer[] imgId = {R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5};
    private ArrayList<View> arr1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up the bottom navigation bar
        bottom_bar = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,R.id.my_nav);
        NavigationUI.setupWithNavController(bottom_bar,navController);

        //set up images and on click on images to ProductScreenActivity
        for (int i=0;i<5;i++){
            View imgView = findViewById(imgId[i]);
            arr1.add(imgView);
        }
        for (View img:arr1){
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, ProductScreenActivity.class));
                }
            });
        }
    }
}