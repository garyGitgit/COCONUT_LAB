package com.gachon.app.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by garyNoh on 2017. 6. 4..
 */

public class UserManager {
    Context context;
    SharedPreferences sharedPreferencesPoints;
    SharedPreferences sharedPreferencesMax;
    SharedPreferences sharedPreferencesProgress;
    static String pointsKey = "userPoints";
    static String maxKey = "maxPoints";
    static String progressKey = "userProgress";

    String nickname = "코딩이";
    String mygroup = "NoGroup";

    public UserManager(Context context){
        this.context = context;
        sharedPreferencesPoints = context.getSharedPreferences(pointsKey, 0);
        sharedPreferencesMax = context.getSharedPreferences(maxKey, 0);
        sharedPreferencesProgress = context.getSharedPreferences(progressKey, 1);

    }

    public String getMygroup() {
        return mygroup;
    }

    public void setMygroup(String mygroup) {
        this.mygroup = mygroup;
    }

    public String getNickname(){
        return this.nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public int getPoints(){
        return sharedPreferencesPoints.getInt(pointsKey, 0);
    }

    public int getMaxPoints(){
        return sharedPreferencesMax.getInt(maxKey, 0);
    }

    /**
     *
     * @return true 면 레벨업
     */
    public boolean addPoints(){
        SharedPreferences.Editor editor = sharedPreferencesPoints.edit();
        editor.putInt(pointsKey, getPoints()+100); //100점씩 더한다
        editor.commit();
        //레벨업 할 때
        if(getPoints() == getMaxPoints()){
            editor.putInt(pointsKey, 0); // 0으로 초기화시키고
            setMaxPoints(getPoints()+100); //max 를 한 단계 올린다
            editor.commit();
            return true;
        }
        return false;
    }

    public void setMaxPoints(int maxPoints){
        SharedPreferences.Editor editor = sharedPreferencesMax.edit();
        editor.putInt(maxKey, maxPoints); // max 를 초깃값으로 초기화
        editor.commit();
    }


    public void incrementProgress(){
        SharedPreferences.Editor editor = sharedPreferencesProgress.edit();
        editor.putInt(progressKey, getProgress()+1); // max 를 초깃값으로 초기화
        editor.commit();
    }

    public int getProgress(){return sharedPreferencesProgress.getInt(progressKey, 0);}




    void resetMaxPoints(){
        SharedPreferences.Editor editor = sharedPreferencesMax.edit();
        editor.putInt(maxKey, 100); // max 를 초깃값으로 초기화
        editor.commit();
    }

    void resetPoints(){
        SharedPreferences.Editor editor = sharedPreferencesPoints.edit();
        editor.putInt(pointsKey, 0);
        editor.commit();
    }

    void resetProgress(){
        SharedPreferences.Editor editor = sharedPreferencesProgress.edit();
        editor.putInt(progressKey, 1);
        editor.commit();
    }

    public void reset(){
        resetPoints();
        resetMaxPoints();
        resetProgress();
    }


}
