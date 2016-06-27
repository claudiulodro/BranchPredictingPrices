# Evaluating the Effectiveness of Saturating Counter Branch-Prediction Algorithms for Predicting Price Movements

This is a program that can be used to test the effectiveness of different branch-prediction algorithms for predicting price movements in time-series data. I was not able to find any literature discussing whether branch-predictors can be used reliably on time-series data, so I built out my own experiment-running platform for this purpose.

Branch-prediction is a technique computers use to increase the throughput of the instruction pipeline by trying to guess which way a branch will go before it does. There are many techniques that can be used for this, but the one I am most interested in testing is the Saturating Counter (https://en.wikipedia.org/wiki/Branch_predictor#Saturating_counter). 

I have tested multiple variations of the Saturating Counter implemented as a state machine with different node configurations.

Initial results predicting increases and decreases in S&P 500 daily price movements have been promising, but further testing of assorted data is needed to determine true effectiveness. For the S&P 500 in the 3-month period April-June 2016 the following results were achieved:

Binary predictor: 40.0% accuracy

Standard saturating counter with hard switch: 49.23% accuracy

Standard saturating counter with soft switch: 46.15% accuracy

Six node saturating counter with soft switch: 46.15% accuracy
