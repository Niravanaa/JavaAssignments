# 3D-Space Encryption-Decryption Program

This program allows users to encrypt or decrypt a message using the 3D-Space encryption algorithm. The encryption process involves flipping pairs of letters in the message based on whether the message length is even or odd. By inputting a plain text message, users can obtain an encrypted message, and by inputting an encrypted message, users can retrieve the original plain text.

## Description

The 3D-Space Encryption-Decryption Program is a Java-based application developed for the purpose of encrypting and decrypting messages. Here's how it works:

1. The program prompts the user to enter a plain text message.
2. The inputted message is trimmed to remove any leading or trailing white spaces.
3. The program checks the length of the inputted message to determine whether it is even or odd.
4. For an even-length message, the program flips pairs of characters, swapping their positions.
5. For an odd-length message, the program retains the first letter as is and then proceeds to flip the remaining pairs of characters.
6. The resulting encrypted or decrypted message is displayed to the user.

## Usage

1. Compile and run the `A3_Q1.java` file.
2. Follow the on-screen instructions to enter the plain text message.
3. The program will encrypt or decrypt the message based on its length.
4. The resulting encrypted or decrypted message will be displayed.

## Example

Here's an example to illustrate the program's functionality:

```makefile
Welcome to the 3D-Space Encryption-Decryption Program:
++++++++++++++++++++++++++++++++++++++++++++++++++++++

Please enter your plain text below:
Hello, World!

Kindly find below your encrypted text output:
eHll,owrldo !

Thank you for your contribution to this Space Project.
```

## License

This program is released under the MIT License. See [LICENSE](https://opensource.org/license/mit/)) for more details.
