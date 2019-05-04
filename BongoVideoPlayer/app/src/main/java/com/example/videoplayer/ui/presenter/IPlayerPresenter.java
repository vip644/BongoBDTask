package com.example.videoplayer.ui.presenter;

import com.example.videoplayer.ui.base.IBasePresenter;
import com.example.videoplayer.ui.iview.IPlayerView;

/**
 * Created by vipin.c on 04/05/2019
 */
public interface IPlayerPresenter<V extends IPlayerView> extends IBasePresenter<V> {

    void launchActivity();
}
