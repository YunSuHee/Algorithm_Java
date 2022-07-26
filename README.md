[![Solved.ac프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=tngml97)](https://solved.ac/tngml97)

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

### ArrayList

**정렬하기**
- Collections.sort(list) // 오름차순
- Collections.sort(list, Collections.reverseOrder()) //내림차순
- list.sort(Comparator.naturalOrder()) //오름차순
- list.sort(Comparator.reverseOrder()) //내림차순

**list 내부 다 지우기**
- ArrayList.clear()

**list 값 변경**

```
ArrayList<Integer> a = new ArrayList();
a.set(index위치, 변경할 값)

```



### 특정값 포함되어 있는지 확인(Contains)
```
Arrays.asList(배열).contains(값)
```
반환 값 true / false

### Array

**정렬하기**

```
Arrays.sort(arr); //오름차순
Arrays.sort(arr,Collections.reverseOrder()); //내림차순
```

