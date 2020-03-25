import KnapsackItems.*;
import ProblemObjects.Knapsack;
import Utilities.Algorithm.*;
import Utilities.Problem;
import Utilities.ProblemRandomiser;

import java.util.Arrays;


public class StartPoint {
    public static void main(String[] args) {
        Problem p = new Problem();

        p.addItems(
                new Book("Dragon Rising", 300, 5),
                new Book("A Blade In The Dark", 500, 5),
                new Food("Cabbage", 2, 4),
                new Food("Venison", 7),
                new Weapon(Weapon.WeaponTypes.SWORD)
        );

        p.addKnapsack(new Knapsack(20));

        p.getKnapsack().clearKnapsack();
        //p = new ProblemRandomiser().generateProblem();

        //System.out.println(p);

        Algorithm a = new Greedy(p.getKnapsack(), p.getItems());
        System.out.println(a);

        p.getKnapsack().clearKnapsack();

        Algorithm b = new Dynamic(p.getKnapsack(), p.getItems());
        System.out.println(b);


    }


}
