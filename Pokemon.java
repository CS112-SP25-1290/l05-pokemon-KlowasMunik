public class Pokemon {
    // CONSTANT VARIABLES
    public static final String[] TYPES = { "Normal", "Fire", "Fighting", "Water", "Flying", "Grass", "Poison",
        "Electric", "Ground", "Psychic", "Rock", "Ice", "Bug", "Dragon", "Ghost", "Dark", "Steel", "Fairy"};
    public static final String DEFAULT_NAME = "Missingno.";
    public static final String DEFAULT_TYPE1 = "Normal";
    public static final String DEFAULT_TYPE2 = null;

    // INSTANCE VARIABLES
    private String name;
    private String type1;
    private String type2;

    // CONSTRUCTORS
    public Pokemon(String name, String type1, String type2) throws IllegalArgumentException {
        if(!this.setAll(name, type1, type2)) {
            throw new IllegalArgumentException("Invalid Pokemon data provided (name, type1, or type2).");
        }
    }

    public Pokemon(String name, String type) throws IllegalArgumentException {
        this(name, type, null);
    }
    
    public Pokemon() {
        this(DEFAULT_NAME, DEFAULT_TYPE1, DEFAULT_TYPE2);
    }

    public Pokemon(Pokemon p) throws IllegalArgumentException {
        if(p == null) {
            throw new IllegalArgumentException("Pokemon copy constructor illegal argument (null) passed.");
        }
        this.setAll(p.name, p.type1, p.type2);
    }

    // MUTATOR/SETTER METHODS
    public boolean setName(String name) {
        if(name != null && name.length() > 0) {
            this.name = this.toTitleCase(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean setType1(String type1) {
        if(this.isValidType(type1)) {
            this.type1 = this.toTitleCaseWord(type1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setType2(String type2) {
        if(type2 == null) {
            this.type2 = null;
            return true;
        } else if (this.isValidType(type2)) {
            this.type2 = this.toTitleCaseWord(type2);
            return true;
        } else {
            return false;
        }
    }

    public boolean setAll(String name, String type1, String type2) {
        return this.setName(name) && this.setType1(type1) && this.setType2(type2);
    }

    // ACCESSOR/GETTER METHODS
    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    // OTHER REQUIRED METHODS
    @Override
    public String toString() {
        return "Pokemon: Name = " + this.name + ", Type 1: " + this.type1 + ", Type 2: " + this.type2;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || this.getClass() != other.getClass()) {
            return false;
        } else {
            Pokemon otherPokemon = (Pokemon)other;
            boolean type2Equals = (this.type2 == null && otherPokemon.type2 == null)
                || (this.type2 != null & otherPokemon.type2 != null && this.type2.equals(otherPokemon.type2));
            return this.name.equals(otherPokemon.name) && this.type1.equals(otherPokemon.type1) && type2Equals;
        }
    }

    // HELPER METHODS
    public String toRow() {
        if(this.type2 == null) {
            return String.format("%s [%s]", this.name, this.type1);
        } else {
            return String.format("%s [%s - %s]", this.name, this.type1, this.type2);
        }
    }

    private boolean isValidType(String type) {
        boolean isValid = false;
        int count = 0;

        while (count < TYPES.length && !isValid) {
            isValid = TYPES[count].equalsIgnoreCase(type);
            count++;
        }

        return isValid;
    }

    private String toTitleCase(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for(String word : words) {
            builder.append( " " + this.toTitleCaseWord(word) );
        }

        return builder.toString().substring(1);
    }

    private String toTitleCaseWord(String word) {
        char firstLetter = word.toUpperCase().charAt(0);
        String restOfWord = word.toLowerCase().substring(1);
        return firstLetter + restOfWord;
    }
}