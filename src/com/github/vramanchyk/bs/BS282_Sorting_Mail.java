package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 8/4/20.
 */
public class BS282_Sorting_Mail {

    public String[] solve(String[][] mailboxes) {

        final List<String> answer = new ArrayList<>();

        int column = 0;
        while (true) {
            boolean hasColumns = false;

            for (String[] mailbox : mailboxes) {
                if (column < mailbox.length) {
                    hasColumns = true;

                    if (!"junk".equals(mailbox[column])) {
                        answer.add(mailbox[column]);
                    }
                }
            }

            if (!hasColumns) {
                break;
            }

            column++;
        }

        return answer.toArray(new String[0]);
    }
}
