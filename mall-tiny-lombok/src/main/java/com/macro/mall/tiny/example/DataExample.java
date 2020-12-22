package com.macro.mall.tiny.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Created by macro on 2020/12/17.
 */
@Data
public class DataExample {
    @NonNull
    private Long id;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private Integer age;

    public static void main(String[] args) {
        //@RequiredArgsConstructor已生效
        DataExample example1 = new DataExample(1L);
        //@Getter @Setter已生效
        example1.setName("test");
        example1.setAge(20);
        //@ToString已生效
        System.out.println(example1);
        DataExample example2 = new DataExample(1L);
        //@EqualsAndHashCode已生效
        System.out.println(example1.equals(example2));
    }
}
