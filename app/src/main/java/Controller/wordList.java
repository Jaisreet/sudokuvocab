package Controller;

import java.util.HashMap;
import java.util.Random;


public class wordList {

    private drawBoard gameBoard;
    private static HashMap<Integer, String[]> wordList = new HashMap<>();
    private static HashMap<Integer, String[]> gameWords;// = new HashMap<>();

    public wordList(){
        gameWords = new HashMap<>();
    }

    static {
        wordList.put(1, new String[] { "un","one"});
        wordList.put(2, new String[] { "deux","two"});
        wordList.put(3, new String[] { "trois","three"});
        wordList.put(4, new String[] { "quatre","four"});
        wordList.put(5, new String[] { "cinq","five"});
        wordList.put(6, new String[] { "six","six"});
        wordList.put(7, new String[] { "sept","seven"});
        wordList.put(8, new String[] { "huit","eight"});
        wordList.put(9, new String[] { "neuf","nine"});
        wordList.put(10, new String[] {"salut", "hi"});
        wordList.put(11, new String[] {"bonjour", "hello/good day"});
        wordList.put(12, new String[] {"bébé", "child"});
        wordList.put(13, new String[] {"demain", "tomorrow"});
        wordList.put(14, new String[] {"au'jour'd'hui", "today"});
        wordList.put(15, new String[] {"soleil", "sun"});
        wordList.put(16, new String[] {"lune", "moon"});
        wordList.put(17, new String[] {"terrain", "earth"});
        wordList.put(18, new String[] {"seul", "single"});
        wordList.put(19, new String[] {"conjoint", "spouse"});
        wordList.put(20, new String[] {"femme", "wife"});
        wordList.put(21, new String[] {"file", "daughter"});
        wordList.put(22, new String[] {"garcon", "son"});
        wordList.put(23, new String[] {"bon", "good"});
        wordList.put(24, new String[] {"bien", "nice"});
        wordList.put(25, new String[] {"bienvenue", "welcome"});
        wordList.put(26, new String[] {"merci", "thank you"});
        wordList.put(27, new String[] {"beaucoup", "a lot"});
        wordList.put(28, new String[] {"bureau", "office"});
        wordList.put(29, new String[] {"rouge", "ref"});
        wordList.put(30, new String[] {"jaune", "yellow"});
        wordList.put(31, new String[] {"juene", "young"});
        wordList.put(32, new String[] {"l'eau", "water"});
        wordList.put(33, new String[] {"lait", "milk"});
        wordList.put(34, new String[] {"soir", "evening"});
        wordList.put(35, new String[] {"au revoir", "bye"});
        wordList.put(36, new String[] {"etat", "state"});
        wordList.put(37, new String[] {"portable", "mobile"});
        wordList.put(38, new String[] {"disponible", "available"});
        wordList.put(39, new String[] {"cafe", "coffee"});
        wordList.put(40, new String[] {"lundi", "monday"});
        wordList.put(41, new String[] {"mardi", "tuesday"});
        wordList.put(42, new String[] {"mercredi", "wednesday"});
        wordList.put(43, new String[] {"jeudi", "thursday"});
        wordList.put(44, new String[] {"vendredi", "friday"});
        wordList.put(45, new String[] {"samedi", "saturday"});
        wordList.put(46, new String[] {"dimanche", "sunday"});
        wordList.put(47, new String[] {"noir", "black"});
        wordList.put(48, new String[] {"blanc", "white"});
        wordList.put(49, new String[] {"moteur", "engine"});
        wordList.put(50, new String[] {"lecture", "to read"});
        wordList.put(51, new String[] {"jeu", "game"});
        wordList.put(52, new String[] {"plus", "more"});
        wordList.put(53, new String[] {"dernier", "previous"});
        wordList.put(54, new String[] {"prochain", "next"});
        wordList.put(55, new String[] {"deja", "already"});
        wordList.put(56, new String[] {"nom", "name, surname"});
        wordList.put(57, new String[] {"prenom", "firstname"});
        wordList.put(58, new String[] {"homme", "gentleman"});
        wordList.put(59, new String[] {"cordialment", "regards"});
        wordList.put(60, new String[] {"votre", "your"});
        wordList.put(61, new String[] {"vous", "you"});
        wordList.put(62, new String[] {"sortie", "exit"});
        wordList.put(63, new String[] {"yaourt", "yoghurt"});
        wordList.put(64, new String[] {"nous vous", "we"});
        wordList.put(65, new String[] {"voyage", "journey"});
        wordList.put(66, new String[] {"ami", "friend"});
        wordList.put(67, new String[] {"petit", "small"});
        wordList.put(68, new String[] {"dejeuner", "meal"});
        wordList.put(69, new String[] {"anne", "year"});
        wordList.put(70, new String[] {"mois", "month"});
        wordList.put(71, new String[] {"semaine", "week"});
        wordList.put(72, new String[] {"poid", "weight"});
        wordList.put(73, new String[] {"pomme", "apple"});
        wordList.put(74, new String[] {"banane", "banana"});
        wordList.put(75, new String[] {"poivre", "pepper"});
        wordList.put(76, new String[] {"vert", "green"});
        wordList.put(77, new String[] {"miel", "honey"});
        wordList.put(78, new String[] {"horaire", "schedule"});
        wordList.put(79, new String[] {"carte", "card"});
        wordList.put(80, new String[] {"mangue", "mango"});
        wordList.put(81, new String[] {"ecrit", "write"});
        wordList.put(82, new String[] {"parle", "speak"});
        wordList.put(83, new String[] {"batiment", "building"});
        wordList.put(84, new String[] {"maison", "house"});
        wordList.put(85, new String[] {"contrat", "contract"});
        wordList.put(86, new String[] {"travail", "work"});
        wordList.put(87, new String[] {"etudiant", "student"});
        wordList.put(88, new String[] {"montagne", "mountain"});
        wordList.put(89, new String[] {"ognon", "onion"});
        wordList.put(90, new String[] {"bonbon", "sweets"});
        wordList.put(91, new String[] {"gateau", "cake"});
        wordList.put(92, new String[] {"resole", "sorry"});
        wordList.put(93, new String[] {"plage", "beach"});
        wordList.put(94, new String[] {"promenade", "walk"});
        wordList.put(95, new String[] {"coer", "heart"});
        wordList.put(96, new String[] {"soer", "sister"});
        wordList.put(97, new String[] {"frere", "father"});
        wordList.put(98, new String[] {"mere", "mother"});
        wordList.put(99, new String[] {"oef", "egg"});
        wordList.put(100, new String[] {"chien", "chien"});
    }
    public static String getWord(int value, String language) {
        if (wordList.containsKey(value)) {
            if (language.equals("English")) {
                return wordList.get(value)[1];
            } else if (language.equals("French")) {
                return wordList.get(value)[0];
            }
        }
        return "";
    }


    public static HashMap<Integer, String[]> gameWords(int n) {
        int index;
        for (int i = 1; i < n + 1; i++) {
            //index = (int) (Math.random() * 100);
            Random rand = new Random();
            index = rand.nextInt(100) + 1;
            gameWords.put(i, new String[]{ getWord(index, "French"),getWord(index, "English")});
        }

        return gameWords;
    }
}
