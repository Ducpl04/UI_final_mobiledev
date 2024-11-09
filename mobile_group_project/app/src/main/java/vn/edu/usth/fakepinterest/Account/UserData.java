package vn.edu.usth.fakepinterest.Account;

import android.widget.ImageView;

public class UserData {
    String userName;
    Integer userPins;
    String description;
    Integer dataResources;
    Integer userFollow;

    public UserData(Integer dataResources, String userName, String description, Integer userPins , Integer userFollow){
        this.userName = userName;
        this.userPins = userPins;
        this.dataResources = dataResources;
        this.description = description;
        this.userFollow = userFollow;
    }

    public Integer getDataResources() {
        return dataResources;
    }

    public Integer getUserFollow() {
        return userFollow;
    }

    public Integer getUserPins() {
        return userPins;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }
}
