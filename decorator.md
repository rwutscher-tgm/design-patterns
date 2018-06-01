[back](README.md)

# Decorator Pattern

### Problem

Wir haben eine Basisklasse und einige konkretisierte Klassen. Nun wollen wir diese Subklassen dynamisch erweitern können bzw. dekorieren können. Das heißt, wir haben zum Beispiel eine Klasse, welches Text einlesen und dann etwas entsprechendes ausgeben kann und wir wollen nun Möglichkeiten erstellen um die Ausgabe nur in Klein - oder Großbuchstaben auszugeben.

Als Beispiel im Buch hatten wir den Café-Shop, welcher die verschiedenen Extras(Mocha, Whip, ...), zu den Kaffees hinzufügen musste.

### Lösung

Wie schon zuvor haben wir wieder mehrere Möglichkeiten, dieses Problem zu lösen.

1. *Klassen für alle Möglichkeiten:*  

Eine der erwähnten Möglichkeiten ist die Erstellung von Klassen für jede einzelne Kombination von Kaffees und Extras. Allerdings führt dies zu einer "Klassenexplosion". Es entsteht eine Unmenge an Klassen und falls sich dann eine Zutat ändert, muss man somit alle Klassen ändern, welche diese Zutat benutzt haben.

2. *Attribute und Vererbung:*  

Das vererben der Attribute und diese dann immer auf *TRUE* oder *FALSE* zu setzen, hört sich auf jeden Fall schon besser an. Allerdings hat auch diese Methode einige Probleme. Hierzu zählt zum Beispiel, dass bei dem Hinzufügen von neuen Zutaten nicht nur neue Getter - und Setter-Methoden implementiert werden müssen, sonder auch, dass die Kostenfunktion umgeschrieben werden muss.

3. ***Decorator Pattern:***  

Und nun kommen wir zum Decorator Pattern, mit welchem wir auch das Design Principle **open for extension - closed for modification** erfüllen. Indem man die Zutaten um den Kaffee "wrappet", kann man, ohne die Benutzung von Attributen oder unzähligen Klassen, die Kosten ganz leicht ausrechnen.

### UML & Beispielcode

![Observer_Pattern_Beispiel](https://github.com/TGM-HIT/sew4-design-patterns-ntesanovic-tgm/blob/master/images/decorator_pattern.PNG)

Zuerst muss eine abstrakte Klasse für die Getränke erstellt werden, zusammen mit den konkreten Klassen.

~~~java

public abstract class Beverage {
	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	public double cost() {
		return .89;
	}
}
~~~

Die konkrete Decorator erben von dem abstrakten Decorator, welcher in diesem Fall die getDescription-Methode abstrakt macht.

~~~ java
public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}

public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return .20 + beverage.cost();
	}
}
~~~

Um nun einen Kaffee mit einem Decorator zu erweitern, muss man das Kaffee-Objekt erstellen und dann beim hinzufügen des Decorators, das vorher erstellte Objekt ersetzen mit einem neuen Objekt, welches das ürsprüngliche Objekt als Parameter hat.

~~~ java
public class StarbuzzCoffee {
	public static void main(String args[]) {
		Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
		System.out.println(beverage.getDescription()
				+ " $" + beverage.cost());
	}
}

~~~
