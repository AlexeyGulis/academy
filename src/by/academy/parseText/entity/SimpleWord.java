package by.academy.parseText.entity;

public class SimpleWord extends Word{
    public String simpleWord;
    public SimpleWord(String simpleWord){
        super();
        this.simpleWord = simpleWord;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(" ").append(simpleWord);
        return sb.toString();
    }
}
