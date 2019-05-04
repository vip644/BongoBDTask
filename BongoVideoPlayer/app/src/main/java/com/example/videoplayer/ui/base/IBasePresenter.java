package com.example.videoplayer.ui.base;

/**
 * Created by vipin.c on 04/05/2019
 */
public interface IBasePresenter<V extends IBaseView> {

    void onAttach(V mvpView);
}
