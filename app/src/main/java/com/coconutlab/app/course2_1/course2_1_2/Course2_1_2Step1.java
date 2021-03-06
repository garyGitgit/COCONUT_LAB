package com.coconutlab.app.course2_1.course2_1_2;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.coconutlab.app.R;
import com.coconutlab.app.helper.PageHelper;
import com.coconutlab.app.helper.ViewFactoryCS;


/**
 * course 1-2 연산자
 * step 1 : 연산자 종류 설명
 */

public class Course2_1_2Step1 extends Fragment {

    View root;
    ViewFactoryCS viewFactory;

    public Course2_1_2Step1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_g_step1, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //최상단 루트 레이아웃
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.fragment_g_step1);
        viewFactory = new ViewFactoryCS(layout);

        //연산자에 대해서 설명하는 카드 생성
        LinearLayout textCard1 = viewFactory.createCard(1.0f, Color.WHITE, true, new int[]{0,0,0, PageHelper.defaultMargin});
        LinearLayout textCard2 = viewFactory.createCard(1.0f, Color.WHITE, true, new int[]{0,0,0, PageHelper.defaultMargin});
        LinearLayout textCard3 = viewFactory.createCard(1.0f, Color.WHITE, true, new int[]{0,0,0, PageHelper.defaultMargin});
        LinearLayout textCard4 = viewFactory.createCard(1.0f, Color.WHITE, true, new int[]{0,0,0, PageHelper.defaultMargin});

        //연산자에 대해서 하나씩 소개하는 simple Text 생성
        viewFactory.addSimpleText("조건문을 완성하기 위해 필요한 2가지 ", 20, textCard1);
        viewFactory.addSimpleText("1. true / false 로 판단할 수 있는 조건 ", 20, textCard2);
        viewFactory.addSimpleText("2. 조건을 만족시키면 하는 행동", 20, textCard3);
        viewFactory.addSimpleText("" +
                "만약에 '비가 온다'가 참이면\n" +
                "     우산을 쓰고 나간다\n" +
                "그렇지 않으면\n" +
                "     우산을 쓰고 나가지 않는다", 20, textCard4);



    }
}
