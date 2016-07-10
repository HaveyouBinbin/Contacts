package com.poisonh.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.poisonh.contacts.widgets.SideBarMenu;

/**
 *  Created by PoisonH on 2016/7/10.
 */
public class MainActivity extends AppCompatActivity
{
    private SideBarMenu mSiderBarMenu;
    private TextView mTvTips;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //setClickListener();
    }

    private void initView()
    {
        mSiderBarMenu = (SideBarMenu) findViewById(R.id.sbm_siderbarmenu);
        mTvTips = (TextView) findViewById(R.id.tv_tips);
        mSiderBarMenu.setTextView(mTvTips);
    }
}
