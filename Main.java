import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int choice = -1;
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        
        // Initialize Pokemon array with try-catch for exceptions
        Pokemon[] caught = null;
        try {
            caught = new Pokemon[]{
                new Pokemon("Pikachu", "Electric"),
                new Pokemon("Bulbasaur", "Grass", "Poison"),
                new Pokemon("Charmeleon", "Fire"),
                new Pokemon("Squirtle", "Water"),
                new Pokemon("Butterfree", "Bug", "Flying"),
                new Pokemon("Pidgeotto", "Normal", "Flying")
            };
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing Pokemon: " + e.getMessage());
            System.exit(1);
        }

        // WELCOME
        System.out.println("Preloading Pokemon Box...");
        PokemonBox myBox = null;
        try {
            myBox = new PokemonBox(caught);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Pokemon Box: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("...Done!\n");

        System.out.println("---------------------------");
        System.out.println("| Welcome to Pokemon Box! |");
        System.out.println("---------------------------\n");
        System.out.println(myBox);

        //INPUT + PROCESSING + OUTPUT
        do {
            System.out.println("\nMAIN MENU\nWhat would you like to do?");
            System.out.println("\t1) Add a New Pokemon \n\t2) List All Pokemon \n\t3) Exit Program \n");
            System.out.print("Enter choice number> ");
            
            try {
                choice = keyboard.nextInt(); // Could throw InputMismatchException
                keyboard.nextLine();
                System.out.println();

                if (choice == 1) {
                    boolean validPokemon = false;
                    while (!validPokemon) {
                        try {
                            System.out.println("Enter Pokemon Info to be added:");
                            System.out.print("Enter Pokemon Name> ");
                            String name = keyboard.nextLine();
                            System.out.print("Enter Pokemon Type #1> ");
                            String type1 = keyboard.nextLine();
                            System.out.print("Enter Pokemon Type #2 (none if no second type)> ");
                            String type2 = keyboard.nextLine();
                            type2 = (type2.equalsIgnoreCase("none")) ? null : type2;

                            Pokemon p = new Pokemon(name, type1, type2); // Could throw IllegalArgumentException
                            
                            try {
                                myBox.add(p); // Could throw PokemonAlreadyExistsException
                                System.out.println("\n" + name + " added!");
                                validPokemon = true;
                            } catch (PokemonAlreadyExistsException e) {
                                System.out.println("\nError: " + e.getMessage());
                                System.out.println("Our region's sustainability efforts in reducing habitat loss and environmental impacts");
                                System.out.println("requires a maximum of 1 of the same type of Pokémon in the Box.");
                                System.out.print("Would you like to try adding a different Pokemon? (y/n)> ");
                                String retry = keyboard.nextLine();
                                if (!retry.equalsIgnoreCase("y")) {
                                    validPokemon = true; // Exit the loop if user doesn't want to try again
                                }
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("\nError: " + e.getMessage());
                            System.out.print("Would you like to try again with valid Pokemon data? (y/n)> ");
                            String retry = keyboard.nextLine();
                            if (!retry.equalsIgnoreCase("y")) {
                                validPokemon = true; // Exit the loop if user doesn't want to try again
                            }
                        }
                    }
                } else if (choice == 2) {
                    System.out.println(myBox);
                } else if (choice == 3) {
                    keyboard.close();
                    tryAgain = false;
                } else {
                    System.out.println("Invalid choice, please pick a valid option from the menu.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: Please enter a valid integer choice.");
                keyboard.nextLine(); // Clear the invalid input
            }
        } while (tryAgain);

        System.out.println("Thank you for using the Pokemon Box program :D see you later!");
    }
}