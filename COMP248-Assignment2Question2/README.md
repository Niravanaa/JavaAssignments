# Farms Distribution Center Price Index Program

This Java program, A2_Q2.java, calculates the index of a particular month and market based on user input. It contains specific harvest percentages for each month of the year for both the domestic and international markets. The program is case-insensitive, meaning it can handle variations of upper-case and lower-case input for month and market names. Additionally, it provides error messages for incorrect user inputs.

## Program Description

The program prompts the user to enter the name of a month and market. It then calculates the price index using the given month and market's corresponding harvest percentage. The program uses two switch statements to validate the user input and retrieve the correct harvest percentage. Finally, it displays the calculated price index and a thank-you message.
## Usage

    Run the program.
    Enter the name of a month and market when prompted.
    The program will calculate the price index based on the given inputs.
    The calculated price index will be displayed.
    Thank you for using Farms Distribution Center Price Index Program!

## Harvest Percentages 
### Domestic Market

    January: 75.25%
    February: 62.86%
    March: 54.78%
    April: 68.46%
    May: 35.89%
    June: 28.94%
    July: 42.50%
    August: 86.10%
    September: 69.7%
    October: 85.4%
    November: 75.9%
    December: 76.8%

### International Market

    January: 24.75%
    February: 37.14%
    March: 45.22%
    April: 31.54%
    May: 64.11%
    June: 71.06%
    July: 57.5%
    August: 13.9%
    September: 30.3%
    October: 14.6%
    November: 24.1%
    December: 23.2%

## Price Index Calculation

The program calculates the price index using the following formula:

```makefile

Index = 1/20 * Percentage * W
```

Where:

    Percentage is the harvest percentage for the given month and market.
    W is a constant value (1.4672).

## Error Handling

    If the user enters an invalid value for the Month variable, an error message is displayed.
    If the user enters an invalid value for the Market variable, an error message is displayed.

## Dependencies

This program does not have any external dependencies.
## Note

Please make sure to close the program properly after use.

Feel free to contribute to the program and add more month-market combinations and their respective harvest percentages!

Thank you for using the Farms Distribution Center Price Index Program!

---

This program was created as part of a university assignment.
