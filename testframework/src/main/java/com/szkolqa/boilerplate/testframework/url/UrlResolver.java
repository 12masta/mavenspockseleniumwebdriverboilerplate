package com.szkolqa.boilerplate.testframework.url;

public interface UrlResolver {
    void goToRelativeUrl(String relativeUrl);

    public String getUrlRelativePath();

    public String getUrl();
}
