package eccomerce.sample.shop.base;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UtilTimeSetter {   // 테이블에 날짜 컬럼을 추가하고 로컬 날짜 데이터도 넣어주는 추상 클래스를 만들어 보자

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    // 이렇게 만든 로컬 날짜를 넣어주는 추상 클래스는 필요한 곳마다 상속시키면 된다
}
