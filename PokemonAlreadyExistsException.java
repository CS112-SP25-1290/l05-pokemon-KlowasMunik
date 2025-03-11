public class PokemonAlreadyExistsException extends Exception {
    public PokemonAlreadyExistsException() {
        super("A Pokemon with this name already exists in the box.");
    }
    
    public PokemonAlreadyExistsException(String message) {
        super(message);
    }
}