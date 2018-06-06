package com.example.dagger2_eventbus.presenter.impl;

import com.example.dagger2_eventbus.data.model.ILoginModel;
import com.example.dagger2_eventbus.data.model.LoginModelImpl;
import com.example.dagger2_eventbus.di.component.DaggerComponent;
import com.example.dagger2_eventbus.di.module.LoginModule;
import com.example.dagger2_eventbus.presenter.contract.ILoginContract;

import javax.inject.Inject;

public class LoginPresenterImpl implements ILoginContract.ILoginPresenter {
    ILoginContract.ILoginView iLoginView;
    @Inject
    LoginModelImpl model;

    public LoginPresenterImpl(ILoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        DaggerComponent.builder().loginModule(new LoginModule()).build().injects(this);
    }

    @Override
    public void login(String userName, String userPwd) {
        iLoginView.loging();
        model.onShowData(userName, userPwd, new ILoginModel.SetOnDataChangedListener() {
            @Override
            public void getResponseData(String responseData) {
                iLoginView.showData(responseData);
                iLoginView.completed();
            }
        });
    }
}
