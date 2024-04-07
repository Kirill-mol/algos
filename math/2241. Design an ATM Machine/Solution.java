class ATM {

    private int[] banknotes;

    public ATM() {
        banknotes = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            banknotes[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] result = new int[5];
        int remainingAmount = amount;

        result[4] = Integer.min(remainingAmount / 500, banknotes[4]);
        remainingAmount -= result[4] * 500;
        result[3] = Integer.min(remainingAmount / 200, banknotes[3]);
        remainingAmount -= result[3] * 200;
        result[2] = Integer.min(remainingAmount / 100, banknotes[2]);
        remainingAmount -= result[2] * 100;
        result[1] = Integer.min(remainingAmount / 50, banknotes[1]);
        remainingAmount -= result[1] * 50;
        result[0] = Integer.min(remainingAmount / 20, banknotes[0]);
        remainingAmount -= result[0] * 20;

        if (remainingAmount == 0) {
            subtractBanknotes(result);
            return result;
        } else {
            return new int[]{-1};
        }
    }

    private void subtractBanknotes(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            banknotes[i] -= banknotesCount[i];
        }
    }
}