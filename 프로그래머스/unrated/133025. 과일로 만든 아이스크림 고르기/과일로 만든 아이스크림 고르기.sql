-- 코드를 입력하세요
SELECT f.FLAVOR FROM FIRST_HALF f JOIN ICECREAM_INFO i ON f.flavor = i.flavor 
WHERE f.TOTAL_ORDER>=3000 AND i.ingredient_type= "fruit_based"