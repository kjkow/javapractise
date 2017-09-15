package chapter3;

/**
 * Created by kamil on 2017-09-05.
 */
public class PageData {
    private String html;
    private WikiPage wikiPage;
    private String content;

    public String getHtml() {
        return html;
    }

    public WikiPage getWikiPage() {
        return wikiPage;
    }

    public boolean hasAttribute(String attribute) {
        return false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
