package hcmute.edu.vn.baitaptuan06_21110282_customadapter_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonHocAdapter extends BaseAdapter {
    // Khai báo
    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    // Tạo Constructors
    public MonHocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.context= context;
        this.layout= layout;
        this.monHocList= monHocList;
    }

    // Trả về số dòng
    @Override
    public int getCount() {
        return monHocList.size(); // Lấy kích thước monHoclist
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Lấy context
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Gọi view chứa layout
        view = inflater.inflate(layout,null);
        // Ánh xạ view
        TextView textName = (TextView) view.findViewById(R.id.textName);
        TextView textDesc = (TextView)  view.findViewById(R.id.textDesc);
        ImageView imagePic = (ImageView) view.findViewById(R.id.imagePic);

        // Khởi tạo viewHolder
        ViewHolder viewHolder;
        // Lấy context
        if (view == null){
            inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Gọi view chứa layout
            view = inflater.inflate(layout,null);
            // Ánh xạ view
            viewHolder = new ViewHolder();
            viewHolder.textName = (TextView) view.findViewById(R.id.textName);
            viewHolder.textDesc = (TextView)  view.findViewById(R.id.textDesc);
            viewHolder.imagePic = (ImageView) view.findViewById(R.id.imagePic);
            view.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) view.getTag();
        }

        // Gán giá trị
        MonHoc monHoc = monHocList.get(i);
        textName.setText(monHoc.getName());
        textDesc.setText(monHoc.getDesc());
        imagePic.setImageResource(monHoc.getPic());

        // Trả về view
        return view;
    }

    // Tạo class viewholder
    private class ViewHolder{
        TextView textName,textDesc;
        ImageView imagePic;
    }
}
