package me.yokeyword.sample.demo_wechat.ui.fragment.setting;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by charles on 2017/11/27 0027.
 */

public class PersonalSettingFragment extends SupportFragment{
    private Toolbar mToolbar;

    public static PersonalSettingFragment newInstance() {

        Bundle args = new Bundle();

        PersonalSettingFragment fragment = new PersonalSettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
