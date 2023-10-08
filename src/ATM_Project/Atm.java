package ATM_Project;

public class Atm {
    public static int atmBalance = 0;
    public Atm() {
    }
    public static int getAtmBalance() {
        return atmBalance;
    }
    public static void setAtmBalance(int atmBalance) {
        Atm.atmBalance = atmBalance;
    }
}
