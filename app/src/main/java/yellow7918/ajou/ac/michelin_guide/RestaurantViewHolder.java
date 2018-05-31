package yellow7918.ajou.ac.michelin_guide;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    private TextView titleText;
    private TextView descText;
    private ImageView imageView;

    public RestaurantViewHolder(View itemView) {
        super(itemView);

        titleText = itemView.findViewById(R.id.text_title);
        descText = itemView.findViewById(R.id.text_description);
        imageView = itemView.findViewById(R.id.image_project);
    }

    void setProjectView(Restaurant restaurant) {
        titleText.setText(restaurant.getrName());
//        descText.setText(restaurant.getDescription());

        // Image - Glide
        Glide.with(this.imageView)
                .load(restaurant.imageResourceAt(0))
                .into(imageView);
    }

}
