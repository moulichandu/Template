package com.yeeooh.jpmorgan;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.yeeooh.jpmorgan.api.CustomStringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * Created by Employee on 8/9/2017.
 */

public class AppPreferences {
    static SharedPreferences chatPref;
    static String MYPREF="CheapCabzDriver";

    public static SharedPreferences getPref(Context ctx)
    {
        if(chatPref==null)
            chatPref=ctx.getSharedPreferences(MYPREF,0);
        return chatPref;
    }

    public static void clearPreferecence(Context ctx) {
        getPref(ctx).edit().clear().commit();
    }




                    /*FCM DEVICE TOKEN*/

    public static void addToken(Context ctx,String token)
    {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putString("token",token);
        editor.putBoolean("registered",true);
        editor.commit();
        //registerToken(token);
    }

    public static boolean isRegistered(Context ctx)
    {
        return  getPref(ctx).getBoolean("registered",false);
    }

    public static String getToken(Context ctx) {

        return getPref(ctx).getString("token",null);
    }

    public static boolean isresgisteredOnserver(Context ctx)
    {
        Log.v("getToken(ctx);",""+getToken(ctx));
        return  getPref(ctx).getBoolean("serverRegister",false);
    }
    public  static void registerToken(String token,final Context ctx,String uid,String accesstoken)
    {
        System.out.println("Registerd server: "+uid);
        String url=String.format(AppUrls.FCM_TOKEN);
        CustomStringRequest request=new CustomStringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Registerd server: succes "+response.toString());

                /*{"success":false,"msg":"Please enter all required field","dev_msg":"missing post data","code":"221"}*/
                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getBoolean("success"))
                        getPref(ctx).edit().putBoolean("serverRegister", true).commit();
                    else getPref(ctx).edit().putBoolean("serverRegister", false).commit();
                }catch (JSONException ex)
                {
                    ex.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Registerd server: fail "+error.getMessage());
            }
        });
        HashMap<String,String> hm=new HashMap<>();
        hm.put("driver_id",uid);
        hm.put("device_type","1");
        hm.put("fcm",token);
        hm.put("token",accesstoken);
        request.setRequestParams(hm);
        Log.v("Token request","Token Request"+hm.toString());
        App.getInstance().addToRequestQueue(request);
    }


                         /*OnlineMode*/

    public static void setOnLineStatus(boolean value,Context ctx)
    {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putBoolean("isOnLIne",value);
        editor.commit();
    }
    public static boolean isOnLineStatus(Context ctx)
    {
        return   getPref(ctx).getBoolean("isOnLIne",false);
    }
                    /*WELCOMEPAGES*/


    public static boolean isEnableNotifications(Context ctx)
    {
        return   getPref(ctx).getBoolean("notifications",true);
    }

    public static void setEnableNotifications(Context ctx,boolean value)
    {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putBoolean("notifications",value);
        editor.commit();

    }


                     /*SYNCHED COntacts*/

    public static void contactsSynched(Context ctx,boolean value) {
        SharedPreferences.Editor editor = getPref(ctx).edit();
        editor.putBoolean("sync", value);
        editor.commit();
    }

    public static boolean isContactsSynced(Context ctx)
    {
        return  getPref(ctx).getBoolean("sync",false);
    }



                        /*Themes*/

    public static void addThemeGroup(Context ctx,int value) {
        SharedPreferences.Editor editor = getPref(ctx).edit();
        editor.putInt("theme_group", value);
        editor.commit();
    }
    public static void addThemeIndividual(Context ctx,int value) {
        SharedPreferences.Editor editor = getPref(ctx).edit();
        editor.putInt("theme", value);
        editor.commit();
    }

    public static int getThemeGrp(Context ctx)
    {
        return  getPref(ctx).getInt("theme_group",-1);
    }
    public static int getThemeIndividual(Context ctx)
    {
        return  getPref(ctx).getInt("theme",-1);
    }



                    /*Welcome Pages*/

    public static boolean isViewedWelcomPages(Context ctx)
    {
        return   getPref(ctx).getBoolean("welcomscreens",false);
    }

    public static void viewedWelcomPages(Context ctx)
    {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putBoolean("welcomscreens",true);
        editor.commit();

    }


    public static  void setLogin(boolean isLoggedIn,Context ctx) {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        editor.commit();
    }

    public static  String getDRIVERID(Context ctx) {
        return getPref(ctx).getString(DRIVERID, null);
    }

    public static  void setDriverID(String driverID,Context ctx) {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putString(DRIVERID, driverID).commit();
    }
    public static  boolean isLoggedIn(Context ctx) {
        return getPref(ctx).getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public static void logoutUser(Context ctx){
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.clear();
        editor.commit();

    }
    static  private String KEY_IS_LOGGEDIN = "isLoggedIn";
    static  private String DRIVERID = "driverid";

    public static void addRideId(Context ctx, String rideId) {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putString("RIDE_ID", rideId);
                editor.commit();
    }
    public static String getRideId(Context ctx) {
        return getPref(ctx).getString("RIDE_ID",null);

    }

    public static boolean isSkiped(Context ctx)
    {
        return getPref(ctx).getBoolean("SKIPED",false);
    }
    public static void setSkiped(boolean value,Context ctx)
    {
        SharedPreferences.Editor editor=getPref(ctx).edit();
        editor.putBoolean("SKIPED", value);
        editor.commit();
    }
}
