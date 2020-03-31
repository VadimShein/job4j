package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
    }

    @Override
    public void passenger(int number) {

    }

    @Override
    public int fuel(int volume) {
        int cost = 40;
        return cost * volume;
    }
}
