package demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpDownload {

    @FindBy(linkText = "File Download")
    private WebElement pageLink;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/a[1]")
    private WebElement file;

    private void goToDownloadPage() {
        pageLink.click();
    }

    private int getStatusCode() throws Exception {

        String link = file.getAttribute("href");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();

        HttpResponse response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

        return  response.statusCode();
    }

    public HttpDownload() {
    }

    public Integer checkHttp() throws Exception {
        goToDownloadPage();
        return getStatusCode();
    }
}
