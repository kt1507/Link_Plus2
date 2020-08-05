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

        LatLng car1 = new LatLng(36.348976, 127.415158);
        googleMap.addMarker(new MarkerOptions()
                .position(car1)
                .title("금호타이어")
                .snippet("자동차/타이어")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.car))
                    );
        LatLng car2 = new LatLng(36.349007, 127.415664);
        googleMap.addMarker(new MarkerOptions()
                .position(car2)
                .title("오정자동차")
                .snippet("자동차/정비")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.car)));
        LatLng sigong1 = new LatLng(36.348682, 127.414422);
        googleMap.addMarker(new MarkerOptions()
                .position(sigong1)
                .title("한남시공사")
                .snippet("시공/창문/샷시")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.topnie)));
        LatLng jungi1 = new LatLng(36.348976, 127.415158);
        googleMap.addMarker(new MarkerOptions()
                .position(jungi1)
                .title("에스디산전")
                .snippet("전기/전구/형광등")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lightbulb)));
        LatLng jungi2 = new LatLng(36.348651, 127.416079);
        googleMap.addMarker(new MarkerOptions()
                .position(jungi2)
                .title("전자마트")
                .snippet("전기/전자제품")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lightbulb)));
        LatLng bosu1 = new LatLng(36.347744, 127.415547);
        googleMap.addMarker(new MarkerOptions()
                .position(bosu1)
                .title("오정서비스센터")
                .snippet("보수/전자제품")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bosu)));
        LatLng gonggu1 = new LatLng(36.348490, 127.416428);
        googleMap.addMarker(new MarkerOptions()
                .position(gonggu1)
                .title("오정공구")
                .snippet("공구/부품")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.spanner)));
    }

}
