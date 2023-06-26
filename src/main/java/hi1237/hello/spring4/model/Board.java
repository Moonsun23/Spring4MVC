package hi1237.hello.spring4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Board {

    private String bno;
    private String title;
    private String userid;
    private String regdate;
    private String views;
    private String contents;


}
