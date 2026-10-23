/*
 * Name: Ryan R
 * Date: October 15, 2026
 * Description: Recommends a perfect pet based on the user's color, season,
 * and name.
 */
import java.util.Arrays;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
      String name = readName(input);
      if (name == null) {
        return;
      }

     System.out.println( "Enter your favorite color (red, blue, or green): ");
      String color = input.nextLine();
      if(!(color.equals("blue") || color.equals("green")|| color.equals("red"))){
          System.out.println("wrong input!");
          return;
        }
    
      System.out.println("Enter your favorite season (winter, spring, summer, fall):");
      String season = input.nextLine();
      if (!(season.equals("winter") || season.equals("spring")
          || season.equals("summer") || season.equals("fall"))) {
        System.out.println("wrong input!");
        return;
      }

      String pet = getPet(color, season, name.charAt(0));
      System.out.println("Your perfect pet is: " + pet);
  }

 

  private static String readName(Scanner input) {
    while (true) {
      System.out.print("Enter your name: ");
      if (!input.hasNextLine()) {
        System.out.println("\nInput ended before all answers were provided.");
        return null;
      }

      String name = input.nextLine().trim();
      if (!name.isEmpty() && Character.isLetter(name.charAt(0))) {
        return name;
      }
      System.out.println("Please enter a name that starts with a letter.");
    }
  }

  private static String getPet(String color, String season, char first) {
    char letter = Character.toLowerCase(first);
    boolean vowel = "aeiou".indexOf(letter) >= 0;
    boolean consonant = "bcdfghjklmnpqrstvwxyz".indexOf(letter) >= 0;

    if (color.equals("red") && vowel) {
      return "Porcupine";
    } else if (color.equals("red")) {
      return "Panda";
    }

    if (color.equals("green")) {
      if (season.equals("winter") && consonant) {
        return "Giraffe";
      }
      if (!season.equals("fall")) {
        return "Dog";
      }
    }

    if (color.equals("blue")) {
      if (season.equals("fall")) {
        return "Alligator";
      }
      if (season.equals("spring")) {
        return "Ostrich";
      }
      if (season.equals("winter") && consonant) {
        return "Axolotl";
      }
      if (season.equals("summer")) {
        return "Pony";
      }
    }

    return "Pet Rock";
  }
}
