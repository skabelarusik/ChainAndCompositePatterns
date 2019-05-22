package by.epam.texthandling.resources;

public class RegularExpression {

    public static final String PARAGRAPH_SPLIT_REG_EX = "(?m)(?=^\\s{4})";
    public static final String SENTENCE_SPLIT_REG_EX = "(?<=\\.)";
    public static final String WORD_SPLIT_REG_EX = "\\s+";
    public static final String PUNKT_SPLIT_REG_EX = " ";
}
