package com.icaboalo.historystoreapp.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/14/2015.
 */
public class UserModel {

    @SerializedName("id")
    String userId;

    @SerializedName("username")
    String username;

    @SerializedName("first_name")
    String userFirstName;

    @SerializedName("last_name")
    String userLastName;

    @SerializedName("email")
    String userEmail;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
