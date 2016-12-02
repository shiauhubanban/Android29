package com.org.iii.shine29;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private ArrayList<View> views;
    private ViewFlipper flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        initViewPager();
    }

    private void initViewPager(){
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);

        View page0 = inflater.inflate(R.layout.page0,null);
        View page1 = inflater.inflate(R.layout.page1,null);
        View page2 = inflater.inflate(R.layout.page2,null);
        View page3 = inflater.inflate(R.layout.page3,null);
        View page4 = inflater.inflate(R.layout.page4,null);
        views.add(page0);
        views.add(page1);views.add(page2);views.add(page3);
        views.add(page4);


        flipper = (ViewFlipper) page2.findViewById(R.id.flipper);
        View f0 = flipper.getChildAt(0);
        View f1 = flipper.getChildAt(1);
        View f2 = flipper.getChildAt(2);
        f0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });

        pager.setAdapter(new MyPagerAdapter());
        pager.setOnPageChangeListener(new MyPageChangeListener());
        pager.setCurrentItem(1);


//        ListView lv = new ListView(this);
//        LinkedList<HashMap<String,String>> data = new LinkedList<>();
//        HashMap<String,String> ok = new HashMap<>();
//        ok.put("key1", "value1");
//        ok.put("key2", "value2");
//        ok.put("key3", "value3"); // 不存在畫面中
//        data.add(ok);
//        SimpleAdapter adapter = new SimpleAdapter(this,ok,);
//
//        lv.setAdapter();

    }

    private class MyPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            //super.onPageSelected(position);
            if (position == 0){
                pager.setCurrentItem(1);
            }else if (position == 4){
                pager.setCurrentItem(3);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            Log.v("shine", "pos:" + position);
        }
    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            pager.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = views.get(position);
            pager.removeView(view);
            //super.destroyItem(container, position, object);
        }
    }

}
