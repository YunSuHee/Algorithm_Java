select u.user_id, u.nickname , sum(b.price) as total_sales
from USED_GOODS_USER u 
join (select * from USED_GOODS_BOARD where status = "DONE") b
on u.user_id = b.writer_id
group by writer_id
having total_sales >= 700000
order by total_sales
