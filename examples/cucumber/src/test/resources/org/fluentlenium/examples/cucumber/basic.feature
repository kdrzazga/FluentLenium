Feature: basic

  Scenario: scenario1
    Given Visit duckduckgo search page
    When I search FluentLenium term
    Then Title contains FluentLenium term
