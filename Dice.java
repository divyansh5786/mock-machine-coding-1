public class Dice {
int val;

    Dice()
    {
        val=0;
    }
    void rollDice()
    {
        val = (int)(Math.random()*6);
    }
}
