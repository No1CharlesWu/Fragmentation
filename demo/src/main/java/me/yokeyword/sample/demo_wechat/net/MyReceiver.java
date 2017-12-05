package me.yokeyword.sample.demo_wechat.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by charles on 2017/12/5 0005.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MYTAG", "onclock.............");
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
