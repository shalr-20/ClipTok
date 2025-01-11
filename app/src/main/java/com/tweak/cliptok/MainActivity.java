package com.tweak.cliptok;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tweak.cliptok.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Model> arrayList=new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //requestFeature() must be added before content
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide statusbar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);  //flags control the behaviour and appearance of the window

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); //returns the root view of the inflated layout (here, constraint layout), which is then used to set the activity's content.
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.getTheme().applyStyle(R.style.Fullscreen, false);

        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid1, R.drawable.profile, "Drake Ramoray")); //pass in Model: Video's and profile's URI as argument, and a string
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid2, R.drawable.profile, "Chandler Bing"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid3, R.drawable.profile, "Monica Geller"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid4, R.drawable.profile, "Ross Geller"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid5, R.drawable.profile, "Joey Tribiani"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid6, R.drawable.profile, "Phoebe Buffey"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid7, R.drawable.profile, "Rachel Green"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid8, R.drawable.profile, "Gunther"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.vid9, R.drawable.profile, "Emma"));

        adapter=new Adapter(MainActivity.this, arrayList);
        binding.viewPager2.setAdapter(adapter);
    }
}