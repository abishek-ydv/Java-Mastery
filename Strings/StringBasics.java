public class StringBasics {
    public static void main(String[] args) {
        String name = "Abhishek Yadav";
        String greeting = "Hello, " + name + "!";
        System.out.println(greeting);

        String upperCaseName = name.toUpperCase();
        System.out.println("Uppercase Name: " + upperCaseName);

        String lowerCaseName = name.toLowerCase();
        System.out.println("Lowercase Name: " + lowerCaseName);

        int nameLength = name.length();
        System.out.println("Length of Name: " + nameLength);

        char firstCharacter = name.charAt(0);
        System.out.println("First Character: " + firstCharacter);

        boolean containsYadav = name.contains("Yadav");
        System.out.println("Contains 'Yadav': " + containsYadav);

        String replacedName = name.replace("Abhishek", "Abhi");
        System.out.println("Replaced Name: " + replacedName);

        String substring = name.substring(5);
        System.out.println("Substring: " + substring);

    }
}
