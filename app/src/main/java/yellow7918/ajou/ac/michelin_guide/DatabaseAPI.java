package yellow7918.ajou.ac.michelin_guide;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DatabaseAPI {

    @GET("restaurant")
    Call<List<Restaurant>> getRestaurant();

    @GET("restaurant")
    Observable<List<Restaurant>> getRestaurantObserve();
}
