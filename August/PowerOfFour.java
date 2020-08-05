class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return Math.log(num)/Math.log(2) % 2 == 0;
    }
}
