import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * The plinko class is a really basic plinko game
 * due to the fact that we dont have a GUI setup yet the game simply randomly chooses a number out of an array in which a maximum of 5 spins can be earned
 * when the GUI is introduced we will still have to same array however the selection process will be based off of where a ball "lands" at the bottom 
 * of the screen.
 * 
 * @author
 * Matthew Forman
 */
public class Plinko {
    //Instance Variables
    private ArrayList<Integer> spinEarnedArray = new ArrayList<Integer>();
    private Random randIndexGenerator;
    private Player player = new Player("John Doe");
    
    /**
     * Plinko Constructor
     */
    public Plinko(){
        this.spinEarnedArray = new ArrayList<Integer>();
        this.randIndexGenerator = new Random();
    }

    /**
     * the getSpinsFromPlinko method randomly selects an index value from the array 
     * @return the int element of the array from the random index
     */    
    public int getSpinsFromPlinko(){
        int randIndex = randIndexGenerator.nextInt(spinEarnedArray.size());
        player.setSpins(spinEarnedArray.get(randIndex));
        System.out.println("Congratualtions you earned " + player.getSpins() + " spins!");
        return spinEarnedArray.get(randIndex);

    }

    /**
     * simple adding function for the setup of the Array
     * @param num is added to the array
     */
    public void addNum(int num){
        spinEarnedArray.add(num);
    }

    public int getValueFromSpinsEarnedArray(int i){
        ArrayList<Integer> getterSpins = new ArrayList<Integer>();
        for (int n: spinEarnedArray){
            getterSpins.add(n);
        }
        return getterSpins.get(i);
    } 

    public void setUserName(){
        Scanner userNameInput = new Scanner(System.in);
        System.out.println("Hello, please enter your name!");
        String userName = userNameInput.nextLine();

        player.setName(userName);
        System.out.println("Welcome " + player.getName() + "!");
        userNameInput.close();

    }

    
    /**
     * this function adds the initial values to the array that the game chooses from
     * this MUST be called before Plinko is played!!!
     */
    public void setUpPlinko(){
        this.addNum(2);
        this.addNum(4);
        this.addNum(3);
        this.addNum(1);
        this.addNum(5);
        this.addNum(1);
        this.addNum(3);
        this.addNum(4);
        this.addNum(2);

    }

    public static void main(String[] args){
        Plinko plinkoTerminal = new Plinko();
        plinkoTerminal.setUpPlinko();
        plinkoTerminal.setUserName();
        plinkoTerminal.getSpinsFromPlinko();


    } 
    
}
