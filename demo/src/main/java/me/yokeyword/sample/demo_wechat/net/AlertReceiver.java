package me.yokeyword.sample.demo_wechat.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by charles on 2017/12/5 0005.
 */

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //调试信息输出
        Log.d("MYTAG", "onclock.............");
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
        //调用播放系统闹钟声音
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone r = RingtoneManager.getRingtone(context,notification);
//        r.play();
    }
}
