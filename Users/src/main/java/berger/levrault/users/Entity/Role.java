package berger.levrault.users.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "\"Role\"")
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @Column(unique = true)
    private String name;
    private LocalDateTime createdDate;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;
}
