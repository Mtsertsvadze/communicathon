package communicathon.forset.kapiure;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class MainAdapter extends FragmentStatePagerAdapter {

    String username;
    String coins;
    public MainAdapter(FragmentManager fm, String username, String coins) {
        super(fm);
        this.username = username;
        this.coins = coins;
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0 ){
            return MainFragment.newInstance();
        }else if(i == 1){
            return ProfileFragment.newInstance(username, coins);
        }else{
            return MatchedFragment.newInstance();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "კომპასი";
        } else if (position == 1){
            return "პროფილი " + position;
        }else{
            return "შემოთავაზებები";
        }
    }
}
