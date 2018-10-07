package com.yeeooh.jpmorgan;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import java.text.DecimalFormat;

/**
 * Created by YEEOOH on 11/21/2017.
 */

public class AppUrls
{
    public static final String BASE_URL = "http://192.168.1.116:3001/";
    //public static final String BASE_URL = "http://cheapcabz.com:3001/";
    //public static final String IMAGE_UPLOAD_BASE_URL = "http://cheapcabzpartner.com:3002/";
    public static final String IMAGE_UPLOAD_BASE_URL = "http://192.168.1.116:3002/";
    public static final String SERVICE_URL =BASE_URL+ "api/driver/";
    public static final String REGISTER = SERVICE_URL+"register";
    public static final String CITIES = SERVICE_URL+"get_cities";
    public static final String LOGIN = SERVICE_URL + "login";
    public static final String RESEND_OTP = SERVICE_URL + "send_otp";
    public static final String NEW_PASSWORD = SERVICE_URL + "resset_password";
    public static final String CANCELLATION_REASONS = SERVICE_URL + "get_cancellation_reasons";
    public static final String UPDATE_BASIC_PROFILE = SERVICE_URL + "update_profile";
    public static final String CHANGE_PASSWORD = SERVICE_URL + "change_password";
    public static final String RESET_PASSWORD = SERVICE_URL + "resset_password";
    public static final String OTP = SERVICE_URL + "";
    public static final String FCM_TOKEN = SERVICE_URL + "";



    public static String LOCATION_DIRECTION="https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&key=AIzaSyCxF-M_cxYeCl9Gb4itFhPvwKjgXqHxSRE";

    public static void showToast(Context ctx, String msg)
    {
     /*   Toast toast= Toast.makeText(ctx,
                msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();*/

        View layoutValue = LayoutInflater.from(ctx).inflate(R.layout.layout_customtoast, null);
        TextView text = (TextView) layoutValue.findViewById(R.id.custom_toast);

        text.setText(msg);
        //Creating the Toast object
        Toast toast = new Toast(ctx);
        toast.setDuration(Toast.LENGTH_SHORT);

        // gravity, xOffset, yOffset
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(layoutValue);//setting the view of custom toast layout
        toast.show();

    }

    public static String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9@.#$%^&*_&]+$";
    public static String NETWORK_MESSAGE = "Please check your network!";
    public static String SOCKET_SERVER_CONNECT_ERROR= "Unable to connect server!";
    public static int RIDE_FINISH_REQUEST= 200;
    public static int ACTIVITY_REQUEST_SELECTVEHICLE= 201;


    public static double calculateDistance(double fromLat, double fromLong, double toLat, double toLong) {

        // TODO Auto-generated method stub
        final int R = 6371;
        // Radius of the earth
        Double latDistance = Math.toRadians(toLat - fromLat);
        Double lonDistance = Math.toRadians(toLong - fromLong);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(fromLat)) * Math.cos(Math.toRadians(toLat)) *Math.sin(lonDistance / 2) *Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c*1.6;
        // convert to meters
        DecimalFormat newFormat = new DecimalFormat("#.###");
        String result = newFormat.format(Double.valueOf(distance));
        double finalresult = Double.parseDouble(result);
        //Log.d("Purushotham", "" + finalresult);
        return finalresult;
    }




        /*ccdriver123$
    ccdriver*/

}
