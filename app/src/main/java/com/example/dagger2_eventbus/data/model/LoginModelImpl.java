package com.example.dagger2_eventbus.data.model;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class LoginModelImpl implements ILoginModel {

    @Override
    public void onShowData(String userName, String userPwd, final SetOnDataChangedListener setOnDataChangedListener) {
        String responseString = "momo啦！~";
        if (userName.equals("gy") && userPwd.equals("666")) {
            responseString = "成功哦耶耶耶茄子哦哦哦好厉害啊";
        }else {
            responseString = "失败咯不要气馁明天充满希望！~";

        }

        Observable
                .just(responseString)
                .delay(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String responseData) {
                        setOnDataChangedListener.getResponseData(responseData);
                    }
                });
    }
}
