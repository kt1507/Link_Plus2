package com.example.linkmain.ui.cat1;

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

public class Cat1Fragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView = null;

    public Cat1Fragment()
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


    }

}
