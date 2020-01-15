package com.nuil.cleansample.presentation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.add(containerViewId, fragment);
        transaction.commit();
    }
}
