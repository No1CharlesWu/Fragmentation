package me.yokeyword.sample.demo_wechat.ui.fragment.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_wechat.base.BaseBackFragment;
import me.yokeyword.sample.demo_wechat.ui.fragment.CycleFragment;
import me.yokeyword.sample.demo_wechat.ui.fragment.second.ViewFragment;

public class MarketSpreadAlertFragment extends BaseBackFragment {
    private Spinner mSpinner_high;
    private Spinner mSpinner_low;
    private EditText mSpread;
    private Button mButton;
    private Toolbar mToolbar;


    public static MarketSpreadAlertFragment newInstance() {
        return new MarketSpreadAlertFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.market_spread_alert_fragment, container, false);
        initView(view);
        return attachToSwipeBack(view);
    }
    private void initView(View view){
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        initToolbarNav(mToolbar);
        mToolbar.setTitle(R.string.market_spread_alert);

        mSpinner_high = (Spinner)view.findViewById(R.id.spinner_web_list_first);
        mSpinner_low = (Spinner)view.findViewById(R.id.spinner_web_list_second);
        mSpread = (EditText)view.findViewById(R.id.et_spread);
        mButton = (Button)view.findViewById(R.id.btn_save);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String select_high_web = mSpinner_high.getSelectedItem().toString();
                String select_low_web = mSpinner_low.getSelectedItem().toString();
                String spread = mSpread.getText().toString();
                String toast_text = "Spinner_first:" + select_high_web + "\nSpinner_second:" + select_low_web + "\nSpread:" + spread;
                Toast toast=Toast.makeText(getContext(), toast_text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
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
