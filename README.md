# Visitor-Pattern vs. Sealed Interfaces & Records

**Hypothese:** Das Visitor-Pattern ist durch Sealed Interfaces & Records obsolet geworden.

Die Beispiele in diesem Repository sollen die Hypothese untermauern oder widerlegen.

Da das Visitor-Pattern mehrere Anwändungsfälle hat, bedarf es auch mehrerer Beispiele:

* Dictionary:  
Das Visitor-Pattern kann dafür genutzt werden, einen Binärbaum zu durchlaufen und nach einem Knoten zu suchen.
Dafür muss abhängig vom aktuell betrachteten Knoten entschieden werden, in welche Richtung weitergesucht wird.
Sobald ein passender Knoten gefunden wurde, soll sein Wert zurückgegeben werden.  
**Dieser Anwendungsfall ist mit Sealed Interfaces & Records umsetzbar.**