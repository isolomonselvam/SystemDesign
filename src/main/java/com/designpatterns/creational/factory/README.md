# Factory Patterns

## 📖 Overview

This package demonstrates two important creational design patterns:
1. **Factory Method Pattern** - Creates objects without specifying exact classes
2. **Abstract Factory Pattern** - Creates families of related objects

## 🏭 Factory Method Pattern

### 📁 Structure
```
Shape (Interface)
├── Circle
├── Rectangle
└── Triangle

ShapeFactory (Static Factory)
├── createShape(ShapeType, params...)
├── createCircle(radius)
├── createRectangle(width, height)
├── createTriangle(a, b, c)
├── createEquilateralTriangle(side)
└── createRightTriangle(base, height)
```

### 🎯 Key Features

#### **1. Type-Safe Creation**
```java
Shape circle = ShapeFactory.createCircle(5.0);
Shape rectangle = ShapeFactory.createRectangle(4.0, 6.0);
Shape triangle = ShapeFactory.createTriangle(3.0, 4.0, 5.0);
```

#### **2. Parameter Validation**
- Circle: Positive radius
- Rectangle: Positive width and height
- Triangle: Valid triangle inequality (a+b > c, a+c > b, b+c > a)

#### **3. Convenience Methods**
```java
// Special triangle types
Shape equilateral = ShapeFactory.createEquilateralTriangle(6.0);
Shape rightTriangle = ShapeFactory.createRightTriangle(3.0, 4.0); // Creates 3-4-5 triangle
```

#### **4. Advanced Triangle Features**
- **Area calculation** using Heron's formula
- **Triangle type detection** (Equilateral, Isosceles, Scalene)
- **Perimeter calculation**
- **Comprehensive validation**

### 🧪 Usage Example
```java
// Create shapes using factory
Shape circle = ShapeFactory.createCircle(5.0);
Shape rectangle = ShapeFactory.createRectangle(4.0, 6.0);
Shape triangle = ShapeFactory.createTriangle(3.0, 4.0, 5.0);

// Use the shapes
circle.draw();                    // "Drawing a Circle with radius: 5.0"
System.out.println(circle.calculateArea()); // 78.54

Triangle t = (Triangle) triangle;
System.out.println(t.getTriangleType());    // "Scalene"
System.out.println(t.getPerimeter());       // 12.0
```

## 🏭 Abstract Factory Pattern

### 📁 Structure
```
UIFactory (Abstract Factory)
├── WindowsUIFactory
└── MacUIFactory

Products:
├── Button (Windows/Mac implementations)
├── TextField (Windows/Mac implementations)
└── Checkbox (Windows/Mac implementations)
```

### 🎯 Key Features

#### **1. Platform-Specific UI Components**
```java
UIFactory factory = new WindowsUIFactory();
Button button = factory.createButton();        // Windows-style button
TextField field = factory.createTextField();   // Windows-style text field
Checkbox checkbox = factory.createCheckbox();  // Windows-style checkbox
```

#### **2. Consistent UI Families**
- **Windows UI**: 3D borders, system sounds, square checkboxes
- **Mac UI**: Rounded corners, animations, blue accents

#### **3. Runtime Factory Selection**
```java
UIFactory factory = createUIFactory(System.getProperty("os.name"));
// Automatically creates appropriate factory based on OS
```

#### **4. Interchangeable Families**
```java
// Switch entire UI style by changing factory
UIFactory windowsFactory = new WindowsUIFactory();
UIFactory macFactory = new MacUIFactory();

// Same client code works with both
createUI(windowsFactory); // Creates Windows UI
createUI(macFactory);     // Creates Mac UI
```

### 🧪 Usage Example
```java
// Detect OS and create appropriate factory
String os = System.getProperty("os.name").toLowerCase();
UIFactory factory = os.contains("mac") ? new MacUIFactory() : new WindowsUIFactory();

// Create consistent UI family
Button button = factory.createButton();
TextField textField = factory.createTextField();
Checkbox checkbox = factory.createCheckbox();

// All components have consistent styling
button.render();     // Platform-specific rendering
textField.setText("Hello!");
checkbox.setChecked(true);
```

## 🔄 Pattern Comparison

| Aspect | Factory Method | Abstract Factory |
|--------|----------------|------------------|
| **Purpose** | Create single objects | Create families of objects |
| **Complexity** | Simple | More complex |
| **Use Case** | Different types of same product | Related products that work together |
| **Example** | Different shapes | UI components for different platforms |

## 🚀 Running the Demos

### Factory Method Pattern
```bash
./run-demo.sh factory
# or
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.factory.FactoryDemo"
```

### Abstract Factory Pattern
```bash
./run-demo.sh abstractfactory
# or
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.factory.abstractfactory.AbstractFactoryDemo"
```

## 🧪 Running Tests

```bash
# Run all factory tests
mvn test -Dtest="*Factory*"

# Run specific tests
mvn test -Dtest="ShapeFactoryTest"
```

## 🎯 Real-World Applications

### Factory Method Pattern
- **Database connections**: Different database drivers
- **File parsers**: JSON, XML, CSV parsers
- **Logging frameworks**: Different log appenders
- **HTTP clients**: Different transport implementations

### Abstract Factory Pattern
- **GUI toolkits**: Swing, JavaFX, SWT components
- **Database access**: Different database vendor families
- **Game engines**: Different platform-specific renderers
- **Cloud providers**: AWS, Azure, GCP service families

## 📚 Key Benefits

### Factory Method
- ✅ **Encapsulates object creation**
- ✅ **Reduces coupling** between client and concrete classes
- ✅ **Centralizes validation** and error handling
- ✅ **Easy to extend** with new types

### Abstract Factory
- ✅ **Ensures consistency** within product families
- ✅ **Easy to switch** entire families
- ✅ **Isolates client** from concrete implementations
- ✅ **Supports multiple platforms** seamlessly

## 🔧 Extension Points

### Adding New Shapes
1. Create new class implementing `Shape`
2. Add to `ShapeType` enum
3. Update `createShape()` method
4. Add convenience method if needed

### Adding New UI Platforms
1. Create new concrete factory implementing `UIFactory`
2. Implement platform-specific components
3. Update factory selection logic
4. Add to demo if desired

Both patterns are **production-ready** with comprehensive validation, error handling, and testing! 🎉 