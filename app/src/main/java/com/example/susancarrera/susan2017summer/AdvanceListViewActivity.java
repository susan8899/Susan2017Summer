package com.example.susancarrera.susan2017summer;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.susancarrera.susan2017summer.adapter.AdvanceListViewAdapter;
import com.example.susancarrera.susan2017summer.adapter.BaseViewPagerAdapter;
import com.example.susancarrera.susan2017summer.fragment.BlueFragment;
import com.example.susancarrera.susan2017summer.fragment.GreenFragment;
import com.example.susancarrera.susan2017summer.fragment.RedFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvanceListViewActivity extends BaseActivity {

    @BindView(R.id.activity_advance_list_view) ListView lv;

    private ArrayList<Fragment> list2 = new ArrayList<Fragment>();
    private ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
        ButterKnife.bind(this);
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello, how are you");
        list.add("I am fine thank you");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");


        AdvanceListViewAdapter adapter = new AdvanceListViewAdapter(this, list);
        lv.setAdapter(adapter);


        //TextView as HeaderView
       /* TextView tv = new TextView(this);
        tv.setText("HeaderView");
        tv.setTextSize(50);
        lv.addHeaderView(tv);*/


        //ViewPager as HeaderView  Quiz4
        View root = getLayoutInflater().inflate(R.layout.activity_view_pager2,null,false);
        viewPager = (ViewPager) root.findViewById(R.id.activity_view_pager2);
        list2.add(new RedFragment());
        list2.add(new GreenFragment());
        list2.add(new BlueFragment());
        BaseViewPagerAdapter adapter1 =
                new BaseViewPagerAdapter(getSupportFragmentManager(),list2);
        viewPager.setAdapter(adapter1);
        viewPager.setCurrentItem(0);
        lv.addHeaderView(viewPager);



        TextView tv1 = new TextView(this);
        tv1.setText("FooterView");
        tv1.setTextSize(50);
        lv.addFooterView(tv1);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast(String.valueOf(position));
            }
        });

    }
}
