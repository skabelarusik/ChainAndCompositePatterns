package by.epam.texthandling.resource;

public class RegularExpression {

    public static final String PARAGRAPH_SPLIT_REG_EX = "(?m)(?=^\\s{4})";
    public static final String SENTENCE_SPLIT_REG_EX = "(?<=(\\.|\\!|\\?|\u2620))";
    public static final String WORD_SPLIT_REG_EX = "\\s+";
    public static final String PUNСT_SPLIT_REG_EX = " ";
}
