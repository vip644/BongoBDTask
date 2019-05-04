package com.example.videoplayer.ui.presenter;

import android.content.Context;

import com.example.videoplayer.ui.base.BasePresenter;
import com.example.videoplayer.ui.iview.IPlayerView;

/**
 * Created by vipin.c on 04/05/2019
 */
public class PlayerPresenter<V extends IPlayerView> extends BasePresenter<V> implements IPlayerPresenter<V>{

    public PlayerPresenter(Context context) {
        super(context);
    }

    @Override
    public void launchActivity() {
        getMvpView().initializePlayer();
        getMvpView().releasePlayer();
    }
}
