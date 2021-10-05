package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// 테이블명을 USER로 변경하고자 하면  설정
// @Table(name = "USER")
public class Member {

    @Id
    private Long id;

    // 컬럼명 username로 변경하고자 하면 설정
    // @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
