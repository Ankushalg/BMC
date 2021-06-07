package com.allstudio.bmc;

import android.content.Context;
import android.content.SharedPreferences;

class SharedMemory {
    private final SharedPreferences prefs;
    SharedMemory(Context ctx) {prefs = ctx.getSharedPreferences("SCREEN_SETTINGS", Context.MODE_PRIVATE);}

    void setUToken(String value) {prefs.edit().putString("Token", value).apply();}
    String getUToken() { return  prefs.getString("Token", null); }
}
