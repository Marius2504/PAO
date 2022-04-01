package menu;

public class clear {
    public void clearAll()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
