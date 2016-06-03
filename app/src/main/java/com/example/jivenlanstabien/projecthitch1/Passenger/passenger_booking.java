package com.example.jivenlanstabien.projecthitch1.Passenger;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.jivenlanstabien.projecthitch1.Login.Login;
import com.example.jivenlanstabien.projecthitch1.R;

import java.util.Calendar;

public class passenger_booking extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String json_string;
    private Calendar cal;
    private int day, month, year, hour, minute;
    private EditText DateDepart, DateReturn, TimeDepart, TimeReturn;
    private RadioButton rb1, rb2;
    private String DateCondition, TimeCondition;
    String[] Places = {"Taguig", "Makati", "Quezon", "Manila", "Cavite"};
    AutoCompleteTextView TxtViewFrom, TxtViewTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_booking_navigation_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Auto Complete Text View
        TxtViewFrom = (AutoCompleteTextView) findViewById(R.id.SpnrFrom);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Places);
        TxtViewFrom.setThreshold(2);
        TxtViewFrom.setAdapter(adapter);

        TxtViewTo = (AutoCompleteTextView) findViewById(R.id.SpnrTo);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Places);
        TxtViewTo.setThreshold(2);
        TxtViewTo.setAdapter(adapter);

        //Date & Time Picker
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        DateDepart = (EditText) findViewById(R.id.EditText);
        DateReturn = (EditText) findViewById(R.id.EditText1);
        TimeDepart = (EditText) findViewById(R.id.EditText2);
        TimeReturn = (EditText) findViewById(R.id.EditText3);

        DateReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateCondition = "DateReturn";
                showDialog(0);
            }
        });

        DateDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateCondition = "DateDepart";
                showDialog(0);
            }
        });

        TimeDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeCondition = "TimeDepart";
                showDialog(1);
            }
        });

        TimeReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeCondition = "TimeReturn";
                showDialog(1);
            }
        });
        //END OF DATE PICKER

        rb1 = (RadioButton) findViewById(R.id.RadioReturn);
        rb2 = (RadioButton) findViewById(R.id.RadioOneWay);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb2.setChecked(false);
                TimeReturn.setVisibility(View.VISIBLE);
                DateReturn.setVisibility(View.VISIBLE);
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1.setChecked(false);
                TimeReturn.setVisibility(View.INVISIBLE);
                DateReturn.setVisibility(View.INVISIBLE);
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    //Set Date Picked to Text View
    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                return new TimePickerDialog(this, timePickerListener, hour, minute, false);
            case 0:
                return new DatePickerDialog(this, datePickerListener, year, month, day);
        }
        return null;

    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            if (DateCondition == "DateReturn") {
                DateReturn.setText(selectedDay + " / " + (selectedMonth + 1) + " / " + selectedYear);
            } else if (DateCondition == "DateDepart") {
                DateDepart.setText(selectedDay + " / " + (selectedMonth + 1) + " / " + selectedYear);
            }
        }
    };


    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
            // TODO Auto-generated method stub
            hour = hourOfDay;
            minute = minutes;

            if (TimeCondition == "TimeReturn") {
                TimeReturn.setText(hour + ":" + minute);
            } else if (TimeCondition == "TimeDepart") {
                TimeDepart.setText(hour + ":" + minute);
            }
        }
    };

    public void ShowSched(View view)
    {
        new BackgroundTask(this).execute();
        Intent intent = new Intent(passenger_booking.this,PassengerViewTripList.class);
        startActivity(intent);
    }

    class BackgroundTask extends AsyncTask<Void,Void,String> {

        private Context context;

        public BackgroundTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... params) {
            return null;
        }
        //Set Date Picked to Text View
        @Deprecated
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case 1:
                    return new TimePickerDialog(passenger_booking.this, timePickerListener, hour, minute, false);
                case 0:
                    return new DatePickerDialog(passenger_booking.this, datePickerListener, year, month, day);
            }
            return null;

        }

        private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                if (DateCondition == "DateReturn") {
                    DateReturn.setText(selectedDay + " / " + (selectedMonth + 1) + " / " + selectedYear);
                } else if (DateCondition == "DateDepart") {
                    DateDepart.setText(selectedDay + " / " + (selectedMonth + 1) + " / " + selectedYear);
                }
            }
        };


        private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
                // TODO Auto-generated method stub
                hour = hourOfDay;
                minute = minutes;

                if (TimeCondition == "TimeReturn") {
                    TimeReturn.setText(hour + ":" + minute);
                } else if (TimeCondition == "TimeDepart") {
                    TimeDepart.setText(hour + ":" + minute);
                }
            }
        };
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
            getMenuInflater().inflate(R.menu.passenger_navigation_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();


        if (id == R.id.nav_profile) {

            Intent intent = new Intent(passenger_booking.this, passenger_home_screen.class);
            startActivity(intent);

        } else if (id == R.id.nav_booking) {

            Intent intent = new Intent(passenger_booking.this, passenger_booking.class);
            startActivity(intent);


        }  else if (id == R.id.nav_logout) {
           final AlertDialog.Builder alertDialog = new AlertDialog.Builder(passenger_booking.this);

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
                    Toast.makeText(passenger_booking.this, "Successfully Logged Out!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(passenger_booking.this, Login.class);
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