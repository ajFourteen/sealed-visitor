package sealed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchInDictionaryTest {

  @Test
  void example() {
    var dictionary =
        new Node.BinaryTree<String, String>(
            "Konsistenz", "Einheitliche Anwendung von Regeln/Strukturen.",
            new Node.BinaryTree<String, String>(
                "Algorithmus", "Schritt-für-Schritt-Vorgehen zur Problemlösung.",
                new Node.Leaf<>(
                    "Abstraktion",
                    "Reduzieren von Details auf das Wesentliche."
                ),
                new Node.Leaf<>(
                    "Invariante",
                    "Bedingung, die immer wahr bleiben muss."
                )
            ),
            new Node.BinaryTree<String, String>(
                "Modularität", "Aufteilung in unabhängige Bestandteile.",
                new Node.Leaf<>(
                    "Kopplung",
                    "Maß der Abhängigkeit zwischen Komponenten."
                ),
                new Node.BinaryTree<String, String>(
                    "Refactoring", "Umstrukturieren ohne Verhaltensänderung.",
                    new Node.EmptyNode<>(),
                    new Node.Leaf<>(
                        "Testfixtur",
                        "Vorbereitete Testumgebung."
                    )
                )
            )
        );
    var sut = new SearchInDictionary(dictionary);

    var result = sut.result("Invariante");

    assertTrue(result.isPresent());
    assertEquals("Bedingung, die immer wahr bleiben muss.", result.get());
  }
}
