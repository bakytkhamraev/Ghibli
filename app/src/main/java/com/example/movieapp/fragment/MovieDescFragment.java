 package com.example.movieapp.fragment;

 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ImageView;
 import android.widget.TextView;

 import androidx.annotation.NonNull;
 import androidx.annotation.Nullable;
 import androidx.fragment.app.Fragment;


 import com.example.movieapp.R;

 import java.util.ArrayList;

 public class MovieDescFragment extends Fragment {

     private TextView tv_title, tv_desc;
     private ImageView img_movie;
     private ArrayList<MovieTask> movieTask =new ArrayList<>();
     private MovieTask model;


     public MovieDescFragment() {
         // Required empty public constructor
     }


     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
         Bundle bundle=this.getArguments();
         if (bundle!=null){
             model=(MovieTask)bundle.getSerializable("pos");
             movieTask.add(model);
         }
         return inflater.inflate(R.layout.fragment_movie_desc, container, false);
     }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         tv_title =view.findViewById(R.id.tv_title);
         tv_desc =view.findViewById(R.id.tv_desc);
         img_movie =view.findViewById(R.id.img_movie);
         if (model!=null){
             tv_title.setText(model.getTv_title());
             tv_desc.setText(model.getTv_desc());
             img_movie.setImageResource(model.getImg_movie());

         }
     }




 }