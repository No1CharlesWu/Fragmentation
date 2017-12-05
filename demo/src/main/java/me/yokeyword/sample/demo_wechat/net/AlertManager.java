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
            PrintAlert(alert);
            switch (alert.type){
                case 0:
                    try {
                        if (findTicker(alert.Sma_web) != null
                                && findTicker(alert.Sma_web).ticker_last >= alert.Sma_high_price
                                && findTicker(alert.Sma_web).ticker_last <= alert.Sma_low_price){
                            rAList.add(alert);
                            System.out.println("******" + alert.alert_name + alert.Sma_web + "******");
                        }
                    }catch (Exception e){
                        System.out.println(e + "******" + alert.alert_name + alert.Sma_web + "******");
                    }
                    break;
                case 1:
                    try{
                        if (findTicker(alert.Msa_web_high) != null
                                && findTicker(alert.Msa_web_low) != null
                                && findTicker(alert.Msa_web_high).ticker_last - findTicker(alert.Msa_web_low).ticker_last >= alert.Msa_spread){
                            rAList.add(alert);
                            System.out.println("******" + alert.alert_name + "******");
                        }
                    }catch (Exception e){
                        System.out.println(e + "******" + alert.alert_name + alert.Msa_web_high + alert.Msa_web_low +"******");
                    }
                    break;
            }
        }
        System.out.println(getTriggeredAlert().size());
    }

    private void PrintAlert(Alert alert){
        System.out.println("name: "+ alert.alert_name+" type: " + alert.type + " Sma_web: "+alert.Sma_web + " Sma_high: "+alert.Sma_high_price + " Sma_low: "+alert.Sma_low_price);
        System.out.println("name: "+ alert.alert_name+" type: " + alert.type + " Msa_web_high: "+alert.Msa_web_high + " Msa_web_low: "+alert.Msa_web_low + " Msa_spread: "+alert.Msa_spread);
    }


    private Ticker findTicker(String name){
        for (int i = 0; i < mTList.size(); i++) {
            if (mTList.get(i).ticker_name.equals(name)){
                return mTList.get(i);
            }
        }
        return null;
    }

    public List<Alert> getTriggeredAlert(){
        return rAList;
    }
}
