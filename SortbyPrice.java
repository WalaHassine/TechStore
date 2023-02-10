 import java.util.Comparator;
 class SortbyPrice implements Comparator <Element> {
    public int compare(Element a, Element b){
        return (int) Math.ceil(a.getPrixArticle() - b.getPrixArticle());
    }
}
