package weareallthesame.adapters;

import java.util.List;

import weareallthesame.view.R;
import android.content.Context;
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

	public GamesAdapter(Context context, List<String> games) {
		super(context, R.layout.gamelist_layout, games);
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		gameList = games;
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
		int resID = context.getResources().getIdentifier(gameList.get(position), "string", context.getPackageName());
		holder.gameName.setText(context.getString(resID));
		
		return convertView;
	}
	
}





