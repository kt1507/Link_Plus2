package com.example.linkmain.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.linkmain.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



//public class HomeFragment extends FragmentActivity implements OnMapReadyCallback {

public class HomeFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView = null;

    public HomeFragment()
    {
        // required
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_home, container, false);

        mapView = (MapView)layout.findViewById(R.id.map);
        mapView.getMapAsync(this);

        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //액티비티가 처음 생성될 때 실행되는 함수

        if(mapView != null)
        {
            mapView.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //기본위치지정(나중에현재위치로변경!)
        LatLng ojung = new LatLng(36.348518, 127.415516);
        googleMap.addMarker(new MarkerOptions().position(ojung).title("오정동").snippet("현재위치"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ojung));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17));

        //하드코딩하세영!

        LatLng jungi1 = new LatLng(36.349524, 127.414039);
        googleMap.addMarker(new MarkerOptions()
                .position(jungi1)
                .title("대일전기")
                .snippet("전기")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungi2 = new LatLng(36.354680, 127.407600);
        googleMap.addMarker(new MarkerOptions()
                .position(jungi2)
                .title("LS산전")
                .snippet("전기")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungi3 = new LatLng(36.349128,127.415073);
        googleMap.addMarker(new MarkerOptions()
                .position(jungi3)
                .title("백제종합전기")
                .snippet("전기")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungi4 = new LatLng(36.350293, 127.413880);
        googleMap.addMarker(new MarkerOptions()
                .position(jungi4)
                .title("명일전기")
                .snippet("전기")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungi5 = new LatLng(36.353716, 127.411533);
        googleMap.addMarker(new MarkerOptions()
                .position(jungi5)
                .title("상일전기")
                .snippet("전기")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng jungu1 = new LatLng(36.348720, 127.415479);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu1)
                .title("남영LED")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu2 = new LatLng(36.348465, 127.415759);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu2)
                .title("동아LED")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu3 = new LatLng(36.349777, 127.413832);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu3)
                .title("동광전기조명")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu4 = new LatLng(36.358567, 127.406740);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu4)
                .title("아리랑전기조명")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu5 = new LatLng(36.355136, 127.406996);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu5)
                .title("대경전기조명(플러스전기조명)")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu6 = new LatLng(36.354535, 127.407811);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu6)
                .title("형제종합전기조명")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu7 = new LatLng(36.352043, 127.410905);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu7)
                .title("이엘조명")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu8 = new LatLng(36.350364, 127.413069);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu8)
                .title("동양전기조명")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu9 = new LatLng(36.346700, 127.417263);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu9)
                .title("조명랜드")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu10 = new LatLng(36.354751, 127.407518);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu10)
                .title("KD전기조명")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng jungu11 = new LatLng(36.353073, 127.410024);
        googleMap.addMarker(new MarkerOptions()
                .position(jungu11)
                .title("우주전기조명")
                .snippet("조명")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng anjun1 = new LatLng(36.349353, 127.414521);
        googleMap.addMarker(new MarkerOptions()
                .position(anjun1)
                .title("나우안전(M.R.O)")
                .snippet("안전용품")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        LatLng anjun2 = new LatLng(36.354018, 127.408704);
        googleMap.addMarker(new MarkerOptions()
                .position(anjun2)
                .title("신광트렌드")
                .snippet("안전용품")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        LatLng anjun3 = new LatLng(36.352641, 127.410066);
        googleMap.addMarker(new MarkerOptions()
                .position(anjun3)
                .title("안전119산업")
                .snippet("안전용품")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        LatLng anjun4 = new LatLng(36.351803, 127.412026);
        googleMap.addMarker(new MarkerOptions()
                .position(anjun4)
                .title("부일종합물산")
                .snippet("안전용품")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        LatLng anjun5 = new LatLng(36.349044,127.414978);
        googleMap.addMarker(new MarkerOptions()
                .position(anjun5)
                .title("럭키산업안전")
                .snippet("안전용품")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

        LatLng gongu1 = new LatLng(36.349102, 127.414857);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu1)
                .title("SJ종합상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu2 = new LatLng(36.349166, 127.414195);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu2)
                .title("영신공구")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu3 = new LatLng(36.349378, 127.413925);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu3)
                .title("대선종합상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu4 = new LatLng(36.355858, 127.406221);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu4)
                .title("현대종합공구")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu5 = new LatLng(36.355298, 127.406416);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu5)
                .title("동진공구철")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu6 = new LatLng(36.354751, 127.407293);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu6)
                .title("힐티대전기업")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu7 = new LatLng(36.351156, 127.411930);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu7)
                .title("대성종합기계상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu8 = new LatLng(36.354754, 127.407496);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu8)
                .title("강산건재철물")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu9 = new LatLng(36.353176, 127.409247);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu9)
                .title("동우공구")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu10 = new LatLng(36.354441, 127.407750);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu10)
                .title("두리상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu11 = new LatLng(36.354202, 127.407906);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu11)
                .title("번영공구백화점")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu12 = new LatLng(36.351844, 127.410948);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu12)
                .title("동한상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu13 = new LatLng(36.351269, 127.412470);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu13)
                .title("금성종합상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu14 = new LatLng(36.353920, 127.408853);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu14)
                .title("금강종합상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu15 = new LatLng(36.349964,127.413610);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu15)
                .title("경보상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu16 = new LatLng(36.349424, 127.414688);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu16)
                .title("현대로프상사")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu17 = new LatLng(36.351932,127.411006);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu17)
                .title("오정공구")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu18 = new LatLng(36.352339,127.410999);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu18)
                .title("삼원공구")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu19 = new LatLng(36.354431, 127.407752);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu19)
                .title("계양전동공구")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng gongu20 = new LatLng(36.349118,127.415014);
        googleMap.addMarker(new MarkerOptions()
                .position(gongu20)
                .title("한양종합상가")
                .snippet("공구")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        LatLng pipec1 = new LatLng(36.349835,127.414082);
        googleMap.addMarker(new MarkerOptions()
                .position(pipec1)
                .title("선광자동밸브")
                .snippet("파이프")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        LatLng clmul1 = new LatLng(36.353553,127.409310);
        googleMap.addMarker(new MarkerOptions()
                .position(clmul1)
                .title("신세계철물")
                .snippet("철물")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng clgon1 = new LatLng(36.348921,127.415021);
        googleMap.addMarker(new MarkerOptions()
                .position(clgon1)
                .title("금강스틸")
                .snippet("철공예")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        LatLng clgon2 = new LatLng(36.349601,127.413819);
        googleMap.addMarker(new MarkerOptions()
                .position(clgon2)
                .title("명용접기")
                .snippet("철공예")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        LatLng clgon3 = new LatLng(36.353918, 127.408361);
        googleMap.addMarker(new MarkerOptions()
                .position(clgon3)
                .title("후지육절기/저울")
                .snippet("철공예")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        LatLng clgon4 = new LatLng(36.351906, 127.411002);
        googleMap.addMarker(new MarkerOptions()
                .position(clgon4)
                .title("광덕금속")
                .snippet("철공예")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        LatLng clgon5 = new LatLng(36.352355, 127.410422);
        googleMap.addMarker(new MarkerOptions()
                .position(clgon5)
                .title("신성철망")
                .snippet("철공예")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng tiyle1 = new LatLng(36.353241,127.409735);
        googleMap.addMarker(new MarkerOptions()
                .position(tiyle1)
                .title("로하스산업")
                .snippet("타일")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        LatLng tiyle2 = new LatLng(36.351948, 127.411834);
        googleMap.addMarker(new MarkerOptions()
                .position(tiyle2)
                .title("탑블랙세라믹")
                .snippet("타일")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng jangp1 = new LatLng(36.352298, 127.410581);
        googleMap.addMarker(new MarkerOptions()
                .position(jangp1)
                .title("신혼지업사")
                .snippet("장판")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        LatLng jangp2 = new LatLng(36.350440, 127.414290);
        googleMap.addMarker(new MarkerOptions()
                .position(jangp2)
                .title("(주)다원하우징")
                .snippet("장판")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng boilr1 = new LatLng(36.353051, 127.408939);
        googleMap.addMarker(new MarkerOptions()
                .position(boilr1)
                .title("삼우스팀보일러")
                .snippet("보일러")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        LatLng boilr2 = new LatLng(36.353567,127.410088);
        googleMap.addMarker(new MarkerOptions()
                .position(boilr2)
                .title("한빛가스상사(경동나비엔 대덕대리점)")
                .snippet("보일러")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng chnmk1 = new LatLng(36.356093, 127.405613);
        googleMap.addMarker(new MarkerOptions()
                .position(chnmk1)
                .title("우신천막사")
                .snippet("천막")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        LatLng chnmk2 = new LatLng(36.354104, 127.408950);
        googleMap.addMarker(new MarkerOptions()
                .position(chnmk2)
                .title("대한천막공사")
                .snippet("천막")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        LatLng chnmk3 = new LatLng(36.350235, 127.414021);
        googleMap.addMarker(new MarkerOptions()
                .position(chnmk3)
                .title("신창천막사")
                .snippet("천막")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        LatLng dackt1 = new LatLng(36.354914, 127.407204);
        googleMap.addMarker(new MarkerOptions()
                .position(dackt1)
                .title("화신공조상사")
                .snippet("닥트")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng dackt2 = new LatLng(36.348880,127.415125);
        googleMap.addMarker(new MarkerOptions()
                .position(dackt2)
                .title("신도공조닥트")
                .snippet("닥트")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng jinel1 = new LatLng(36.354630, 127.407719);
        googleMap.addMarker(new MarkerOptions()
                .position(jinel1)
                .title("우신앵글진열장")
                .snippet("진열대")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng gapan1 = new LatLng(36.349729, 127.414080);
        googleMap.addMarker(new MarkerOptions()
                .position(gapan1)
                .title("영락인쇄")
                .snippet("간판")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng gapan2 = new LatLng(36.350309,127.413466);
        googleMap.addMarker(new MarkerOptions()
                .position(gapan2)
                .title("중부도장")
                .snippet("간판")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng gapan3 = new LatLng(36.349259, 127.414920);
        googleMap.addMarker(new MarkerOptions()
                .position(gapan3)
                .title("미래사")
                .snippet("간판")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        LatLng paint1 = new LatLng(36.349975,127.413764);
        googleMap.addMarker(new MarkerOptions()
                .position(paint1)
                .title("제비표페인트")
                .snippet("페인트")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        LatLng paint2 = new LatLng(36.350471, 127.413578);
        googleMap.addMarker(new MarkerOptions()
                .position(paint2)
                .title("페인트마트")
                .snippet("페인트")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        LatLng pojan1 = new LatLng(36.351844, 127.410948);
        googleMap.addMarker(new MarkerOptions()
                .position(pojan1)
                .title("맥스본드")
                .snippet("포장/접착")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        LatLng pojan2 = new LatLng(36.350537, 127.413524);
        googleMap.addMarker(new MarkerOptions()
                .position(pojan2)
                .title("아주접착테프")
                .snippet("포장/접착")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        LatLng pojan3 = new LatLng(36.349540, 127.414772);
        googleMap.addMarker(new MarkerOptions()
                .position(pojan3)
                .title("보성테이프")
                .snippet("포장/접착")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        LatLng carfo1 = new LatLng(36.348799, 127.415232);
        googleMap.addMarker(new MarkerOptions()
                .position(carfo1)
                .title("양지타이어")
                .snippet("자동차용품")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng drive1 = new LatLng(36.353894, 127.408893);
        googleMap.addMarker(new MarkerOptions()
                .position(drive1)
                .title("신성산업공사")
                .snippet("운반기기")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        LatLng motor1 = new LatLng(36.352763, 127.409635);
        googleMap.addMarker(new MarkerOptions()
                .position(motor1)
                .title("광명전기공조")
                .snippet("모터펌프")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
    }

}
