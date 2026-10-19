# TechStore

TechStore is a Java console application that models a small technology store with two user perspectives:
- **Administration (manager)**: can add, modify, remove, and restock products.
- **Client**: can browse stock, manage a cart, and finalize an order.

The project is implemented with plain Java classes (no external framework) and focuses on object-oriented modeling of products, stock, people, and store operations.

## Table of Contents
- [Project Goals](#project-goals)
- [Features](#features)
- [Architecture](#architecture)
- [Conception and Design Choices](#conception-and-design-choices)
- [Repository Structure](#repository-structure)
- [How It Works](#how-it-works)
- [Build and Run](#build-and-run)
- [Known Limitations](#known-limitations)
- [License](#license)

## Project Goals
- Model a technology store catalog with multiple product families.
- Manage stock quantities and product CRUD operations.
- Let clients create and manage carts.
- Generate an order invoice at checkout.

## Features

### Manager-side features
- Add products by category:
  - Desktop computer (`OrdinateurBureau`)
  - Laptop (`OrdinateurPortable`)
  - Mobile phone (`Mobile`)
  - Storage component (`ComposantStockage`)
  - Peripheral (`Peripheriques`)
- Increase product quantity in stock.
- Modify product information and quantity.
- Remove a product from stock.
- Display stock list.

### Client-side features
- Add products to cart by reference and quantity.
- Update quantity of an item in cart.
- Remove an item from cart.
- Display cart content.
- Browse stock sorted by price (ascending or descending).
- Finalize order (invoice generation + total).
- Cancel order.

## Architecture

The project follows a **domain-centric, object-oriented architecture** centered on entities and relationships.

### 1) Entry point and interaction layer
- **`TechStore.java`**
  - Contains `main` and console menus.
  - Routes user actions (manager/client) to domain methods.
  - Handles user input parsing with `Scanner`.

### 2) Core inventory layer
- **`Stock.java`**
  - Central aggregate for store inventory.
  - Stores `ArrayList<Element>` where each `Element` couples:
    - one `Article` (or subclass)
    - one quantity.
  - Provides operations for add/update/remove/find/increment/decrement.
  - Supports stock display sorted by price via `SortbyPrice`.

- **`Element.java`**
  - Wrapper class representing inventory line items (`article + quantity`).
  - Exposes quantity and article metadata helpers.

### 3) Product model (inheritance hierarchy)

`Article` is the base class for all products.

- **`Article`** (base)
  - Generic fields: ID, name, reference, price.

- **`AppareilInfo`** extends `Article`
  - Shared digital-device attributes: screen resolution, processor, RAM, OS (`SystemExploite`).

- **`Ordinateur`** extends `AppareilInfo`
  - Shared computer attributes: disk size and GPU.

- **`OrdinateurBureau`** extends `Ordinateur`
  - Desktop-specific attribute: power supply.

- **`OrdinateurPortable`** extends `Ordinateur`
  - Laptop-specific attribute: battery capacity.

- **`Mobile`** extends `AppareilInfo`
  - Mobile-specific attributes: front/rear cameras, SIM count, battery.

- **`ComposantStockage`** extends `Article`
  - Storage-specific attribute: capacity.

- **`Peripheriques`** extends `Article`
  - Peripheral-specific attributes: connection technology and interface.

### 4) User model
- **`Personne`**: base class for people with identity and address.
- **`Adresse`**: value object for postal data.
- **`Client`** extends `Personne`:
  - Owns a `panier` (`ArrayList<Element>`).
  - Performs cart lifecycle and checkout operations.
- **`Administration`** extends `Personne` (abstract):
  - Provides stock management methods by delegating to `Stock`.

### 5) Utility
- **`SortbyPrice`**: comparator for sorting stock items by article price.
- **`Test`**: simple class for basic object instantiation tests.

## Conception and Design Choices

### Object-oriented conception
The implementation is designed around OOP principles:
- **Inheritance** to model product families and specialization.
- **Composition** in `Stock` and `Client` through `Element` lists.
- **Encapsulation** via getters/setters and entity-level behavior.

### Domain-first modeling
The code prioritizes business entities (products, stock, client, cart) before infrastructure concerns. This keeps the model explicit and easy to evolve in a learning context.

### Overloaded stock operations
`Stock` exposes multiple overloaded `AjouterArticle(...)` methods to create different concrete product types while keeping a single stock API.

### Separation of concerns (current level)
- Console interaction is concentrated in `TechStore.main`.
- Domain behavior is mostly placed in `Stock`, `Client`, and product classes.
- Persistence and service layers are not yet abstracted (in-memory only).

## Repository Structure

```text
TechStore/
├── TechStore.java              # Main entry point and menus
├── Stock.java                  # Inventory aggregate and operations
├── Element.java                # Inventory line (article + quantity)
├── Article.java                # Base product model
├── AppareilInfo.java           # Device-level shared fields
├── Ordinateur.java             # Computer-level shared fields
├── OrdinateurBureau.java       # Desktop product model
├── OrdinateurPortable.java     # Laptop product model
├── Mobile.java                 # Mobile product model
├── ComposantStockage.java      # Storage product model
├── Peripheriques.java          # Peripheral product model
├── Personne.java               # Base person model
├── Client.java                 # Client/cart/checkout behavior
├── Administration.java         # Abstract admin stock operations
├── Adresse.java                # Address value object
├── SortbyPrice.java            # Price comparator
├── Test.java                   # Basic object test class
└── LICENSE
```

## How It Works

1. Run `TechStore`.
2. Choose profile:
   - `0` for manager
   - `1` for client
3. Use menu-driven actions.
4. For client checkout, an invoice text file is generated (current implementation uses a fixed local path).

## Build and Run

From the repository root:

```bash
javac *.java
java TechStore
```

Optional test class:

```bash
java Test
```

## Known Limitations
- No build tool (`Maven`/`Gradle`) yet.
- No database persistence (runtime memory only).
- Input validation and error handling are limited.
- Some hardcoded paths and menu/control-flow issues remain in current implementation.
- No automated test suite.

## License
This repository includes a `LICENSE` file. See it for licensing details.
