# Algorithm_Java

### String to int / int to String
 **String to int**
- parseInt()와 valueOf()메소드 사용할 수 있다.

   parseInt() 메소드는 primitive type인 int를 리턴\
   valueOf() 메소드는 문자열을 변환하여 Integer Object를 리턴

``` 
 String str1 = "123";        
 int intValue1 = Integer.parseInt(str1)
 System.out.println(intValue1); // 123
 
 String str2 = "-123";         
 int intValue2 = Integer.valueOf(str2).intValue();         
 System.out.println(intValue2); // -123
```

 **int to String**
- Integer.toString(), String.valueOf() 빈 문자열과 int를 '+'연산자로 연결하여 문자열로 변환할 수 있다.

```
 int intValue1 = 123;        
 int intValue2 = -123;   
 int intValue3 = 1234; 
       
 String str1 = Integer.toString(intValue1);        
 String str2 = String.valueOf(intValue2);
 String str3 = intValue3 + "";

```

