package communicathon.forset.kapiure;

import android.annotation.SuppressLint;
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

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import communicathon.forset.kapiure.login.LoginActivity;
import communicathon.forset.kapiure.registration.RegistrationActivity;

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {
    private ImageView IVcompas;
    private int id;
    private Button button;

    @SuppressLint("ValidFragment")
    public MainFragment(int id){
        this.id = id;
    }
    public static MainFragment newInstance(int id) {
        MainFragment fragment = new MainFragment(id);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);

        IVcompas = view.findViewById(R.id.compas);
        IVcompas.setImageResource(id);

        button = view.findViewById(R.id.quiz_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Quiz.class);
                startActivity(intent);
            }
        });
        return view;
    }




}
