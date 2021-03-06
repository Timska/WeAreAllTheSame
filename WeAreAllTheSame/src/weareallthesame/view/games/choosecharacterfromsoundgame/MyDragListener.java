package weareallthesame.view.games.choosecharacterfromsoundgame;

import weareallthesame.model.ApplicationInterface;
import android.media.MediaPlayer;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyDragListener implements OnDragListener {

	private MediaPlayer mediaPlayer;
	private ApplicationInterface appInterface;

	public MyDragListener(MediaPlayer mMediaPlayer, ApplicationInterface appInterface) {
		this.appInterface = appInterface;
		this.mediaPlayer = mMediaPlayer;
	}

	@Override
	public boolean onDrag(View receivingLayoutView, DragEvent event) {
		// TODO Auto-generated method stub

		TextView draggedTextView = (TextView) event.getLocalState();

		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			break;
		case DragEvent.ACTION_DRAG_LOCATION:
			break;
		case DragEvent.ACTION_DROP:
			String tagDragged = (String) draggedTextView.getTag();
			try{
				appInterface.executeCommand("ChooseString", draggedTextView.getText());
			} catch(Exception e){
				e.printStackTrace();
			}
			if (tagDragged.equals("Correct")) {
				ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedTextView
						.getParent();
				draggedImageViewParentLayout.removeView(draggedTextView);
				TextView dropTarget = (TextView) receivingLayoutView;
				TextView droppedView = (TextView) draggedTextView;
				dropTarget.setText(droppedView.getText());
				mediaPlayer.start();
				draggedTextView.setVisibility(View.VISIBLE);
				return true;
			} else {
				draggedTextView.setVisibility(View.VISIBLE);
				return false;
			}

		case DragEvent.ACTION_DRAG_ENDED:

			if (!event.getResult()) {

				draggedTextView.setVisibility(View.VISIBLE);
			}
		default:
			break;
		}
		return true;
	}

}
