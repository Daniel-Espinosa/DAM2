package net.openwebinars.helloworld.maven;

import org.apache.commons.lang3.RandomStringUtils;

public class App {

    public static void main(String[] args) {
        System.out.println(String.format("Hello World random message: %s", RandomStringUtils.randomAscii(10)));
    }

}
