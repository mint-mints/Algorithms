package other;

public class O05_ReplaceSpace {
    /**
     * 把字符串 s 中的每个空格替换成"%20"。
     */
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
