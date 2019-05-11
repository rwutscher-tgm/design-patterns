[back](README.md)

# Singleton Pattern

### Problem

In einigen Fällen ist es nützlich bzw. vielleicht sogar notwendig, dass nur ein Objekt existiert. Solche Fälle wären zum Beispiel bei Objekten, welche mit der Registry arbeiten oder bei Thread Pools. Bei diesen möchte man nicht mehrere Objekte haben, welche gleichzeitig daran arbeiten und so möglicherweise Fehler erzeugen.

### Lösung

Die Lösung für dieses Problem ist das Singleton Pattern, mit welchem man das Kriterium, von nur einer Instanz, erfüllen kann. Dies wird erreicht indem man das Objekt mit einem privatem Konstruktor erstellt. Hat ein Objekt einen private Konstruktor, kann es nicht mehr von einer anderen Klasse instanziiert werden, außer sich selbst. Um nun die einzelne Instanz des Objektes zu erhalten, braucht man eine statische getInstance-Methode. Die Methode muss statisch sein, da man nur statische Methoden ohne Objekt aufrufen kann. In getInstance wird nun das Objekt zurückgegeben bzw. erstellt, falls es noch nicht instanziiert wurde. Das Objekt wird in einem Attribut gespeichert.

![Factory_Method_Pattern](https://github.com/ntesanovic-tgm/design-patterns/tree/master/images/singleton_pattern.png)
<small>[Head First Design Patterns](http://shop.oreilly.com/product/9780596007126.do) Seite 179</small>

~~~ java
public class Singleton {
	private static Singleton uniqueInstance;

	private Singleton(){}

	public static Singleton getInstance(){
		if(uniqueInstance == null) uniqueInstance = new Singleton();
		return uniqueInstance;
	}
	// weiterer benötigter Code
}
~~~

Weitere Probleme könnten dann nur noch bei mehreren Threads auftauchen, wenn noch keine Objekt instanziiert wurde und meherere Threads fast gleichzeitig ein Objekt erstellen. Hierfür hat man wieder mehrere Lösungsmöglichkeiten

~~~ java
// 1.
private static Singleton uniqueInstance = new Singleton();

// 2. synchronized
public static synchronized Singleton getInstance(){...}

// 3. double-checked looking
private volatile static Singleton uniqueInstance;

public static Singleton getInstance(){
	if(uniqueInstance == null){
		synchronized(Singleton.class){
			if(uniqueInstance == null){
				uniqueInstance = new Singleton();
			}
		}
	}
}
~~~