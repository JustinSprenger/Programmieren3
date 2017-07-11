/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.opu.brovkov.io;

/**
 *
 * @author user
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EncodingTest {

    public static void main(String[] args) throws IOException {
        String s1 = "Alpha \u03b1, Beta \u03b2, Epsilon \u03b5";
        try (OutputStreamWriter out = new OutputStreamWriter(
                new FileOutputStream("data.txt"), "UTF-8")) {
            out.write(s1);
        }
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(
                "data.txt"), "UTF-8")) {
            int c;
            StringBuilder sb = new StringBuilder();
            while ((c = in.read()) != -1) {
                sb.append((char) c);
            }
            String s2 = sb.toString();
            System.out.println(s2);
            System.out.println(s1.equals(s2));
        }
    }
}
