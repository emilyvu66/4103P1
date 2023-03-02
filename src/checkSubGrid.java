
public class checkSubGrid implements Runnable {
    static int subGridCount = 0;
    makeGrid table;

    public checkSubGrid(makeGrid newGrid){
        table = newGrid;
    }
    @Override
    public void run() {
        int grid[][] = new int[9][9];
        grid = table.makeGridArray();
        // subgrid R012-C012, R012-C345, R012-C678
        for (int a = 0; a < 9; a = a + 3) {
            int sum = 0;
            for (int i = a; i < a + 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += grid[j][i];
                }
            }
            if (sum != 45) {
                System.out.println("[" + Thread.currentThread().getName() + "] Subgrid R012C" + a + (a + 1) + (a + 2) + ": Invalid");
            } 
            else {
                System.out.println("[" + Thread.currentThread().getName() + "] Subgrid R012C" + a + (a + 1) + (a + 2) + ": Valid");
                subGridCount++;
            }
        }

        // subgrid R345-C012, R345-C345, R345-C678
        for (int a = 0; a < 9; a = a + 3) {
            int sum = 0;
            for (int i = a; i < a + 3; i++) {
                for (int j = 3; j < 6; j++) {
                    sum += grid[j][i];
                }
            }
            if (sum != 45) {
                System.out.println("[" + Thread.currentThread().getName() + "] Subgrid R345C" + a + (a + 1) + (a + 2) + ": Invalid");
            } 
            else {
                System.out.println("[" + Thread.currentThread().getName() + "] Subgrid R345C" + a + (a + 1) + (a + 2) + ": Valid");
                subGridCount++;
            }
        }
        // subgrid R678-C012, R678-C345, R678-C678
        for (int a = 0; a < 9; a = a + 3) {
            int sum = 0;
            for (int i = a; i < a + 3; i++) {
                for (int j = 6; j < 9; j++) {
                    sum += grid[j][i];
                }
            }
            if (sum != 45) {
                System.out.println("[" + Thread.currentThread().getName() + "] Subgrid R678C" + a + (a + 1) + (a + 2) + ": Invalid");
            }
            else {
                System.out.println("[" + Thread.currentThread().getName() + "] Subgrid R678C" + a + (a + 1) + (a + 2) + ": Valid");
                subGridCount++;
            }
        }
    }
}