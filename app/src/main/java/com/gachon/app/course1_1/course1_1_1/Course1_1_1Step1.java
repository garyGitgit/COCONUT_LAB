package com.gachon.app.course1_1.course1_1_1;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gachon.app.R;
import com.gachon.app.helper.MainPagerAdapter;
import com.gachon.app.helper.PageHelper;
import com.gachon.app.helper.ViewFactoryCS;


/**
 * course 1-1 데이터 타입 / 변수 / 초기화
 * step 1 : 신발장을 통한 비유
 */
public class Course1_1_1Step1 extends Fragment {
    //항상 추가
    View root; // 부모 액티비티
    ViewFactoryCS viewFactory;

    //layout
    FrameLayout[] textCard = new FrameLayout[3];
    RelativeLayout[] cardCover = new RelativeLayout[3];

    // Required empty public constructor
    public Course1_1_1Step1() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //항상 추가
        root = inflater.inflate(R.layout.fragment_g_step1, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //cardcover 로딩

        //최상단 루트 레이아웃
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.fragment_g_step1);
        viewFactory = new ViewFactoryCS(layout);

        //space 추가
//        viewFactory.addSpace(0.5f);

        //animation card 생성
        FrameLayout animCard = viewFactory.createCard(3.0f, new int[]{0,0,0,PageHelper.defaultMargin});

        //viewpager card 생성
//        FrameLayout slideCard = viewFactory.createCard(1.0f, new int[]{0,0,0,PageHelper.defaultMargin});

        //final AutoResizeTextView autoResizeTextView = (AutoResizeTextView)viewFactory.createWidget("TextView", new String[] {"1"});

//        LinearLayout slideCard_linear = (LinearLayout)getActivity().getLayoutInflater().inflate(R.layout.slidecard, null);
//        MyViewPager viewPager = (MyViewPager) slideCard_linear.findViewById(R.id.slideCard_viewPager);

        //MainPagerAdapter pagerAdapter = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,0}, viewPager, slideCard_linear);
        //MyViewPager viewPager = new MyViewPager(getContext());
        final ViewPager viewPager = new ViewPager(getContext());
        viewPager.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        MainPagerAdapter pagerAdapter = viewFactory.createSlideCard(1.0f, new int[]{0,0,0,0}, viewPager);

        Activity parentActivity = getActivity();
        viewFactory.addCardOnSlideCard("변수란\n값을 저장하기 위한 공간이다. (신발장 공간)", pagerAdapter,parentActivity);
        viewFactory.addCardOnSlideCard("변수의 데이터 타입\n변수를 사용하기 위한 목적이다. 데이터 타입은 공간의 목적에 따라 다르다. (신발장의 목적 : 신발을 담기 위함)", pagerAdapter, parentActivity);
        viewFactory.addCardOnSlideCard("변수의 선언\n변수를 사용하겠다고 이름과 데이터 타입을 정의하는 것. (나는 신발장을 담기 위한 공간을 마련할거야.)", pagerAdapter, parentActivity);
        viewFactory.addCardOnSlideCard("다음", pagerAdapter, parentActivity);
//        viewFactory.addNextCard(slideCard, getActivity()); //다음페이지로 넘어가는 카드 추가
//        viewFactory.addText("변수의 선언\n변수를 사용하겠다고 이름과 데이터 타입을 정의하는 것. (나는 신발장을 담기 위한 공간을 마련할거야.)", slideCard);
//        viewFactory.addText("변수의 데이터 타입\n변수를 사용하기 위한 목적이다. 데이터 타입은 공간의 목적에 따라 다르다. (신발장의 목적 : 신발을 담기 위함)", slideCard);
//        viewFactory.addText("변수란\n값을 저장하기 위한 공간이다. (신발장 공간)", slideCard);

        //space 추가
        viewFactory.addSpace(0.5f);

        //image button
        ImageButton goNext = (ImageButton)root.findViewById(R.id.goNext);
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisPage = viewPager.getCurrentItem();
                int pageNum = 3;

                if (thisPage < pageNum-1) {
                    viewPager.setCurrentItem(++thisPage);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "next", Toast.LENGTH_SHORT).show();
                    ViewFactoryCS.onGoNext onGoNext = (ViewFactoryCS.onGoNext)getActivity();
                    onGoNext.onPressNext();
                }
            }
        });

        ImageButton goPrev= (ImageButton)root.findViewById(R.id.goPrevious);
        goPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisPage = viewPager.getCurrentItem();

                if (thisPage > 0) {
                    viewPager.setCurrentItem(--thisPage);
                }
                else{
                    ViewFactoryCS.onGoPrevious onGoPrev= (ViewFactoryCS.onGoPrevious)getActivity();
                    onGoPrev.onPressPrev();
                }

            }
        });


        //이해를 돕는 이미지 카드 생성
//        LinearLayout imageCard = viewFactory.createCard(0.0f, Color.WHITE, true, new int[]{0,0,0, PageHelper.defaultMargin});
//        viewFactory.addImage(100, 100, getResources().getDrawable(R.drawable.shoebox), imageCard);


//        //카드 생성
//        for(int i = 0 ; i < 3; i++){
//            textCard[i] = viewFactory.createCard(1.0f, new int[]{0,0,0, PageHelper.defaultMargin});
//        }
//
//        //텍스트 추가
//        viewFactory.addSimpleText("" +
//                "변수란\n" +
//                "값을 저장하기 위한 공간이다. (신발장 공간)", 20, textCard[0]);
//
//        viewFactory.addSimpleText("" +
//                "변수의 데이터 타입\n" +
//                "변수를 사용하기 위한 목적이다. 데이터 타입은 공간의 목적에 따라 다르다. (신발장의 목적 : 신발을 담기 위함)", 20, textCard[1]);
//
//        viewFactory.addSimpleText("" +
//                "변수의 선언\n" +
//                "변수를 사용하겠다고 이름과 데이터 타입을 정의하는 것. (나는 신발장을 담기 위한 공간을 마련할거야.)", 20, textCard[2]);
//
//        //카드 추가, 카드로 덮기
//        LayoutInflater inflater = (LayoutInflater)root.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//

//        for(int i = 0 ; i < 3; i++){
//            //card 커버 로드
//            cardCover[i] = new RelativeLayout(getContext());
//            inflater.inflate(R.layout.cardcover, cardCover[i]);
//            //카드 눌렀을 때 카드 사라지기
//            textCard[i].setTag(i);
//            textCard[i].setOnClickListener(new onCardClicked());
//            //card 로 덮기
//            textCard[i].addView(cardCover[i]);
//        }

    }
    class onCardClicked implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int tag = ((Integer)v.getTag());
            switch (tag){
                case 0:
                    YoYo.with(Techniques.FadeOut).duration(PageHelper.cardOpenDelay).playOn(cardCover[0]);
                    break;
                case 1:
                    YoYo.with(Techniques.FadeOut).duration(PageHelper.cardOpenDelay).playOn(cardCover[1]);
                    break;
                case 2:
                    YoYo.with(Techniques.FadeOut).duration(PageHelper.cardOpenDelay).playOn(cardCover[2]);
                    break;
            }
        }
    }
}
