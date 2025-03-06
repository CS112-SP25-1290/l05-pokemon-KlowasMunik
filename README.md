[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pTqFesNy)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=18567589)
![Corsola, Pokémon that looks grey, semi-transparent and sad due to climate change](https://i.imgur.com/s2UcGQ9.png)

# **PokémonBox + Exceptions**
Welcome to the wonderful world of Pokémon! We want to keep the world wonderful, but due to climate change and the impact human beings have had on habitat loss we've had to make changes. Our Pokémon world region has decided that to accomplish this, **Pokémon trainers will only be allowed to keep one type of each Pokémon**.

The Pokémon Box technology needs upgrading, the code provided does not limit the addition of Pokémon with the same name. Create a custom exception class, called `PokemonAlreadyExistsException` that can be thrown when the `add` method in `PokemonBox`. The constructors also need upgrading to throw an exception, rather than shutdown the program. An `IllegalArgumentException` should be used in the `Pokemon` class constructors.


## **List of Requirements:**
- `Pokemon.java`:
  - Upgrade constructors to throw `IllegalArgumentException`, rather than shutdown the program
- `PokemonBox.java`:
  - Upgrade constructors to throw `IllegalArgumentException`, rather than shutdown the program
  - Upgrade `getPokemon` method to throw `IndexOutOfBoundsException` for illegal `location` value
  - Upgrade `add` method to throw `PokemonAlreadyExistsException` when the name of the provided Pokemon already exists in the array
    - Make sure to create the `PokemonAlreadyExistsException` class first!
- `Main.java`:
  - Upgrade the driver (menu program) to handle the following exceptions:
    - `InputMismatchException`: Allow the user to reenter a valid option (as an integer)
    - `IllegalArgumentException`: Allow the user to reenter valid data for Pokemon data
    - `PokemonAlreadyExistsException`: Allow the user to try again,reminding them that our regions sustainability efforts in reducing habitat loss and environmental impacts requires a max of 1 of the same type of Pokémon in the Box.

## **Sample Working Screenshots:**
*Note that your output may differ from the examples shown below, as long as it fulfills the requirements above and the output is clean you have creative liberty on how you provide feedback to the user.*


Start of menu program:
![screenshot shows preloading, welcome, initial box contents, and main menu](https://i.imgur.com/6lmMVtu.png)

Invalid integer choice error handling:
![screenshot handling "woops" entered instead of integer](https://i.imgur.com/cuq1gGy.png)

Invalid Pokémon information error handling (should work similarly for illegal name or type):
![screenshot handling illegal Pokémon type](https://i.imgur.com/lQIgHv9.png)

Invalid add to PokemonBox error handling (already exists):
![screenshot handling Pokémon input that's already in box](https://i.imgur.com/OwH1pgB.png)

Valid Pokémon added successfully:
![screenshot of valid (unique) pokemon added to box](https://i.imgur.com/ZaKba2H.png)

Exiting program option:
![screenshot of exit program option entered](https://i.imgur.com/fLQbFtd.png)