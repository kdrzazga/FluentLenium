package org.fluentlenium.seleniumeasy.test.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PageUrl("https://www.seleniumeasy.com/test/table-pagination-demo.html")
public class TablePaginationPage extends FluentPage {

    @FindBy(xpath = "//div[@class='col-md-6 text-left']")
    private FluentWebElement paragraph;

    @FindBy(xpath = "//table[@class='table table-hover']")
    private FluentWebElement table;

    @FindBy(xpath = "//tbody[@id='myTable']/tr[@style='display: table-row;']")
    private List<FluentWebElement> visibleTableRows;

    @FindBy(css = "a.page_link")
    private List<FluentWebElement> pageLinks;

    @FindBy(css = "a.page_link.active")
    private FluentWebElement activePageLink;

    public List<String> getPageLinksTexts() {

        if (pageLinks == null) return List.of("");

        return pageLinks.stream().map(FluentWebElement::text)
                .collect(Collectors.toList());
    }

    public String getActivePageLinkText() {
        return Optional.ofNullable(activePageLink)
                .map(FluentWebElement::text)
                .orElse("");
    }

    public String getParagraph() {
        return Optional.ofNullable(paragraph)
                .map(FluentWebElement::text)
                .orElse("");
    }

    public String getWholeTableContent() {
        return Optional.ofNullable(table)
                .map(FluentWebElement::text)
                .orElse("");
    }

    public void clickLink(int number) {
        number = (number > 0) ? number - 1 : 0;

        if (number >= pageLinks.size()) return;

        pageLinks.get(number).click();
    }

    public List<String> getVisibleTableRows() {

        //needed something adequate to PageFactory.initElements();

        if (visibleTableRows.isEmpty())
            return List.of("");

        return visibleTableRows.stream().map(FluentWebElement::text)
                .collect(Collectors.toList());
    }
}
