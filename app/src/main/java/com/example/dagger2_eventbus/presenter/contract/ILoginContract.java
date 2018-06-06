package com.example.dagger2_eventbus.presenter.contract;

import com.example.dagger2_eventbus.presenter.BasePresenter;
import com.example.dagger2_eventbus.ui.BaseView;

public interface ILoginContract {
    interface ILoginPresenter extends BasePresenter{
        void login(String userName, String userPwd);
    }

    interface ILoginView<ILoginPresenter> extends BaseView<ILoginPresenter>{
        void loging();

        void showData(String responseData);

        void completed();
    }
}
