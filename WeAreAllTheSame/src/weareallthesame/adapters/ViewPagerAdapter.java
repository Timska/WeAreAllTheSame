package weareallthesame.adapters;

import java.util.List;

import weareallthesame.model.categories.AbstractCategory;
import weareallthesame.view.R;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {

	private List<AbstractCategory> categories;
	private Context context;
	private LayoutInflater inflater;
	
	public ViewPagerAdapter(Context context, List<AbstractCategory> categories) {
		this.context = context;
		this.categories = categories;
	}
	
	@Override
	public int getCount() {
		return categories.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == (RelativeLayout) object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position){
		TextView txtName;
		ImageView imgCategory;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpager_item, container, false);
		
		txtName = (TextView) itemView.findViewById(R.id.category_name);
		txtName.setText(categories.get(position).getName());
		
		imgCategory = (ImageView) itemView.findViewById(R.id.category_image);
		imgCategory.setImageResource(context.getResources().getIdentifier(categories.get(position).getResourceName(), "drawable", context.getPackageName()));
		
		((ViewPager) container).addView(itemView);
		
		return itemView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object){
		((ViewPager) container).removeView((RelativeLayout) object);
	}
}
