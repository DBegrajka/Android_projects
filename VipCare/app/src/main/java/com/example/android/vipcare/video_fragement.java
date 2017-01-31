package com.example.android.vipcare;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class video_fragement extends Fragment{
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        if (container == null){
            return null;
        }
        View rootView = inflater.inflate(R.layout.video_fragement,container, false);
        MediaController mc= new MediaController(getActivity());

        VideoView view = (VideoView)rootView.findViewById(R.id.videoView1);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.abuse;
        view.setVideoURI(Uri.parse(path));
        view.setMediaController(mc);
        view.start();
        view.requestFocus();
        return inflater.inflate(R.layout.video_fragement,container, false);
    }*/
private VideoView mVideoView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        if (container == null){
            return null;
        }
        View rootView = inflater.inflate(R.layout.video_fragement,container, false);
        VideoView mVideoView = (VideoView) rootView.findViewById(R.id.videoView1);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.abuse));
        mVideoView.setMediaController(new MediaController(getActivity()));
        mVideoView.requestFocus();
        return rootView;
    }
}
