import java.io.*;
import java.net.URL;

/**
 * Created by kunze on 1/13/2017.
 * Thank you, for the 
 */
public class main {
    public static void main(String[] args) throws IOException {
        PrintWriter strongPosWriter = new PrintWriter("strongPosWords.txt");
        PrintWriter strongNegWriter = new PrintWriter("strongNegWords.txt");
        PrintWriter weakPosWriter = new PrintWriter("weakPosWords.txt");
        PrintWriter weakNegWriter = new PrintWriter("weakNegWords.txt");
        URL path = ClassLoader.getSystemResource("wordDict.txt");
        BufferedReader reader = new BufferedReader(new FileReader("src/wordDict.txt"));
        String line = reader.readLine();

        while (line != null) {
            String[] lineArray = line.split(" ");
            String word = lineArray[2].substring(6);
            String wordStrength = lineArray[0];
            String wordConnotation = lineArray[5];

            if (wordStrength.equals("type=strongsubj")) {
                if (wordConnotation.equals("priorpolarity=positive")) {
                    //STRONG POS
                    strongPosWriter.println(word);
                } else {
                    //STRONG NEG
                    strongNegWriter.println(word);
                }
            } else if(wordStrength.equals(("type=weaksubj"))) {
                if (wordConnotation.equals("priorpolarity=positive")) {
                    //WEAK POS
                    weakPosWriter.println(word);
                } else {
                    //WEAK NEG
                    weakNegWriter.println(word);
                }
            }
            try {
                line = reader.readLine();
            } catch (Exception e) {
                System.out.println("Failure reading line");
            }

        }
        weakNegWriter.close();
        weakPosWriter.close();
        strongNegWriter.close();
        strongPosWriter.close();

    }
}