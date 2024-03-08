package hcmute.edu.vn.baitaptuan06_21110282_customadapter_gridview;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CustomAdapterGridViewActivityActivity extends AppCompatActivity {
    // Khai báo
    GridView gridView;
    ArrayList<MonHoc> arrayList;
    EditText editText1;
    Button btnNhap;
    Button btnCapnhat;
    MonHocAdapter adapter;

    private void AnhXa() {
        gridView = (GridView) findViewById(R.id.gridview1);
        editText1 = (EditText) findViewById(R.id.editText1);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnCapnhat = (Button) findViewById(R.id.btnCapNhat);
        // Thêm dữ liệu vào List
        arrayList = new ArrayList<MonHoc>();
        arrayList.add(new MonHoc("Java","Java 1",R.drawable.java1));
        arrayList.add(new MonHoc("C#","C# 1",R.drawable.csharp));
        arrayList.add(new MonHoc("PHP","PHP 1",R.drawable.php));
        arrayList.add(new MonHoc("Kotlin","Kotlin 1",R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart","Dart 1",R.drawable.dart));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bỏ title của android
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_custom_adapter_grid_view_activity);

        // Ánh xạ
        AnhXa();
        // Tạo Adapter
        adapter = new MonHocAdapter(CustomAdapterGridViewActivityActivity.this, R.layout.row_monhoc, arrayList);
        // truyền dữ liệu từ adapter ra listview
        gridView.setAdapter(adapter);
    }
}