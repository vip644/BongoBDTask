package com.example.videoplayer.ui.base;

import android.content.Context;

/**
 * Created by vipin.c on 04/05/2019
 */
public class BasePresenter<V extends IBaseView> implements IBasePresenter<V>{

    private Context mContext;
    private V mMvpView;

    public BasePresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    protected V getMvpView(){
        return mMvpView;
    }
}
