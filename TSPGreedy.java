import java.util.*;
 
public class TSPGreedy {
 
    static void findMinRoute(int[][] tsp)
    {
        int sum = 0;
        int counter = 0;
        int j = 0, i = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> visitedRouteList
            = new ArrayList<>();
 
       visitedRouteList.add(0);
        int[] route = new int[tsp.length];
 
        while (i < tsp.length
               && j < tsp[i].length) {
 
            if (counter >= tsp[i].length - 1) {
                break;
            }
            if (j != i
                && !(visitedRouteList.contains(j))) {
                if (tsp[i][j] < min) {
                    min = tsp[i][j];
                    route[counter] = j + 1;
                }
            }
            j++;
            if (j == tsp[i].length) {
                sum += min;
                min = Integer.MAX_VALUE;
                visitedRouteList.add(route[counter] - 1);
                j = 0;
                i = route[counter] - 1;
                counter++;
            }
        }
        i = route[counter - 1] - 1;
 
        for (j = 0; j < tsp.length; j++) {
 
            if ((i != j) && tsp[i][j] < min) {
                min = tsp[i][j];
                route[counter] = j + 1;
            }
        }
        sum += min;
        System.out.print("Minimum Cost is : ");
        System.out.println(sum);
    }
    public static void
        main(String[] args)
    {
       Scanner a= new Scanner(System.in);
		System.out.println("Enter The number of city :");
		int city = a.nextInt();
		int[][] tsp = new int[city][city];
		for(int i=0;i<city;i++)
          	{
          	    for(int j=0;j<city;j++)
          	    {
             		     tsp[i][j] = a.nextInt();
             		 }
         	 }
		for(int c=0;c<city;c++)
		{
			for(int d=0;d<city;d++)
			{
				System.out.print(" "+tsp[c][d]);
			}
			System.out.println(" ");
		}
        findMinRoute(tsp);
    }
}