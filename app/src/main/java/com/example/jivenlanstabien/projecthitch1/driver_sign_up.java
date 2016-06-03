package com.example.jivenlanstabien.projecthitch1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jivenlanstabien.projecthitch1.Login.SendMail;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.io.IOException;

public class driver_sign_up extends AppCompatActivity implements View.OnClickListener{

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4;
    //--------Personal Info Declarations---------
    TextView txtDriverID,txtFullname;
    String drID;
    EditText TxtAddress1,TxtAddress2,TxtCity,TxtCountry,TxtMainPhone,TxtAlterPhone,TxtEmerContact,TxtEmerPhone;
    Spinner maritalstatus;
    Spinner bodytype, make, year, fuel_type;
    EditText model, vehicle_color, platenumber, engine, chassis;
    String sbodytype, smake, smodel, syear, svehicle_color, sfuel_type, splatenumber, sengine, schassis, sTxtAddress1, sTxtAddress2, sTxtCity, sTxtCountry, sTxtMainPhone, sTxtAlterPhone, sTxtEmerContact, sTxtEmerPhone, stbLicenseNo, stbLicenseExpiry, salternateDriverEmail, salternateDriverID, smaritalstatus, getemail,getemail2;

    //--------Personal Info Declarations---------
    private int PICK_IMAGE_REQUEST = 1;
    private Uri filePath;
    private Bitmap bitmap;
    //--------Alternate Driver Declaration------
    EditText alternateDriverEmail, alternateDriverID;
    //--------Alternate Driver Declaration------

    String btnClicked = "";
    //--------Requirements Declarations----------
    Context context=this;
    ImageView Photo,ImgNBI,ImgPNP,ImgInsurance,ImgOR,ImgCR;
    Button btnImgNBI,btnImgPNP,btnImgInsurance,btnImgOR,btnImgCR;
    EditText tbLicenseNo,tbLicenseExpiry;
    String imgDecodableString;
    private static final int RESULT_LOAD_IMAGE = 1;
    //--------Requirements Declarations----------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_up);

        TextView email = (TextView)findViewById(R.id.email);

        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String email_login = sharedPreferences.getString("email_login", "");
        getemail2 = email_login;
        //=========================PERSONAL INFORMATION=================================
        sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        txtFullname = (TextView) findViewById(R.id.txtName);
        txtDriverID = (TextView) findViewById(R.id.txtDriverID);
        txtDriverID.setText(sharedPreferences.getString("ID", ""));
        //=========================PERSONAL INFORMATION=================================
        //=========================REQUIREMENTS INFORMATION=================================
        tbLicenseNo = (EditText) findViewById(R.id.tbLicenseNo);
        tbLicenseExpiry = (EditText) findViewById(R.id.tbLicenseExpiry);
       /* SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        txtDriverID = (TextView) findViewById(R.id.txtDriverID);
        txtDriverID.setText(sharedPreferences.getString("ID",""));*/
        Photo = (ImageView) findViewById(R.id.Photo);
        ImgNBI = (ImageView) findViewById(R.id.imgNBI);
        ImgPNP = (ImageView) findViewById(R.id.imgPNP);
        ImgInsurance = (ImageView) findViewById(R.id.imgInsurance);
        ImgOR = (ImageView) findViewById(R.id.imgOR);
        ImgCR = (ImageView) findViewById(R.id.imgCR);

        Photo.setOnClickListener(this);
        ImgNBI.setOnClickListener(this);
        ImgPNP.setOnClickListener(this);
        ImgInsurance.setOnClickListener(this);
        ImgOR.setOnClickListener(this);
        ImgCR.setOnClickListener(this);
        //=========================REQUIREMENTS INFORMATION=================================
        //=========================Alternate Driver=========================================
        alternateDriverEmail = (EditText)findViewById(R.id.txtAlterDriver);
        alternateDriverID = (EditText)findViewById(R.id.txtAlterDriverID);

        // ==========================Vehicle=======================================
        bodytype = (Spinner) findViewById(R.id.body_type);
        make = (Spinner) findViewById(R.id.make);
        model = (EditText) findViewById(R.id.model);
        year = (Spinner) findViewById(R.id.year);
        vehicle_color = (EditText) findViewById(R.id.vehicle_color);
        fuel_type = (Spinner) findViewById(R.id.fuel_type);
        platenumber = (EditText) findViewById(R.id.plate_number);
        engine = (EditText) findViewById(R.id.engine);
        chassis = (EditText) findViewById(R.id.chassis);

        // ==========================Vehicle=======================================
        final TextView btnOpenPopup = (TextView) findViewById(R.id.clickhere);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.request_driverid_popup, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,650, 950,true);

                final EditText email = (EditText) popupView.findViewById(R.id.email_address);
                Button btnDismiss = (Button)popupView.findViewById(R.id.cancelbutton);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                    }});
                Button request = (Button)popupView.findViewById(R.id.send_request);
                request.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        String getemail = email.getText().toString().trim();
                        if(getemail.equals("")) {
                            Toast.makeText(getBaseContext(),"Please put the email address",Toast.LENGTH_LONG).show();
                        }
                        else {
                            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                            String getemail2 = sharedPreferences.getString("email_login", "");
                            EditText editTextEmail = (EditText) findViewById(R.id.email_address);
                            Toast.makeText(getBaseContext(), "The driver ID of your alternate driver will be send to your email account if he/she accepted your request", Toast.LENGTH_LONG).show();
                            popupWindow.dismiss();

                            String subject = "Project Hitch";
                            String message = getemail2+" wants to add you as his/her alternate driver. Please send your driver ID to him/her if you want to be his/her alternate driver Thanks";
                            //Creating SendMail object
                            SendMail sm = new SendMail(driver_sign_up.this, getemail, subject, message);
                            //Executing sendmail to send email
                            sm.execute();
                        }
                    }});
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
            }});
    }

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }
    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }
    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }
    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    @Override
    public void onClick(View v) {

        if (v == Photo) {
            btnClicked = "photo";
            showFileChooser();
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(btnClicked=="photo"){
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                filePath = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                    Photo.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addAccount(View view)
    {
        //for requirements information
        stbLicenseNo = tbLicenseNo.getText().toString();
        stbLicenseExpiry = tbLicenseExpiry.getText().toString();

        //for alternate driver
        salternateDriverEmail = alternateDriverEmail.getText().toString();
        salternateDriverID = alternateDriverID.getText().toString();

        //for vehicle
        sbodytype = bodytype.getSelectedItem().toString();
        smake = make.getSelectedItem().toString();
        smodel = model.getText().toString();
        syear = year.getSelectedItem().toString();
        svehicle_color = vehicle_color.getText().toString();
        sfuel_type = fuel_type.getSelectedItem().toString();
        splatenumber = platenumber.getText().toString();
        sengine = engine.getText().toString();
        schassis = chassis.getText().toString();

        if (stbLicenseNo.equals("") || stbLicenseNo == null || stbLicenseExpiry.equals("") || stbLicenseExpiry.length() == 0 ||
                svehicle_color.equals("") || svehicle_color == null || sfuel_type.equals("") || sfuel_type.length() == 0 ||
                splatenumber.equals("") || splatenumber == null || sengine.equals("") || sengine.length() == 0 || schassis.equals("") || schassis.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please complete your details.", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            String method = "register";
            driverBackgroundTask1 backgroundTask = new driverBackgroundTask1(this);
            backgroundTask.execute(method, sbodytype, smake, smodel, syear, svehicle_color, sfuel_type, splatenumber, sengine, schassis, salternateDriverEmail, salternateDriverID, stbLicenseNo, stbLicenseExpiry, getemail2);

            Intent intent = new Intent(driver_sign_up.this, DriverTripList.class);
            startActivity(intent);
        }
    }
}
