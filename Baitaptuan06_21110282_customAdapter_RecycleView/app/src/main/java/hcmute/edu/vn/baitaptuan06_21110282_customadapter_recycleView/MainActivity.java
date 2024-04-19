package hcmute.edu.vn.baitaptuan06_21110282_customadapter_recycleView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<SongModel> mSongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvSongs= (RecyclerView)findViewById(R.id.rv_songs);

        mSongs= new ArrayList<>();
        mSongs.add(new SongModel("50696", "Nếu em còn tồn tại", "Khi anh bắt đầu một tình yêu là lúc anh tự thấy ...", "Trịnh Đình Quang"));

        mSongs.add(new SongModel("50781", "NGOC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new SongModel("50658","TÌNH YÊU CHẤP VÁN","Muốn đi xa nơi yêu thương mình từng có Để không nghe", "Mr. Siro"));
        mSongs.add(new SongModel("56688", "CHỜ NGÀY MƯA TAN", "1 ngày mưa và en khuất xa nơi anh bóng dáng cử", "Trung Đức"));
        mSongs.add(new SongModel ("58728","QUA ĐI LẶNG LẼ", "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi", "Phan Mạnh Quỳnh"));
        mSongs.add(new SongModel ("58856", "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ REMIX", "Cần thân bao lâu để em quên đi niền đâu Cần thêm", "Thiện Ngôn"));
        mSongAdapter =new SongAdapter (this, mSongs);
        rvSongs.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, LinearLayoutManager. VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);
    }
}
