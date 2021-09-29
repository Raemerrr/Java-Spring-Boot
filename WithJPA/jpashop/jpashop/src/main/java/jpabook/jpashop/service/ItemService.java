package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        //상품은 동일 이름으로 등록되어도 되는가?
        //validateDuplicateItem(item);
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Book findItem = (Book) itemRepository.findOne(itemId);
        findItem.change(name, price, stockQuantity);
    }

    private void validateDuplicateItem(Item item) {
        List<Item> findList = itemRepository.findByName(item.getName());
        if (!findList.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이템입니다.");
        }
    }

    //아이템 전체 조회
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    //아이템 단건 조회
    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }
}
