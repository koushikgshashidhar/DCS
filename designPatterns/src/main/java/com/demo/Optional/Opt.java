package com.demo.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Opt {

    public static void main(String[] args) {
        // Optional is a container object which may or may not contain a non-null value.
        // It is used to represent optionality in Java.

        Optional<String> var = Optional.empty();

        Optional<String> var1= Optional.of("wassup");
        // Optional<String> var1= Optional.of(null);
        Optional<String> var2= Optional.ofNullable("howuDoing");
        Optional<String> var3= Optional.ofNullable(null);
        System.out.println( "var3:"+var3);
        System.out.println("var2:"+var2);
        System.out.println("var2.get():"+var2.get());
        System.out.println("var2.isEmpty()"+var2.isEmpty()+" var2.isPresent()"+var2.isPresent());
        System.out.println("var3.isEmpty()"+var3.isEmpty()+" var3.isPresent()"+var3.isPresent());
        var2.ifPresent(a->System.out.println(a));
        var3.ifPresent(a->System.out.println(a));
        var3.ifPresentOrElse(a->System.out.println(a),()->System.out.println("var3 is empty"));
        String temp= "abcd";
        String var4=Optional.ofNullable(temp).orElse("default");
        System.out.println("var4:"+var4);
        String var5= (String) Optional.ofNullable(null).orElseGet(()->"default");
        System.out.println("var5:"+var5);
      //  String var6= (String) Optional.ofNullable(null).orElseThrow();
        //String var6= (String) Optional.ofNullable(null).orElseThrow(()->new RuntimeException("value is null"));
       var2.filter(a->a.equals("howuDoing")).isPresent();
        var2.filter(a->a.equals("howuDoing")).ifPresent(a->System.out.println("value is present"));
        var2.filter(a->a.equals("howuDoing")).ifPresentOrElse(a->System.out.println("value is present"),()->System.out.println("value is not present"));
        var2.map(a->a.toUpperCase()).ifPresent(a->System.out.println("value is present in upper case"));

        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional
                .map(List::size)
                .orElse(0);
        String name = "baeldung";
        Optional<String> nameOptional = Optional.of(name);

        int len = nameOptional
                .map(String::length)
                .orElse(0);

        //flatMap is used to flatten the nested Optional
        // so if we have Optional<Optional<String>> and we want to get the value inside the inner Optional
        // we can use flatMap to get the value inside the inner Optional
        // so flatMap will return Optional<String> instead of Optional<Optional<String>>
        //whereas map will return Optional<Optional<String>>

        var2.flatMap(a->Optional.ofNullable(a.toUpperCase())).ifPresent(a->System.out.println("value is present in upper case"));





    }
}
