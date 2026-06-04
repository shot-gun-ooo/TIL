USE sqldb;

SELECT * FROM usertbl U
   INNER JOIN buytbl B
   ON U.userID = B.userID
WHERE U.userID = 'JYP';


SELECT 
    U.userID, 
    U.name, 
    B.prodName, 
    U.addr, 
    CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
   LEFT OUTER JOIN buytbl B
   ON U.userID = B.userID
ORDER BY U.userID ASC;


SELECT 
    U.userID, 
    U.name, 
    B.prodName, 
    U.addr, 
    CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
   LEFT OUTER JOIN buytbl B
   ON U.userID = B.userID
WHERE U.mobile1 IS NOT NULL
ORDER BY U.userID ASC;