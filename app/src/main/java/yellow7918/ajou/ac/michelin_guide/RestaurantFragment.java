package yellow7918.ajou.ac.michelin_guide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class RestaurantFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        setHasOptionsMenu(true);

        recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        RestaurantListAdapter adapter = new RestaurantListAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        new Thread(() -> {
            try {
                List<Restaurant> list =DatabaseClient.getInstance().getRestaurant().execute().body();
                System.out.println(list.get(0).toString());
                adapter.setRestaurantList(list);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

//        DatabaseClient.getInstance().getRestaurantObserve()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(restaurants -> {
//                    System.out.println("TEST");
//                    System.out.println("TEST : " + restaurants);
//                    adapter.setRestaurantList(restaurants);
//                    adapter.notifyDataSetChanged();
//                }, e -> {
//                    System.out.println(e);
//                });

        return view;
    }
}
