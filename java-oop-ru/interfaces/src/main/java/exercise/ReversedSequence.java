package exercise;

import java.util.stream.IntStream;

// BEGIN
public class ReversedSequence implements CharSequence{

    private String sequence;

    public ReversedSequence(String sequence) {
        this.sequence = new StringBuilder(sequence).reverse().toString();;
    }

    @Override
    public int length() {
        return this.sequence.length();
    }

    @Override
    public char charAt(int index) {
        return this.sequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.sequence.subSequence(start, end);
    }

    @Override
    public String toString() {
        return this.sequence;
    }
}
// END
