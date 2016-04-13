package com.example.philipcanniff.youtube_video_test;

/**
 * Created by philipcanniff on 3/18/16.
 */
public class YouTube_Object {

    String videoTitle;
    String videoPoster;
    int videoDuration;

    public YouTube_Object(String videoTitle, String videoPoster, int videoDuration) {
        this.videoTitle = videoTitle;
        this.videoPoster = videoPoster;
        this.videoDuration = videoDuration;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoPoster() {
        return videoPoster;
    }

    public void setVideoPoster(String videoPoster) {
        this.videoPoster = videoPoster;
    }

    public int getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(int videoDuration) {
        this.videoDuration = videoDuration;
    }
}
