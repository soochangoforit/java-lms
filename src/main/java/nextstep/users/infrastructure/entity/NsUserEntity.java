package nextstep.users.infrastructure.entity;

import java.time.LocalDateTime;
import nextstep.courses.domain.BaseTimeEntity;
import nextstep.users.domain.NsUser;

/**
 *  JPA 처럼 구성하고자 한다.
 *
 *
 create table ns_user (
 id bigint generated by default as identity,
 user_id varchar(20) not null,
 password varchar(20) not null,
 name varchar(20) not null,
 email varchar(50),
 created_at timestamp not null,
 updated_at timestamp,
 primary key (id)
 );


 */
public class NsUserEntity extends BaseTimeEntity {

  private Long id;

  private String userId;

  private String password;

  private String name;

  private String email;

  public NsUserEntity() {
  }

  /**
   * 주 생성자
   */
  public NsUserEntity(long id, String userId, String password, String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
    super(createdAt, updatedAt);
    this.id = id;
    this.userId = userId;
    this.password = password;
    this.name = name;
    this.email = email;
  }

  public NsUser toDomain() {
    return new NsUser(id, userId, password, name, email, createdAt, updatedAt);
  }
}
