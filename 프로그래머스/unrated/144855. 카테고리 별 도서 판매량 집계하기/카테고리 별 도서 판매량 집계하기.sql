select category, sum(sales) from book b join (select * from book_sales where SALES_DATE like "2022-01%") s
on b.book_id = s.book_id 
group by b.category
order by category
