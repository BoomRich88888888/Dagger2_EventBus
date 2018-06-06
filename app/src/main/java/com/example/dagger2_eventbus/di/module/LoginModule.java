package com.example.dagger2_eventbus.di.module;

import com.example.dagger2_eventbus.data.model.LoginModelImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    public LoginModelImpl getInstance(){
        return new LoginModelImpl();
    }//要抽取注解内容
}
