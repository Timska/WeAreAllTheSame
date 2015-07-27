package weareallthesame.factories.simplefactories;

import java.util.Random;

/**
 * Ovaa klasa ke se koristi kako fabrika na kirilicni bukvi.
 * @author i5
 *
 */
public class LetterFactory implements SimpleFactoryInterface {

	private static char[] cyrilicLetters = {'А', 'Б', 'В', 'Г', 'Д', 'Ѓ', 'Е', 'Ж', 'З', 'Ѕ', 'И', 'Ј', 'К', 'Л',
			'Љ', 'М', 'Н', 'Њ', 'О', 'П', 'Р', 'С', 'Т', 'Ќ', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Џ', 'Ш'};

	@Override
	public String getOnPosition(int position) {
		return String.format("%c",cyrilicLetters[position]);
	}

	@Override
	public String getDefault() {
		Random random = new Random();
		int position = random.nextInt(cyrilicLetters.length);
		return getOnPosition(position);
	}

	@Override
	public int compare(String o1, String o2) {
		if(o1.equals(o2)){
			return 0;
		}
		for(int i=0;i<cyrilicLetters.length;++i){
			if(o1.equals(cyrilicLetters[i])){
				return -1;
			}
			if(o2.equals(cyrilicLetters[i])){
				return 1;
			}
		}
		return 0;
	}
}
