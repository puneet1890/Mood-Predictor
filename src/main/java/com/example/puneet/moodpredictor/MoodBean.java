package com.example.puneet.moodpredictor;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class MoodBean
{
    private String heartbeat;
    private String skin;
    private String temp;
    private String mood;
    private String mobile;

    public MoodBean( String heartbeat, String skin, String temp, String mood, String mobile)
    {
        this.heartbeat = heartbeat;
        this.skin = skin;
        this.temp = temp;
        this.mood = mood;
        this.mobile = mobile;
    }

     String getHeartbeat() {
        return heartbeat;
    }

     String getSkin() {
        return skin;
    }

     String getTemp() {
        return temp;
    }

     String getMood() {
        return mood;
    }

    String getMobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoodBean)) return false;
        MoodBean moodBean = (MoodBean) o;
        return  Objects.equals(heartbeat, moodBean.heartbeat) &&
                Objects.equals(skin, moodBean.skin) &&
                Objects.equals(temp, moodBean.temp) &&
                Objects.equals(mood, moodBean.mood) &&
                Objects.equals(mobile, moodBean.mobile);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(heartbeat, skin, temp, mood, mobile);
    }

    @Override
    @NotNull
    public String toString()
    {
        return "MoodBean{" +
                " heartbeat='" + heartbeat + '\'' +
                ", skin='" + skin + '\'' +
                ", temp='" + temp + '\'' +
                ", mood='" + mood + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

