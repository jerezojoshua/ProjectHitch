package com.example.jivenlanstabien.projecthitch1;


import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jivenlanstabien.projecthitch1.Login.Login;

public class driver_profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_profile_navigation_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Spinner passenger_preference;
        final  EditText luggage_provision;
        final Button seat1, seat2, seat3, seat4, seat5, seat6, seat7, save, seat0;
        final TextView seat;
        final PopupWindow popupWindow;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String passenger_preference_value = sharedPreferences.getString("saved_passenger_preference", "No Value");
        String luggage_provision_value = sharedPreferences.getString("saved_luggage_provision", "");
        String seat1_value = sharedPreferences.getString("saved_seat1", "No Value");
        String seat2_value = sharedPreferences.getString("saved_seat2", "No Value");
        String seat3_value = sharedPreferences.getString("saved_seat3", "No Value");
        String seat4_value = sharedPreferences.getString("saved_seat4", "No Value");
        String seat5_value = sharedPreferences.getString("saved_seat5", "No Value");
        String seat6_value = sharedPreferences.getString("saved_seat6", "No Value");
        String seat7_value = sharedPreferences.getString("saved_seat7", "No Value");

        passenger_preference = (Spinner) findViewById(R.id.passenger_preference);
        luggage_provision = (EditText) findViewById(R.id.luggage_provision);
        seat1 = (Button) findViewById(R.id.Seat1);
        seat2 = (Button) findViewById(R.id.Seat2);
        seat3 = (Button) findViewById(R.id.Seat3);
        seat4 = (Button) findViewById(R.id.Seat4);
        seat5 = (Button) findViewById(R.id.Seat5);
        seat6 = (Button) findViewById(R.id.Seat6);
        seat7 = (Button) findViewById(R.id.Seat7);
        save = (Button)  findViewById(R.id.save);
        seat = (TextView)findViewById(R.id.seat);
        seat0 = (Button) findViewById(R.id.Seat0);

        if (luggage_provision != null) {
            luggage_provision.setText(luggage_provision_value);
        }

        if (seat1_value == "Not Available") {
            seat1.setBackgroundColor(Color.RED);
            seat1.setText("Not Available");
        } else {
            seat1.setBackgroundColor(Color.parseColor("#00FF00"));
            seat1.setText("Available");
        }

        if (seat2_value == "Not Available") {
            seat2.setBackgroundColor(Color.RED);
            seat2.setText("Not Available");
        } else {
            seat2.setBackgroundColor(Color.parseColor("#00FF00"));
            seat2.setText("Available");
        }

        if (seat3_value == "Not Available") {
            seat3.setBackgroundColor(Color.RED);
            seat3.setText("Not Available");
        } else {
            seat3.setBackgroundColor(Color.parseColor("#00FF00"));
            seat3.setText("Available");
        }

        if (seat4_value == "Not Available") {
            seat4.setBackgroundColor(Color.RED);
            seat4.setText("Not Available");
        } else {
            seat4.setBackgroundColor(Color.parseColor("#00FF00"));
            seat4.setText("Available");
        }

        if (seat5_value == "Not Available") {
            seat5.setBackgroundColor(Color.RED);
            seat5.setText("Not Available");
        } else {
            seat5.setBackgroundColor(Color.parseColor("#00FF00"));
            seat5.setText("Available");
        }

        if (seat6_value == "Not Available") {
            seat6.setBackgroundColor(Color.RED);
            seat6.setText("Not Available");
        } else {
            seat6.setBackgroundColor(Color.parseColor("#00FF00"));
            seat6.setText("Available");
        }

        if (seat7_value == "Not Available") {
            seat7.setBackgroundColor(Color.RED);
            seat7.setText("Not Available");
        } else {
            seat7.setBackgroundColor(Color.parseColor("#00FF00"));
            seat7.setText("Available");
        }


        seat0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Driver seat cant avail his/her seat for the passenger", Toast.LENGTH_SHORT).show();
            }
        });


        seat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (seat1.getText() == "Not Available") {
                    seat1.setBackgroundColor(Color.parseColor("#00FF00"));
                    seat1.setText("Available");
                    Toast.makeText(getBaseContext(), "Front Right Seat is set to Available", Toast.LENGTH_SHORT).show();

                } else {
                    seat1.setBackgroundColor(Color.RED);
                    seat1.setText("Not Available");
                    Toast.makeText(getBaseContext(), "Front Right Seat is set to not Available", Toast.LENGTH_SHORT).show();
                }

            }
        });


        seat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (seat2.getText() == "Not Available") {
                    seat2.setBackgroundColor(Color.parseColor("#00FF00"));
                    seat2.setText("Available");
                    Toast.makeText(getBaseContext(), "Middle Left Seat is set to Available", Toast.LENGTH_SHORT).show();
                } else {
                    seat2.setBackgroundColor(Color.RED);
                    seat2.setText("Not Available");
                    Toast.makeText(getBaseContext(), "Middle Left Seat is set to not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        seat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (seat3.getText() == "Not Available") {
                    seat3.setBackgroundColor(Color.parseColor("#00FF00"));
                    seat3.setText("Available");
                    Toast.makeText(getBaseContext(), "Middle Center Seat is set to Available", Toast.LENGTH_SHORT).show();
                } else {
                    seat3.setBackgroundColor(Color.RED);
                    seat3.setText("Not Available");
                    Toast.makeText(getBaseContext(), "Middle Center Seat is set to not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        seat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seat4.getText() == "Not Available") {
                    seat4.setBackgroundColor(Color.parseColor("#00FF00"));
                    seat4.setText("Available");
                    Toast.makeText(getBaseContext(), "Middle Right Seat is set to Available", Toast.LENGTH_SHORT).show();
                } else {
                    seat4.setBackgroundColor(Color.RED);
                    seat4.setText("Not Available");
                    Toast.makeText(getBaseContext(), "Middle Right Seat is set to not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        seat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (seat5.getText() == "Not Available") {
                    seat5.setBackgroundColor(Color.parseColor("#00FF00"));
                    seat5.setText("Available");
                    Toast.makeText(getBaseContext(), "Back Left Seat is set to Available", Toast.LENGTH_SHORT).show();
                } else {
                    seat5.setBackgroundColor(Color.RED);
                    seat5.setText("Not Available");
                    Toast.makeText(getBaseContext(), "Back Left Seat is set to not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        seat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (seat6.getText() == "Not Available") {
                    seat6.setBackgroundColor(Color.parseColor("#00FF00"));
                    seat6.setText("Available");
                    Toast.makeText(getBaseContext(), "Back Center Seat is set to Available", Toast.LENGTH_SHORT).show();
                } else {
                    seat6.setBackgroundColor(Color.RED);
                    seat6.setText("Not Available");
                    Toast.makeText(getBaseContext(), "Back Center Seat is set to not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        seat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (seat7.getText() == "Not Available") {
                    seat7.setBackgroundColor(Color.parseColor("#00FF00"));
                    seat7.setText("Available");
                    Toast.makeText(getBaseContext(), "Back Right Seat is set to Available", Toast.LENGTH_SHORT).show();
                } else {
                    seat7.setBackgroundColor(Color.RED);
                    seat7.setText("Not Available");
                    Toast.makeText(getBaseContext(), "Back Right Seat is set to not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passenger_preference_value = passenger_preference.getSelectedItem().toString();
                String luggage_provision_value = luggage_provision.getText().toString();
                String seat1_value = seat1.getText().toString();
                String seat2_value = seat2.getText().toString();
                String seat3_value = seat3.getText().toString();
                String seat4_value = seat4.getText().toString();
                String seat5_value = seat5.getText().toString();
                String seat6_value = seat6.getText().toString();
                String seat7_value = seat7.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("saved_passenger_preference", passenger_preference_value);
                editor.putString("saved_luggage_provision", luggage_provision_value);
                editor.putString("saved_seat1", seat1_value);
                editor.putString("saved_seat2", seat2_value);
                editor.putString("saved_seat3", seat3_value);
                editor.putString("saved_seat4", seat4_value);
                editor.putString("saved_seat5", seat5_value);
                editor.putString("saved_seat6", seat6_value);
                editor.putString("saved_seat7", seat7_value);
                editor.commit();

                Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.driver_navigation_menu, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_personal_info) {

            Intent intent = new Intent(this,driver_home_screen.class);
            startActivity(intent);

        } else if (id == R.id.nav_driver_home_screen) {
            Intent intent = new Intent(this,driver_profile.class);
            startActivity(intent);
        } else if (id == R.id.nav_requirements) {

            Intent intent = new Intent(this,driver_requirements.class);
            startActivity(intent);

        } else if (id == R.id.nav_driver_schedule) {

            Intent intent = new Intent(this, DriverScheduleList.class);
            startActivity(intent);

        } else if (id == R.id.nav_trip) {

            Intent intent = new Intent(this, DriverTripList.class);
            startActivity(intent);

        } else if (id == R.id.nav_vehicle) {

            Intent intent = new Intent(this, vehicle_records.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(driver_profile.this);

            // Setting Dialog Title
            alertDialog.setTitle("Logout...");

            // Setting Dialog Message
            alertDialog.setMessage("Are you sure you want to logout?");


            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {

                    // Showing Alert Message

                    SharedPreferences settings = getSharedPreferences("login", MODE_PRIVATE);
                    settings.edit().clear().commit();
                    Toast.makeText(driver_profile.this, "Successfully Logged Out!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(driver_profile.this, Login.class);
                    startActivity(intent);
                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}





