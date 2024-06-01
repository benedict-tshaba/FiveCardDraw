##  Five Card Draw [♥ ♦ ♣ ♠]
This is a varient of the Five-Card Draw Poker game. In Five-Card Draw Poker, each player is dealt five cards, and they have the option to exchange some of their cards to improve their hand. After the exchange, players evaluate their hands based on predefined hand rankings to determine the winner.

Unlike the five-card draw variant, no swapping will be allowed.

The application provides the following functionality:
 - Simulate shuffling a standard deck of 52 cards.
 - Deal a single hand of 5 cards to the player.
 - Evaluate the player’s hand, informing them of the highest ranked poker hand that matches their hand of 5 cards.

## Running The Code
To run the code, you will need to have maven 3.8.7 and above.
You need to make sure you have Java 17 installed. Tested with OpenJDK 17.0.11.
The unit tests use the jUnit5 framework which is a substantial improvement over jUnit4.

With the above requirements met. 
Run the following commands:
```sh
git clone https://github.com/benedict-tshaba/FiveCardDraw.git
cd FiveCardDraw
chmod +x run.sh
./run.sh
```

Or run the following commands;
```sh
mvn clean package
java -jar ./target/five-card-1.0-SNAPSHOT.jar
```

Example running ./run.sh:
```sh
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ five-card ---
[INFO] Building jar: /home/phomolo/Java/advance/five-card/target/five-card-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.285 s
[INFO] Finished at: 2024-06-01T23:06:02+02:00
[INFO] ------------------------------------------------------------------------
Shuffling... Shuffling... Shuffling... 
Your Hand: A♠ 2♦ 3♣ 5♦ 5♥ 
You Have: One Pair
```

Enjoy! (;