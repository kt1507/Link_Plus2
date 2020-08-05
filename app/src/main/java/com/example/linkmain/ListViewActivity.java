package com.example.linkmain;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {

    private ListView listview;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        //Adapter 생성
        adapter = new ListViewAdapter();

        //리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        //adapter를 통해 자료 추가
        adapter.addItem("야무진", "042-638-0689~90", "8:30~17:30", "주차 가능 여부 : X", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("대남기공사","042-626-4880","07:00~18:00","주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("세종종합상사","042-635-6040","07:00~19:00","주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("샘 광고 레이저","042-632-4445,631-0907","08:00~18:00", "주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("명창종합상사","042-626-9240","07:00~19:00","주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));
        adapter.addItem("케이투발전기(주)","042-673-9400","08:00~18:30","주차 가능 여부 : O", getResources().getDrawable(R.mipmap.ic_launcher));

        adapter.notifyDataSetChanged(); //어댑터의 변경을 알림

    }
}
