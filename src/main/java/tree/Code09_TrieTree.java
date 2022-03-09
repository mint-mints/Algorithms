package tree;

public class Code09_TrieTree {

    public static class TrieNode {
        int pass;
        int end;
        TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];     // 代表26个字母
        }
    }

    public static class TireTree {
        private TrieNode root;

        // insert a word
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            for (char c : chars) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        // delete a word
        public void delete(String word) {
            if (word == null) {
                return;
            }
            if (search(word) == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            for (char c : chars) {
                int index = c - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

        // search the times of word
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (char c : chars) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // return the num of strings which begin with pre
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            for (char c : chars) {
                int index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

    }

}
