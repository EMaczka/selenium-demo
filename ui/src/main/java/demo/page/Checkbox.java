package demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Checkbox {

    @FindBy(linkText = "Checkboxes")
    private WebElement pageLink;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    public Checkbox() {
    }

    private void goToCheckboxPage() {
        pageLink.click();
    }

    private boolean[] getCheckboxesStatusBefore() {

        boolean[] checkboxesStatusBefore = new boolean[checkboxes.size()];

        for(int i=0; i<checkboxes.size();i++) {
            checkboxesStatusBefore[i] = checkboxes.get(i).isSelected();
        }
        return checkboxesStatusBefore;
    }

    private void reverseCheckboxesStatuses() {
        for(WebElement checkbox : checkboxes) {
                checkbox.click();
            }
        }

    private boolean[] getCheckboxesStatusAfter() {
        reverseCheckboxesStatuses();

        boolean[] checkboxesStatusAfter = new boolean[checkboxes.size()];

        for(int i=0; i<checkboxes.size();i++) {
            checkboxesStatusAfter[i] = checkboxes.get(i).isSelected();
        }

        return checkboxesStatusAfter;
    }

    private boolean compareTable() {
        boolean[] beforeTab = getCheckboxesStatusBefore();
        boolean[] afterTab = getCheckboxesStatusAfter();

        for (int i=0;i<beforeTab.length;i++) {
            if(beforeTab[i] == afterTab[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean areEditableTest() {
        goToCheckboxPage();
        return compareTable();
    }
}
