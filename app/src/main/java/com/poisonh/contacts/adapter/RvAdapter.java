package com.poisonh.contacts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poisonh.contacts.R;
import com.poisonh.contacts.model.ConatactModel;
import com.poisonh.contacts.utils.PinyinComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>
{
    private Context mContext;
    private List<ConatactModel> mContactLists;

    public RvAdapter(Context context)
    {
        this.mContext = context;
        mContactLists = new ArrayList<>();
    }

    @Override
    public int getItemCount()
    {
        return mContactLists.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.mTvContent.setText(mContactLists.get(position).getmStrName());
        int section = getSectionForPosition(position);

        if (position == getPositionForSection(section))
        {
            holder.mTvGroup.setVisibility(View.VISIBLE);
            holder.mTvGroup.setText(mContactLists.get(position).getmStrFirstLetter());
        } else
        {
            holder.mTvGroup.setVisibility(View.GONE);
        }

    }

    protected class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTvGroup;
        private TextView mTvContent;

        protected MyViewHolder(View view)
        {
            super(view);

            mTvGroup = (TextView) view.findViewById(R.id.tv_group);
            mTvContent = (TextView) view.findViewById(R.id.tv_content);
        }
    }

    public void notif(List<ConatactModel> list)
    {
        this.mContactLists = list;
        Collections.sort(mContactLists, new PinyinComparator());
        this.notifyDataSetChanged();
    }

    public int getSectionForPosition(int position)
    {
        return mContactLists.get(position).getmStrFirstLetter().charAt(0);
    }

    public int getPositionForSection(int section)
    {
        for (int i = 0; i < getItemCount(); i++)
        {
            String sortStr = mContactLists.get(i).getmStrFirstLetter();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section)
            {
                return i;
            }
        }
        return -1;
    }
}
