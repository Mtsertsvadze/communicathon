package communicathon.forset.kapiure;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import communicathon.forset.kapiure.models.Users;
import communicathon.forset.kapiure.models.UsersDatabase;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private MainAdapter mainAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.main_tab_layout);
        viewPager = findViewById(R.id.main_view_pager);



        String username = getIntent().getStringExtra("username");
        String coins  = "100";

        mainAdapter = new MainAdapter(getSupportFragmentManager(), username, coins);
        viewPager.setAdapter(mainAdapter);

        tabLayout.setupWithViewPager(viewPager);


    }
}
