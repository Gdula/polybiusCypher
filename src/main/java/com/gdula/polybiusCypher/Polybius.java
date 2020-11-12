package com.gdula.polybiusCypher;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.List;

public class Polybius {

    public String polybiusCipher(String s) {
        int row, col;
        String cipher = "";

        // convert each character
        // to its encrypted code
        for (int i = 0; i < s.length(); i++) {

            // finding row of the table
            row = (int) Math.ceil((s.charAt(i) - 'a') / 5) + 1;

            // finding column of the table
            col = ((s.charAt(i) - 'a') % 5) + 1;

            // if character is 'k'
            if (s.charAt(i) == 'k') {
                row = row - 1;
                col = 5 - col + 1;
            }

            // if character is greater than 'j'
            else if (s.charAt(i) >= 'j') {
                if (col == 1) {
                    col = 6;
                    row = row - 1;
                }
                col = col - 1;
            }
            cipher += row;
            cipher += col;

            cipher += " ";

        }

        return cipher;
    }
}
