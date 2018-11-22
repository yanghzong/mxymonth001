package com.bwie.mxymonth001.mvp.model;

import com.bwie.mxymonth001.inter.ICallBack;
import com.bwie.mxymonth001.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * date:2018/11/21
 * author:mxy(M)
 * function:
 */
public class Model {
    public void getData(String url, ICallBack iCallBack, Type type){
        HttpUtils.getInstance().getData(url,iCallBack,type);
    }
}
