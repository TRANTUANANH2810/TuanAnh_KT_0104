package com.example.kiemtra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class listView extends AppCompatActivity {
    ListView lvta;
    ArrayList<ThucAn> arrayThucan;
    ThucanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        AnhXa();
        adapter = new ThucanAdapter(this, R.layout.layout_listview, arrayThucan);
        lvta.setAdapter(adapter);
        lvta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThucAn ta = arrayThucan.get(i);
                doOpenMainActivity2(ta.getTen(), ta.getMota(), ta.getHinh());
            }
        });
        lvta.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);

                return false;
            }
        });

    }

    private void AnhXa() {
        lvta = (android.widget.ListView) findViewById(R.id.lvThucan);
        arrayThucan = new ArrayList<>();
        arrayThucan.add(new ThucAn("Cây Si(Gừa) ", "Gừa[2] hay còn gọi Si \nquả nhỏ,[3][4]  (danh pháp \n khoa học: Ficus microcarpa) là\n một loài thực vật \ncó hoa trong họ Dâu\n tằm (Moraceae). \nĐây là loài có thân\n gỗ, cao 15-20 m, \ncó rễ phụ mọc ra từ\n thân và các cành trên\n cao", R.drawable.caysi));
        arrayThucan.add(new ThucAn("Cây long Não", "Long não hay còn \ngọi là dã hương\n (danh pháp hai phần:\n Cinnamomum camphora) là một\n loại cây thân gỗ,\n lớn và thường xanh,\n có thể cao tới 20–30 m.\n Các lá nhẵn và bóng, \nbề mặt như sáp và \ncó mùi long não khi bị\n vò nát trong tay. \nVề mùa xuân nó sinh ra\n các lá màu xanh lục nhạt\n với nhiều hoa nhỏ màu\n trắng. ", R.drawable.longnao));
        arrayThucan.add(new ThucAn("Cây Đa", "Cây đa (tên khác: cây đa đa, dây hải sơn, \ncây dong, cây da)\n có danh pháp hai phần \n(theo Bailey năm 1976) \nlà Ficus bengalensis, \nmột loài cây thuộc\n họ Dâu tằm (Moraceae),\n nó có thể phát triển\n thành loài cây\n khổng lồ mà tán của\n nó che phủ đến \nmột vài nghìn mét vuông.", R.drawable.cayda));
        arrayThucan.add(new ThucAn("Cây bàng", "Bàng (danh pháp hai phần:\n Terminalia catappa) là một loài \ncây thân gỗ lớn sinh sống chủ \nyếu ở vùng nhiệt đới, thuộc họ Trâm\n bầu (Combretaceae).Loài cây này có \nthể mọc cao tới 35 m, với \ntán lá mọc thẳng, đối xứng \nvà các cành nằm ngang.\n Khi cây già hơn thì tán \nlá của nó trở nên phẳng \nhơn để tạo thành hình\n dáng giống như cái bát \ntrải rộng.", R.drawable.caybang));

    }

    private void XacNhanXoa(final int position) {

        AlertDialog.Builder alerDiaLog = new AlertDialog.Builder(this);
        alerDiaLog.setTitle("Thong bao !");
        alerDiaLog.setIcon(R.mipmap.ic_launcher);
        alerDiaLog.setMessage("Bạn có muốn xóa hay không?");

        alerDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                arrayThucan.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
        alerDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alerDiaLog.show();
    }

    public void doOpenMainActivity2(String title, String des, int image) {
        Intent myIntent;
        myIntent = new Intent(this, Chuyentrang.class);
        myIntent.putExtra("title", title);
        myIntent.putExtra("image", image);
        myIntent.putExtra("des", des);
        startActivity(myIntent);
    }
}