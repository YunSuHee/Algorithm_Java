-- 코드를 입력하세요
select product_code, o.total * p.price as sales
from product p
join (SELECT product_id, sum(sales_amount) as total
from offline_sale 
group by product_id) o
on p.product_id = o.product_id
order by sales desc, product_code 