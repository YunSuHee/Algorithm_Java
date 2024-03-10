-- 코드를 입력하세요
select flavor from (select f.flavor, f.total_order + j.total_order total from first_half f join (
SELECT flavor, sum(total_order) total_order from july group by flavor ) j
on f.flavor = j.flavor) b order by total desc limit 3



