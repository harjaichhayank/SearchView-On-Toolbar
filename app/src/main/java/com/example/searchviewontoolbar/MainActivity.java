package com.example.searchviewontoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Movie> arrayList = new ArrayList<>();

    int[] moviePosters = {R.drawable.movie_1,R.drawable.movie_2,R.drawable.movie_3,
            R.drawable.movie_4,R.drawable.movie_5,R.drawable.movie_6,
            R.drawable.movie_7,R.drawable.movie_8,R.drawable.movie_9,R.drawable.movie_10,
            R.drawable.movie_11,R.drawable.movie_12,R.drawable.movie_13,R.drawable.movie_14};

    String[] MovieNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.ToolBar);
        setSupportActionBar(toolbar);

        MovieNames = getResources().getStringArray(R.array.Top_10_movies);

        recyclerView = findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        int count = 0;
        for (String name : MovieNames){
            arrayList.add(new Movie(name,moviePosters[count]));
            count++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Movie> newList = new ArrayList<>();
        for(Movie movie: arrayList){
            String name = movie.getNames().toLowerCase();
            if (name.contains(newText)){
                newList.add(movie);
            }
        }
        adapter.setFilter(newList);
        return true;
    }
}
