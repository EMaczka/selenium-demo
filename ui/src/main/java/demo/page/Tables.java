package demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class Tables {

    @FindBy(linkText = "Sortable Data Tables")
    private WebElement pageLink;

    @FindBy(css = "#table1 thead tr th:nth-of-type(1)")
    private WebElement tableOneLastNameHeader;

    @FindBy(css = "#table1 tbody tr td:nth-of-type(1)")
    private List<WebElement> tableOneLastNameValues;

    @FindBy(css = "#table1 thead tr th:nth-of-type(2)")
    private WebElement tableOneFirstNameHeader;

    @FindBy(css = "#table1 tbody tr td:nth-of-type(2)")
    private List<WebElement> tableOneFirstNameValues;

    @FindBy(css = "#table1 thead tr th:nth-of-type(3)")
    private WebElement tableOneEmailHeader;

    @FindBy(css = "#table1 tbody tr td:nth-of-type(3)")
    private List<WebElement> tableOneEmailValues;

    @FindBy(css = "#table1 thead tr th:nth-of-type(4)")
    private WebElement tableOneDueHeader;

    @FindBy(css = "#table1 tbody tr td:nth-of-type(4)")
    private List<WebElement> tableOneDueValues;

    @FindBy(css = "#table1 thead tr th:nth-of-type(5)")
    private WebElement tableOneWebSiteHeader;

    @FindBy(css = "#table1 tbody tr td:nth-of-type(5)")
    private List<WebElement> tableOneWebSiteValues;

    private List<Double> numberValues = new LinkedList<>();
    private List<WebElement> stringValues = new LinkedList<>();

    private String columnToBeSort;
    private String sortType;

    public Tables() {
    }

    private void goToTablesPage() {
        pageLink.click();
    }

    private void sortBy(String columnName, String method) {
        goToTablesPage();

        switch (columnName) {
            case "Due":
                tableOneDueHeader.click();
                if (method.equalsIgnoreCase("desc")) {
                    tableOneDueHeader.click();
                }
                for (WebElement element : tableOneDueValues) {
                    numberValues.add(Double.parseDouble(element.getText().replace("$", "")));
                }
                break;
            case "Email":
                tableOneEmailHeader.click();
                if (method.equalsIgnoreCase("desc")) {
                    tableOneEmailHeader.click();
                }
                stringValues.addAll(tableOneEmailValues);
                break;
            case "First Name":
                tableOneFirstNameHeader.click();
                if (method.equalsIgnoreCase("desc")) {
                    tableOneFirstNameHeader.click();
                }
                stringValues.addAll(tableOneFirstNameValues);
                break;
            case "Last Name":
                tableOneLastNameHeader.click();
                if (method.equalsIgnoreCase("desc")) {
                    tableOneLastNameHeader.click();
                }
                stringValues.addAll(tableOneLastNameValues);
                break;
            case "Web Site":
                tableOneWebSiteHeader.click();
                if (method.equalsIgnoreCase("desc")) {
                    tableOneWebSiteHeader.click();
                }
                stringValues.addAll(tableOneWebSiteValues);
                break;
        }
    }

    public boolean isColumnSorted(String columnName, String method) {
        this.columnToBeSort = columnName;
        this.sortType = method;

        sortBy(columnName, method);

        if (numberValues.size() > 0) {
            if (method.equalsIgnoreCase("asc")) {
                for (int counter = 0; counter < numberValues.size() - 1; counter++) {
                    if ((numberValues.get(counter)) > (numberValues.get(counter + 1))) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int counter = 0; counter < numberValues.size() - 1; counter++) {
                    if ((numberValues.get(counter)) < (numberValues.get(counter + 1))) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            if (method.equalsIgnoreCase("asc")) {
                for (int counter = 0; counter < stringValues.size() - 1; counter++) {
                    if ((stringValues.get(counter).getText().compareTo(stringValues.get(counter + 1).getText())) > 0) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int counter = 0; counter < stringValues.size() - 1; counter++) {
                    if ((stringValues.get(counter).getText().compareTo(stringValues.get(counter + 1).getText())) < 0) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
