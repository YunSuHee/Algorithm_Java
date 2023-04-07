select Month(start_date) month, car_id, count(*) record
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in(
    select car_id 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where date_format(start_date,"%Y-%m")  BETWEEN '2022-08' AND '2022-10'
    group by car_id
    having count(car_id) >= 5)
    AND (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
group by month, car_id
having record > 0
ORDER BY MONTH, CAR_ID DESC;