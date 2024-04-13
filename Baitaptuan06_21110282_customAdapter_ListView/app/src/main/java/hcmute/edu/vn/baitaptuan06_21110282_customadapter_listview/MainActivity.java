package hcmute.edu.vn.baitaptuan06_21110282_customadapter_listview;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Khai báo
    ListView listView;
    ArrayList<String> arrayList;
    EditText editText1;
    Button btnNhap;
    Button btnCapnhat;
    Button btnXoa;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bỏ title của android
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        listView= (ListView) findViewById(R.id.listview1);
        editText1 = (EditText) findViewById(R.id.editText1);
        btnNhap= (Button) findViewById(R.id.btnNhap);
        btnCapnhat = (Button) findViewById(R.id.btnCapNhat);
        btnXoa = (Button) findViewById(R.id.btnXoa);

        // Thêm dữ liệu vào List
        arrayList= new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");

        //Tạo ArrayAdapter
        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayList);

        // Truyền dữ liệu từ adapter ra listview
        listView.setAdapter(adapter);

        // Bắt sự kiện click nhanh trên từng dòng của Listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Code yêu cầu
                // i: trả về vị trí click chuột trên ListView-> i ban đầu = 0
                Toast.makeText(MainActivity.this,""+i,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Bắt sự kiện click giữ trên từng dòng của Listview
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean
            onItemLongClick(AdapterView<?> adapterView,
                            View view, int i, long l) {
                // Code yêu cầu
                // i: trả về vị trí click chuột trên ListView-> i ban đầu = 0
                Toast.makeText(MainActivity.this,"Bạn đang nhấn giữ " + i + " - " + arrayList.get(i),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Bắt sự kiện click nút thêm
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                if (!name.isEmpty()) {
                    arrayList.add(name);
                    adapter.notifyDataSetChanged();

                    editText1.setText("");
                }
            }
        });

        // Bắt sự kiện trên từng dòng của Listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Lấy nội dung đưa lên editText
                editText1.setText(arrayList.get(i));
                vitri= i;
            }
        });

        // Bắt sự kiện click nút cập nhật
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri != -1) {
                    arrayList.set(vitri, editText1.getText().toString());
                    adapter.notifyDataSetChanged();

                    vitri = -1;
                    editText1.setText("");
                }
            }
        });

        // Bắt sự kiện click nút xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri != -1) {
                    arrayList.remove(vitri);
                    adapter.notifyDataSetChanged();

                    vitri = -1;
                    editText1.setText("");
                }
            }
        });
    }
}