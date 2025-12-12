package classic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchInDictionaryTest {

  @Test
  void example() {
    var dictionary =
        new BinaryTree<>(
            "Konsistenz", "Einheitliche Anwendung von Regeln/Strukturen.",
            new BinaryTree<>(
                "Algorithmus", "Schritt-für-Schritt-Vorgehen zur Problemlösung.",
                new Leaf<>(
                    "Abstraktion",
                    "Reduzieren von Details auf das Wesentliche."
                ),
                new Leaf<>(
                    "Invariante",
                    "Bedingung, die immer wahr bleiben muss."
                )
            ),
            new BinaryTree<>(
                "Modularität", "Aufteilung in unabhängige Bestandteile.",
                new Leaf<>(
                    "Kopplung",
                    "Maß der Abhängigkeit zwischen Komponenten."
                ),
                new BinaryTree<>(
                    "Refactoring", "Umstrukturieren ohne Verhaltensänderung.",
                    new EmptyNode<>(),
                    new Leaf<>(
                        "Testfixtur",
                        "Vorbereitete Testumgebung."
                    )
                )
            )
        );
    var sut = new SearchInDictionary("Invariante");

    dictionary.accept(sut);

    assertTrue(sut.result().isPresent());
    assertEquals("Bedingung, die immer wahr bleiben muss.", sut.result().get());
  }
}
