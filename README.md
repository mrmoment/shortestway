Assume there is a 2-d map. A deliver man positioned at (x,y) want to go to destination (m,n). At every step, it will go to the adjacent node, and there is some node being blocked. The blocked node has a value of 0, otherwise of 1. The code segment is used to count HOW MANY shortest ways for the deliver man to go.

An example of the map:

(0,0,1)  -  (0,1,1)  -  (0,2,1)  -  (0,3,0)
    |                |                |               |
(1,0,1)  -  (1,1,1)  -  (1,2,0)  -  (1,3,1)
    |                |                |               |
(2,0,1)  -  (2,1,1)  -  (2,2,1)  -  (2,3,1)

And the shortest way number is 3 from (0,0) to (2,2).