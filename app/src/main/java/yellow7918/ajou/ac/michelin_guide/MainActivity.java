package yellow7918.ajou.ac.michelin_guide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.appyvet.materialrangebar.RangeBar;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);

        RestaurantFragment fragment = new RestaurantFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();

        toggle.setHomeAsUpIndicator(R.drawable.ic_menu);
        toggle.syncState();

        Button confirm = findViewById(R.id.confirm);

        EditText location = findViewById(R.id.text_location);
        EditText category = findViewById(R.id.text_category);
        RangeBar money = findViewById(R.id.money);

        String[] spinnerList = {"식당", "지역", "요리"};
        SpinnerAdapter spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerList);
        Spinner spinner = findViewById(R.id.spinner_category);
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ImageView searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(view -> {
            fragment.updateListBySimpleQuery("서","","");
            Toast.makeText(this, (String) spinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
        });

        confirm.setOnClickListener(view -> {
            String loc = location.getText().toString();
            String cat = category.getText().toString();
            String min = money.getLeftPinValue();
            String max = money.getRightPinValue();

            Toast.makeText(this, loc + "/" + cat + "/" + min + "/" + max, Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawer(GravityCompat.START);
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
