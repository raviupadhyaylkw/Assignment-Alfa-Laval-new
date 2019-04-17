/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
public static void main (String[] args) throws java.lang.Exception
{
int[] weights = {10, 3,10,2,8,50,25,2,8,6};
           
        int[] values = {30,6,15, 10,24,10,50,6,20,24};
        
        int n = 10;

        List < Integer > items_to_pack = new ArrayList < > ();

        List < Integer > items_to_pack_vals = new ArrayList < > ();

        int total_weight = 0;

        double vals_per_weight[] = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            vals_per_weight[i] = (values[i] / (double) weights[i]);
            // System.out.print(" "+vals_per_weight[i]);
        }
         
         pairsort(vals_per_weight,weights,values,n); 

        for (int i = values.length - 1; i >= 0; i--) {
            total_weight += weights[i];
            if (total_weight <= 40) {
                items_to_pack.add(weights[i]);
                items_to_pack_vals.add(values[i]);
            } else {
                total_weight -= weights[i];
            }
        }

        System.out.println(total_weight);
        System.out.println(items_to_pack);
        System.out.println(items_to_pack_vals);


}

public static void pairsort(double v[], int a[], int b[], int n) {
        //HashMap < Integer, Integer > map1 = new HashMap < > (20);
        TreeMap < String, String > map2 = new TreeMap < > ();

        for (int i = 0; i < n; i++) {
            map2.put(v[i] + "-" + i, a[i] + "-" + b[i]);
        
        }
        
        
        int i = 0;
        for (Map.Entry < String, String > entry: map2.entrySet()) {
            a[i] = Integer.parseInt(entry.getValue().substring(0, entry.getValue().indexOf("-")));
            b[i] = Integer.parseInt(entry.getValue().substring(entry.getValue().indexOf("-") + 1, entry.getValue().length()));
            //System.out.print(" "+Integer.parseInt(entry.getValue().substring(0,entry.getValue().indexOf("-"))));
            //System.out.print("*"+Integer.parseInt(entry.getValue().substring(entry.getValue().indexOf("-")+1,entry.getValue().length())));

            i++;
        }

    }
}
