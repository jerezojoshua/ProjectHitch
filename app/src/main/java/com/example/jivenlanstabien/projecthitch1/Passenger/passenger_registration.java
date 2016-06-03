package com.example.jivenlanstabien.projecthitch1.Passenger;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jivenlanstabien.projecthitch1.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

public class passenger_registration extends Activity {

    final String TAG = getClass().getName();
    private Button scanButton;
    private TextView resultTextView;
    private int MY_SCAN_REQUEST_CODE = 100;
    Spinner spinner1,passenger_type,passenger_preference_spinner,prefered_seat,tracking,paymenttype;
    EditText school,idnumber,Bank,accountname,Card,Expiry,Code;
    String getemail2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_registration);

        passenger_type = (Spinner)findViewById(R.id.passenger_type);
        passenger_preference_spinner = (Spinner)findViewById(R.id.passenger_preference_spinner);
        prefered_seat = (Spinner)findViewById(R.id.prefered_seat);
        school = (EditText)findViewById(R.id.school);
        tracking = (Spinner) findViewById(R.id.tracking);
        idnumber = (EditText)findViewById(R.id.idnumber);

        paymenttype = (Spinner)findViewById(R.id.spinner1);
        Bank = (EditText) findViewById(R.id.Bank);
        accountname = (EditText) findViewById(R.id.accountname);
        Card = (EditText) findViewById(R.id.Card);
        Expiry = (EditText) findViewById(R.id.Expiry);
        Code = (EditText) findViewById(R.id.Code);




        spinner1 = (Spinner) findViewById(R.id.spnType);


        TextView email = (TextView)findViewById(R.id.pass_email);

        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        String email_login = sharedPreferences.getString("email_login", "");
        getemail2 = email_login;
        //scanButton = (Button) findViewById(R.id.scan);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (CardIOActivity.canReadCardWithCamera()) {
            scanButton.setText("Scan a credit card with card.io");
        } else {
            scanButton.setText("Enter credit card information");
        }
    }

    /*public void onScanPress(View v) {
        Intent scanIntent = new Intent(this, CardIOActivity.class);

        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true);
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false);
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false);
        scanIntent.putExtra(CardIOActivity.EXTRA_RESTRICT_POSTAL_CODE_TO_NUMERIC_ONLY, false);
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME, true);

        scanIntent.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, false);
        scanIntent.putExtra(CardIOActivity.EXTRA_KEEP_APPLICATION_THEME, false);
        startActivityForResult(scanIntent, MY_SCAN_REQUEST_CODE);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String resultStr;
        if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
            CreditCard scanResult = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
            resultStr = "Card Number: " + scanResult.getRedactedCardNumber() + "\n";

            if (scanResult.isExpiryValid()) {
                resultStr += "Expiration Date: " + scanResult.expiryMonth + "/" + scanResult.expiryYear + "\n";
            }
            if (scanResult.cvv != null) {
                resultStr += "CVV has " + scanResult.cvv.length() + " digits.\n";
            }
            if (scanResult.postalCode != null) {
                resultStr += "Postal Code: " + scanResult.postalCode + "\n";
            }
            if (scanResult.cardholderName != null) {
                resultStr += "Cardholder Name : " + scanResult.cardholderName + "\n";
            }
        } else {
            resultStr = "Scan was canceled.";

        }
        resultTextView.setText(resultStr);
    }


    public void submit(View view)
    {
        String getpassenger_type = passenger_type.getSelectedItem().toString().trim();
        String getpassenger_preference_spinner = passenger_preference_spinner.getSelectedItem().toString().trim();
        String getprefered_seat = prefered_seat.getSelectedItem().toString().trim();
        String getschool = school.getText().toString().trim();
        String gettracking = tracking.getSelectedItem().toString().trim();
        String getidnumber = idnumber.getText().toString().trim();

        String getpaymenttype = paymenttype.getSelectedItem().toString().trim();
        String getBank = Bank.getText().toString().trim();
        String getaccountname = accountname.getText().toString().trim();
        String getCard = Card.getText().toString().trim();
        String getExpiry = Expiry.getText().toString().trim();
        String getCode = Code.getText().toString().trim();


        if (getpaymenttype.equals("") || getpaymenttype == null || getBank.equals("") || getBank.length() == 0 ||
                getaccountname.equals("") || getaccountname == null || getCard.equals("") || getCard.length() == 0 ||
                getExpiry.equals("") || getExpiry == null || getCode.equals("") || getCode.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please complete your Payment details.", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            String method = "register";
            passengerBackgroundTask backgroundTask = new passengerBackgroundTask(this);
            backgroundTask.execute(method, getpassenger_type, getpassenger_preference_spinner, getprefered_seat, getschool, gettracking, getidnumber, getpaymenttype, getBank, getaccountname, getCard, getExpiry, getCode, getemail2);

            Intent intent = new Intent(passenger_registration.this, passenger_booking.class);
            startActivity(intent);
        }
    }
    public void expandableButton1(View view) {
        ExpandableRelativeLayout expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        ExpandableRelativeLayout expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        ExpandableRelativeLayout expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

}
