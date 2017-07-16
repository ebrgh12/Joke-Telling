package com.jokelibrary;

import java.util.Random;

public class MyClass {
    private static final String[] JOKES = {
            "A family of mice were surprised by a big cat. Father Mouse jumped and and said, \"Bow-wow!\" The cat ran away. \"What was that, Father?\" asked Baby Mouse. \"Well, son, that's why it's important to learn a second language.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "I heard women love a man in uniform. Can’t wait to start working at McDonalds.",
            "Mother to Johnny: how was your exam, is all questions difficult?\nJohnny: No mom, all the questions were simple, It was the answers which gave me all the trouble!",
            "Patient: Doctor, please can you help me out?\nDoctor: Yes, you may make your way out the same way you come in.",
            "How can you make number seven to an even number?\nJust take the s out from it!",
            "Which is the place pencils like to go for a vacation?\nPencil – vania!",
            "Why did the computer consult with the doctor?\nBecause it was suffering from a virus!",
            "What is owned by you but mostly used by others?\nYour name!",
            "Which is the flower on face?\nTu – lips!",
            "Which is the way chosen by crazy people?\nThe psycho path!",
            "Can you name a bear with no socks?\nA bare-foot!",
    };
    private static final Random rndmGenerator = new Random();

    public static String getRandomJoke() {
        return JOKES[rndmGenerator.nextInt(JOKES.length)];
    }
}
