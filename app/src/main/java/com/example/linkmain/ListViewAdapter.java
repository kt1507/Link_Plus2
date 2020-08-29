package com.example.linkmain;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    //private ImageView iconImageView;
    private TextView store_nameTextView;
    private TextView phoneTextView;
    private TextView timeTextView;
    private TextView categoryTextView;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    //ListviewAdapter의 생성자
    public ListViewAdapter(){
    }

    //Adapter에 사용되는 데이터의 개수를 리턴
    @Override
    public int getCount(){
        return listViewItemList.size();
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //"listview_item" Layout 을 inflate하여 convertView 참조 획득
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        store_nameTextView = (TextView) convertView.findViewById(R.id.store_name);
        phoneTextView = (TextView) convertView.findViewById(R.id.phone);
        timeTextView = (TextView) convertView.findViewById(R.id.time);
        categoryTextView = (TextView) convertView.findViewById(R.id.category);
        //iconImageView = (ImageView) convertView.findViewById(R.id.image);

        final ListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        store_nameTextView.setText(listViewItem.getStoreName());
        phoneTextView.setText(listViewItem.getPhone());
        timeTextView.setText(listViewItem.getTime());
        categoryTextView.setText(listViewItem.getCategoryStr());
        //iconImageView.setImageDrawable(listViewItem.getIcon());
      
        LinearLayout listview = (LinearLayout)convertView.findViewById(R.id.shapeLayout);
        listview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), StoreInfoActivitiy.class);
                intent.putExtra("store_name", listViewItemList.get(pos).getStoreName());
                intent.putExtra("phone",listViewItemList.get(pos).getPhone());
                intent.putExtra("time",listViewItemList.get(pos).getTime());
                intent.putExtra("parking",listViewItemList.get(pos).getParking());
                intent.putExtra("store_picture",listViewItemList.get(pos).getStorepicture());

                context.startActivity(intent);
            }
        });


        return convertView;
    }//getView

    //지정한 위치(position)에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(String store_name, String phone, String time, String category, int parking, int storepicture){
        ListViewItem item = new ListViewItem();

        item.setStoreName(store_name);
        item.setPhone(phone);
        item.setTime(time);
        item.setCategoryStr(category);
        item.setParking(parking);
        item.setStorepicture(storepicture);
        //item.setIcon(icon);
      
        listViewItemList.add(item);
    }

}
