# Book Record Management Program

This program is designed to manage book records. It allows users to create, validate, and store book information in a structured manner. The program consists of three main parts: syntax checking, semantic validation, and interactive navigation.

## Features

- **Part 1: Syntax Checking**
  - Creates files and checks the syntax of input files
  - Handles custom exceptions for various error scenarios, such as too many or too few fields, missing fields, unknown genre, bad ISBN formats, bad price, and bad year

- **Part 2: Semantic Validation**
  - Reads the outputted CSV files from Part 1
  - Performs semantic checks on the records
  - Serializes the validated records into binary files

- **Part 3: Interactive Navigation**
  - Opens the serialized binary files
  - Deserializes the records and provides an interactive program to navigate through the book records
  - Allows users to view each file and its syntax and semantic-correct records

## Usage

1. Run the program by executing the `Driver` class.
2. The program will automatically perform the following steps:
   - Part 1: Syntax checking
   - Part 2: Semantic validation and serialization
   - Part 3: Interactive navigation
3. Follow the on-screen instructions to navigate and view the book records.

## Dependencies

This program does not have any external dependencies.

## License

This program is released under the MIT License. See [LICENSE]([LICENSE](https://www.mit.edu/~amini/LICENSE.md)) for more details.
