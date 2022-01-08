import java.io.*;
import java.util.*;


public class main {

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSnake =  Integer.parseInt(br.readLine());
        Map<Integer,snake> snakes = new HashMap<Integer, snake>();
        for(int i=0;i<numberOfSnake;i++)
        {
            String input[] = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            snake newSnake = new snake(start,end);
            snakes.put(start,newSnake);
        }

        int numberOfLadder =  Integer.parseInt(br.readLine());
        Map<Integer,ladder> ladders = new HashMap<Integer, ladder>();
        for(int i=0;i<numberOfLadder;i++)
        {
            String input[] = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            ladder newLadder = new ladder(start,end);
            ladders.put(start,newLadder);
        }

        int numberOfPlayers =  Integer.parseInt(br.readLine());
        Set<player> players = new HashSet<player>();
        for(int i=0;i<numberOfPlayers;i++)
        {
            String name = br.readLine();
            players.add(new player(name));
        }
        gamePlay demo = new gamePlay(snakes,ladders,players);
        demo.playthegame();
    }
}


