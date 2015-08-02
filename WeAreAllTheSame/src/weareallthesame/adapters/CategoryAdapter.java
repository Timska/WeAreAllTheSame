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

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			// if it's not recycled, initialize some attributes
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(170, 170));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

		System.out.println(listCategories.get(position).getResourceName());
		int resourceId = context.getResources().getIdentifier(listCategories.get(position).getResourceName(), "drawable", context.getPackageName());
		System.out.println(resourceId);
		imageView.setImageResource(resourceId);
		return imageView;
	}

}
