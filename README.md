# edsp Library

The `edsp` library is a versatile Java package designed to streamline file-related operations and data manipulation tasks. It provides a collection of classes that work seamlessly together to handle sending, searching, linking, and sorting data within text files. This library aims to simplify common file operations, making your code more efficient and readable.

## Table of Contents

- [Introduction](#introduction)
- [Installation](#installation)
  - [Prerequisites](#prerequisites)
  - [Installation Steps](#installation-steps)
- [Usage](#usage)
  - [Data Management](#data-management)
  - [Searching and Linking](#searching-and-linking)
  - [File Information](#file-information)
  - [Sorting](#sorting)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Managing data and performing operations on files can be complex and error-prone. The `edsp` library simplifies these tasks by providing an organized set of Java classes. These classes are designed to handle various file operations, from sending data to files, searching for specific strings, linking strings, obtaining file information, and sorting file contents.

## Installation

### Prerequisites

To use the `edsp` library, you need to have Java JDK installed on your system.

### Installation Steps

1. Clone the `edsp` repository using the following command:
   ```
   git clone https://github.com/vafaeim/edsp.git
   ```
2. Navigate to the `edsp` directory:
   ```
   cd edsp
   ```
3. Compile the Java files:
   ```
   javac edsp/*.java
   ```
4. Include the compiled `.class` files in your Java project's classpath.

## Usage

### Data Management

The `Data` class is at the core of the `edsp` library, providing essential methods for managing data within text files.

```java
import edsp.*;

public class Example {
    public static void main(String[] args) {
        Data data = new Data("path/to/file", "txt");
        
        try {
            data.send("Hello, world!");
            data.link("Hello", "world!", " - ");
            String linkedData = data.getLinked("Hello", true, " - ");
            
            System.out.println("Linked Data: " + linkedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Searching and Linking

Utilize the `Search` and `SearchLink` classes to search for strings and linked strings within files.

```java
try {
    boolean found = data.search("Hello", true);
    if (found) {
        System.out.println("String found in the file.");
    } else {
        System.out.println("String not found in the file.");
    }
    
    boolean linkedFound = data.searchLink("Hello", true, " - ");
    if (linkedFound) {
        System.out.println("Linked string found in the file.");
    } else {
        System.out.println("Linked string not found in the file.");
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### File Information

Retrieve information about files using the `GetInformations` class.

```java
try {
    GetInformations fileInfo = new GetInformations("path/to/file.txt");
    int numberOfLines = fileInfo.NumberOfLines();
    long sizeBytes = fileInfo.SizeByte();
    double sizeKB = fileInfo.SizeKB();
    
    System.out.println("Number of Lines: " + numberOfLines);
    System.out.println("File Size (Bytes): " + sizeBytes);
    System.out.println("File Size (KB): " + sizeKB);
} catch (IOException e) {
    e.printStackTrace();
}
```

### Sorting

Sort the content of files using the `Sort` class.

```java
try {
    Sort sorter = new Sort("path/to/file.txt");
    boolean sorted = sorter.sort();
    
    if (sorted) {
        System.out.println("File content sorted successfully.");
    } else {
        System.out.println("Sorting operation failed.");
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

## Contributing

Contributions to the `edsp` library are welcome! If you find a bug, have an enhancement idea, or want to contribute in any way, please submit a pull request on the [GitHub repository](https://github.com/vafaeim/edsp).

## License

This library is open-source and released under the [MIT License](LICENSE).

Feel free to modify and use this library according to your needs.

---
