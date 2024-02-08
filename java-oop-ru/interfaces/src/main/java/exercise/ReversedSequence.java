package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        this.str = str;
    }

    public int length() {
        return str.length();
    }

    public char charAt(int index) {
        return str.charAt(length() - index - 1);
    }

    public CharSequence subSequence(int start, int end) {
        return new StringBuilder(str.substring(start, end)).reverse().toString();
    }

    public String toString() {
        return new StringBuilder(str).reverse().toString();
    }
}
// END
