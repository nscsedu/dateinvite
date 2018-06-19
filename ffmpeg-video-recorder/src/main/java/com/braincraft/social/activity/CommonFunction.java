package com.braincraft.social.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.DatePicker;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.Calendar;

/**
 * Created by USER on 10/3/2017.
 */

public class CommonFunction {
    public static String optStringNullCheck(final JSONObject json, final String key) {
        if (json.isNull(key)||json.optString(key).equalsIgnoreCase("null"))
            return "";
        else
            return json.optString(key, key);
    }
    public static String stringNullCheck(final String key) {
        if (key.equalsIgnoreCase("null")){
            return "";
        }
        else return key;

    }

    public static void savePreferences(Context context, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();

    }
    public static  void datePicker(final EditText editText, Context context) {
        Calendar dateCalender = Calendar.getInstance();
        int year = dateCalender.get(Calendar.YEAR);
        int month = dateCalender.get(Calendar.MONTH);
        int day = dateCalender.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog;
        datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear + 1;
                //2001-05-03
                editText.setText( year + "-" + monthOfYear + "-" + dayOfMonth);

            }
        }, year, month, day);
        datePickerDialog.setTitle("SELECT DATE");
        datePickerDialog.show();
    }
    public static String getPreferences(Context context, String prefKey) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        return sharedPreferences.getString(prefKey, "");
    }

}
