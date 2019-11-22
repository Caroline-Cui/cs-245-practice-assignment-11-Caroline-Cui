public class Find_The_Judge
{
    public static int findJudge(int n, int[][]trust)
    {
        int[] people = new int[n+1]; // initialize people to 0.
        // use array people store the people who trust others
        int p = -1; // people who has the potential to be the judge
        people[0] = -1;
        // use this for loop set people who trust other to -1
        // these people cannot be the judge
        for (int i = 0; i < trust.length; i++)
            people[trust[i][0]] = -1;
        // loop through the people array to find if there is anyone
        // who trust nobody
        for (int i = 1; i < n+1; i++)
        {
            if (people[i] == 0)
            {
                p = i;
                break;
            }
        }
        // if everyone trust others then return -1
        if (p == -1)
            return -1;
        // find the one who is trusted by all people in this town
        int count = 0;
        for (int i = 0; i < trust.length; i++)
            if (trust[i][1] == p)
                count++;
        if (count == n-1)
            return p;
        return -1;
    }

    public static void main(String[] args)
    {
        int judge = 0;
        int[][] arr1 = new int[1][2];
        arr1[0][0] = 1;
        arr1[0][1] = 2;
        judge = findJudge(2, arr1);
        System.out.println(judge);
        int[][] arr2 = new int[2][2];
        arr2[0][0] = 1;
        arr2[0][1] = 3;
        arr2[1][0] = 2;
        arr2[1][1] = 3;
        judge = findJudge(3, arr2);
        System.out.println(judge);
        int[][] arr3 = new int[3][2];
        arr3[0][0] = 1;
        arr3[0][1] = 3;
        arr3[1][0] = 2;
        arr3[1][1] = 3;
        arr3[2][0] = 3;
        arr3[2][1] = 1;
        judge = findJudge(3,arr3);
        System.out.println(judge);
        int[][] arr4 = new int[2][2];
        arr4[0][0] = 1;
        arr4[0][1] = 2;
        arr4[1][0] = 2;
        arr4[1][1] = 3;
        judge = findJudge(3,arr4);
        System.out.println(judge);
        int[][] arr5 = new int[5][2];
        arr5[0][0] = 1;
        arr5[0][1] = 3;
        arr5[1][0] = 1;
        arr5[1][1] = 4;
        arr5[2][0] = 2;
        arr5[2][1] = 3;
        arr5[3][0] = 2;
        arr5[3][1] = 4;
        arr5[4][0] = 4;
        arr5[4][1] = 3;
        judge = findJudge(4,arr5);
        System.out.println(judge);
    }
}
