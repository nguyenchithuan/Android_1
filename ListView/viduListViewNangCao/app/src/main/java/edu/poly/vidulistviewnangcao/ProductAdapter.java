package edu.poly.vidulistviewnangcao;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    // được dùng để gửi dữ liệu lên đến adapter và sau đó từ dữ liệu adapter gửi lên listview để hiển thị
    // baseAdapter giống nhữ adapter thường được dùng  khác như ArrayAdapter
    ArrayList<Product> listProduct;

    //tạo hàm khởi tạo
    public ProductAdapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() { // trả về số lượng sản phẩm trong danh sách
        return listProduct.size();
    }

    @Override
    public Object getItem(int i) { // trả về 1 phần tử tại vị trí thứ i trong danh sách
        Product objProduct = listProduct.get(i);
        return objProduct;
    }

    @Override
    public long getItemId(int i) { // trả về ID của sản phẩm, không phải số thứ tự
        Product objProduct = listProduct.get(i);
        return objProduct.id;
    }

    // i là số thứ tự
    // khi chưa có biến view thì view là null, nếu có biến view thì nó sẽ sử dụng lại
    // viewgroup là chứa dữ liệu của dung này
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { // phần này quan trọng // trả về view là 1 dòng
        // nếu view == null tức là chưa có thì ta phải tạo ra view == View.inflate();
        // còn nếu người ta chuyền view vào thì ta sẽ lấy cái view ý
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.item_row_listview_product, null);
            // khở tạo layout cho 1 dòng
        }

        // ánh xạ các view
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_price = view.findViewById(R.id.tv_price);
        ImageView img = view.findViewById(R.id.img_product);

        // lấy đối tượng sản phẩm
        Product objProduct = listProduct.get(i);

        // gán dữ liệu
        tv_name.setText(objProduct.name);
        tv_price.setText(objProduct.price + "");
        img.setImageResource(objProduct.img_res);

        // trả về view dòng
        return view;
    }
}
