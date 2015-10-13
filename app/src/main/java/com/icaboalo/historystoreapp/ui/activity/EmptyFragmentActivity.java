package com.icaboalo.historystoreapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.ui.fragment.PlacesFragment;
import com.icaboalo.historystoreapp.util.VUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EmptyFragmentActivity extends AppCompatActivity {

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_fragment);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        VUtil.replaceFragment(new PlacesFragment(), getSupportFragmentManager());
    }

}
