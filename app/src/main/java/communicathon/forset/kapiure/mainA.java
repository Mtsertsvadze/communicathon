package communicathon.forset.kapiure;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class mainA extends AppCompatActivity {

    private TabLayout tabLayout;
    private MainAdapter2 mainAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.main_tab_layout);
        viewPager = findViewById(R.id.main_view_pager);



        String username = getIntent().getStringExtra("username");
        String coins  = "100";

        mainAdapter = new MainAdapter2(getSupportFragmentManager(), username, coins);
        viewPager.setAdapter(mainAdapter);

        tabLayout.setupWithViewPager(viewPager);


    }
}
