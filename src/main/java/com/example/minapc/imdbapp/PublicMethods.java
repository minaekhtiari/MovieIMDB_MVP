package com.example.minapc.imdbapp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by MinaPC on 6/23/2018.
 */

public class PublicMethods {
    public static void showToast(Context mContext , String msg){
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }
}
