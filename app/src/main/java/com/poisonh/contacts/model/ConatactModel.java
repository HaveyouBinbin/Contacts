package com.poisonh.contacts.model;

/**
 * 联系人实体类
 * Created by Administrator on 2016/7/13.
 */

public class ConatactModel
{
    /**
     * 姓名
     */
    private String mStrName;
    /**
     * 拼音首字母
     */
    private String mStrFirstLetter;
    /**
     * 是否被收藏
     */
    private boolean isStart;

    public String getmStrName()
    {
        return mStrName;
    }

    public void setmStrName(String mStrName)
    {
        this.mStrName = mStrName;
    }

    public String getmStrFirstLetter()
    {
        return mStrFirstLetter;
    }

    public void setmStrFirstLetter(String mStrFirstLetter)
    {
        this.mStrFirstLetter = mStrFirstLetter;
    }

    public boolean isStart()
    {
        return isStart;
    }

    public void setStart(boolean start)
    {
        isStart = start;
    }

}
