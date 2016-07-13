package com.poisonh.contacts.utils;

import com.poisonh.contacts.model.ConatactModel;

import java.util.Comparator;

/**
 * 自定义排序规则：对集合中的中的数据根据A-Z进行排序，前面两个if判断主要是将不是以汉字开头的数据放在后面
 */
public class PinyinComparator implements Comparator<ConatactModel>
{

    public int compare(ConatactModel o1, ConatactModel o2)
    {
        if (o1.getmStrFirstLetter().equals("@") || o2.getmStrFirstLetter().equals("#"))
        {
            return -1;
        } else if (o1.getmStrFirstLetter().equals("#") || o2.getmStrFirstLetter().equals("@"))
        {
            return 1;
        } else
        {
            return o1.getmStrFirstLetter().compareTo(o2.getmStrFirstLetter());
        }
    }
}
