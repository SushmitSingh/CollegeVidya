package com.app.collegevidya.ui;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.app.collegevidya.R;
import com.app.collegevidya.databinding.ActivityHomeBinding;
import com.app.collegevidya.ui.home.FindQuickUniversityDailogFragment;
import com.app.collegevidya.ui.home.NavFragment;

public class HomeActivity extends AppCompatActivity {

    public NavController navController;
    private DialogFragment dialogFragment;
    //we declare the layout that was included as a View objects.
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        navController = Navigation.findNavController(this, R.id.nav_host_homeFragment);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.background_light_blue));
        }
        // Load Side Nav
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.navFrame, new NavFragment())
                .commit();
        binding.bottomNav.setItemSelected(R.id.explore, true);
        binding.bottomNav.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.explore:
                    navController.navigate(R.id.nav_host_homeFragment);
                    break;
                case R.id.compare:
                    navController.navigate(R.id.compareCollegeFragment);
                    break;
                case R.id.topUniversity:
                    dialogFragment = new FindQuickUniversityDailogFragment();
                    dialogFragment.show(getSupportFragmentManager(), "My  Fragment");
                    //dialogFragment.setCancelable(false);
                    break;
            }
        });

    }

    public void openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void closeBottomNav(){
        binding.bottomNav.setVisibility(View.GONE);
    }
    public void openBottomNav(){
        binding.bottomNav.setVisibility(View.VISIBLE);
    }


    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isOpen())
            binding.drawerLayout.close();
        else
            super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}