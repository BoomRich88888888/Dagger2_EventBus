package com.example.dagger2_eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.dagger2_eventbus.data.bean.Bean;
import com.example.dagger2_eventbus.presenter.contract.ILoginContract;
import com.example.dagger2_eventbus.presenter.impl.LoginPresenterImpl;
import com.example.dagger2_eventbus.ui.activity.ShowActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginContract.ILoginView<ILoginContract.ILoginPresenter>{

    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_userPwd)
    EditText etUserPwd;
    @BindView(R.id.mLogin)
    Button mLogin;
    @BindView(R.id.mProgressBar)
    ProgressBar mProgressBar;
    private ILoginContract.ILoginPresenter presenter;
    private String userName;
    private String userPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.mLogin)
    public void onViewClicked() {
        userName = etUserName.getText().toString();
        userPwd = etUserPwd.getText().toString();
        presenter.login(userName, userPwd);
    }

    @Override
    public void loging() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showData(String responseData) {
        Toast.makeText(this, responseData, Toast.LENGTH_SHORT).show();
        Bean bean = new Bean(userName, userPwd);
        EventBus.getDefault().postSticky(bean);
        startActivity(new Intent(LoginActivity.this, ShowActivity.class));
    }

    @Override
    public void completed() {
        mProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void setPresenter(ILoginContract.ILoginPresenter iLoginPresenter) {
        presenter = iLoginPresenter;
    }
}
