package weareallthesame.view.games.choosecharacterfromsoundgame;

import android.media.MediaPlayer;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyDragListener implements OnDragListener {

	private MediaPlayer mediaPlayer;

	public MyDragListener(MediaPlayer mMediaPlayer) {

		this.mediaPlayer = mMediaPlayer;
	}

	@Override
	public boolean onDrag(View receivingLayoutView, DragEvent event) {
		// TODO Auto-generated method stub

		View draggedTextView = (View) event.getLocalState();

		switch (event.getAction()) {
		case DragEvent.ACTION_DRAG_STARTED:
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			break;
		case DragEvent.ACTION_DRAG_LOCATION:
			break;
		case DragEvent.ACTION_DROP:
			String tagDragged = (String) draggedTextView.getTag();
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
