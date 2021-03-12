package com.jhon.demo.temp;

import java.awt.*;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

public class test {

    public static void main(String[] args) throws Exception {

        String input = "1233";

        System.out.println(Long.parseLong(input));
    }
    public static String strYtoStrF(String input) {
        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        return decimalFormat.format(Double.parseDouble(input) * 100);
    }

}
