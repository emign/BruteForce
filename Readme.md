Ein Großteil der digitalen Sicherheits- und Verschlüsselungstechnik setzt darauf, dass
verwendete Passwörter oder Kryptoschlüssel derart schwer zu erraten sind, dass es einfach zu lange
dauern würde, so viele auszuprobieren, bis schließlich der passende dabei ist (BruteForce).

Dennoch können bei vielen Diensten die Passwörter selbst gewählt werden. Mit diesem kleinen
Programm soll man sensibilisiert werden, sich ein möglichst sicheres Passwort zuzulegen.
Am besten ein individuelles für jeden Dienst, den man nutzt.

Wenn man den Quellcode selbst kompilieren möchte, darf man kein BlueJ nutzen, da dies Probleme mit JavaFX-Anwendungen hat.
Alternativ steht die selbstlaufende Datei **BruteForce.jar** zur Verfügung.

## Aufgabe
Machen Sie sich mit der Bedienung der Applikation vertraut. Fertigen Sie anschließend Diagramme an,
welche die benötigte Laufzeit eines BruteForce-Angriffs auf ihr gewähltes Passwort gegenüber der Passwort-Länge auftragen.
Unterscheiden Sie hier zwischen den drei möglichen Alphabeten: Alpha, Alphanumerisch und Numerisch.
Entwickeln Sie zudem eine Formel, welche es ermöglicht, die Zahl der möglichen Passwörter der Länge n für die jeweiligen
Alphabete zu berechnen.
Vergleichen Sie die erhaltenen Werte mit denen eines vergleichebaren Passwortes, welches über einem Alphabet gebildet wurde,
welches auch Sonderzeichen mit einschließt.

## Bedienung
Man gibt ein Passwort im entsprechenden Feld ein und lässt den Computer mit Klick auf "Knacken" das Passwort
mit einem BruteForce-Verfahren erraten. Hierzu wählt man auch noch das passende Alphabet aus.
Achtung: Tasten Sie sich langsam an längere Passwörter heran, da die Laufzeit stark ansteigen kann.
