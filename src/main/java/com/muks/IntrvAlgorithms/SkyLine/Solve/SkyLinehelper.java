package com.muks.IntrvAlgorithms.SkyLine.Solve;

/*
 * Created by mukthar.ahmed on 2/2/16.
 */



public class SkyLinehelper {

    public static SkyLine traverse(Building[] arr, int l, int h) {
        if (l == h) {
            SkyLine res = new SkyLine(2);
            res.append(new Strip(arr[l].left, arr[l].height));
            res.append(new Strip(arr[l].right, 0));
            return res;
        }

        int mid = (l + h)/2;

        // Recur for left and right halves and merge the two results
        SkyLine sl = traverse(arr, l, mid);
        SkyLine sr = traverse(arr, mid+1, h);
//        System.out.println("+ sl = " + sl.toString());
//        System.out.println("+ sr = " + sr.toString());
        SkyLine res = Merge(sl, sr);

        // Return merged skyline
        for (Strip strip : res.strips) {
            System.out.print(" " + strip);
        }
        return res;
    }


    public static SkyLine Merge(SkyLine skyLine1, final SkyLine skyLine2) {
        // Merge logic
        // Create a resultant skyline with capacity as sum of two skylines
        SkyLine res = new SkyLine(skyLine1.strips.length + skyLine2.strips.length);

        // To store current heights of two skylines
        int h1 = 0, h2 = 0;

        // Indexes of strips in two skylines
        int i = 0, j = 0;
        while (i < skyLine1.strips.length && j < skyLine2.strips.length) {

            if (skyLine1.strips[i] == null) {
                System.out.println("111111111");
            }
            if (skyLine2.strips[j] == null) {
                System.out.println("222222222");
            }

            if (skyLine1.strips[i] == null && skyLine2.strips[j] == null) {
                i++;
                j++;
                continue;
            }
            // Compare x coordinates of left sides of two skylines and put the smaller one in result
            if (skyLine1.strips[i] == null && skyLine2.strips[j] != null) {
                System.out.println("+ 1 is null");

                int x2 = skyLine2.strips[j].left;
                h2 = skyLine2.strips[j].height;

                int maxh = Math.max(h1, h2);

                res.append(new Strip(x2, maxh));
                j++;
            }
            else if (skyLine1.strips[i] != null && skyLine2.strips[j] == null) {
                System.out.println("+ 2 is null");
                int x1 = skyLine1.strips[i].left;
                h1 = skyLine1.strips[i].height;

                // Choose height as max of two heights
                int maxh = Math.max(h1, h2);

                res.append(new Strip(x1, maxh));
                i++;
            }

            else if (skyLine1.strips[i].left < skyLine2.strips[j].left) {
                int x1 = skyLine1.strips[i].left;
                h1 = skyLine1.strips[i].height;

                // Choose height as max of two heights
                int maxh = Math.max(h1, h2);

                res.append(new Strip(x1, maxh));
                i++;
            }
            else {
                int x2 = skyLine2.strips[j].left;
                h2 = skyLine2.strips[j].height;

                int maxh = Math.max(h1, h2);

                res.append(new Strip(x2, maxh));
                j++;
            }
        }

        // If there are strips left in this skyline or other
        // skyline
        while (i < skyLine1.strips.length){
            res.append(skyLine1.strips[i]);
            i++;
        }
        while (j < skyLine2.strips.length) {
            res.append(skyLine2.strips[j]);
            j++;
        }

        return res;
        //return skyLine1;

    }



    public static void traverseBuildings(Building[] mainArray, int l, int h) {

        if (mainArray.length <= 1) {
            return;
        }

        // Split the array in half
        int mid = mainArray.length/2;
        Building[] first = new Building[mid];
        Building[] second = new Building[mainArray.length - mid];

        int i;
        for (i = 0 ; i < mid; i++) {
            first[i] = mainArray[i];
        }

        for (int j = mid; j < mainArray.length; j++) {
            second[j - mid] = mainArray[j];
        }

        // Sort each half
        traverseBuildings(first, 0, first.length);
        traverseBuildings(second, 0, second.length);

        // Merge the halves together, overwriting the original array
        buildingsToSkyline(first, second);

    }

    private static void buildingsToSkyline(Building[] first, Building[] second) {
        System.out.println("===================================================");

        System.out.println("+ First set of buildings");
        for (Building building : first) {
            building.print();
        }

        System.out.println("\n");
        System.out.println("+ Second set of buildings");

        for (Building building : second) {
            building.print();
        }

        System.out.println("\n");
        System.out.println("===================================================");
    }


}
