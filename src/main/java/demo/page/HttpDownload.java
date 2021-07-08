package demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HttpDownload {

    @FindBy(linkText = "File Download")
    private WebElement pageLink;

    @FindBy (tagName = "a")
    private List<WebElement> allLinks;

    private void goToDownloadPage() {
        pageLink.click();
    }

    private List<Integer> getStatusCode() throws Exception {

        List<HttpResponse> responses = new ArrayList<>();
        List<Integer> statusCodes = new ArrayList<>();
        for (int i = 1; i < allLinks.size()-1 ; i++) {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(allLinks.get(i).getAttribute("href")))
                    .build();

            responses.add(client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString()));
        }

        for (HttpResponse response : responses) {
            statusCodes.add(response.statusCode());
        }
        return  statusCodes;
    }

    public HttpDownload() {
    }

    public List<Integer> checkHttp() throws Exception {
        goToDownloadPage();
        return getStatusCode();
    }
}
