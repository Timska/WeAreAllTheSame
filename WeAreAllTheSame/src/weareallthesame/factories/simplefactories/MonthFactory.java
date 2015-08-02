package weareallthesame.factories.simplefactories;

import java.util.Random;

public class MonthFactory implements SimpleFactoryInterface {

	private static String[] months = {"Јануари", "Февруари", "Март", "Април", "Мај",
		"Јуни", "Јули", "Август", "Септември", "Октомври", "Ноември", "Декември"};

	@Override
	public String getOnPosition(int position) {
		return months[position];
	}

	@Override
	public String getDefault() {
		Random random = new Random();
		return months[random.nextInt(months.length)];
	}

	@Override
	public int compare(String o1, String o2) {
		if(o1.equals(o2)){
			return 0;
		}
		for(int i=0;i<months.length;++i){
			if(o1.equals(months[i])){
				return -1;
			}
			if(o2.equals(months[i])){
				return 1;
			}
		}
		return 0;
	}
}
