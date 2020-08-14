package com.example.movieapp.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.App;
import com.example.movieapp.R;
import com.example.movieapp.data.GhibliService;
import com.example.movieapp.model.Film;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private OnItemClickListener onItemClickListener;

    public void setInBookClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    ArrayList<MovieTask> movieTasks;

    public MovieAdapter(ArrayList<MovieTask> movieTasks) {
        this.movieTasks = movieTasks;

        //My Neighbor Totoro
        GhibliService.GhibliCallback ghibliCallback = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.totoro,film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "filmNameTotoro");
            }
        };
        App.ghibliService.getFilmById("58611129-2dbc-4a81-a72f-77ddfc1b1b49", ghibliCallback);

        //Castle in the Sky
        GhibliService.GhibliCallback Sky = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.sky, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Sky");
            }
        };
        App.ghibliService.getFilmById("2baf70d1-42bb-4437-b551-e5fed5a87abe", Sky);

        //Grave of the Fireflies
        GhibliService.GhibliCallback Fireflies = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.fair, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Fireflies");
            }
        };
        App.ghibliService.getFilmById("12cfb892-aac0-4c5b-94af-521852e46d6a", Fireflies);


        //Kiki's Delivery Service
        GhibliService.GhibliCallback Service = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.service, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }



            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Service");
            }
        };
        App.ghibliService.getFilmById("ea660b10-85c4-4ae3-8a5f-41cea3648e3e", Service);


        //Only Yesterday
        GhibliService.GhibliCallback Yesterday = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.yesterday, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Yesterday");
            }
        };
        App.ghibliService.getFilmById("4e236f34-b981-41c3-8c65-f8c9000b94e7", Yesterday);


        //Porco Rosso
        GhibliService.GhibliCallback Rosso = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.rosso, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Rosso");
            }
        };
        App.ghibliService.getFilmById("ebbb6b7c-945c-41ee-a792-de0e43191bd8", Rosso);



        //Pom Poko
        GhibliService.GhibliCallback Poko = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.rosso, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Pom Poko");
            }
        };
        App.ghibliService.getFilmById("1b67aa9a-2e4a-45af-ac98-64d6ad15b16c", Poko);



               //Whisper of the Heart
        GhibliService.GhibliCallback Heart = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.rosso, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Heart");
            }
        };
        App.ghibliService.getFilmById("ff24da26-a969-4f0e-ba1e-a122ead6c6e3", Heart);



        //Princess Mononoke
        GhibliService.GhibliCallback Mononoke = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.rosso, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Mononoke");
            }
        };
        App.ghibliService.getFilmById("0440483e-ca0e-4120-8c50-4c8cd9b965d6", Mononoke);



        //"My Neighbors the Yamadas
        GhibliService.GhibliCallback Yamadas = new GhibliService.GhibliCallback() {
            @Override
            public void onSuccess(Film film) {
                MovieTask movieTask = new MovieTask(R.drawable.rosso, film.getTitle(), film.getDescription());
                movieTasks.add(movieTask);
            }

            @Override
            public void onFailure(Exception exception) {
                Log.d("TAG", "Yamadas");
            }
        };
        App.ghibliService.getFilmById("45204234-adfd-45cb-a505-a8e7a676b114", Yamadas);



    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.onBind(movieTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return movieTasks.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_movie;
        private TextView tv_title;
        private TextView tv_desc;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            initializationViews(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(getAdapterPosition());

                }
            });
        }

        private void initializationViews(View itemView) {
            img_movie = itemView.findViewById(R.id.img_movie);
            tv_title = itemView.findViewById(R.id.tv_title);
            /*tv_desc = itemView.findViewById(R.id.tv_desc);*/


        }

        public void onBind(MovieTask movieTask) {
            img_movie.setImageResource(movieTask.getImg_movie());
            tv_title.setText(movieTask.getTv_title());
            /*tv_desc.setText(movieTask.getTv_desc());*/

        }
    }
}

