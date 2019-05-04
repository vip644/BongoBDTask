package com.example.videoplayer.ui.activities;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;

import com.example.videoplayer.R;
import com.example.videoplayer.ui.base.BaseActivity;
import com.example.videoplayer.ui.iview.IPlayerView;
import com.example.videoplayer.ui.presenter.IPlayerPresenter;
import com.example.videoplayer.ui.presenter.PlayerPresenter;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;

public class PlayerActivity extends BaseActivity implements
        Player.EventListener, IPlayerView {

    private DataSource.Factory mediaDataSourceFactory;
    private DefaultTrackSelector trackSelector;
    private boolean shouldAutoPlay;
    private BandwidthMeter bandwidthMeter;
    private ProgressDialog progressDialog;
    private Uri contentUri = Uri.parse(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4");
    private SimpleExoPlayer player;


    @Override
    protected int getResourceLayout() {
        return R.layout.activity_exo_player;
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {
        IPlayerPresenter IPlayerPresenter = new PlayerPresenter(this);
        IPlayerPresenter.onAttach(this);
        IPlayerPresenter.launchActivity();
        shouldAutoPlay = true;
        bandwidthMeter = new DefaultBandwidthMeter();
        mediaDataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "KioraPlayer"),
                (TransferListener<? super DataSource>) bandwidthMeter);
    }

    @Override
    public void initializePlayer() {


        PlayerView playerView = findViewById(R.id.player_view);
        playerView.requestFocus();

        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);

        trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

        playerView.setPlayer(player);

        player.setPlayWhenReady(shouldAutoPlay);

        ExtractorMediaSource mediaSource = new ExtractorMediaSource.Factory(
                mediaDataSourceFactory).createMediaSource(contentUri);
        player.prepare(mediaSource);

//        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
//        player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
    }

    @Override
    public void releasePlayer() {
        if (player != null) {
            shouldAutoPlay = player.getPlayWhenReady();
            player.release();
            player = null;
            trackSelector = null;
        }
    }

    @Override
    protected void onActivityPause() {
        releasePlayer();
    }

    @Override
    protected void onActivityBackPressed() {
        finish();
    }

    @Override
    protected void onActivityStop() {
        if (player == null) {
            releasePlayer();
        }
    }

    @Override
    protected void onActivityStart() {
        initializePlayer();
    }

    @Override
    public void showProgressBar() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait\nConnecting to Server...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

    }

    @Override
    public void onLoadingChanged(boolean isLoading) {

    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

    }

    @Override
    public void onRepeatModeChanged(int repeatMode) {

    }

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {

    }

    @Override
    public void onPositionDiscontinuity(int reason) {

    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

    }

    @Override
    public void onSeekProcessed() {

    }
}
