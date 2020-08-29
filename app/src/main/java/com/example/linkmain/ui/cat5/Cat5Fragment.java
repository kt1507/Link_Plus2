package com.example.linkmain.ui.cat5;

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

public class Cat5Fragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView = null;

    public Cat5Fragment()
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
    }

}
