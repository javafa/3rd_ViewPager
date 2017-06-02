package com.veryworks.android.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    Fragment one;
    Fragment two;
    Fragment three;
    Fragment four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. ViewPager 위젯 연결
        pager = (ViewPager) findViewById(R.id.pager);

        // 2. 프래그먼트들 생성
        one = new OneFragment();
        two = new TwoFragment();
        three = new ThreeFragment();
        four = new FourFragment();

        // 3. 프래그먼트를 datas 저장소에 담은 후
        List<Fragment> datas = new ArrayList<>();
        datas.add(one);
        datas.add(two);
        datas.add(three);
        datas.add(four);

        // 4. 프래그먼트 매니저와 함께 아답터에 전달
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), datas);

        // 5. 아답터를 페이저 위젯에 연결
        pager.setAdapter(adapter);
    }

    class PagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> datas;

        public PagerAdapter(FragmentManager fm, List<Fragment> datas) {
            super(fm);
            this.datas = datas;
        }
        @Override
        public Fragment getItem(int position) {
            return datas.get(position);
        }
        @Override
        public int getCount() {
            return datas.size();
        }
    }
}
