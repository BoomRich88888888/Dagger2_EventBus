package com.example.dagger2_eventbus.di.component;

import com.example.dagger2_eventbus.di.module.LoginModule;
import com.example.dagger2_eventbus.presenter.impl.LoginPresenterImpl;

@dagger.Component(modules = LoginModule.class)
public interface Component {
  void injects(LoginPresenterImpl loginPresenter);//要注解的地方
}
