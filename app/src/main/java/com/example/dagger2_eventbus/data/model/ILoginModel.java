package com.example.dagger2_eventbus.data.model;

public interface ILoginModel {
    void onShowData(String userName, String userPwd,SetOnDataChangedListener setOnDataChangedListener);

    interface SetOnDataChangedListener{
        void getResponseData(String responseData);
    }
}
