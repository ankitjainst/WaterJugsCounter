package com.swiftthoughts;

//Represents the state of water jugs and the capacities of water jugs
public class WaterJugsState {

    //the current quantity of water in jugs
    public int a, b;

    //the amount of steps that remain to solve from this state of water jug
    public int stepsRemaining;

    //the size of water jugs a and b
    //name clarification ma is max a, mb is maxb
    public static int ma, mb;

    //a reference to the water jug from which this state was reached
    public WaterJugsState parent;

    //a description of the move required to achieve this state of water jug, helpful in order to understand the step taken
    public String desc;

    //constructor to create water jugs state
    public WaterJugsState(int jugACapacity, int jugBCapacity, int stepsRemaining, WaterJugsState parent, String desc){
        a = jugACapacity;
        b = jugBCapacity;
        this.stepsRemaining = stepsRemaining;
        this.parent = parent;
        this.desc = desc;
    }

    //helper function to create next state of water jugs
    private WaterJugsState privateCons(int an, int bn, int stepsRemaining, String desc)
    {
        return new WaterJugsState(an, bn, stepsRemaining, this, desc);
    }
    //throw away a
    public WaterJugsState move1()
    {
        return privateCons(0, b, stepsRemaining - 1, "throw away a");
    }
    //throw away b
    public WaterJugsState move2()
    {
        return privateCons(a, 0, stepsRemaining - 1, "throw away b");
    }
    //put from a into b ... remaining capacity in b is mb - b and precondition is a >= mb - b
    public WaterJugsState move3()
    {
        if(!(a>= mb -b)) return null;
        int newB = mb;
        int newA = a - (mb - b);
        return privateCons(newA, newB, stepsRemaining - 1,"put from a into b, a >= mb - b");
    }

    //put from a into b ... remaining capacity in b is mb - b and another precondition can be when a < mb - b
    public WaterJugsState move4()
    {
        if((a>= mb -b)) return null;
        int newB = b + (a);
        int newA = 0;
        return privateCons(newA, newB, stepsRemaining - 1, "put from a into b, a < mb - b");
    }

    //put from b into a ... remaining capacity in a is ma - a and precondition is b >= ma - a
    public WaterJugsState move5()
    {
        if(!(b >= ma - a)) return null;
        int newA = ma;
        int newB = b - (ma - a);
        return privateCons(newA, newB, stepsRemaining - 1, "put from b into a, b >= ma - a");
    }

    //put from b into a ... remaining capacity in a is ma - a and another precondition can be when b < ma - a
    public WaterJugsState move6()
    {
        if((b >= ma - a)) return null;
        int newA = a + (b);
        int newB = 0;
        return privateCons(newA, newB, stepsRemaining - 1, "put from b into a, b < ma - a");
    }

    //fill a to full
    public WaterJugsState move7()
    {
        return privateCons(ma, b, stepsRemaining - 1, "fill a to full");
    }

    //fill b to full
    public WaterJugsState move8()
    {
        return privateCons(a, mb, stepsRemaining - 1, "fill b to full");
    }

    //helper function useful to print the intermediate steps required to extract the quantity from water jugs
    public void printJugStateAncestory()
    {
        System.out.println("("+a + " " + b+"), "+desc);
        if(parent != null)
            parent.printJugStateAncestory();

    }

    //helper function useful to get the number of steps required to extract the desired quantity
    public int getAncestoryLength()
    {
        int count = 0;
        WaterJugsState currNode = this;
        while(currNode != null) {

            currNode = currNode.parent;
            count++;
        }
        return count;
    }
}
