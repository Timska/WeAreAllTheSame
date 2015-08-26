package weareallthesame.adapters;

import java.util.List;

import weareallthesame.factories.TagsFactory;
import weareallthesame.factories.ViewFactory;
import weareallthesame.model.ApplicationInterface;
import weareallthesame.view.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GamesAdapter extends ArrayAdapter<String> {

	private Context context;
	private LayoutInflater inflater;
	private List<String> gameList;
	private ApplicationInterface appInterface;

	public GamesAdapter(Context context, List<String> games, ApplicationInterface appInterface) {
		super(context, R.layout.gamelist_layout, games);
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		gameList = games;
		this.appInterface = appInterface;
	}
	
	private class GameHolder {
		private RelativeLayout itemLayout;
		private TextView gameName;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GameHolder holder = null;
		if (convertView == null) {
			holder = new GameHolder();
			holder.itemLayout = (RelativeLayout) inflater.inflate(R.layout.gamelist_layout, parent, false);
			holder.gameName = (TextView) holder.itemLayout.findViewById(R.id.game_textView);
			convertView = holder.itemLayout;
			convertView.setTag(holder);
		}
		holder = (GameHolder) convertView.getTag();
		System.out.println("list" + gameList.get(position));
		int resID = context.getResources().getIdentifier(gameList.get(position), "string", context.getPackageName());
		final String name = context.getString(resID);
		final int pos = position;
		holder.gameName.setText(name);
		
		convertView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println(name);
				Intent intent = new Intent(context, ViewFactory.getActivityClass(appInterface.getCurrentCategoryType(), name, context));
				try{
					System.out.println("Igra" + name);
					intent.putExtra("gameType", appInterface.getGameType(gameList.get(pos)));
					System.out.println("Na klik na igra" + appInterface.getGameType(name));
				}
				catch(Exception e){
					e.printStackTrace();
				}
				intent.putStringArrayListExtra("gameTags", TagsFactory.getGameTags(appInterface.getCurrentCategoryType(), name, context));
				intent.putExtra("appInterface", appInterface);
				context.startActivity(intent);
			}
		});
		
		return convertView;
	}
	
}






