package q4_answer;

class Wrapper {
    static String warp(String s, int width) {
        if (s == null) { return ""; }
        if (s.length() <= width) { return s; }

        int breakPosition = s.lastIndexOf(' ', width);
        if (breakPosition == -1) {
            breakPosition = width;
        }
        return s.substring(0, breakPosition).trim() + '\n' + warp(s.substring(breakPosition).trim(), width);
    }
}
