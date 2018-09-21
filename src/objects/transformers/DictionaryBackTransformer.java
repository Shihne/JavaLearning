package objects.transformers;

public class DictionaryBackTransformer extends WordsTransformerWithList {

    public DictionaryBackTransformer(String s) {
        super(s);
    }

    @Override
    public String transform(String str) {
        if(str.startsWith("xxx"))
            return str.substring(3);
        else if(str.matches("\\d{1,8}"))
            return words.get(Integer.parseInt(str));
        else
            return str;
    }
}
