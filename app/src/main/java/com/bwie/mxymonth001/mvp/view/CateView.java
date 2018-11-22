package com.bwie.mxymonth001.mvp.view;

import com.bwie.mxymonth001.bean.CategotyChild;
import com.bwie.mxymonth001.bean.CategotyGroup;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public interface CateView {
    void getGroup(CategotyGroup categotyGroup);

    void getChild(CategotyChild categotyChild);
}
