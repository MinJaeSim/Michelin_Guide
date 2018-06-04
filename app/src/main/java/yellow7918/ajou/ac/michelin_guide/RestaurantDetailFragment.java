package yellow7918.ajou.ac.michelin_guide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Restaurant restaurant = (Restaurant) getArguments().getSerializable("RESTAURANT");
        System.out.println(restaurant.toString());

        TextView title = view.findViewById(R.id.text_detail_title);
        title.setText(restaurant.getrName());

        TextView category = view.findViewById(R.id.text_detail_category);
        category.setText(restaurant.getCategory());

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        ImageViewPageAdapter adapter = new ImageViewPageAdapter(getLayoutInflater(), new String[]{restaurant.getImgRsc1(), restaurant.getImgRsc2(), restaurant.getImgRsc3()});
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_dots);
        tabLayout.setupWithViewPager(viewPager);

        TextView gradeDesc = view.findViewById(R.id.text_detail_grade);
        gradeDesc.setText(restaurant.getGrade() + " test");

        TextView avgPrice = view.findViewById(R.id.text_detail_avg_price);
        avgPrice.setText(restaurant.getPrice() + " test");

        TextView homepage = view.findViewById(R.id.text_detail_homepage);
        homepage.setText(restaurant.getHomepage());

        TextView phoneNum = view.findViewById(R.id.text_detail_phone_number);
        phoneNum.setText(restaurant.getPhoneNumber());

        return view;
    }

    public static RestaurantDetailFragment newInstance(Restaurant restaurant) {
        RestaurantDetailFragment fragment = new RestaurantDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("RESTAURANT", restaurant);

        fragment.setArguments(bundle);
        return fragment;
    }
}
