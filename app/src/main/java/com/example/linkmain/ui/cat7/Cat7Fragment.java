package com.example.linkmain.ui.cat7;

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

public class Cat7Fragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView = null;

    public Cat7Fragment()
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
    }

}
