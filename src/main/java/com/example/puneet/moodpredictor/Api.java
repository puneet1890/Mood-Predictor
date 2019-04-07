package com.example.puneet.moodpredictor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api
{
    // Initiating the db  - using @Query
   // String BASE_URL = "http://ec2-35-154-226-182.ap-south-1.compute.amazonaws.com:8080/MoodDetector/";
    // String BASE_URL = "http://ec2-35-154-226-182.ap-south-1.compute.amazonaws.com:8080/MoodDetector/SensorData?id=1234567890&temp=5600&bpm=3400&skin=2300/";


   //@GET("SensorData?id=1234567890&temp=5600&bpm=3400&skin=2300")
    //Call<MoodBean> getMoodDetails(@QueryMap Map<String,String> parameters);

    // Fetching the data  - using @Path

    //http://ec2-35-154-226-182.ap-south-1.compute.amazonaws.com:8080/MoodDetector/rest/user/handleLogin/1234567890

    @GET("{mobile}")
    Call<MoodBean> getData(@Path("mobile")String mobile);

}

