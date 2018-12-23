package communicathon.forset.kapiure;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class ProfileFragment extends Fragment {

    private TextView TVusername;
    private TextView TVcoins;

    private String username;
    private String coins;

    @SuppressLint("ValidFragment")
    public ProfileFragment(String username, String coins){
        this.username = username;
        this.coins = coins;
    }

    public static ProfileFragment newInstance(String username, String coins) {
        ProfileFragment fragment = new ProfileFragment(username, coins);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        TVusername = view.findViewById(R.id.profile_username);
        TVcoins = view.findViewById(R.id.profile_coins);

        TVusername.setText(username);
        TVcoins.setText(coins);

        return view;
    }
}
