package weareallthesame.adapters;

import java.util.List;

import weareallthesame.model.ApplicationInterface;
import weareallthesame.model.categories.AbstractCategory;
import weareallthesame.model.exceptions.CategoryDoesNotExistException;
import weareallthesame.view.GameActivity;
import weareallthesame.view.PagerActivity;
import weareallthesame.view.R;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {

	private List<AbstractCategory> categories;
	private Context context;
	private LayoutInflater inflater;
	private ApplicationInterface appInterface;
	
	public ViewPagerAdapter(Context context, List<AbstractCategory> categories, ApplicationInterface appInterface) {
		this.context = context;
		this.categories = categories;
		this.appInterface = appInterface;
	}
	
	@Override
	public int getCount() {
		return categories.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == (LinearLayout) object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position){
		TextView txtName;
		ImageView imgCategory;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpager_item, container, false);
		
		itemView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((PagerActivity) context).finish();
			}
		});
		
		txtName = (TextView) itemView.findViewById(R.id.category_name);
		@SuppressWarnings("deprecation")
		int screenHeight = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
		float textSize = (float) (screenHeight / 30.0);
		System.out.println(screenHeight + ", " + textSize);
		txtName.setTextSize(textSize);
		txtName.setText(categories.get(position).getName());
		
		imgCategory = (ImageView) itemView.findViewById(R.id.category_image);
		imgCategory.setImageResource(context.getResources().getIdentifier(categories.get(position).getResourceName(), "drawable", context.getPackageName()));
		final int itemIndex = position;
		imgCategory.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, GameActivity.class);
				try {
					appInterface.openCategory(categories.get(itemIndex).getType());
				} catch (CategoryDoesNotExistException e) {
					e.printStackTrace();
				}
				intent.putExtra("appInterface", appInterface);
				context.startActivity(intent);
			}
		});
		
		((ViewPager) container).addView(itemView);
		
		return itemView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object){
		((ViewPager) container).removeView((LinearLayout) object);
	}
}
