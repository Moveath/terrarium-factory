# Terrarium Factory

Implementation of the **Factory Method** and **Abstract Factory** design patterns using a terrarium-building domain as an example.

## What is being built

**Part A: Factory Method:** `Terrarium` is a product interface with two concrete types `DesertTerrarium` and `TropicalTerrarium`. A `TerrariumFactory` decides, based on a string parameter, which concrete type to instantiate, so client code never depends on the concrete classes directly.

**Part B: Abstract Factory:** A terrarium kit consists of two related products  a `Plant` and a `Substrate`  that must stay consistent with each other (e.g. a cactus should come with sand, not soil). `TerrariumKitFactory` is an abstract factory interface with two creation methods (`createPlant()`, `createSubstrate()`). Two concrete factories  `DesertKitFactory` and `TropicalKitFactory`  each guarantee a matching pair of products.

## Structure

- `Terrarium`, `DesertTerrarium`, `TropicalTerrarium`, `TerrariumFactory`  Factory Method (Part A)
- `Plant`, `Cactus`, `Fern`  one product family (Part B)
- `Substrate`, `Sand`, `Soil`  second product family (Part B)
- `TerrariumKitFactory`, `DesertKitFactory`, `TropicalKitFactory`  abstract factory and concrete factories (Part B)
- `Main`  client code demonstrating both parts

## Clean Code principles

### 1. Meaningful, intention-revealing names

Class and method names describe exactly what they do, with no abbreviations or vague names.

```java
public Terrarium createTerrarium(String type) 
{ 
    ... 
}
public Plant createPlant() 
{ 
    ... 
}
```

### 2. Program to an interface, not an implementation

Client code (`Main`) only ever refers to `Terrarium`, `Plant`, `Substrate`, and `TerrariumKitFactory` — never to a concrete class like `DesertTerrarium` or `Cactus` directly.

```java
// Before (bad): client depends on a concrete class
Terrarium desert = new DesertTerrarium();

// After: client depends only on the factory and the interface
Terrarium desert = myTerrarium.createTerrarium("desert");
```

### 3. Single Responsibility Principle

Each class has exactly one job: `TerrariumFactory` only decides which product to create, `DesertTerrarium`/`TropicalTerrarium` only know how to describe themselves, and `Main` only orchestrates calls. Creation logic is never mixed with product behavior.

### 4. Validated construction / fail-fast on invalid input

`TerrariumFactory.createTerrarium(...)` throws a clear exception instead of silently returning an unusable object when given an unknown type.

```java
if (type.equalsIgnoreCase("desert")) 
{
    return new DesertTerrarium();
} 
else if (type.equalsIgnoreCase("tropical")) 
{
    return new TropicalTerrarium();
}
throw new IllegalArgumentException("Unknown terrarium type: " + type);
```

### 5. Small, focused classes (no magic strings inside products)

Every concrete product class (`Cactus`, `Fern`, `Sand`, `Soil`) is a small, single-purpose class with one method. Consistency between related products (plant + substrate) is guaranteed structurally, by grouping their creation inside one factory class, rather than by comparing string labels at the call site.

```java
public class DesertKitFactory implements TerrariumKitFactory {
    @Override
    public Plant createPlant() { return new Cactus(); }

    @Override
    public Substrate createSubstrate() { return new Sand(); }
}
```

## Usage example

```java
TerrariumFactory terrariumFactory = new TerrariumFactory();
Terrarium desert = terrariumFactory.createTerrarium("desert");
desert.describe();

TerrariumKitFactory desertKit = new DesertKitFactory();
Plant plant = desertKit.createPlant();
Substrate substrate = desertKit.createSubstrate();
plant.grow();
substrate.describe();
```