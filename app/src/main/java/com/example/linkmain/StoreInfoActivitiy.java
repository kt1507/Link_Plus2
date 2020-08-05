package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class StoreInfoActivitiy extends AppCompatActivity {

    private ListView listview;
    private StoreInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_info);

        TextView store_nameTextView = (TextView)findViewById(R.id.store_name);
        TextView phoneTextView = (TextView)findViewById(R.id.phone);
        TextView timeTextView = (TextView)findViewById(R.id.time);
        TextView parkingTextView = (TextView)findViewById(R.id.parking);

        Intent intent = getIntent();

        store_nameTextView.setText((String)intent.getExtras().get("store_name"));
        phoneTextView.setText((String)intent.getExtras().get("phone"));
        timeTextView.setText((String)intent.getExtras().get("time"));
        parkingTextView.setText((String)intent.getExtras().get("parking"));

        //Adapter 생성
        adapter = new StoreInfoAdapter();

        //리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.product_listview);
        listview.setAdapter(adapter);

        //adapter를 통해 자료 추가
        adapter.addItem("물품01","10,000원");
        adapter.addItem("물품02","20,000원");

        adapter.notifyDataSetChanged(); //어댑터의 변경을 알림
    }
}
