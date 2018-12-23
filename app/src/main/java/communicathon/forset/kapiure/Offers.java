package communicathon.forset.kapiure;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import communicathon.forset.kapiure.login.LoginActivity;
import communicathon.forset.kapiure.registration.RegistrationActivity;

public class Offers extends Fragment {
    private ImageView IVcompas;

    private Button button;

    public static Offers newInstance() {
        Offers fragment = new Offers();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offers, container, false);

        IVcompas = view.findViewById(R.id.offer_list);
        IVcompas.setImageResource(R.drawable.list);

        button = view.findViewById(R.id.list_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment.newInstance(R.drawable.map2);
            }
        });

        return view;
    }

}
