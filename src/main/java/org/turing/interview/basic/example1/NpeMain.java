package org.turing.interview.basic.example1;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Optional;

public class NpeMain {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        Address myAddress = new Address("123 Main St", " Austin ", "CA");
        User myUser = new User("John Doe", 35, myAddress);
        String city = Optional.of(myUser)
                .map(User::getAddress)
                .map(Address::getCity)
                .map(String::trim)
                .orElseGet(NpeMain::getDefaultCity);
        System.out.println(city);
    }

    public static String getDefaultCity() {
        System.out.println("get default city");
        return "changzhou";
    }


}
