package by.academy.parseText.entity;

public class PunctuationMarks extends Word {
    public String punctuationMark;

    public PunctuationMarks(String punctuationMark) {
        super();
        this.punctuationMark = punctuationMark;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(punctuationMark);
        return sb.toString();
    }
}
