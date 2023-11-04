package com.example.soga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.soga.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        user = FirebaseAuth.getInstance().getCurrentUser();
        Intent intent;

        if (user != null) {//if the user logged in, just jump to map page
//            intent = new Intent(this, Register.class);
//            intent = new Intent(this, .class);

        } else {// if not,jump to log in page
            intent = new Intent(this, Login.class);
            startActivity(intent);
//            finish();
        }
//        intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.home_dashboard);

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void onButtonClickCreate(View view){
        startActivities(new Intent[]{new Intent(this, RoomManagement.class)});
    }

    public void onButtonClickJoin(View view){
        startActivities(new Intent[]{new Intent(this, JoinActivity.class)});
    }
    public void onButtonClickBoard(View view){
        startActivities(new Intent[]{new Intent(this, LeaderBoard.class)});
    }

    public void logOut(View view){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "User logged out.",Toast.LENGTH_SHORT).show();
    }


}