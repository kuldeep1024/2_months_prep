# When Not to Use Records

## 1. JPA Entity

Why:

A JPA entity usually needs to be mutable because JPA can change its fields when loading or updating data.

JPA also commonly requires a no-argument constructor and uses proxies for features such as lazy loading.

Records are designed to be immutable and their fields are final. Because of this, they are generally not a good choice for JPA entities.

For example, this is usually a bad design:

```java
@Entity
public record User(
        Long id,
        String name,
        String email) {
}
```

The entity lifecycle and persistence requirements do not fit well with the record model.

Better choice:

Use a normal class for the JPA entity.

```java
@Entity
public class User {

    @Id
    private Long id;

    private String name;
    private String email;

    protected User() {
    }

    // getters and setters
}
```

Records can still be useful for **DTOs** returned from the application.

---

## 2. Mutable Domain Object

Why:

Records are designed to represent immutable data.

Once a record is created, its fields cannot be changed.

For example:

```java
public record ShoppingCart(
        List<String> items,
        double total) {
}
```

If the business object needs operations such as:

```text
addItem()
removeItem()
applyDiscount()
changeQuantity()
```

and its state needs to change during its lifecycle, a record may not be the best choice.

Using a record for such an object can make the design awkward because every state change may require creating a new object.

Better choice:

Use a normal class when the object's state is expected to change.

```java
public class ShoppingCart {

    private final List<String> items = new ArrayList<>();
    private double total;

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void applyDiscount(double discount) {
        total -= discount;
    }
}
```

A class gives us controlled mutation through business methods.

---

## 3. Framework Proxy / Inheritance Requirement

Why:

Records are final and cannot be extended.

For example:

```java
public record User(String name) {
}
```

Another class cannot extend it:

```java
class AdminUser extends User {
}
```

This will not work because records are implicitly final.

Some frameworks also depend on subclassing or runtime proxies to add behavior.

For example, a framework may create a proxy subclass to provide features such as:

```text
Lazy loading
Transaction handling
Interception
Dependency injection
Runtime behavior
```

A final record can prevent this kind of design.

Better choice:

Use a normal class when inheritance or framework-generated subclasses/proxies are required.

```java
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class AdminUser extends User {

    public AdminUser(String name) {
        super(name);
    }
}
```

A normal class gives the framework or application the flexibility to extend or proxy the object.

---

# Summary

Records are a great choice when the main purpose of a type is to represent **immutable data**.

Good examples include:

```text
DTO
API response
Configuration value
Value object
Result type
Small immutable data carrier
```

Records are usually a poor choice when we need:

```text
JPA entity
Mutable state
Inheritance
Framework-generated proxies
Complex lifecycle management
```

The important rule is:

> **Don't use a record just because it reduces code. Use it when the object's design matches the record model: immutable data with value-based equality.**
