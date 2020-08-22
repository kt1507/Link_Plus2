package com.example.linkmain.ui.cat4;

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

public class Cat4Fragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView = null;

    public Cat4Fragment()
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


    }

}
