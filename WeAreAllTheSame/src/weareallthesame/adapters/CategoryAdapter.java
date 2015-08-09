package weareallthesame.adapters;

import java.util.List;

import weareallthesame.model.categories.AbstractCategory;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CategoryAdapter extends BaseAdapter {

	private Context context;
	public static List<AbstractCategory> listCategories;

	public CategoryAdapter(Context c, List<AbstractCategory> categories) {
		context = c;
		listCategories = categories;
		System.out.println("Categories Adapter constructor");
		System.out.println(getCount());
	}

	public int getCount() {
		return listCategories.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		GridView grid = (GridView) parent;
		int size = grid.getColumnWidth();
		
		if (convertView == null) {
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(size, size));
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setPadding(10, 10, 10, 10);
		} else {
			imageView = (ImageView) convertView;
		}

		System.out.println(listCategories.get(position).getResourceName());
		int resourceId = context.getResources().getIdentifier(listCategories.get(position).getResourceName(), "drawable", context.getPackageName());
		imageView.setImageResource(resourceId);
		return imageView;
	}

}
