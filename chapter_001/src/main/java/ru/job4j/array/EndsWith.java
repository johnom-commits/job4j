package ru.job4j.array;

public class EndsWith {
    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        int dif = wrd.length - pst.length;
        for (int i = pst.length - 1; i >= 0; i--) {
            if (pst[i] != wrd[i + dif]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
