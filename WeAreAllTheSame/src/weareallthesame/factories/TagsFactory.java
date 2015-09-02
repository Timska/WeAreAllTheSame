package weareallthesame.factories;

import java.util.ArrayList;

import android.content.Context;
import weareallthesame.view.R;

public class TagsFactory {

	public static ArrayList<String> getGameTags(String categoryType, String gameName, Context context){
		ArrayList<String> tags = new ArrayList<String>();
		if(categoryType.equalsIgnoreCase("Letters")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_chooseLetter))){
				tags.add("letters");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_fillLetters))){
				tags.add("hangman");
				tags.add("letters");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_orderLetters))){
				tags.add("letters");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_hangman))){
				tags.add("hangman");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_orderWord))){
				tags.add("hangman");
				tags.add("letters");
				return tags;
			}
			
		}
		if(categoryType.equalsIgnoreCase("Numbers")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_addNumbers))){
				tags.add("addition");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_addSets))){
				tags.add("addition");
				tags.add("set");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_chooseNumber))){
				tags.add("numbers");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_countObjects))){
				tags.add("set");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_orderNumbers))){
				tags.add("numbers");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_findSign))){
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_sets))){
				tags.add("set");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_substractNumbers))){
				tags.add("subtraction");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_substractSets))){
				tags.add("subtraction");
				tags.add("set");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_classify))){
				tags.add("odd");
				tags.add("even");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_chooseOperator))){
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_chooseOperatorSets))){
				tags.add("set");
				return tags;
			}
			
		}
		if(categoryType.equalsIgnoreCase("Animals")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_chooseAnimal))){
				tags.add("animals");
				tags.add("sound");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_choosePicture))){
				tags.add("animals");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_chooseWord))){
				tags.add("animals");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_connectAnimals))){
				tags.add("animals");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_groupPictures))){
				tags.add("wild");
				tags.add("domestic");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_groupWords))){
				tags.add("wild");
				tags.add("domestic");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("ClothesAndBodyParts")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseBodyPartFromPicture))){
				tags.add("bodyParts");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseBodyPartFromWord))){
				tags.add("bodyParts");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseClothingFromPicture))){
				tags.add("clothes");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseClothingFromWord))){
				tags.add("clothes");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_connect))){
				tags.add("clothes");
				tags.add("tag");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("ColorsAndObjects")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_chooseColor))){
				tags.add("colors");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_chooseObject))){
				tags.add("objects");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_connect))){
				tags.add("colorsAndObjects");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_whatsTheColor))){
				tags.add("colors");
				//tags.add("tag");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("Day")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.day_dayParts))){
				// TODO ne znam kako da go organiziram
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.day_whatsTheTime))){
				// TODO ne znam kako da go organiziram
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("Emotions")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.emotions_choosePicture))){
				tags.add("emotions");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.emotions_chooseWord))){
				tags.add("emotions");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("FruitsAndVegetables")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_choosePicture))){
				tags.add("fruitsAndVegetables");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_chooseWord))){
				tags.add("fruitsAndVegetables");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_connectPictures))){
				tags.add("fruitsAndVegetables");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_groupPictures))){
				tags.add("fruit");
				tags.add("vegetable");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_groupWords))){
				tags.add("fruit");
				tags.add("vegetable");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("Prepositions")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.prepositions_choosePicture))){
				tags.add("prepositions");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.prepositions_choosePreposition))){
				tags.add("prepositions");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.prepositions_connect))){
				tags.add("prepositions");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("Shapes")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_choosePicture))){
				tags.add("shapes");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_chooseWord))){
				tags.add("shapes");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_looksLike))){
				tags.add("shapes");
				tags.add("tag");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_similarity))){
				tags.add("shapes");
				tags.add("tag");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_classifyPictures))){
				tags.add("2d");
				tags.add("3d");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_classifyWords))){
				tags.add("2d");
				tags.add("3d");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("Weather")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_choosePicture))){
				tags.add("weather");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_chooseWord))){
				tags.add("weather");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_connectPictures))){
				tags.add("weather");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_outsideWeather))){
				tags.add("weather");
				tags.add("sound");
				return tags;
			}
		}
		if(categoryType.equalsIgnoreCase("Year")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_groupWords))){
				tags.add("day");
				tags.add("month");
				//tags.add("season");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_orderDays))){
				tags.add("days");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_orderMonths))){
				tags.add("months");
				return tags;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_questions))){
				tags.add("question");
				return tags;
			}
		}
		
		return null;
	}
}
