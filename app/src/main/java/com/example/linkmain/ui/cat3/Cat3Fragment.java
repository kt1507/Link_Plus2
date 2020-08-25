package com.example.linkmain.ui.cat3;

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

public class Cat3Fragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView = null;

    public Cat3Fragment()
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


    }

}
