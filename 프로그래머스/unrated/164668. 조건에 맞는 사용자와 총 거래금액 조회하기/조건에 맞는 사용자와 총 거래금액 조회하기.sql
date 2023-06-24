select u.user_id, u.nickname, sum(b.price) as total_price
from used_goods_user u
join (select * from used_goods_board where status = "DONE") b
on u.user_id = b.writer_id
group by b.writer_id
having total_price >= 700000
order by total_price