package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BookForm {
    private Long id;

    @NotEmpty(message = "상품 이름은 필수 입니다.")
    private String name;
    @Min(value = 0, message = "가격은 0원 이상 가능합니다.")
    private int price;
    @Min(value = 0, message = "수량은 0개 이상 가능합니다.")
    private int stockQuantity;

    private String author;
    private String isbn;
}
