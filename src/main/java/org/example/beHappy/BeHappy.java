package org.example.beHappy;

import java.util.ArrayList;
import java.util.List;

public class BeHappy
{
    public static int findSadFeeling(int i, List<Integer> feelings) throws Exception
    {
        // returns the index of the next sad value, or -1 if none exists

        if (i < 0 || i >= feelings.size())
        {
            throw new Exception("Invalid parameter");
        }

        for (int index = i; index < feelings.size(); ++index)
        {
            if (feelings.get(index) < -1 || feelings.get(index) > 1) {
                throw new Exception("Invalid parameter");
            }
            if (feelings.get(index) == -1)
            {
                return index;
            }
        }
        return -1;
    }

    public static boolean checkNeighbours(int i, List<Integer> feelings) throws Exception
    {
        // Returns true if value or neighbours are ok, false otherwise

        if (i < 0 || i >= feelings.size())
        {
            throw new Exception("Invalid parameter");
        }

        if (feelings.get(i) != -1)
        {
            return true;
        }

        if (feelings.size() == 1 || i == 0 || i == feelings.size() - 1)
        {
            return false;
        }

        if (feelings.get(i - 1) != 1 || feelings.get(i + 1) != 1)
        {
            return false;
        }

        return true;
    }

    public static void InsertHappyFeelings(int i, List<Integer> feelings) throws Exception
    {
        // inserts happy neighbour values around i, if they do not exist

        if (i < 0 || i > feelings.size() || feelings.get(i) != -1)
        {
            throw new Exception("Invalid parameter");
        }

        boolean leftSideCovered = false, rightSideCovered = false;

        if (i == 0)
        {
            feelings.add(0, 1);
            leftSideCovered = true;
            i++;
        }
        if (i == feelings.size() - 1)
        {
            rightSideCovered = true;
            feelings.add(1);
        }

        if (!leftSideCovered && feelings.get(i - 1) != 1)
        {
            feelings.add(i, 1);
            i++;
        }
        if (!rightSideCovered && feelings.get(i + 1) != 1)
        {
            feelings.add(i + 1, 1);
        }
    }

    public static List<Integer> BeHappy(List<Integer> feelings) throws Exception
    {
        int nextSad = findSadFeeling(0, feelings);
        while (nextSad != -1)
        {
            if (!checkNeighbours(nextSad, feelings))
            {
                InsertHappyFeelings(nextSad, feelings);
            }

            nextSad = findSadFeeling(nextSad + 1, feelings);
        }
        return feelings;
    }

    public static void main(String[] args) throws Exception
    {
        List<Integer> testList = new ArrayList<>(List.of(-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, 1));
        List<Integer> outputList = new ArrayList<>(List.of(1, -1, 1, -1, 1, 0, 0, 1, 1, -1, 1, 0, 1, -1, 1, 0, 1, 1, -1, 1, 0, 1, 1));
        System.out.println(outputList.equals(BeHappy(testList)));
    }
}
