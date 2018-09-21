package objects.transformers;

public class DictionaryTransformer extends WordsTransformerWithList {

    public DictionaryTransformer(String s) {
        super(s);
    }

    @Override
    public String transform(String str) {
        str = str.toLowerCase();
        if(words.contains(str))
            return words.indexOf(str) + "";
        else
            return "xxx" + str;
    }
}
