package Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈境聪
 * @date 2022年09月01日 15:03
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
}
