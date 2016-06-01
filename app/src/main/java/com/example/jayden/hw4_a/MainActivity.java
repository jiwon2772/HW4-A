package com.example.jayden.hw4_a;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뾱뾱이 객체 선언
        final Aircap caps[] = {new Aircap(), new Aircap(), new Aircap(), new Aircap(),new Aircap(), new Aircap(), new Aircap(), new Aircap(),
                new Aircap(), new Aircap(), new Aircap(), new Aircap(),new Aircap(), new Aircap(), new Aircap(), new Aircap(),
                new Aircap(), new Aircap(), new Aircap(), new Aircap(),new Aircap(), new Aircap(), new Aircap(), new Aircap(),
                new Aircap(), new Aircap(), new Aircap(), new Aircap(),new Aircap(), new Aircap(), new Aircap(), new Aircap(),
                new Aircap(), new Aircap(), new Aircap(), new Aircap(),new Aircap(), new Aircap(), new Aircap(), new Aircap(),
                new Aircap(), new Aircap()};

        // 커스텀 아답타 생성
        final MyAdapter adapter = new MyAdapter (getApplicationContext(), R.layout.row, caps);    // 데이터

        GridView gv = (GridView)findViewById(R.id.gridView);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

        // GridView 아이템을 클릭하면 상단 텍스트뷰에 position 출력
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 각 이미지를 클릭하면 변경된 상태로 바꾸어줌
                if(caps[position].state == true) {
                    caps[position].state = false;
                }
                else {
                    caps[position].state = true;
                }
                adapter.notifyDataSetChanged(); //상태가 변경되었다고 알려준다. [갱신]
            }
        });

    }
    public class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        Aircap aircaps[];
        LayoutInflater inf;
        int img[] = { R.drawable.aircap2, R.drawable.aircap1};

        public MyAdapter(Context context, int layout, Aircap[] caps) {
            this.context = context;
            this.layout = layout;
            this.aircaps = caps;
            inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return aircaps.length;
        }

        @Override
        public Object getItem(int position) {
            return aircaps[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null)
                convertView = inf.inflate(layout, null);
            ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
            // 현재 상태에 맞는 이미지로 바꾸어준다.
            if( ((Aircap)getItem(position)).state == true ) {
                iv.setImageResource(img[1]);
            }
            else {
                iv.setImageResource(img[0]);
            }

            return convertView;
        }
    }
}


