package me.yokeyword.sample.demo_wechat.ui.fragment.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_wechat.base.BaseBackFragment;
import me.yokeyword.sample.demo_wechat.ui.fragment.CycleFragment;
import me.yokeyword.sample.demo_wechat.ui.fragment.second.ViewFragment;

public class MarketSpreadAlertFragment extends BaseBackFragment {
    public static MarketSpreadAlertFragment newInstance() {
        return new MarketSpreadAlertFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.market_spread_alert_fragment, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        initToolbarNav(toolbar);
        toolbar.setTitle(R.string.market_spread_alert);

        return attachToSwipeBack(view);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        // 懒加载
        // 同级Fragment场景、ViewPager场景均适用
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        // 当对用户可见时 回调
        // 不管是 父Fragment还是子Fragment 都有效！
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        // 当对用户不可见时 回调
        // 不管是 父Fragment还是子Fragment 都有效！
    }
}
