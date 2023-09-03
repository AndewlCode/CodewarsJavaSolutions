package Classes.Nessie;

public class Nessie {
    public static boolean isLockNessMonster(String s){
        //FIND THE LOCH NESS MONSTER. SAVE YOUR TREE FIDDY
        String [] monstersSignatures = new String[]{"three fifty","tree fiddy","3.50" };
        for (String monstersSignature : monstersSignatures) {
            if (s.contains(monstersSignature)){
                return true;
            }
        }
        return false;
    }
}
