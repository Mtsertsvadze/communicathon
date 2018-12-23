package communicathon.forset.kapiure;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MatchedFragment extends Fragment {

    private RecyclerView recyclerView;

    private ListRecyclerAdapter recyclerAdapter;

    public static MatchedFragment newInstance() {
        MatchedFragment fragment = new MatchedFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.matched_fragment, container, false);
        recyclerView = view.findViewById(R.id.fragment_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new ListRecyclerAdapter();

        recyclerView.setAdapter(recyclerAdapter);

        getUsers();

        return view;
    }

    private void getUsers(){
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.ic_launcher_foreground);
        data.add(R.drawable.perc);
        data.add(R.drawable.ic_launcher_foreground);
        recyclerAdapter.setData(data);
    }

}
