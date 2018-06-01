package yellow7918.ajou.ac.michelin_guide;

import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RestaurantFragment fragment;

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

        fragment = new RestaurantFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();

        toggle.setHomeAsUpIndicator(R.drawable.ic_menu);
        toggle.syncState();

        CheckBox grade1 = findViewById(R.id.grade_1);
        CheckBox grade2 = findViewById(R.id.grade_2);
        CheckBox grade3 = findViewById(R.id.grade_3);
        CheckBox grade4 = findViewById(R.id.grade_4);
        CheckBox grade5 = findViewById(R.id.grade_5);
        CheckBox[] grades = {grade1, grade2, grade3, grade4, grade5};

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

        EditText editText = findViewById(R.id.text_search);

        ImageView searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(view -> {
            String searchData = editText.getText().toString();
            if (searchData.length() <= 0) {
                Snackbar.make(view, "검색어를 입력해 주세요", Snackbar.LENGTH_SHORT).show();
                return;
            }

            String loc = "";
            String cat = "";
            String name = "";
            String type = ((String) spinner.getSelectedItem());

            if (type.contains("요"))
                cat = searchData;
            else if (type.contains("식"))
                name = searchData;
            else if (type.contains("지"))
                loc = searchData;

            fragment.updateListBySimpleQuery(loc, cat, name);
            Toast.makeText(this, type + " / " + editText.getText().toString(), Toast.LENGTH_SHORT).show();
        });

        confirm.setOnClickListener(view -> {
            String loc = location.getText().toString();
            String cat = category.getText().toString();
            String min = money.getLeftPinValue();
            String max = money.getRightPinValue()+"0000";
            String grade = "";
            for (int i = 0; i < grades.length; i++) {
                if (grades[i].isChecked()) {
                    grade = String.valueOf(i + 1);
                    break;
                }

            }

            fragment.updateListByComplexQuery(loc, cat, min, max, grade);
//            Toast.makeText(this, loc + "/" + cat + "/" + min + "/" + max, Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawer(GravityCompat.START);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.reset) {
            fragment.updateListAll();
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
