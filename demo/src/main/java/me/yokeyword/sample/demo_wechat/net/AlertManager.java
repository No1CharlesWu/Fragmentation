package me.yokeyword.sample.demo_wechat.net;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.sample.demo_wechat.entity.Alert;
import me.yokeyword.sample.demo_wechat.entity.Ticker;

/**
 * Created by charles on 03/12/2017.
 */

public class AlertManager {
    private List<Ticker> mTList;
    private List<Alert> mAList;

    private List<Alert> rAList = new ArrayList<>();

    public AlertManager(List<Ticker> T, List<Alert> A){
        this.mTList = T;
        this.mAList = A;

        findTriggeredAlert();
    }

    private void findTriggeredAlert(){
        for (Alert alert:mAList) {

            switch (alert.type){
                case 0:
                    if (findTicker(alert.Sma_web) != null
                            && findTicker(alert.Sma_web).ticker_last >= alert.Sma_high_price
                            && findTicker(alert.Sma_web).ticker_last <= alert.Sma_low_price){
                        rAList.add(alert);
                        System.out.println("******" + alert.alert_name + alert.alert_msg + "******");
                    }
                    break;
                case 1:
                    break;
            }
        }
    }



    private Ticker findTicker(String name){
        for (int i = 0; i < mTList.size(); i++) {
            if (mTList.get(i).ticker_name == name){
                return mTList.get(i);
            }
        }
        return null;
    }

    public List<Alert> getTriggeredAlert(){
        return rAList;
    }
}
