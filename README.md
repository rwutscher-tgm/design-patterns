# Design Patterns

### Inhaltsverzeichnis

- [Strategy Pattern](strategy.md)
- [Observer Pattern](observer.md)
- [Decorator Pattern](decorator.md)
- [Factory Pattern](factory.md)
- [Singleton Pattern](singleton.md)

## OO Principles

### encapsulate what varies

Alles was sich ändern kann soll zusammengefügt werden und somit getrennt werden, von sich nicht-änderndem Code. Hiermit sollen dann Nebeneffekte und unerwünschte Änderungen bzw. Probleme vermieden werden.

### composition > inheritance

Man soll Kapselung der Vererbung vorziehen, da Vererbung nicht wirklich dynamisch ist. Man keine die Klasse, von welcher man erbt, nicht während der Laufzeit ändern.

### interfaces not implementations

Anstatt vorhandenen Code immer wieder zu ändern, sollte man eher auf Interfaces programmieren. Hier geht man nach dem Prinzip: "never touch a running system(code)"

### loosely coupled

Hat man Objekte, welche zusammen arbeiten, soll man diese möglichst unabhängig voneinander gestalten. <small>(Observer)</small>

### open for extension - closed for modification

Man soll die Möglichkeit haben Klassen zu erweitern, um z.B. neue Ansprüche zu erfüllen. Allerdings soll währenddessen der bereits vorhandene Code nicht geändert werden. <small>(Decorator)</small>

### depend upon abstractions

Eine High-Level Komponente sollte nicht von Low-Level Komponenten abhängig sein. Hiermit ist gemeint, dass eine Klasse (High-Level) nicht von von vielen konkreten Klassen (Low-Level) abhängig sein soll. Dieses Prinzip kann man erfüllen, indem die Low-Level Komponenten von einer abstrakten Klasse erben. Die High-Level Komponente kann dann diese Klasse nutzen um nicht mehr von den ganzen Low-Level Komponenten abhängig zu sein. <small>(Factory)</small>
