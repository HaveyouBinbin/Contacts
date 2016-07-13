package com.poisonh.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.poisonh.contacts.adapter.RvAdapter;
import com.poisonh.contacts.model.ConatactModel;
import com.poisonh.contacts.utils.ParsePinyinUtils;
import com.poisonh.contacts.widgets.SideBarMenu;

import java.util.List;

/**
 * Created by PoisonH on 2016/7/10.
 */
public class MainActivity extends AppCompatActivity
{
    private SideBarMenu mSiderBarMenu;
    private TextView mTvTips;
    private RecyclerView mRvContacts;
    private RvAdapter mRvAdapter;
    private List<ConatactModel> mContactLists;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView()
    {
        mSiderBarMenu = (SideBarMenu) findViewById(R.id.sbm_siderbarmenu);
        mRvContacts = (RecyclerView) findViewById(R.id.rv_contacts);
        mTvTips = (TextView) findViewById(R.id.tv_tips);
        mSiderBarMenu.setTextView(mTvTips);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvContacts.setLayoutManager(manager);
        mRvAdapter = new RvAdapter(this);
        mRvContacts.setAdapter(mRvAdapter);
        mContactLists = ParsePinyinUtils.parsePinyin(getResources().getStringArray(R.array.contacts));
        mRvAdapter.notif(mContactLists);
    }

}
