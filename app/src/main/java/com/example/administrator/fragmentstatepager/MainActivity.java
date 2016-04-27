package com.example.administrator.fragmentstatepager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends FragmentActivity {
    static final int NUM_ITEMS = 4;
    @InjectView(R.id.tabWidget_navi) TabWidget tabWidget;
    @InjectView(R.id.pager) ViewPager mPager;
    //     MyAdapter mAdapter;
//    ViewPager mPager;
    ArrayList<Fragment> fragmentsList;
//    private TabWidget tabWidget;
    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.tab_home_btn, R.drawable.tab_message_btn, R.drawable.tab_selfinfo_btn,
            R.drawable.tab_square_btn};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页", "消息", "好友", "广场"};
    private Class list[] = {Fragment1.class, Fragment2.class, Fragment3.class, Fragment4.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
        ButterKnife.inject(this);
        InitViewPager();
//        tabWidget = (TabWidget) findViewById(R.id.tabWidget_navi);
        for (int i = 0; i < list.length; i++) {
            tabWidget.addView(getTabItemView(i));
            final View view = tabWidget.getChildTabViewAt(i);
            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPager.setCurrentItem(finalI);
                    view.setBackgroundResource(R.drawable.selector_tab_background);
                    updateTab();
                }
            });


        }


    }

    private void updateTab() {
        int currentItem = mPager.getCurrentItem();
        for (int i = 0; i < list.length; i++) {
            View view = tabWidget.getChildAt(i);
            TextView view1 = (TextView) view.findViewById(R.id.textview);
            if (currentItem == i) {

                view1.setTextColor(getResources().getColor(R.color.gray));
                view.setSelected(true);

            } else {
                view1.setTextColor(getResources().getColor(R.color.black));
                view.setSelected(false);
            }
        }
    }

    private View getTabItemView(int index) {
        LayoutInflater layoutInflater = null;
        View view = layoutInflater.from(this).inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;
    }

    private void InitViewPager() {
//        mPager = (ViewPager) findViewById(R.id.pager);
        fragmentsList = new ArrayList<Fragment>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();
        fragmentsList.add(fragment1);
        fragmentsList.add(fragment2);
        fragmentsList.add(fragment3);
        fragmentsList.add(fragment4);
        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentsList));
        mPager.setCurrentItem(0);
    }
}