
public class checkColumn implements Runnable {
    static int columnCount = 0;
    makeGrid table;

    public checkColumn(makeGrid newGrid){
        table = newGrid;
    }

    @Override
    public void run(){
        int row[] = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            row = table.makeColumn(i);
            for (int j = 0; j < 9; j++){
                sum += row[j];
            }
            if (sum != 45) {
                System.out.println("[" + Thread.currentThread().getName() + "] Column " + i + ": Invalid");
            }
            else {
                System.out.println("[" + Thread.currentThread().getName() + "] Column " + i + ": Valid");
                columnCount++;
            }
            sum = 0;
        }
    }
}