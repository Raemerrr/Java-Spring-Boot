package hellojpa;

import javax.persistence.*;

// 테이블명을 USER로 변경하고자 하면  설정
// @Table(name = "USER")
@Entity
public class Member {

    protected Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue
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
