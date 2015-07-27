package weareallthesame.factories.simplefactories;

import java.util.Random;

public class NumberFactory implements SimpleFactoryInterface {

	private int maxPosition;
	
	public NumberFactory(int maxPosition) {
		this.maxPosition = maxPosition;
	}

	@Override
	public String getOnPosition(int position) {
		return String.valueOf(position);
	}

	@Override
	public String getDefault() {
		Random random = new Random();
		return getOnPosition(random.nextInt(maxPosition));
	}

	@Override
	public int compare(String o1, String o2) {
		return Integer.parseInt(o1) - Integer.parseInt(o2);
	}

}
