package com.example.linkmain;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
//        getSupportActionBar().hide();

        TextView store_nameTextView = (TextView)findViewById(R.id.store_name);
        TextView phoneTextView = (TextView)findViewById(R.id.phone);
        TextView timeTextView = (TextView)findViewById(R.id.time);
        TextView parkingTextView = (TextView)findViewById(R.id.parking);
        ImageButton back_btn = (ImageButton)findViewById(R.id.info_back_btn);

        Intent intent = getIntent();

        store_nameTextView.setText((String)intent.getExtras().get("store_name"));
        phoneTextView.setText((String)intent.getExtras().get("phone"));
        timeTextView.setText((String)intent.getExtras().get("time"));
        parkingTextView.setText((String)intent.getExtras().get("parking"));

        //Adapter 생성
        adapter = new StoreInfoAdapter();

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.product_listview);
        listview.setAdapter(adapter);

        //adapter를 통해 자료 추가
        adapter.addItem("물품01","10,000원");
        adapter.addItem("물품02","20,000원");

        adapter.notifyDataSetChanged(); //어댑터의 변경을 알림
    }
}
