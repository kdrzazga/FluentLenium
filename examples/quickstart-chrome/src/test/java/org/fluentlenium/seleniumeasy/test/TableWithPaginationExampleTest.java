package org.fluentlenium.seleniumeasy.test;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.examples.test.AbstractChromeTest;
import org.fluentlenium.seleniumeasy.test.pages.TablePaginationPage;
import org.junit.Before;
import org.junit.Test;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import static org.junit.Assert.assertEquals;

public class TableWithPaginationExampleTest extends AbstractChromeTest {

    @Page
    private TablePaginationPage tablePaginationPage;

    @Before
    public void setUp() {
        goTo(tablePaginationPage).isAt();
    }

    @Test
    public void testPageOpen() {
        assertThat(tablePaginationPage.getDriver().getTitle())
                .startsWith("Selenium Easy")
                .endsWith("Table with Pagination Demo");
    }

    @Test
    public void testPageTitle() {
        assertThat(tablePaginationPage.getParagraph())
                .contains("Table with Pagination Example");
    }

    @Test
    public void testWholeTableContent() {
        assertThat(tablePaginationPage.getWholeTableContent())
                .contains("Table heading")
                .contains("Table cell");
    }

    @Test
    public void testRowsCount() {
        assertThat(tablePaginationPage.getVisibleTableRows())
                .hasSize(5);
    }

    @Test
    public void testPageLinks() {
        assertThat(tablePaginationPage.getPageLinksTexts())
                .isNotEmpty()
                .hasSize(3)
                .contains("1", "2", "3");

        assertEquals("1", tablePaginationPage.getActivePageLinkText());
    }

    @Test
    public void testLinkClicking() {
        tablePaginationPage.clickLink(2);

        assertThat(tablePaginationPage.getVisibleTableRows())
                .isNotEmpty()
                .contains("6", "7", "8", "9", "10");
    }
}
