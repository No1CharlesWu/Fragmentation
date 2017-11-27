package me.yokeyword.sample.demo_wechat.ui.fragment.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_wechat.base.BaseMainFragment;

/**
 * Created by charles on 2017/11/27 0027.
 */

public class SettingFragment extends BaseMainFragment {
    private Toolbar mToolbar;
    private View mView;

    public static SettingFragment newInstance() {

        Bundle args = new Bundle();

        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.setting_fragment, container, false);
        return mView;
    }
}
