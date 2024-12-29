package com.iejnnnmokkk.funnyplay;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.iejnnnmokkk.common.base.BaseActivity;
import com.iejnnnmokkk.funnyplay.game.GameFragment;
import com.iejnnnmokkk.funnyplay.gift.GiftFragment;
import com.iejnnnmokkk.funnyplay.personal.PersonalFragment;
import com.iejnnnmokkk.funnyplay.shop.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, GameFragment.OnShoppingClickListener {

    @BindView(R.id.rb_game)
    public RadioButton rbGame;
    @BindView(R.id.rg_menu)
    public RadioGroup rgMenu;

    private boolean doubleBackToExitPressedOnce = false;
    private static final int DOUBLE_BACK_PRESS_INTERVAL = 3000;

    private List<Fragment> fragments;

    @Override
    protected void onInitView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rbGame.setSelected(true);
        rgMenu.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        initFragment();
        defaultFragment();
    }

    private void defaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, fragments.get(0));
        transaction.commit();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new GameFragment());
        fragments.add(new GiftFragment());
        fragments.add(new ShopFragment());
        fragments.add(new PersonalFragment());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        rgMenu.check(i);
        switch (i) {
            case R.id.rb_game:
                transaction.replace(R.id.fl_content, fragments.get(0));
                break;
            case R.id.rb_gift:
                transaction.replace(R.id.fl_content, fragments.get(1));
                break;
            case R.id.rb_shop:
                transaction.replace(R.id.fl_content, fragments.get(2));
                break;
            case R.id.rb_personal:
                transaction.replace(R.id.fl_content, fragments.get(3));
                break;
        }
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (doubleBackToExitPressedOnce) {
                finish();
            } else {
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, DOUBLE_BACK_PRESS_INTERVAL);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onShoppingClick() {
        rgMenu.check(R.id.rb_shop);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, fragments.get(2));
        transaction.commit();
    }
}