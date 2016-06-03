package com.example.jivenlanstabien.projecthitch1;

/**
 * Created by Belal on 10/24/2015.
 */
public class DriverConfig {

    public static final String URL_GET_ALL_TRIP = "http://angkas.net23.net/getAllTrp.php";
    public static final String URL_GET_TRIP = "http://angkas.net23.net/getTrp.php?tripid=";
    public static final String URL_GET_ALL_SCHED = "http://angkas.net23.net/getAllSched.php";
    public static final String URL_GET_SCHED = "http://angkas.net23.net/getSched.php?scheduleid=";
    public static final String URL_UPDATE_TRIP = "http://angkas.net23.net/updateTrp.php";
    public static final String URL_UPDATE_TRIPSTATUS_IN = "http://angkas.net23.net/updateStatusIn.php";
    public static final String URL_GET_LOGINID = "http://angkas.net23.net/getDriverID.php?loginid=";

    public static final String URL_UPDATE_SEAT1 = "http://angkas.net23.net/updateSeat1.php";
    public static final String URL_UPDATE_SEAT2 = "http://angkas.net23.net/updateSeat2.php";
    public static final String URL_UPDATE_SEAT3 = "http://angkas.net23.net/updateSeat3.php";
    public static final String URL_UPDATE_SEAT4 = "http://angkas.net23.net/updateSeat4.php";

    public static final String KEY_TRP_TRPID = "tripid";
    public static final String KEY_TRP_SCHEDID = "scheduleid";
    public static final String KEY_TRP_DRID = "driverid";
    public static final String KEY_TRP_VEHID = "vehicleid";
    public static final String KEY_TRP_PUP = "pickup";
    public static final String KEY_TRP_DOFF = "dropoff";
    public static final String KEY_TRP_DATE = "date";
    public static final String KEY_TRP_TIME = "time";
    public static final String KEY_TRP_STATUS = "status";
    public static final String KEY_SEAT1_STATUS = "seat1";
    public static final String KEY_SEAT2_STATUS = "seat2";
    public static final String KEY_SEAT3_STATUS = "seat3";
    public static final String KEY_SEAT4_STATUS = "seat4";

    public static final String TAG_TR_JSON_ARRAY ="result";
    public static final String TAG_TR_TRPID = "tripid";
    public static final String TAG_TR_SCHEDID = "scheduleid";
    public static final String TAG_TR_DRID = "driverid";
    public static final String TAG_TR_VEHID = "vehicleid";
    public static final String TAG_TR_PUP = "pickup";
    public static final String TAG_TR_DOFF= "dropoff";
    public static final String TAG_TR_DATE = "date";
    public static final String TAG_TR_TIME = "time";
    public static final String TAG_TR_SEAT1 = "seat1";
    public static final String TAG_TR_SEAT2 = "seat2";
    public static final String TAG_TR_SEAT3 = "seat3";
    public static final String TAG_TR_SEAT4 = "seat4";
    public static final String TAG_TR_STATUS = "status";

    public static final String TAG_USER_LOGINID = "loginid";
    public static final String TAG_USER_PASSWORD = "password";
    public static final String TAG_USER_DRIVERID = "driverid";
    public static final String TAG_USER_PASSID = "passengerid";

    public static final String TAG_SC_JSON_ARRAY ="result";
    public static final String TAG_SC_SCHEDID = "scheduleid";
    public static final String TAG_SC_DRID = "driverid";
    public static final String TAG_SC_VEHID = "vehicleid";
    public static final String TAG_SC_PUP = "pickup";
    public static final String TAG_SC_DOFF= "dropoff";
    public static final String TAG_SC_DATE = "date";
    public static final String TAG_SC_TIME = "time";

    public static final String TRP_ID = "trp_id";
    public static final String SCHED_ID = "sched_id";
}
