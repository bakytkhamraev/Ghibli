package com.example.movieapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.App;
import com.example.movieapp.R;
import com.example.movieapp.data.GhibliService;
import com.example.movieapp.fragment.MovieAdapter;
import com.example.movieapp.fragment.MovieDescFragment;
import com.example.movieapp.fragment.MovieTask;
import com.example.movieapp.fragment.OnItemClickListener;
import com.example.movieapp.model.Film;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private MovieAdapter adapter;
    private ArrayList<MovieTask> movieDes = new ArrayList<>();
    private RecyclerView recyclerView;

    private TextView totoro;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.rv_movie);
        recyclerView();


        totoro = root.findViewById(R.id.totoro);

        App.ghibliService.getFilmById("2baf70d1-42bb-4437-b551-e5fed5a87abe", new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                totoro.setText(film.getTitle());
                totoro.setText(film.getDescription());
            }

            @Override
            public void onFailure(Exception exception) {

            }
        });

        return root;
    }

    private void recyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new MovieAdapter(movieDes);
        recyclerView.setAdapter(adapter);
        adapter.setInBookClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(int pos) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pos", movieDes.get(pos));
                MovieDescFragment fragment = new MovieDescFragment();
                fragment.setArguments(bundle);
                Log.d("ololo", "ololo");
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_movie, fragment).addToBackStack(null).commit();
                recyclerView.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                recyclerView.setVisibility(View.VISIBLE);
                return false;
            }
        });
    }
}
