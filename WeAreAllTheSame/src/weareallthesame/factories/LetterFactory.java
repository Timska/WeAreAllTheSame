package weareallthesame.factories;

import java.util.Random;

/**
 * Ovaa klasa ke se koristi kako fabrika na kirilicni bukvi.
 * @author i5
 *
 */
public class LetterFactory {

	private static char[] cyrilicLetters = {'А', 'Б', 'В', 'Г', 'Д', 'Ѓ', 'Е', 'Ж', 'З', 'Ѕ', 'И', 'Ј', 'К', 'Л',
			'Љ', 'М', 'Н', 'Њ', 'О', 'П', 'Р', 'С', 'Т', 'Ќ', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Џ', 'Ш'};
	
	/**
	 * So ovoj metod se dobiva bukva na odredena pozicija
	 * @param position pozicijata na bukvata sto sakame da ja dobieme od 0 do 31 vo makedonskata azbuka, kade 0=A
	 * @return bukvata na pozicijata definirana so parametarot position
	 */
	public static Character getLetterOnPosition(int position){
		return cyrilicLetters[position];
	}
	
	/**
	 * So ovoj metod se dobiva slucajno izbrana bukva od kirilicata
	 * @return slucajno izbrana bukva
	 */
	public static Character getDefaultLetter(){
		Random random = new Random();
		int position = random.nextInt(cyrilicLetters.length);
		return getLetterOnPosition(position);
	}
}
