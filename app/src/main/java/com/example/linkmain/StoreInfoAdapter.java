package com.example.linkmain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StoreInfoAdapter extends BaseAdapter {

    private TextView product_nameTextView;
    private TextView product_priceTextView;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<StoreInfoItem> StoreInfoItemList = new ArrayList<StoreInfoItem>();

    //StoreInfoAdapter의 생성자
    public StoreInfoAdapter(){
    }

    //Adapter에 사용되는 데이터의 개수를 리턴
    @Override
    public int getCount(){
        return StoreInfoItemList.size();
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //"listview_item" Layout 을 inflate하여 convertView 참조 획득
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.store_info_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        product_nameTextView = (TextView) convertView.findViewById(R.id.product_name);
        product_priceTextView = (TextView) convertView.findViewById(R.id.product_price);
        final StoreInfoItem listViewItem = StoreInfoItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        product_nameTextView.setText(listViewItem.getProductName());
        product_priceTextView.setText(listViewItem.getProductPrice());

        return convertView;
    }//getView

    //지정한 위치(position)에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return StoreInfoItemList.get(position);
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(String product_name, String product_price){
        StoreInfoItem item = new StoreInfoItem();

        item.setName(product_name);
        item.setPrice(product_price);

        StoreInfoItemList.add(item);
    }

}
