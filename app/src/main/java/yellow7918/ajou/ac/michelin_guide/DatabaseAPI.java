package yellow7918.ajou.ac.michelin_guide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DatabaseAPI {

    @GET("restaurant")
    Call<List<Restaurant>> getRestaurant();

    @GET("restaurant/simple")
    Call<List<Restaurant>> getRestaurantBySimpleQuery(@Query("loc") String loc, @Query("cat") String cat, @Query("name") String name);
}
