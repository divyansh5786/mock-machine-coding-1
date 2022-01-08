import java.util.*;

public class gamePlay {
    Map<Integer,snake> snakes = new HashMap<Integer, snake>();
    Map<Integer,ladder> ladders = new HashMap<Integer, ladder>();
    Set<player> players = new HashSet<player>();

    gamePlay(Map<Integer,snake> snakes,Map<Integer,ladder> ladders,Set<player> players)
    {
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }

    void checkSnakeLadder(player currPlayer)
    {
        while(snakes.get(currPlayer.pos)!=null ||ladders.get(currPlayer.pos)!=null)
        {
            snake currSnake = snakes.get(currPlayer.pos);
            ladder currLadder = ladders.get(currPlayer.pos);
            if(currSnake!=null)
            {
                currPlayer.pos = currSnake.end;
            }
            else
            {
                currPlayer.pos = currLadder.end;
            }
        }
    }
    void playthegame()
    {
        Dice dice = new Dice();
        int maxPos = 0;

        Iterator<player> playersIterator = players.iterator();
        while(maxPos!=100)
        {
            while(playersIterator.hasNext()) {

               player currPlayer = playersIterator.next();
               dice.rollDice();
               if(currPlayer.pos+ dice.val<=100)
               {
                   int startPos = currPlayer.pos;
                   currPlayer.pos
                           += dice.val;
                   checkSnakeLadder(currPlayer);
                   maxPos = Math.max(maxPos, currPlayer.pos);
                   System.out.println(currPlayer.name +"rolled a"+dice.val+" and moved from "+startPos+" to "+currPlayer.pos );
               }
               if(maxPos==100)
               {
                   System.out.println(currPlayer.name +"wins the game");
                   break;
               }


            }
            playersIterator = players.iterator();
        }
    }
}
