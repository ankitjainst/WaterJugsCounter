# WaterJugsCounter
## Important ##

1. This is an assessment exercise.
2. Some code is bundled along with to help speed up the process but is not necessary to be used.
3. This is different than the traditional water jug problem, so read the question carefully before attempting.

## Intro to water jug problem ##

The water jug problem is defined as follows:
Assume that you have two jugs, Jug-A and Jug-B each of which can hold a certain liters of water.  Initially, both are empty, but we have an infinite supply of water. Our task is to measure exactly X liters.
 
As an example: Jug-A holds 4 liters, and Jug-B holds 3 liters.  We wish to obtain exactly 1 gallon. 
 
We can look at a state as a pair of numbers, where the first represents the number of liters of water currently in Jug-A and the second represents the number of liters in Jug-B.
 
Possible legal operators are:   
emptying Jug-A onto the ground, 
emptying Jug-B onto the ground, 
pouring Jug-A into Jug-B (until either Jug-A is empty or Jug-B is full), 
or pouring Jug-B into Jug-A (until either Jug-B is empty  or Jug-A is full).
filling Jug-A to its max capacity, 
filling Jug-B to its max capacity, 

## Question ##
Find all pairs of water jug sizes so that the minimum number of operators required to obtain a quantity of 13 is more than 7.
Constraints :
Size of water jug A and size of water jug B are both >= 10 and <= 50

### Example 1 ###
For e.g.  (10, 17) is such a pair because in order to solve a water jug problem with size of first water jug as 10 and size of second water jug as 17 and to extract a quantity of 13. We need to take the following steps

Step   | State   | How this state was achieved
-------|---------|-----------------------------
Step 0 | (0 0)   | initial state
Step 1 | (10 0)  | fill a to full
Step 2 | (0 10)  | put from a into b| a < mb - b
Step 3 | (10 10) | fill a to full
Step 4 | (3 17)  | put from a into b| a >= mb - b
Step 5 | (3 0)   |  throw away b
Step 6 | (0 3)   | put from a into b| a < mb - b
Step 7 | (10 3)  | fill a to full
Step 8 | (0 13)  | put from a into b| a < mb - b

Important note that there is no other way you can extract 13 liters in less than 8 steps given that the sizes of jugs are 10 and 17. 
### Example 2 ###
Another example is (41, 23) for the size of (jugA, jugB) and to extract a quantity of 13.

Step   | State   | How this state was achieved
-------|---------|-----------------------------
Step 0 | (0 0)   |  initial state
Step 1 | (41 0)  | fill a to full
Step 2 | (18 23) | put from a into b| a >= mb - b
Step 3 | (18 0)  | throw away b
Step 4 | (0 18)  | put from a into b| a < mb - b
Step 5 | (41 18) | fill a to full
Step 6 | (36 23) | put from a into b| a >= mb - b
Step 7 | (36 0)  | throw away b
Step 8 | (13 23) | put from a into b| a >= mb - b

## Helpful Resources ##
Attached in the public repository at https://github.com/ankitjainst/WaterJugsCounter is code for representing the Water Jug State. You will need to write additional code to solve this question.
It is not necessary to solve this program using that code only.

## What to submit ## 
A count of how many pairs exist such as (10,17) and (41,23) detailed in the examples above. Note there are more than 20 such pairs and less than 100 such pairs, where size of water jugs are >= 10 and <= 50. 
For this program we consider (10,17) and (17,10) as two distinct pairs.
## How and where to submit ##
Email the count with your resume and any source code that you used to arrive at the solution to ankit@swiftthoughts.com and also contact via whatsapp at 8790868714.
