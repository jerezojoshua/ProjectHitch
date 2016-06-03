package com.example.jivenlanstabien.projecthitch1.Passenger;

/**
 * Created by JivenlansTabien on 5/19/2016.
 */
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jivenlanstabien.projecthitch1.driver_requirements;
import com.example.jivenlanstabien.projecthitch1.DriverScheduleList;
import com.example.jivenlanstabien.projecthitch1.Login.Login;
import com.example.jivenlanstabien.projecthitch1.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class home_screen_registration extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button DriverButton, PassengerButton;
    TextView Email, driver_id, passenger_id;
    Spinner maritalstatus;
    EditText address1, address2, city, country, contactnumber, alternatecontactnumber, emergencycontactperson,emergencycontactnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_registration_navigation_menu);
        new BackgroundTask().execute();
        DriverButton = (Button) findViewById(R.id.DriverButton);
        PassengerButton = (Button) findViewById(R.id.PassengerButton);

        maritalstatus = (Spinner)findViewById(R.id.maritalstatus);
        address1 = (EditText)findViewById(R.id.address1);
        address2 = (EditText) findViewById(R.id.address2);
        city = (EditText) findViewById(R.id.city);
        country = (EditText) findViewById(R.id.country);
        contactnumber = (EditText) findViewById(R.id.contactnumber);
        alternatecontactnumber = (EditText) findViewById(R.id.alternatecontactnumber);
        emergencycontactperson = (EditText) findViewById(R.id.emergencycontactperson);
        emergencycontactnumber = (EditText) findViewById(R.id.emergencycontactnumber);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    class BackgroundTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String reg_url = "http://angkas.net23.net/addingyes.php";

            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
            String email_login = sharedPreferences.getString("email_login", "");

            String username = email_login;
            // end of declaration of params

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("username2", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                OS.close();
                bufferedWriter.close();

                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }
    public void submit(View view)
    {

        String getmaritalstatus = maritalstatus.getSelectedItem().toString().trim();
        String getaddress1 = address1.getText().toString().trim();
        String getaddress2 = address2.getText().toString().trim();
        String getcity = city.getText().toString().trim();
        String getcountry = country.getText().toString().trim();
        String getcontactnumber = contactnumber.getText().toString().trim();
        String getalternatecontactnumber = alternatecontactnumber.getText().toString().trim();
        String getemergencycontactperson = emergencycontactperson.getText().toString().trim();
        String getemergencycontactnumber = emergencycontactnumber.getText().toString().trim();

        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String getemail = sharedPreferences.getString("email_login", "");
        String method = "register";
        updateinfo_BackgroundTask backgroundTask = new updateinfo_BackgroundTask(this);
        backgroundTask.execute(method,getemail,getmaritalstatus,getaddress1,getaddress2,getcity,getcountry,getcontactnumber,getalternatecontactnumber,getemergencycontactperson,getemergencycontactnumber);
    }
    public void driver(View view)
    {
        PassengerButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
        DriverButton.setBackgroundColor(Color.parseColor("#A2F7A5"));
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String getemail = sharedPreferences.getString("email_login", "");
        String method = "register";
        home_screen_BackgroundTask backgroundTask = new home_screen_BackgroundTask(this);
        backgroundTask.execute(method,getemail);

    }
    public void passenger(View view)
    {
        PassengerButton.setBackgroundColor(Color.parseColor("#A2F7A5"));
        DriverButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String getemail = sharedPreferences.getString("email_login", "");
        String method = "register";
        passenger_home_screen_BackgroundTask backgroundTask = new passenger_home_screen_BackgroundTask(this);
        backgroundTask.execute(method,getemail);

    }
    @Override
    public void onBackPressed()
    {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain); // super.onBackPressed(); // Comment this super call to avoid calling finish()
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

        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_settings) {


        } else if (id == R.id.nav_requirements) {

            Intent intent = new Intent(this,driver_requirements.class);
            startActivity(intent);

        } else if (id == R.id.nav_driver_schedule) {

            Intent intent = new Intent(this, DriverScheduleList.class);
            startActivity(intent);

        } else if (id == R.id.nav_home_screen_logout) {

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

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
                    Toast.makeText(home_screen_registration.this, "Successfully Logged Out!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(home_screen_registration.this, Login.class);
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
