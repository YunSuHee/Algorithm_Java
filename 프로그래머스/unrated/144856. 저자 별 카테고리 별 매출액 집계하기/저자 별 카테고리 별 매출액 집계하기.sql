-- 코드를 입력하세요
# SELECT a.author_id, a.author_name, b.category
# from author a
# join book b
# on a.author_id = b.author_id
# group by a.author_name, b.category


select b.author_id, a.author_name, b.category, sum(s.sales * b.price) 
from book b 
join book_sales s on b.book_id = s.book_id 
join author a on a.author_id = b. author_id
where s.sales_date like "2022-01%" group by b.AUTHOR_ID, b.category
order by author_id , category desc;