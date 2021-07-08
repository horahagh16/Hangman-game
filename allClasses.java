import static javax.swing.JOptionPane.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

class leaderBoard {
    String leaderboard = "";
    int a, b;
    user key;

    public void printLeaderBoard(user[] player, int temp) {
        // insertion sort
        for (a = 1; a <= temp; a++) {
            key = player[a];
            b = a - 1;
            while (b >= 0 && player[b].score > key.score) {
                player[b + 1] = player[b];
                b = b - 1;
            }
            player[b + 1] = key;
        }
        for (int t = temp; t >= 0; t--) {
            System.out.print(player[t].username);
            leaderboard = leaderboard + player[t].username;
            for (int i = 0; i < 25 - player[t].username.length(); i++) {
                System.out.print("-");
                leaderboard = leaderboard + "-";
            }
            System.out.print(player[t].score + "\n");
            leaderboard = leaderboard + player[t].score + "\n";

        }
    }
}

class user {
    String username;
    String password;
    int score = 0;

    user() {

    }

    user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getusername() {
        return this.username;
    }

    public int getScore() {
        return this.score;
    }

    public void changeScore() {
        score += 5;
    }

    public void hint() {
        score -= 10;
    }
}

class file {
    public void printFile(String user) {
        try {
            FileOutputStream leaderbord = new FileOutputStream("D:\\leaderboard.txt");
            byte[] converted = user.getBytes();
            leaderbord.write(converted);
            leaderbord.close();
            System.out.println("LEADER BOARD SAVED");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void savedFile(user player) {
        try {
            FileOutputStream fileOut = new FileOutputStream(
                    "history.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void lastProgram(user player) {
        try {
            FileInputStream fileIn = new FileInputStream(
                    "history.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            player = (user) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
    }
}

class DrawMan {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void print(int lives) {
        switch (lives) { // switch case for each live case
        case (7):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|   ");
            System.out.println("|   ");
            System.out.println("|   ");
            System.out.println("|   ");
            System.out.println("|   ");
            System.out.println(ANSI_RESET);
            break;
        case (6):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|  " + ANSI_WHITE + "|" + ANSI_BLUE);
            System.out.println("|   ");
            System.out.println("|   ");
            System.out.println("|   ");
            System.out.println("|   ");
            System.out.println(ANSI_RESET);
            break;
        case (5):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|  " + ANSI_WHITE + "|" + ANSI_BLUE);
            System.out.println("|  " + ANSI_GREEN + "o" + ANSI_BLUE);
            System.out.println("|  ");
            System.out.println("|  ");
            System.out.println("| ");
            System.out.println(ANSI_RESET);
            break;
        case (4):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|  " + ANSI_WHITE + "|" + ANSI_BLUE);
            System.out.println("|  " + ANSI_GREEN + "o" + ANSI_BLUE);
            System.out.println("| " + ANSI_YELLOW + "/" + ANSI_BLUE);
            System.out.println("|  ");
            System.out.println("| ");
            System.out.println(ANSI_RESET);
            break;
        case (3):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|  " + ANSI_WHITE + "|" + ANSI_BLUE);
            System.out.println("|  " + ANSI_GREEN + "o" + ANSI_BLUE);
            System.out.println("| " + ANSI_YELLOW + "/|" + ANSI_BLUE);
            System.out.println("|  ");
            System.out.println("| ");
            System.out.println(ANSI_RESET);
            break;
        case (2):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|  " + ANSI_WHITE + "|" + ANSI_BLUE);
            System.out.println("|  " + ANSI_GREEN + "o" + ANSI_BLUE);
            System.out.println("| " + ANSI_YELLOW + "/|\\" + ANSI_BLUE);
            System.out.println("|  ");
            System.out.println("| ");
            System.out.println(ANSI_RESET);
            break;
        case (1):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|  " + ANSI_WHITE + "|" + ANSI_BLUE);
            System.out.println("|  " + ANSI_GREEN + "o" + ANSI_BLUE);
            System.out.println("| " + ANSI_YELLOW + "/|\\" + ANSI_BLUE);
            System.out.println("| " + ANSI_RED + "/ " + ANSI_BLUE);
            System.out.println("| ");
            System.out.println(ANSI_RESET);
            break;
        case (0):
            System.out.println(ANSI_BLUE + "----");
            System.out.println("|  " + ANSI_WHITE + "|" + ANSI_BLUE);
            System.out.println("|  " + ANSI_GREEN + "o" + ANSI_BLUE);
            System.out.println("| " + ANSI_YELLOW + "/|\\" + ANSI_BLUE);
            System.out.println("| " + ANSI_RED + "/ \\" + ANSI_BLUE);
            System.out.println("| ");
            System.out.println(ANSI_RESET);
        }
    }
}

class words {
    public String word() {
        java.util.Date d1 = new java.util.Date();
        String[] worStrings = { "tehran", "pizza", "banana", "new york", "advanced programming", "michael jordan",
                "lionel messi", "apple", "macaroni", "university", "intel", "kitten", "python", "java",
                "data structures", "algorithm", "assembly", "basketball", "hockey", "leader", "javascript", "toronto",
                "united states of america", "psychology", "chemistry", "breaking bad", "physics", "abstract classes",
                "linux kernel", "january", "march", "time travel", "twitter", "instagram", "dog breeds", "strawberry",
                "snow", "game of thrones", "batman", "ronaldo", "soccer", "hamburger", "italy", "greece",
                "albert einstein", "hangman", "clubhouse", "call of duty", "science",
                "theory of languages and automata" };
        int num = (int) ((d1.getTime()) % 50);
        return worStrings[num];
    }
}

class table {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void drawtable(int wrongs, int lives) {

        for (int j = 0; j < wrongs; j++) {
            System.out.printf("|" + ANSI_RED + "X" + ANSI_RESET);
        }
        for (int j = 0; j < lives; j++) {
            System.out.printf("|" + ANSI_GREEN + "V" + ANSI_RESET);
        }
        System.out.println("|\n");
    }
}

public class allClasses {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        clearScreen();
        // for stat of game
        String ttl = "*HANGMAN*";
        String msg = "💕 Welcome To This Game 💕\n         Guess The Words 😉\n         Raise Your Score 😍 ";
        ImageIcon icon = new ImageIcon("C:\\Users\\Nik\\Desktop\\ap\\proj1\\asset\\play.jpg");
        JOptionPane.showMessageDialog(null, msg, ttl, PLAIN_MESSAGE, icon);

        clearScreen();

        Console console = System.console();
        Scanner input = new Scanner(System.in);
        user[] player = new user[100];
        leaderBoard leaderBoard = new leaderBoard();
        DrawMan man = new DrawMan();
        int userNum = 0, temp = 0;
        int fake = 1;

        // program loop
        while (fake != 0) {
            // main menu
            man.print(0);
            System.out.println(ANSI_RED + "H" + ANSI_BLUE + " A" + ANSI_CYAN + " N" + ANSI_GREEN + " G" + ANSI_YELLOW
                    + " M" + ANSI_WHITE + " A" + ANSI_PURPLE + " N" + ANSI_RESET);
            System.out.println();
            System.out.println(ANSI_GREEN + "1. Signup");
            System.out.println(ANSI_CYAN + "2. Login");
            if (player[0] != null) {
                System.out.println(ANSI_BLUE + "3. Save Leader Board");
            } else {
                System.out.println(ANSI_BLUE + "3. Save Leader Board (leader board is empty)");
            }
            System.out.println(ANSI_PURPLE + "4. Exit" + ANSI_RESET);
            int action1 = input.nextInt();

            // for (int i = 0; i < player.length; i++) {
            // file.lastProgram(player[i]);
            // }
            clearScreen();
            // Save Leader Board
            if (action1 == 3) {
                file file = new file();
                String leaderboard = "";
                if (player[0] == null) {
                    System.out.println(ANSI_RED + "leader board is empty" + ANSI_RESET);
                    continue;
                } else {
                    int a, b;
                    user key;
                    // insertion sort
                    for (a = 1; a <= temp; a++) {
                        key = player[a];
                        b = a - 1;
                        while (b >= 0 && player[b].score > key.score) {
                            player[b + 1] = player[b];
                            b = b - 1;
                        }
                        player[b + 1] = key;
                    }
                    for (int t = temp; t >= 0; t--) {
                        leaderboard = leaderboard + player[t].username;
                        for (int i = 0; i < 25 - player[t].username.length(); i++) {
                            leaderboard = leaderboard + "-";
                        }
                        leaderboard = leaderboard + player[t].score + "\n";
                    }
                }
                file.printFile(leaderboard);
            }
            // exit
            if (action1 == 4) {
                String msg2 = "COME BACK SOON 😉\n      GOOD BYE 🤗";
                icon = new ImageIcon("C:\\Users\\Nik\\Desktop\\ap\\proj1\\asset\\end.jpg");
                JOptionPane.showMessageDialog(null, msg2, ttl, PLAIN_MESSAGE, icon);
                // for (int i = 0; i < karbar.length; i++) {
                // file.savedFile(karbar[i]);
                // }
                clearScreen();
                input.close();
                break;

            }
            // sign up
            if (action1 == 1) {
                if (fake != 1) {
                    userNum++;
                    temp = userNum;
                }
                System.out.println(ANSI_BLUE + "Choose Your Username" + ANSI_RESET);
                String nam = input.next();

                for (int i = 0; i < userNum; i++) {
                    if (player[i].getusername().equals(nam)) {
                        System.out.println(ANSI_YELLOW + "This Username Was Taken, Choose Another :)" + ANSI_RESET);
                        nam = input.next();
                        i = 0;
                    }
                }

                System.out.println(ANSI_BLUE + "Choose Your Password\n" + ANSI_YELLOW
                        + "(it should be at least 6 letters contain uppercase,lowercase,number\n"
                        + "and must have 1 special character like !,@,#,$,...):" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "* YOUR PASSWORD IS HIDDEN *" + ANSI_RESET);
                String pas = new String(console.readPassword());
                String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%#*?&])[\\w@$#!%*?&]{6,}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(pas);
                while (!matcher.matches()) {
                    System.out.println(ANSI_RED
                            + "!!! Your Password Does Not Have The Correct Form, Choose The New Password According To The Requested Pattern!!! "
                            + ANSI_RESET);
                    pas = input.next();
                    clearScreen();
                    matcher = pattern.matcher(pas);
                }

                player[userNum] = new user(nam, pas);
                clearScreen();
                System.out.println(ANSI_GREEN + "YOU SIGNED UP SUCCESSFULLY\n" + ANSI_RESET);
            }
            // log in
            if (action1 == 2) {
                clearScreen();
                System.out.println(ANSI_GREEN + "LOGIN:" + ANSI_BLUE + "\nEnter Your Username:" + ANSI_RESET);
                String savedNam = input.next();
                clearScreen();
                int flagg = 0;
                if (userNum == 0 && player[0] != null) {
                    if (player[0].getusername().equals(savedNam)) {
                        flagg = 1;
                    }
                } else {
                    for (int i = 0; i <= userNum; i++) {
                        if (player[0] != null && player[i].getusername().equals(savedNam)) {
                            flagg = 1;
                            temp = userNum;
                            userNum = i;
                            break;
                        }
                    }
                }
                if (flagg == 0) {
                    System.out.println(ANSI_RED + "ERROR: Username Not Found !!!");
                    System.out.println(ANSI_CYAN + "Please Signup First =)" + ANSI_RESET);
                    continue;
                } else {
                    System.out.println(ANSI_CYAN + "Hello " + player[userNum].getusername() + ANSI_BLUE
                            + "\nEnter Your Password:" + ANSI_RESET);
                    String savedpass = new String(console.readPassword());
                    while (!player[userNum].password.equals(savedpass)) {
                        System.out.println(ANSI_RED + "Password is incorrect !!!\nEnter again:\n" + ANSI_RESET);
                        savedpass = input.next();
                        clearScreen();
                    }
                }
                clearScreen();
                System.out.println(ANSI_GREEN + "1. START GAME");
                System.out.println(ANSI_CYAN + "2. Show Leaderboard" + ANSI_RESET);
                int action2 = input.nextInt();
                // start game
                if (action2 == 1) {
                    words word = new words();
                    String secret = word.word();

                    char[] wordLetters = new char[secret.length()];
                    for (int i = 0; i < wordLetters.length; i++) {
                        if (secret.charAt(i) != ' ') {
                            wordLetters[i] = '-';
                        } else {
                            wordLetters[i] = ' ';
                        }
                    }

                    int lives = 7;
                    int count = 0;
                    int wrongs = 0;
                    int can = 14;
                    int hint = 1;
                    table table = new table();
                    char[] inputLetters = new char[26];

                    for (int i = 0; 0 < lives; i++) {
                        clearScreen();
                        man.print(lives);
                        if (secret.length() > 9) {
                            table.drawtable(wrongs, can);
                        } else {
                            table.drawtable(wrongs, lives);
                        }
                        System.out.println(ANSI_YELLOW + "Dont Choose This Letters:" + ANSI_CYAN);
                        for (int j = 0; j < i; j++) {
                            if (inputLetters[j] != ' ') {
                                System.out.print(inputLetters[j] + " ");
                            }
                        }
                        System.out.println(ANSI_RESET + "\n");
                        for (int j = 0; j < wordLetters.length; j++) {
                            System.out.print(wordLetters[j] + " ");
                        }
                        System.out.println();
                        System.out.println(ANSI_CYAN + "Guess a Letter 🧐: " + ANSI_RESET);
                        if (hint == 1) {
                            System.out.println(ANSI_GREEN + "ENTER '1' AND GIVE 10 SCORE FOR HINT 🔔" + ANSI_RESET);
                        }
                        char letter = input.next().charAt(0);
                        if (letter == '1') {
                            if (hint == 1) {
                                if (player[userNum].getScore() < 10) {
                                    System.out.println(ANSI_RED + "YOUR SCORE IS NOT ENOUGH :(\nEnter 'N' to continue"
                                            + ANSI_RESET);
                                    letter = ' ';
                                    String delay = input.next();
                                } else {
                                    player[userNum].hint();
                                    for (int j = 0; j < secret.length(); j++) {
                                        if (wordLetters[j] == '-') {
                                            letter = secret.charAt(j);
                                            break;
                                        }
                                    }
                                    hint = 0;
                                }
                            } else {
                                System.out.println(
                                        ANSI_RED + "Oops! YOU CAN ONLY USE THE HINT ONCE :(\nEnter 'N' to continue"
                                                + ANSI_RESET);
                                letter = ' ';
                                String delay = input.next();
                            }
                        } else {
                            for (int j = 0; j < i; j++) {
                                if (letter == inputLetters[j]) {
                                    System.out.println(
                                            ANSI_YELLOW + "THIS LETTER WAS SELECTED! ENTER ANOTHER: " + ANSI_RESET);
                                    letter = input.next().charAt(0);
                                    j = 0;
                                }
                            }
                        }
                        inputLetters[i] = letter;
                        clearScreen();
                        int flag = 0;
                        for (int j = 0; j < secret.length(); j++) {
                            if (secret.charAt(j) == letter) {
                                wordLetters[j] = letter;
                                flag = 1;
                            }
                        }
                        int win = 0;
                        for (int j = 0; j < wordLetters.length; j++) {
                            if (wordLetters[j] != '-') {
                                win++;
                            }
                        }
                        if (win == wordLetters.length) {
                            clearScreen();
                            msg = "               * CONGRATULATION *          \n"
                                    + "     * YOU WON AND RECEIVE 5 SCORE *          \n";
                            icon = new ImageIcon("C:\\Users\\Nik\\Desktop\\ap\\proj1\\asset\\hangcar.png");
                            JOptionPane.showMessageDialog(null, msg, ttl, PLAIN_MESSAGE, icon);
                            // System.out.println(ANSI_YELLOW + " * CONGRATULATION * ");
                            // System.out.println(ANSI_CYAN + " * YOU WON AND RECEIVE 5 SCORE * \n" +
                            // ANSI_RED
                            // + "\n------------------------" + ANSI_RESET);
                            player[userNum].changeScore();// score +5
                            break;
                        }
                        if (flag == 0 && secret.length() < 10 && letter != ' ') {
                            lives--;
                            wrongs++;

                        } else if (flag == 0 && secret.length() > 9 && letter != ' ') {
                            count++;
                            wrongs++;
                            can--;
                        }
                        if (count == 2) {
                            lives--;
                            count = 0;
                        }
                    }
                    if (lives == 0) {
                        msg = "!!! GAME OVER !!!\nTHE WORD WAS: " + secret;
                        icon = new ImageIcon("C:\\Users\\Nik\\Desktop\\ap\\proj1\\asset\\unnamed.png");
                        JOptionPane.showMessageDialog(null, msg, ttl, PLAIN_MESSAGE, icon);
                        // man.print(lives);
                        // System.out.println(ANSI_RED + "!!! GAME OVER !!!" + ANSI_RESET);
                        // System.out.println(ANSI_BLUE + secret + ANSI_RESET + "\n\n\n");
                    }
                } else {// see leader board
                    clearScreen();
                    leaderBoard.printLeaderBoard(player, temp);
                    System.out.println();
                }
            }
            userNum = temp;
            fake = 2;
        }
    }
}
