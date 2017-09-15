package chapter3;

/**
 * Created by kamil on 2017-09-05.
 */
public class SetupTeardownIncluder {
    private final PageData pageData;
    private final WikiPage testPage;
    private boolean isSuite;
    private StringBuffer newPageContent;
    private PageCrawler pageCrawler;

    public static String render(PageData pageData) throws Exception {
        return render(pageData, false);
    }

    public static String render(PageData pageData, boolean isSuite)throws Exception {
        return new SetupTeardownIncluder(pageData).render(isSuite);
    }

    private SetupTeardownIncluder(PageData pageData){
        this.pageData = pageData;
        testPage = pageData.getWikiPage();
        pageCrawler = testPage.getPageCrawler();
        newPageContent = new StringBuffer();
    }

    private String render(boolean isSuite) throws Exception {
        this.isSuite = isSuite;
        if(isTestPage()){
            includeSetupAndTeardownPages();
        }
        return pageData.getHtml();
    }

    private boolean isTestPage(){
        return pageData.hasAttribute("Test");
    }

    private void includeSetupAndTeardownPages() throws Exception {
        includeSetupPages();
        includePageContent();
        includeTeardownPages();
        updatePageContent();
    }

    private void includeSetupPages() throws Exception {
       if(isSuite){
           includeSuitSetupPage();
       }
       includeSetupPage();
    }

    private void includeSuitSetupPage() throws Exception {
        include(SuiteResponder.SUITE_SETUP_NAME, "-setup");
    }

    private void includeSetupPage()  throws Exception{
       include("SetUp", "-setup");
    }

    private void includePageContent()  throws Exception{
        newPageContent.append(pageData.getContent());
    }

    private void includeTeardownPages(){
        includeTeardownPage();
        if(isSuite){
            includeSuiteTeardownPage();
        }
    }

    private void includeTeardownPage(){
        include("TearDown", "-teardown");
    }

    private void includeSuiteTeardownPage(){
        include(SuiteResponder.SUITE_TEAR_DOWN_NAME, "-teardown");
    }

    private void updatePageContent(){
        pageData.setContent(newPageContent.toString());
    }

    private void include(String pageName, String arg){
        WikiPage inheritedPage = findInheritedPage(pageName);
        if(inheritedPage != null){
            String pagePathName = getPathNameForPage(inheritedPage);
            buildIncludeDirective(pagePathName, arg);
        }
    }

    private WikiPage findInheritedPage(String pageName){
        return PageCrawlerImpl.getInheritedPage(pageName, testPage);
    }

    private String getPathNameForPage(WikiPage page){
        WikiPagePath pagePath = pageCrawler.getFullPath(page);
        return PathParser.render(pagePath);
    }

    private void buildIncludeDirective(String pagePathName, String arg){
        newPageContent
                .append("\n!include ")
                .append(arg)
                .append(" .")
                .append(pagePathName)
                .append("\n");
    }

}
