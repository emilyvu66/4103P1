
public class checkRow implements Runnable{
    static int rowCount = 0;
    makeGrid table;

    public checkRow(makeGrid newGrid){
        table = newGrid;
    }
    
    @Override
    public void run(){
        int row[] = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            row = table.makeRow(i);
            for (int j = 0; j < 9; j++){
                sum += row[j];
            }
            if (sum != 45) {
                System.out.println("[" + Thread.currentThread().getName() + "] Row " + i + ": Invalid");
            }
            else {
                System.out.println("[" + Thread.currentThread().getName() + "] Row " + i + ": Valid");
                rowCount++;
            }
            sum = 0;
        }
    }
}